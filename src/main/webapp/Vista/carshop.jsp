<%-- 
    Document   : carshop
    Created on : 26 ago 2024, 20:33:38
    Author     : Joaquin
--%>

<%@page import="java.util.List"%>
<%@page import="Modelo.dto.Carrito"%>
<%@page import="Modelo.dao.CarritoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Carrito de Compras - El y Ella Detalles</title>
        <link rel="stylesheet" href="../style.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="icon" href="../img/el y ella logo.jpeg">
        <link href="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.css" rel="stylesheet">

        <style>
            body {
                font-family: 'Arial', sans-serif;
                background-color: #f5f5f5;
            }

            .container {
                max-width: 1200px;
            }

            .cart-items {
                background-color: white;
                border-radius: 8px;
                padding: 15px;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
                margin-bottom: 15px;
            }

            .cart-item {
                display: flex;
                align-items: center;
                justify-content: space-between;
                margin-bottom: 15px;
            }

            .cart-item img {
                max-width: 60px;
                margin-right: 15px;
            }

            .item-details h6 {
                margin-bottom: 5px;
                font-weight: bold;
            }

            .item-quantity input {
                max-width: 60px;
            }

            .details-card {
                background-color: #e055a2;
                border-radius: 8px;
                color: white;
            }

            .details-card .profile-img {
                width: 100px;
                height: 100px;
                object-fit: cover;
            }

            .totals p {
                margin: 0;
            }

            button {
                background-color: #e055a2;
                border: none;
                padding: 10px 20px;
                border-radius: 50px;
                color: white;
                font-weight: bold;
                cursor: pointer;
            }
            button.btn.btn-primary.mt-3 {
                background-color: black; /* Cambia el color de fondo a negro */
                border: none; /* Elimina el borde */
                color: white; /* Asegúrate de que el texto siga siendo blanco */
            }
            button.btn-eliminar {
                background-color: #e055a2; /* Color rosado */
                color: white;
                border: none;
                padding: 10px 20px;
                border-radius: 50px;
                margin-left: auto; /* Alinearlo hacia la derecha */
                display: block;
                cursor: pointer;
            }

            .cart-item {
                display: flex;
                align-items: center;
                justify-content: space-between;
                margin-bottom: 15px;
            }

            .item-details {
                flex: 1; /* Esto asegura que el nombre del producto ocupe todo el espacio disponible */
            }

            .item-quantity {
                margin-right: 20px; /* Espacio entre el botón y el precio */
            }

            .item-price {
                margin-left: 40px; /* Aumenta el espacio a la izquierda del precio */
                flex-shrink: 0;
            }




        </style>
    </head>

    <header class="container-hero">

        <header>
            <div class="container-hero">
                <div class="container hero">
                    <div class="customer-support">
                        <i class="fa-solid fa-headset"></i>
                        <div class="content-customer-support">
                            <span class="text">Soporte al cliente</span>
                            <span class="number">+51 994 802 601</span>
                        </div>
                    </div>

                    <div class="container-logo">
                        <i class="fa-regular fa-flower-tulip"></i>
                        <h1 class="logo"><a href="/">El y Ella Detalles</a></h1>
                    </div>

                    <div class="container-user">
                        <a href="User.jsp"><i class="fa-solid fa-user"></i></a>
                        <a href="carshop.jsp"><i class="fa-solid fa-basket-shopping"></i></a>
                        <div class="content-shopping-cart">
                            <span class="text">Carrito</span>
                            <span class="number">(0)</span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container-navbar">
                <nav class="navbar container">
                    <i class="fa-solid fa-bars"></i>
                    <ul class="menu">
                        <li><a href="AfterLogin.jsp">Inicio</a></li>
                        <li><a href="Box Rosas.jsp">Rosas</a></li>
                        <li><a href="Box Girasoles.jsp">Girasoles</a></li>
                        <li><a href="Box Tulipanes.jsp">Tulipanes</a></li>
                        <li><a href="#">Más</a></li>
                        <li><a href="#">Blog</a></li>
                    </ul>

                    <form class="search-form">
                        <input type="search" placeholder="Buscar..." />
                        <button class="btn-search">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </button>
                    </form>
                </nav>
            </div>
        </header>
    </div>
