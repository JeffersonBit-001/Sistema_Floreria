package Controlador;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;

@WebServlet("/srvReporte")
public class ControlReportes extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if ("exportarJasperReports".equalsIgnoreCase(accion)) {
            exportarReporteUsuarios(request, response);
        } else {
            response.getWriter().println("Acción no especificada o no válida.");
        }
    }

    private void exportarReporteUsuarios(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletOutputStream out = response.getOutputStream();
        Connection conexion = null;

        try {
            // Establecer la conexión a la base de datos
            Class.forName("com.mysql.cj.jdbc.Driver"); // Asegúrate de tener el driver correcto.
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_flores", "root", "root");

            // Cargar el archivo .jasper
            InputStream reporteUsuarios = this.getServletContext()
                    .getResourceAsStream("/Vista/ReporteJasper/ReporteUsuarios.jasper");

            if (reporteUsuarios == null) {
                throw new RuntimeException("No se pudo encontrar el archivo .jasper en la ruta especificada.");
            }

            // Parámetros para el reporte
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("titulo", "Reporte de Usuarios");

            JasperReport report = (JasperReport) JRLoader.loadObject(reporteUsuarios);
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, conexion);

            // Configurar la respuesta HTTP
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=ReporteUsuarios.pdf");

            // Exportar el reporte
            JasperExportManager.exportReportToPdfStream(jasperPrint, out);
            out.flush();

        } catch (Exception e) {
            response.setContentType("text/plain");
            out.print("Error al generar el reporte: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
