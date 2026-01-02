/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Date;
import Modelo.dao.CarritoDAO;
import Modelo.dao.CategoriasDAO;
import Modelo.dao.ComentariosDAO;
import Modelo.dao.Detalle_PedidoDAO;
import Modelo.dao.FloresDAO;
import Modelo.dao.Flores_CategoriasDAO;
import Modelo.dao.PagoDAO;
import Modelo.dao.PedidosDAO;
import Modelo.dao.RegisterDAO;
import Modelo.dto.Carrito;
import Modelo.dto.Categorias;
import Modelo.dto.Comentarios;
import Modelo.dto.Detalle_Pedido;
import Modelo.dto.Flores;
import Modelo.dto.Flores_Categorias;
import Modelo.dto.Pago;
import Modelo.dto.Pedidos;
import Modelo.dto.Register;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joaquin
 */
@WebServlet("/MainControler")
public class MainControler extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private RegisterDAO registerDAO;
    private FloresDAO floresDAO; // Añadido para gestionar flores
    private ComentariosDAO comentariosDAO;
    private PedidosDAO pedidosDAO;
    private PagoDAO pagoDAO;
    private CarritoDAO carritoDAO; // Añadido para gestionar el carrito
    private Detalle_PedidoDAO detallePedidoDAO;

    @Override
    public void init() {
        registerDAO = new RegisterDAO();
        floresDAO = new FloresDAO(); // Inicializar el DAO de flores
        comentariosDAO = new ComentariosDAO();
        pedidosDAO = new PedidosDAO();
        pagoDAO = new PagoDAO();
        carritoDAO = new CarritoDAO(); // Inicializar el DAO del carrito
        detallePedidoDAO = new Detalle_PedidoDAO(); // Inicializar el DAO de Detalle_Pedido
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);  // Este método ahora maneja tanto GET como POST
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "editarUsuario":
                    editarUsuario(request, response);
                    break;
                case "actualizarUsuario":  // Asegúrate de manejar la acción del POST
                    actualizarUsuario(request, response);
                    break;
                case "eliminarUsuario":
                    eliminarUsuario(request, response);
                    break;
                case "editarFlor": // Manejar edición de flores
                    editarFlor(request, response);
                    break;
                case "actualizarFlor": // Manejar actualización de flores
                    actualizarFlor(request, response);
                    break;
                case "eliminarFlor": // Manejar eliminación de flores
                    eliminarFlor(request, response);
                    break;
                case "mostrarFormularioAgregarFlor":
                    mostrarFormularioAgregarFlor(request, response);
                    break;
                case "agregarFlor":
                    agregarFlor(request, response);
                    break;
                case "editarComentario":
                    editarComentario(request, response);
                    break;
                case "actualizarComentario":
                    actualizarComentario(request, response);
                    break;
                case "eliminarComentario":
                    eliminarComentario(request, response);
                    break;

                // Pedidos (Nuevas acciones para pedidos)
                case "editarPedido":
                    editarPedido(request, response);
                    break;
                case "actualizarPedido":
                    actualizarPedido(request, response);
                    break;
                case "eliminarPedido":
                    eliminarPedido(request, response);
                    break;

                case "editarPago":
                    editarPago(request, response);
                    break;
                case "actualizarPago":
                    actualizarPago(request, response);
                    break;
                case "eliminarPago":
                    eliminarPago(request, response);
                    break;

                case "editarCarrito":
                    editarCarrito(request, response);
                    break;
                case "actualizarCarrito":
                    actualizarCarrito(request, response);
                    break;
                case "eliminarCarrito":
                    eliminarCarrito(request, response);
                    break;
                case "eliminarCarritoCliente": // Este es el nuevo caso
                    eliminarCarritoCliente(request, response); // Llamada al nuevo método
                    break;

                // Acciones para Detalle_Pedido
                case "editarDetallePedido":
                    editarDetallePedido(request, response);
                    break;
                case "actualizarDetallePedido":
                    actualizarDetallePedido(request, response);
                    break;
                case "eliminarDetallePedido":
                    eliminarDetallePedido(request, response);
                    break;
                default:
                    listarUsuarios(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void editarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Register usuario = registerDAO.get(id);
        request.setAttribute("usuario", usuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Vista/FormulariosdeEdicion/editarUsuario.jsp");
        dispatcher.forward(request, response);
    }

    private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String contrasena = request.getParameter("contrasena");

        // Crear el objeto Register
        Register usuario = new Register(id, nombre, email, null, direccion, telefono);

        // Si la contraseña no está vacía, actualizarla
        if (contrasena != null && !contrasena.isEmpty()) {
            usuario.setContrasena(contrasena); // Asume que hay un método para establecer la contraseña
        }

        registerDAO.update(usuario);

        // Redirigir de vuelta a la página de administración
        response.sendRedirect(request.getContextPath() + "/Vista/Administrar.jsp");
    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        registerDAO.eliminar(id);
        response.sendRedirect(request.getContextPath() + "/Vista/Administrar.jsp");
    }

    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Código para listar usuarios
    }

    private void editarFlor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Flores flor = floresDAO.get(id);
        request.setAttribute("flor", flor);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Vista/FormulariosdeEdicion/editarFlores.jsp");
        dispatcher.forward(request, response);
    }

    private void actualizarFlor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        double precio = Double.parseDouble(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        String imagenUrl = request.getParameter("imagen_url");

        Flores flor = new Flores(id, nombre, descripcion, precio, stock, imagenUrl);
        floresDAO.update(flor);

        response.sendRedirect(request.getContextPath() + "/Vista/Administrar.jsp");
    }

    private void eliminarFlor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        floresDAO.eliminar(id);
        response.sendRedirect(request.getContextPath() + "/Vista/Administrar.jsp");
    }

    private void mostrarFormularioAgregarFlor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Vista/FormulariosdeEdicion/agregarFlores.jsp");
        dispatcher.forward(request, response);
    }

    private void agregarFlor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        double precio = Double.parseDouble(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        String imagenUrl = request.getParameter("imagen_url");

        Flores flor = new Flores(0, nombre, descripcion, precio, stock, imagenUrl); // ID se generará automáticamente
        floresDAO.agregar(flor);

        response.sendRedirect(request.getContextPath() + "/Vista/Administrar.jsp");
    }

    private void editarComentario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Comentarios comentario = comentariosDAO.get(id);
        request.setAttribute("comentario", comentario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Vista/FormulariosdeEdicion/editarComents.jsp");
        dispatcher.forward(request, response);
    }

    private void actualizarComentario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int florId = Integer.parseInt(request.getParameter("flor_id"));
        int userId = Integer.parseInt(request.getParameter("user_id"));
        String comentario = request.getParameter("comentario");
        int calificacion = Integer.parseInt(request.getParameter("calificacion"));

        Comentarios comentarioObj = new Comentarios(id, florId, userId, comentario, calificacion);
        comentariosDAO.update(comentarioObj);

        response.sendRedirect(request.getContextPath() + "/Vista/Administrar.jsp");
    }

    private void eliminarComentario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        comentariosDAO.delete(id);
        response.sendRedirect(request.getContextPath() + "/Vista/Administrar.jsp");
    }

    // Métodos para manejar las acciones de pedidos
    private void editarPedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener ID del pedido desde la solicitud
        int id = Integer.parseInt(request.getParameter("id"));

        // Obtener el pedido desde la base de datos usando la instancia de PedidosDAO
        Pedidos pedido = pedidosDAO.get(id);

        // Establecer el pedido como atributo de la solicitud
        request.setAttribute("pedido", pedido);

        // Redirigir al formulario de edición
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Vista/FormulariosdeEdicion/editarPedidos.jsp");
        dispatcher.forward(request, response);
    }

    private void actualizarPedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Obtener los parámetros
            String idStr = request.getParameter("id");
            String userIdStr = request.getParameter("userId");
            String totalStr = request.getParameter("total");
            String estado = request.getParameter("estado");
            String fechaPedidoStr = request.getParameter("fechaPedido");

            // Convertir los parámetros y validar
            if (idStr == null || idStr.isEmpty()) {
                throw new IllegalArgumentException("El ID del pedido no puede estar vacío.");
            }
            if (userIdStr == null || userIdStr.isEmpty()) {
                throw new IllegalArgumentException("El ID del usuario no puede estar vacío.");
            }
            if (totalStr == null || totalStr.isEmpty()) {
                throw new IllegalArgumentException("El total no puede estar vacío.");
            }

            int id = Integer.parseInt(idStr);
            int userId = Integer.parseInt(userIdStr);
            double total = Double.parseDouble(totalStr);

            // Si el estado es "En_transito", mapearlo a "En tránsito"
            if ("En_transito".equals(estado)) {
                estado = "En tránsito";
            }

            // Validar y convertir la fecha (fechaPedido)
            Date fechaPedido = null;
            if (fechaPedidoStr != null && !fechaPedidoStr.isEmpty()) {
                fechaPedido = Date.valueOf(fechaPedidoStr);  // Asegúrate de que el formato sea correcto (yyyy-MM-dd)
            } else {
                throw new IllegalArgumentException("La fecha del pedido no es válida.");
            }

            // Crear el objeto Pedido actualizado
            Pedidos pedidoActualizado = new Pedidos(id, userId, total, estado, fechaPedido);

            // Actualizar el pedido en la base de datos
            PedidosDAO pedidosDAO = new PedidosDAO();
            boolean actualizado = pedidosDAO.update(pedidoActualizado);

            if (actualizado) {
                response.sendRedirect(request.getContextPath() + "/Vista/Administrar.jsp");
            } else {
                request.setAttribute("mensajeError", "Error al actualizar el pedido.");
                request.getRequestDispatcher("/Vista/Error.jsp").forward(request, response);
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("mensajeError", "Formato de número inválido. Por favor, ingresa un número válido.");
            request.getRequestDispatcher("/Vista/Error.jsp").forward(request, response);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            request.setAttribute("mensajeError", e.getMessage());
            request.getRequestDispatcher("/Vista/Error.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensajeError", "Error inesperado al actualizar el pedido.");
            request.getRequestDispatcher("/Vista/Error.jsp").forward(request, response);
        }
    }

    private void eliminarPedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener el ID del pedido desde la solicitud
        int id = Integer.parseInt(request.getParameter("id"));

        // Llamar al método de eliminación en PedidosDAO usando la instancia
        pedidosDAO.eliminar(id);

        // Redirigir a la página de administración de pedidos
        response.sendRedirect(request.getContextPath() + "/Vista/Administrar.jsp");
    }

    // Métodos para manejar las acciones relacionadas con pagos
    private void editarPago(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener ID del pago desde la solicitud
        int id = Integer.parseInt(request.getParameter("id"));

        // Obtener el pago desde la base de datos usando la instancia de PagoDAO
        Pago pago = pagoDAO.get(id);

        // Establecer el pago como atributo de la solicitud
        request.setAttribute("pago", pago);

        // Redirigir al formulario de edición
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Vista/FormulariosdeEdicion/editarPago.jsp");
        dispatcher.forward(request, response);
    }

    private void actualizarPago(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los datos actualizados del formulario
        int id = Integer.parseInt(request.getParameter("pago_id"));
        String nombreCompleto = request.getParameter("nombre_completo");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String direccionEnvio = request.getParameter("direccion_envio");
        String ciudad = request.getParameter("ciudad");
        String estado = request.getParameter("estado");
        String codigoPostal = request.getParameter("codigo_postal");
        String numeroTarjeta = request.getParameter("numero_tarjeta");
        String fechaExpiracion = request.getParameter("fecha_expiracion");
        String cvv = request.getParameter("cvv");
        double montoTotal = Double.parseDouble(request.getParameter("monto_total"));

        // Crear el objeto Pago con los datos actualizados
        Pago pagoActualizado = new Pago(id, -1, nombreCompleto, correo, telefono, direccionEnvio, ciudad, estado, codigoPostal, numeroTarjeta, fechaExpiracion, cvv, montoTotal);

        // Llamar al método de actualización en PagoDAO usando la instancia
        pagoDAO.actualizar(pagoActualizado);

        // Redirigir a la página de administración de pagos
        response.sendRedirect(request.getContextPath() + "/Vista/Administrar.jsp");
    }

    private void eliminarPago(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener el ID del pago desde la solicitud
        int id = Integer.parseInt(request.getParameter("id"));

        // Llamar al método de eliminación en PagoDAO usando la instancia
        pagoDAO.eliminar(id);

        // Redirigir a la página de administración de pagos
        response.sendRedirect(request.getContextPath() + "/Vista/Administrar.jsp");
    }

    // Método para editar un carrito (modificado para parecerse al método editarFlor)
    private void editarCarrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("ID recibido para edición: " + id); // Log para verificar el ID

        Carrito carrito = carritoDAO.get(id); // Obtiene el carrito por ID

        if (carrito != null) {
            System.out.println("Carrito encontrado: " + carrito.toString()); // Log para verificar el carrito
            request.setAttribute("carrito", carrito); // Establece el objeto carrito en la solicitud
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Vista/FormulariosdeEdicion/editarCarrito.jsp");
            dispatcher.forward(request, response);
        } else {
            System.out.println("El carrito es nulo para el ID: " + id); // Log si el carrito es nulo
            response.getWriter().println("El carrito con ID " + id + " no se encontró.");
        }
    }

    // Método para actualizar un carrito
    private void actualizarCarrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCarrito = Integer.parseInt(request.getParameter("idCarrito"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        int florId = Integer.parseInt(request.getParameter("florId"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        double precio = Double.parseDouble(request.getParameter("precio"));

        // Crear el objeto Carrito con los datos actualizados
        Carrito carritoActualizado = new Carrito(idCarrito, userId, florId, cantidad, precio);
        carritoDAO.update(carritoActualizado);

        // Redirigir a la página de administración de carritos
        response.sendRedirect(request.getContextPath() + "/Vista/Administrar.jsp");
    }

    // Método para eliminar un carrito
    private void eliminarCarrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        carritoDAO.eliminar(id);
        response.sendRedirect(request.getContextPath() + "/Vista/Administrar.jsp");
    }

    private void eliminarCarritoCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        // Eliminar el carrito
        boolean eliminado = carritoDAO.eliminar(id);

        // Redirigir a la página del carrito después de la eliminación
        if (eliminado) {
            response.sendRedirect(request.getContextPath() + "/Vista/carshop.jsp");
        } else {
            response.getWriter().println("No se pudo eliminar el producto del carrito.");
        }
    }

    // Método para editar un detalle de pedido
    private void editarDetallePedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Detalle_Pedido detallePedido = detallePedidoDAO.get(id); // Obtiene el detalle de pedido por ID

        if (detallePedido != null) {
            request.setAttribute("detallePedido", detallePedido); // Establece el objeto como atributo de la solicitud
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Vista/FormulariosdeEdicion/editarDetPedidos.jsp");
            dispatcher.forward(request, response); // Redirige al JSP de edición
        } else {
            System.out.println("Detalle de pedido no encontrado para el ID: " + id);
            response.getWriter().println("El detalle de pedido con ID " + id + " no se encontró.");
        }
    }