</header>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-8">
                <h5><a href="AfterLogin.jsp">← Continuar comprando</a></h5>
                <h6 class="mb-3">Carrito de compras</h6>

                <%
                    Integer userId = (Integer) session.getAttribute("user_id");
                    double subtotal = 0;
                    double envio = 20.00;
                    double total = 0;

                    if (userId != null) {
                        CarritoDAO carritoDAO = new CarritoDAO();
                        List<Carrito> carritos = carritoDAO.getCarritosByUserId(userId);

                        if (carritos != null && !carritos.isEmpty()) {
                            for (Carrito carrito : carritos) {
                                subtotal += carrito.getPrecio() * carrito.getCantidad();
                            }
                            total = subtotal + envio; // Calculo total
                            session.setAttribute("montoTotal", total); // Almacena el total en la sesión
                %>

                <p>Tienes <%= carritos.size()%> productos en tu carrito</p>
                <div class="cart-items">
                    <%
                        for (Carrito carrito : carritos) {
                    %>
                    <div class="cart-item d-flex align-items-center mb-3">
                        <div class="item-image">
                            <!-- Cambiar a una imagen estática -->
                            <img src="../img/el y ella logo sin fondo.png" alt="Flor Estática" class="img-fluid" style="width: 100px;">
                        </div>
                        <div class="item-details ms-3">
                            <h6 class="mb-1">Flor: <%= carrito.getNombreFlor()%></h6> <!-- Ahora debería funcionar -->
                            <p class="text-muted"><%= carrito.getCantidad()%> unidades</p>
                        </div>

                        <div class="item-quantity ms-3">
                            <form action="<%= request.getContextPath()%>/MainControler" method="post">
                                <input type="hidden" name="action" value="eliminarCarritoCliente">
                                <input type="hidden" name="id" value="<%= carrito.getIdCarrito()%>">
                                <button type="submit" class="btn btn-sm btn-eliminar mt-1 float-right">Eliminar</button>
                            </form>

                        </div>

                        <div class="item-price ms-auto">
                            <p class="mb-0">S/<%= String.format("%.2f", carrito.getPrecio() * carrito.getCantidad())%></p>
                        </div>
                    </div>
                    <%
                        }
                    } else {
                    %>
                    <p>No tienes productos en tu carrito.</p>
                    <%
                        }
                    %>
                </div>

                <%
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                %>
            </div>
            <div class="col-md-4">
                <div class="card details-card">
                    <div class="card-body text-center">
                        <img src="../img/el y ella logo sin fondo.png" alt="Perfil" class="rounded-circle profile-img">
                        <h5 class="mt-2"><%= session.getAttribute("nombre")%></h5>
                        <hr>
                        <div class="totals">
                            <div class="d-flex justify-content-between">
                                <p>Subtotal</p>
                                <p>S/<%= String.format("%.2f", subtotal)%></p>
                            </div>
                            <div class="d-flex justify-content-between">
                                <p>Envío</p>
                                <p>S/<%= String.format("%.2f", envio)%></p>
                            </div>
                            <div class="d-flex justify-content-between">
                                <p>Total</p>
                                <p>S/<%= String.format("%.2f", total)%></p>
                            </div>
                        </div>
                        <button class="btn btn-primary mt-3" onclick="confirmarCompra()">Realizar compra</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script> <!-- SweetAlert2 JS -->

    <script>
                            function confirmarCompra() {
                                Swal.fire({
                                    title: '¿Estás seguro de que deseas realizar la compra?',
                                    text: "No podrás revertir esta acción",
                                    icon: 'warning',
                                    showCancelButton: true,
                                    confirmButtonColor: '#3085d6',
                                    cancelButtonColor: '#d33',
                                    confirmButtonText: 'Sí, comprar',
                                    cancelButtonText: 'Cancelar'
                                }).then((result) => {
                                    if (result.isConfirmed) {
                                        // Redirige a la página de pago si se confirma la compra
                                        window.location.href = 'payshop.jsp';
                                    }
                                });
                            }
    </script>
</body>





<br>
<br>

<footer class="footer">
    <div class="container container-footer">
        <div class="menu-footer">
            <div class="contact-info">
                <p class="title-footer">Información de Contacto</p>
                <ul>
                    <li>
                        Dirección: Av. Señor de Caudivilla 10, Carabayllo 15318, Perú
                    </li>
                    <li>Teléfono: +51 994 802 601</li>
                    <li>Email: elyelladetalles@gmail.com</li>
                </ul>
                <div class="social-icons">
                    <span class="facebook">
                        <i class="fa-brands fa-facebook-f"></i>
                    </span>
                    <span class="twitter">
                        <i class="fa-brands fa-twitter"></i>
                    </span>
                    <span class="youtube">
                        <i class="fa-brands fa-youtube"></i>
                    </span>
                    <span class="pinterest">
                        <i class="fa-brands fa-pinterest-p"></i>
                    </span>
                    <span class="instagram">
                        <i class="fa-brands fa-instagram"></i>
                    </span>
                </div>
            </div>

            <div class="information">
                <p class="title-footer">Información</p>
                <ul>
                    <li><a href="#">Acerca de Nosotros</a></li>
                    <li><a href="#">Información Delivery</a></li>
                    <li><a href="#">Políticas de Privacidad</a></li>
                    <li><a href="#">Términos y condiciones</a></li>
                    <li><a href="Contacto.jsp">Contáctanos</a></li>
                </ul>
            </div>

            <div class="my-account">
                <p class="title-footer">Mi cuenta</p>
                <ul>
                    <li><a href="User.jsp">Mi cuenta</a></li>
                    <li><a href="Pedidos.jsp">Historial de órdenes</a></li>
                    <li><a href="carshop.jsp">Carrito</a></li>
                </ul>
            </div>

            <div class="newsletter">
                <p class="title-footer">Sobre Nosotros</p>
                <div class="content">
                    <p>
                        Somos una empresa dedicada a la venta de arreglos florales, ofreciendo productos de calidad para todas tus ocasiones especiales.
                    </p>

                    <br><!-- comment -->
                    <a href="login.jsp">
                        <button>Loguéate</button>
                    </a>
                </div>
            </div>
        </div>

        <div class="copyright">
            <img src="../img/payment.png" alt="Pagos">
        </div>
    </div>
</footer>

</html>
