package webconfig;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class WebConfig implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Configuración inicial si es necesaria
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Configuración de cabeceras CORS
        httpResponse.setHeader("Access-Control-Allow-Origin", "https://El_y_Ella_Detalles.com"); // Dominios permitidos
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // Métodos permitidos
        httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization"); // Cabeceras permitidas
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true"); // Permite credenciales (cookies)

        // Manejo especial para solicitudes OPTIONS
        if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(request, response); // Continua la ejecución normal para otras solicitudes
        }
    }

    @Override
    public void destroy() {
        // Recursos de limpieza, si es necesario
    }
}
