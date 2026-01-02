<%-- 
    Document   : editarPedidos
    Created on : 26 oct 2024, 10:00:00
    Author     : Joaquin
--%>

<%@page import="Modelo.dto.Pedidos"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    Pedidos pedido = (Pedidos) request.getAttribute("pedido");
    if (pedido == null) {
%>
<p>El pedido no se encontró. Por favor, inténtelo de nuevo.</p>
<%
        return;
    }
%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Editar Pedido</title>
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

            .grupo-input input, .grupo-input select {
                width: 100%;
                padding: 1rem;
                border: 1px solid #ddd;
                border-radius: 0.5rem;
                font-size: 1.4rem;
                box-sizing: border-box;
            }

            .grupo-input input:focus, .grupo-input select:focus {
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
            <h2>Editar Pedido</h2>
            <form action="<%= request.getContextPath()%>/MainControler" method="post" accept-charset="UTF-8">
                <input type="hidden" name="action" value="actualizarPedido">
                <input type="hidden" name="id" value="<%= pedido.getPedidoId()%>"> <!-- Cambié pedidoId a id -->

                <div class="grupo-input">
                    <label for="userId">ID Usuario:</label>
                    <input type="text" id="userId" name="userId" value="<%= pedido.getUserId()%>" required>
                </div>

                <div class="grupo-input">
                    <label for="total">Total:</label>
                    <input type="text" id="total" name="total" value="<%= pedido.getTotal()%>" required>
                </div>

                <div class="grupo-input">
                    <label for="estado">Estado:</label>
                    <select id="estado" name="estado" required>
                        <option value="Pendiente" <%= "Pendiente".equals(pedido.getEstado()) ? "selected" : ""%>>Pendiente</option>
                        <option value="Enviado" <%= "Enviado".equals(pedido.getEstado()) ? "selected" : ""%>>Enviado</option>
                        <option value="En_transito" <%= "En tránsito".equals(pedido.getEstado()) ? "selected" : ""%>>En transito</option>
                        <option value="Finalizado" <%= "Finalizado".equals(pedido.getEstado()) ? "selected" : ""%>>Finalizado</option>
                    </select>

                </div>

                <div class="grupo-input">
                    <label for="fechaPedido">Fecha del Pedido:</label>
                    <input type="date" id="fechaPedido" name="fechaPedido" value="<%= pedido.getFechaPedido()%>" required> <!-- Cambié fecha_pedido a fechaPedido -->
                </div>

                <input type="submit" value="Editar" class="btn-submit">
            </form>

        </div>
    </body>
</html>
