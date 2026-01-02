<%-- 
    Document   : editarDetPedidos
    Created on : 22 sept 2024, 13:50:00
    Author     : Joaquin
--%>

<%@page import="Modelo.dto.Detalle_Pedido"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    Detalle_Pedido detallePedido = (Detalle_Pedido) request.getAttribute("detallePedido");
    if (detallePedido == null) {
%>
    <p>El detalle de pedido no se encontró. Por favor, inténtelo de nuevo.</p>
<%
    return;
    }
%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Editar Detalle de Pedido</title>
        <style>
            body {
                font-family: 'Poppins', sans-serif;
                margin: 0;
                height: 100vh;
                background: url('img/banner_log.jpg') no-repeat center center fixed;
                background-size: cover;
                display: flex;
                justify-content: center;
                align-items: center;
                position: relative;
            }

            .body-overlay {
                position: absolute;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background: rgba(255, 105, 180, 0.5);
                z-index: -1;
            }

            .form-container {
                display: flex;
                flex-direction: column;
                background-color: #fff;
                padding: 3rem;
                border-radius: 1rem;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                z-index: 1;
                width: 100%;
                max-width: 400px;
            }

            h2 {
                color: #f082e2;
                text-align: center;
                margin-bottom: 2rem;
            }

            .grupo-input {
                margin-bottom: 2rem;
                display: flex;
                flex-direction: column;
                align-items: stretch;
            }

            .grupo-input label {
                display: block;
                margin-bottom: 0.5rem;
                color: #333;
                font-size: 1.4rem;
            }

            .grupo-input input {
                width: 100%;
                padding: 1rem;
                border: 1px solid #ddd;
                border-radius: 0.5rem;
                font-size: 1.4rem;
                box-sizing: border-box;
            }

            .grupo-input input:focus {
                border-color: #d5006d;
                outline: none;
            }

            .btn-submit {
                width: 100%;
                padding: 1rem;
                background-color: #f082e2;
                color: #fff;
                border: none;
                border-radius: 0.5rem;
                cursor: pointer;
                font-size: 1.6rem;
                text-transform: uppercase;
                transition: background-color 0.3s ease;
            }

            .btn-submit:hover {
                background-color: #c51162;
            }
        </style>
    </head>
    <body>
        <div class="body-overlay"></div>
        <div class="form-container">
            <h2>Editar Detalle de Pedido</h2>
            <form action="<%= request.getContextPath() %>/MainControler" method="post">
                <input type="hidden" name="action" value="actualizarDetallePedido">
                <input type="hidden" name="detalle_id" value="<%= detallePedido.getDetalleId() %>">

                <div class="grupo-input">
                    <label for="pedidoId">ID Pedido:</label>
                    <input type="text" id="pedidoId" name="pedido_id" value="<%= detallePedido.getPedidoId() %>" required>
                </div>

                <div class="grupo-input">
                    <label for="florId">ID Flor:</label>
                    <input type="text" id="florId" name="flor_id" value="<%= detallePedido.getFlorId() %>" required>
                </div>

                <div class="grupo-input">
                    <label for="cantidad">Cantidad:</label>
                    <input type="number" id="cantidad" name="cantidad" value="<%= detallePedido.getCantidad() %>" required>
                </div>

                <div class="grupo-input">
                    <label for="precio">Precio:</label>
                    <input type="text" id="precio" name="precio" value="<%= detallePedido.getPrecio() %>" required>
                </div>

                <input type="submit" value="Editar" class="btn-submit">
            </form>
        </div>
    </body>
</html>