// Método para actualizar un detalle de pedido
    private void actualizarDetallePedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idDetalle = Integer.parseInt(request.getParameter("detalle_id"));
        int pedidoId = Integer.parseInt(request.getParameter("pedido_id"));
        int florId = Integer.parseInt(request.getParameter("flor_id"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        double precio = Double.parseDouble(request.getParameter("precio"));

        // Crear el objeto Detalle_Pedido con los datos actualizados
        Detalle_Pedido detallePedidoActualizado = new Detalle_Pedido(idDetalle, pedidoId, florId, cantidad, precio);

        // Actualizar el detalle de pedido en la base de datos
        boolean isUpdated = detallePedidoDAO.update(detallePedidoActualizado);

        if (isUpdated) {
            System.out.println("Detalle de pedido actualizado correctamente: " + detallePedidoActualizado);
        } else {
            System.out.println("No se pudo actualizar el detalle de pedido: " + detallePedidoActualizado);
        }

        // Redirigir a la página de administración de pedidos
        response.sendRedirect(request.getContextPath() + "/Vista/Administrar.jsp");
    }

// Método para eliminar un detalle de pedido
    private void eliminarDetallePedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        // Eliminar el detalle de pedido en la base de datos
        boolean isDeleted = detallePedidoDAO.eliminar(id);

        if (isDeleted) {
            System.out.println("Detalle de pedido eliminado correctamente para el ID: " + id);
        } else {
            System.out.println("No se pudo eliminar el detalle de pedido para el ID: " + id);
        }

        // Redirigir a la página de administración de pedidos
        response.sendRedirect(request.getContextPath() + "/Vista/Administrar.jsp");
    }

}
