<%-- 
    Document   : Box Rosas
    Created on : 26 ago 2024, 20:31:16
    Author     : Joaquin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>El y Ella Detalles</title>
    <link rel="stylesheet" href="../style.css">
    <link rel="icon" href="../img/el y ella logo.jpeg">
</head>
<body>
    
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
						<i class="fa-thin fa-flower"></i>
						<h1 class="logo"><a href="/">El y Ella Detalles</a></h1>
					</div>

					<div class="container-user">
						<i class="fa-solid fa-user"></i>
						<i class="fa-solid fa-basket-shopping"></i>
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

        <section class="container top-products">
            <h1 class="heading-1">Nuestros Box Rosas</h1>
        
            <div class="container-options">
                <span class="active">Destacados</span>
                <span>Más recientes</span>
                <span>Mejores Vendidos</span>
            </div>
        
            <div class="container-products">
                <!-- Producto 1 -->
                <div class="card-product">
                    <div class="container-img">
                        <img src="../img/cafe-irish.jpg" alt="Cafe Irish" />
                        <span class="discount">-13%</span>
                        <div class="button-group">
                            <span>
                                <i class="fa-regular fa-eye"></i>
                            </span>
                            <span>
                                <i class="fa-regular fa-heart"></i>
                            </span>
                            <span>
                                <i class="fa-solid fa-code-compare"></i>
                            </span>
                        </div>
                    </div>
                    <div class="content-card-product">
                        <div class="stars">
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-regular fa-star"></i>
                        </div>
                        <h3>Cafe Irish</h3>
                        <span class="add-cart">
                            <i class="fa-solid fa-basket-shopping"></i>
                        </span>
                        <p class="price">$4.60 <span>$5.30</span></p>
                    </div>
                </div>
                <!-- Producto 2 -->
                <div class="card-product">
                    <div class="container-img">
                        <img src="img/cafe-ingles.jpg" alt="Cafe incafe-ingles.jpg" />
                        <span class="discount">-22%</span>
                        <div class="button-group">
                            <span>
                                <i class="fa-regular fa-eye"></i>
                            </span>
                            <span>
                                <i class="fa-regular fa-heart"></i>
                            </span>
                            <span>
                                <i class="fa-solid fa-code-compare"></i>
                            </span>
                        </div>
                    </div>
                    <div class="content-card-product">
                        <div class="stars">
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-regular fa-star"></i>
                            <i class="fa-regular fa-star"></i>
                        </div>
                        <h3>Cafe Inglés</h3>
                        <span class="add-cart">
                            <i class="fa-solid fa-basket-shopping"></i>
                        </span>
                        <p class="price">$5.70 <span>$7.30</span></p>
                    </div>
                </div>
                <!-- Más productos aquí -->
                <!-- Producto 2 -->
                <div class="card-product">
                    <div class="container-img">
                        <img src="img/cafe-ingles.jpg" alt="Cafe incafe-ingles.jpg" />
                        <span class="discount">-22%</span>
                        <div class="button-group">
                            <span>
                                <i class="fa-regular fa-eye"></i>
                            </span>
                            <span>
                                <i class="fa-regular fa-heart"></i>
                            </span>
                            <span>
                                <i class="fa-solid fa-code-compare"></i>
                            </span>
                        </div>
                    </div>
                    <div class="content-card-product">
                        <div class="stars">
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-regular fa-star"></i>
                            <i class="fa-regular fa-star"></i>
                        </div>
                        <h3>Cafe Inglés</h3>
                        <span class="add-cart">
                            <i class="fa-solid fa-basket-shopping"></i>
                        </span>
                        <p class="price">$5.70 <span>$7.30</span></p>
                    </div>
                </div>
                <!-- Producto 2 -->
                <div class="card-product">
                    <div class="container-img">
                        <img src="img/cafe-ingles.jpg" alt="Cafe incafe-ingles.jpg" />
                        <span class="discount">-22%</span>
                        <div class="button-group">
                            <span>
                                <i class="fa-regular fa-eye"></i>
                            </span>
                            <span>
                                <i class="fa-regular fa-heart"></i>
                            </span>
                            <span>
                                <i class="fa-solid fa-code-compare"></i>
                            </span>
                        </div>
                    </div>
                    <div class="content-card-product">
                        <div class="stars">
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-regular fa-star"></i>
                            <i class="fa-regular fa-star"></i>
                        </div>
                        <h3>Cafe Inglés</h3>
                        <span class="add-cart">
                            <i class="fa-solid fa-basket-shopping"></i>
                        </span>
                        <p class="price">$5.70 <span>$7.30</span></p>
                    </div>
                </div>
            </div>
        </section>

        <section class="container top-products">
            
        
            <div class="container-products">
                <!-- Producto 1 -->
                <div class="card-product">
                    <div class="container-img">
                        <img src="img/cafe-irish.jpg" alt="Cafe Irish" />
                        <span class="discount">-13%</span>
                        <div class="button-group">
                            <span>
                                <i class="fa-regular fa-eye"></i>
                            </span>
                            <span>
                                <i class="fa-regular fa-heart"></i>
                            </span>
                            <span>
                                <i class="fa-solid fa-code-compare"></i>
                            </span>
                        </div>
                    </div>
                    <div class="content-card-product">
                        <div class="stars">
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-regular fa-star"></i>
                        </div>
                        <h3>Cafe Irish</h3>
                        <span class="add-cart">
                            <i class="fa-solid fa-basket-shopping"></i>
                        </span>
                        <p class="price">$4.60 <span>$5.30</span></p>
                    </div>
                </div>
                <!-- Producto 2 -->
                <div class="card-product">
                    <div class="container-img">
                        <img src="img/cafe-ingles.jpg" alt="Cafe incafe-ingles.jpg" />
                        <span class="discount">-22%</span>
                        <div class="button-group">
                            <span>
                                <i class="fa-regular fa-eye"></i>
                            </span>
                            <span>
                                <i class="fa-regular fa-heart"></i>
                            </span>
                            <span>
                                <i class="fa-solid fa-code-compare"></i>
                            </span>
                        </div>
                    </div>
                    <div class="content-card-product">
                        <div class="stars">
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-regular fa-star"></i>
                            <i class="fa-regular fa-star"></i>
                        </div>
                        <h3>Cafe Inglés</h3>
                        <span class="add-cart">
                            <i class="fa-solid fa-basket-shopping"></i>
                        </span>
                        <p class="price">$5.70 <span>$7.30</span></p>
                    </div>
                </div>
                <!-- Más productos aquí -->
                <!-- Producto 2 -->
                <div class="card-product">
                    <div class="container-img">
                        <img src="img/cafe-ingles.jpg" alt="Cafe incafe-ingles.jpg" />
                        <span class="discount">-22%</span>
                        <div class="button-group">
                            <span>
                                <i class="fa-regular fa-eye"></i>
                            </span>
                            <span>
                                <i class="fa-regular fa-heart"></i>
                            </span>
                            <span>
                                <i class="fa-solid fa-code-compare"></i>
                            </span>
                        </div>
                    </div>
                    <div class="content-card-product">
                        <div class="stars">
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-regular fa-star"></i>
                            <i class="fa-regular fa-star"></i>
                        </div>
                        <h3>Cafe Inglés</h3>
                        <span class="add-cart">
                            <i class="fa-solid fa-basket-shopping"></i>
                        </span>
                        <p class="price">$5.70 <span>$7.30</span></p>
                    </div>
                </div>
                <!-- Producto 2 -->
                <div class="card-product">
                    <div class="container-img">
                        <img src="img/cafe-ingles.jpg" alt="Cafe incafe-ingles.jpg" />
                        <span class="discount">-22%</span>
                        <div class="button-group">
                            <span>
                                <i class="fa-regular fa-eye"></i>
                            </span>
                            <span>
                                <i class="fa-regular fa-heart"></i>
                            </span>
                            <span>
                                <i class="fa-solid fa-code-compare"></i>
                            </span>
                        </div>
                    </div>
                    <div class="content-card-product">
                        <div class="stars">
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-regular fa-star"></i>
                            <i class="fa-regular fa-star"></i>
                        </div>
                        <h3>Cafe Inglés</h3>
                        <span class="add-cart">
                            <i class="fa-solid fa-basket-shopping"></i>
                        </span>
                        <p class="price">$5.70 <span>$7.30</span></p>
                    </div>
                </div>
            </div>
        </section>

        <section class="container top-products">
            
        
            <div class="container-products">
                <!-- Producto 1 -->
                <div class="card-product">
                    <div class="container-img">
                        <img src="img/cafe-irish.jpg" alt="Cafe Irish" />
                        <span class="discount">-13%</span>
                        <div class="button-group">
                            <span>
                                <i class="fa-regular fa-eye"></i>
                            </span>
                            <span>
                                <i class="fa-regular fa-heart"></i>
                            </span>
                            <span>
                                <i class="fa-solid fa-code-compare"></i>
                            </span>
                        </div>
                    </div>
                    <div class="content-card-product">
                        <div class="stars">
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-regular fa-star"></i>
                        </div>
                        <h3>Cafe Irish</h3>
                        <span class="add-cart">
                            <i class="fa-solid fa-basket-shopping"></i>
                        </span>
                        <p class="price">$4.60 <span>$5.30</span></p>
                    </div>
                </div>
                <!-- Producto 2 -->
                <div class="card-product">
                    <div class="container-img">
                        <img src="img/cafe-ingles.jpg" alt="Cafe incafe-ingles.jpg" />
                        <span class="discount">-22%</span>
                        <div class="button-group">
                            <span>
                                <i class="fa-regular fa-eye"></i>
                            </span>
                            <span>
                                <i class="fa-regular fa-heart"></i>
                            </span>
                            <span>
                                <i class="fa-solid fa-code-compare"></i>
                            </span>
                        </div>
                    </div>
                    <div class="content-card-product">
                        <div class="stars">
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-regular fa-star"></i>
                            <i class="fa-regular fa-star"></i>
                        </div>
                        <h3>Cafe Inglés</h3>
                        <span class="add-cart">
                            <i class="fa-solid fa-basket-shopping"></i>
                        </span>
                        <p class="price">$5.70 <span>$7.30</span></p>
                    </div>
                </div>
                <!-- Más productos aquí -->
                <!-- Producto 2 -->
                <div class="card-product">
                    <div class="container-img">
                        <img src="img/cafe-ingles.jpg" alt="Cafe incafe-ingles.jpg" />
                        <span class="discount">-22%</span>
                        <div class="button-group">
                            <span>
                                <i class="fa-regular fa-eye"></i>
                            </span>
                            <span>
                                <i class="fa-regular fa-heart"></i>
                            </span>
                            <span>
                                <i class="fa-solid fa-code-compare"></i>
                            </span>
                        </div>
                    </div>
                    <div class="content-card-product">
                        <div class="stars">
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-regular fa-star"></i>
                            <i class="fa-regular fa-star"></i>
                        </div>
                        <h3>Cafe Inglés</h3>
                        <span class="add-cart">
                            <i class="fa-solid fa-basket-shopping"></i>
                        </span>
                        <p class="price">$5.70 <span>$7.30</span></p>
                    </div>
                </div>
                <!-- Producto 2 -->
                <div class="card-product">
                    <div class="container-img">
                        <img src="img/cafe-ingles.jpg" alt="Cafe incafe-ingles.jpg" />
                        <span class="discount">-22%</span>
                        <div class="button-group">
                            <span>
                                <i class="fa-regular fa-eye"></i>
                            </span>
                            <span>
                                <i class="fa-regular fa-heart"></i>
                            </span>
                            <span>
                                <i class="fa-solid fa-code-compare"></i>
                            </span>
                        </div>
                    </div>
                    <div class="content-card-product">
                        <div class="stars">
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-regular fa-star"></i>
                            <i class="fa-regular fa-star"></i>
                        </div>
                        <h3>Cafe Inglés</h3>
                        <span class="add-cart">
                            <i class="fa-solid fa-basket-shopping"></i>
                        </span>
                        <p class="price">$5.70 <span>$7.30</span></p>
                    </div>
                </div>
            </div>
        </section>
        
            
        

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


        <script src="https://kit.fontawesome.com/74353e97ea.js" crossorigin="anonymous"></script>

    </body>
    </html>
