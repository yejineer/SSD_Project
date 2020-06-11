<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	

<!doctype html>
<html lang="en">

<head>
<title>Approach &mdash; Website Template by Colorlib</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:400,900|Source+Serif+Pro&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/fonts/icomoon/style.css">

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/jquery.fancybox.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/owl.carousel.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/owl.theme.default.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/fonts/flaticon/font/flaticon.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/aos.css">

<!-- MAIN CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">

</head>

<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">


	<div class="site-wrap" id="home-section">

		<div class="site-mobile-menu site-navbar-target">
			<div class="site-mobile-menu-header">
				<div class="site-mobile-menu-close mt-3">
					<span class="icon-close2 js-menu-toggle"></span>
				</div>
			</div>
			<div class="site-mobile-menu-body"></div>
		</div>



		<header class="site-navbar site-navbar-target" role="banner">

			<div class="container">
				<div class="row align-items-center position-relative">

					<div class="col-3">
						<div class="site-logo">
							<a href="index.html" class="font-weight-bold">Approach</a>
						</div>
					</div>

					<div class="col-9  text-right">


						<span class="d-inline-block d-lg-none"><a href="#"
							class="text-primary site-menu-toggle js-menu-toggle py-5"><span
								class="icon-menu h3 text-primary"></span></a></span>



						<nav class="site-navigation text-right ml-auto d-none d-lg-block"
							role="navigation">
							<ul class="site-menu main-menu js-clone-nav ml-auto ">
								<li><a href="<%=request.getContextPath()%>/index.do" class="nav-link">Home</a></li>
								<li><a href="#">A</a></li>
								<li><a href="#">B</a></li>
								<li><a href="#">C</a></li>
								<li><a href="#">D</a></li>
							</ul>
						</nav>
					</div>


				</div>
			</div>

		</header>


		<div class="site-section-cover">
			<div class="container">
				<div
					class="row align-items-center text-center justify-content-center">
					<div class="col-lg-10">
						<h1 class="text-white mb-4">Creativity is a wild mind and a
							disciplined eye.</h1>
						<p class="lead">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit maxime nemo placeat dolor est.</p>
						<p>
							<a href="<c:url value='/user/register.do' />" data-fancybox
								class="btn-video_38929"><span class="icon-play"></span></a>
						</p>
					</div>
				</div>
			</div>
		</div>

		<div class="container-fluid portfolio-wrap bg-light pt-0 site-section">
			<div class="row align-items-end mb-4">
				<div class="col-md-3">
					<a href="portfolio-single.html" class="portfolio-item"><img
						src="<%=request.getContextPath()%>/resources/images/img_1.jpg" alt="Image" class="img-fluid"></a>
				</div>
				<div class="col-md-6">
					<a href="portfolio-single.html" class="portfolio-item"><img
						src="<%=request.getContextPath()%>/resources/images/img_2.jpg" alt="Image" class="img-fluid"></a>
				</div>
				<div class="col-md-3">
					<a href="portfolio-single.html" class="portfolio-item"><img
						src="<%=request.getContextPath()%>/resources/images/img_3.jpg" alt="Image" class="img-fluid"></a>
				</div>
			</div>
			<div class="row align-items-start">
				<div class="col-md-4">
					<a href="portfolio-single.html" class="portfolio-item"><img
						src="<%=request.getContextPath()%>/resources/images/img_2.jpg" alt="Image" class="img-fluid"></a>
				</div>
				<div class="col-md-4">
					<a href="portfolio-single.html" class="portfolio-item"><img
						src="<%=request.getContextPath()%>/resources/images/hero_1.jpg" alt="Image" class="img-fluid"></a>
				</div>
				<div class="col-md-4">
					<a href="portfolio-single.html" class="portfolio-item"><img
						src="<%=request.getContextPath()%>/resources/images/hero_3.jpg" alt="Image" class="img-fluid"></a>
				</div>
			</div>
		</div>

		<div class="site-section">
			<div class="container">
				<div class="row">
					<div class="col-md-4">
						<div class="service-29191">
							<span class="wrap-icon mb-4 d-block"> <span
								class="icon-desktop_windows"></span>
							</span>
							<h3 class="mb-3">Interface Design</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
								Deleniti voluptatem reiciendis minus, a dolores.</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="service-29191">
							<span class="wrap-icon mb-4 d-block"> <span
								class="icon-explore"></span>
							</span>
							<h3 class="mb-3">Product Design</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
								Deleniti voluptatem reiciendis minus, a dolores.</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="service-29191">
							<span class="wrap-icon mb-4 d-block"> <span
								class="icon-layers"></span>
							</span>
							<h3 class="mb-3">Quality Results</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
								Deleniti voluptatem reiciendis minus, a dolores.</p>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section bg-primary">
			<div class="container mb-5">
				<div class="row">
					<div class="col-md-7">
						<h2 class="text-white font-weight-bold">Blog Updates</h2>
						<p class="text-white lead">Lorem ipsum dolor sit amet,
							consectetur adipisicing elit. Deserunt ducimus facere quam eos
							tempore beatae non eius, provident.</p>
					</div>
				</div>
			</div>
			<div class="container-fluid">




				<div class="owl-carousel nonloop-block-13">
					<div class="media-29191">
						<a href="#" class="d-block mb-4"><img src="images/img_2.jpg"
							alt="Image" class="img-fluid"></a> <span class="date d-block">October
							18, 2019</span>
						<h3 class="mb-4">
							<a href="#">Google saying pseudo-telephoto is more important</a>
						</h3>
						<div class="d-flex vcard-91123 align-items-center">
							<div class="img mr-3">
								<img src="<%=request.getContextPath()%>/resources/images/person_1.jpg" alt="Image" class="img-fluid">
							</div>
							<div class="name">
								<span class="d-block">by John Freeman</span> 
								<span>Thinker &amp; Designer</span>
							</div>
						</div>
					</div>


					<div class="media-29191">
						<a href="#" class="d-block mb-4"><img src="images/img_1.jpg"
							alt="Image" class="img-fluid"></a> <span class="date d-block">October
							18, 2019</span>
						<h3 class="mb-4">
							<a href="#">Google saying pseudo-telephoto is more important</a>
						</h3>
						<div class="d-flex vcard-91123 align-items-center">
							<div class="img mr-3">
								<img src="<%=request.getContextPath()%>/resources/images/person_1.jpg" alt="Image" class="img-fluid">
							</div>
							<div class="name">
								<span class="d-block">by John Freeman</span> 
								<span>Thinker &amp; Designer</span>
							</div>
						</div>
					</div>

					<div class="media-29191">
						<a href="#" class="d-block mb-4"><img src="images/img_3.jpg"
							alt="Image" class="img-fluid"></a> <span class="date d-block">October
							18, 2019</span>
						<h3 class="mb-4">
							<a href="#">Google saying pseudo-telephoto is more important</a>
						</h3>
						<div class="d-flex vcard-91123 align-items-center">
							<div class="img mr-3">
								<img src="<%=request.getContextPath()%>/resources/images/person_1.jpg" alt="Image" class="img-fluid">
							</div>
							<div class="name">
								<span class="d-block">by John Freeman</span> 
								<span>Thinker &amp; Designer</span>
							</div>
						</div>
					</div>

					<div class="media-29191">
						<a href="#" class="d-block mb-4"><img src="images/img_2.jpg"
							alt="Image" class="img-fluid"></a> <span class="date d-block">October
							18, 2019</span>
						<h3 class="mb-4">
							<a href="#">Google saying pseudo-telephoto is more important</a>
						</h3>
						<div class="d-flex vcard-91123 align-items-center">
							<div class="img mr-3">
								<img src="<%=request.getContextPath()%>/resources/images/person_1.jpg" alt="Image" class="img-fluid">
							</div>
							<div class="name">
								<span class="d-block">by John Freeman</span> 
								<span>Thinker &amp; Designer</span>
							</div>
						</div>
					</div>


					<div class="media-29191">
						<a href="#" class="d-block mb-4"><img src="<%=request.getContextPath()%>/resources/images/img_1.jpg"
							alt="Image" class="img-fluid"></a> <span class="date d-block">October
							18, 2019</span>
						<h3 class="mb-4">
							<a href="#">Google saying pseudo-telephoto is more important</a>
						</h3>
						<div class="d-flex vcard-91123 align-items-center">
							<div class="img mr-3">
								<img src="<%=request.getContextPath()%>/resources/images/person_1.jpg" alt="Image" class="img-fluid">
							</div>
							<div class="name">
								<span class="d-block">by John Freeman</span> <span>Thinker
									&amp; Designer</span>
							</div>
						</div>
					</div>

					<div class="media-29191">
						<a href="#" class="d-block mb-4"><img src="<%=request.getContextPath()%>/resources/images/img_3.jpg"
							alt="Image" class="img-fluid"></a> <span class="date d-block">October
							18, 2019</span>
						<h3 class="mb-4">
							<a href="#">Google saying pseudo-telephoto is more important</a>
						</h3>
						<div class="d-flex vcard-91123 align-items-center">
							<div class="img mr-3">
								<img src="<%=request.getContextPath()%>/resources/images/person_1.jpg" alt="Image" class="img-fluid">
							</div>
							<div class="name">
								<span class="d-block">by John Freeman</span> <span>Thinker
									&amp; Designer</span>
							</div>
						</div>
					</div>

				</div>

			</div>
		</div>

		<div class="site-section bg-light">
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<img src="<%=request.getContextPath()%>/resources/images/client_google.png" alt="Image" class="img-fluid">
					</div>
					<div class="col-md-3">
						<img src="<%=request.getContextPath()%>/resources/images/client_invision.png" alt="Image"
							class="img-fluid">
					</div>
					<div class="col-md-3">
						<img src="<%=request.getContextPath()%>/resources/images/client_nike.png" alt="Image" class="img-fluid">
					</div>
					<div class="col-md-3">
						<img src="<%=request.getContextPath()%>/resources/images/client_microsoft.png" alt="Image"
							class="img-fluid">
					</div>
				</div>
			</div>
		</div>


		<div class="footer site-section bg-white">
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<div class="site-logo-footer">
							<a href="index.html">Approach</a>
						</div>
					</div>
					<div class="col-md-8 ml-auto">
						<div class="row">
							<div class="col-md-4 ml-auto">
								<ul class="list-unstyled links">
									<li><a href="#">Contact Us</a></li>
									<li><a href="#">hello@mydomain.com</a></li>
									<li><a href="#">+1 829 2293 382</a></li>
									<li><a href="#">Support</a></li>
								</ul>
							</div>
							<div class="col-md-4">
								<ul class="list-unstyled links">
									<li><a href="#">Home</a></li>
									<li><a href="#">Blog</a></li>
									<li><a href="#">Services</a></li>
									<li><a href="#">About Us</a></li>
								</ul>
							</div>
							<div class="col-md-4">
								<ul class="list-unstyled links">
									<li><a href="#">Home</a></li>
									<li><a href="#">Blog</a></li>
									<li><a href="#">Services</a></li>
									<li><a href="#">About Us</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section">
			<div class="container">
				<div class="row mb-4 text-center">
					<div class="col">
						<a href="#"><span class="m-2 icon-facebook"></span></a> <a
							href="#"><span class="m-2 icon-twitter"></span></a> <a href="#"><span
							class="m-2 icon-linkedin"></span></a> <a href="#"><span
							class="m-2 icon-instagram"></span></a> <a href="#"><span
							class="m-2 icon-skype"></span></a>
					</div>
				</div>
				<div class="row mt-5 justify-content-center">
					<div class="col-md-7 text-center">
						<p>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							Copyright &copy;
							<script>
								document.write(new Date().getFullYear());
							</script>
							All rights reserved | This template is made with <i
								class="icon-heart text-danger" aria-hidden="true"></i> by <a
								href="https://colorlib.com" target="_blank">Colorlib</a>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						</p>
					</div>
				</div>
			</div>
		</div>



	</div>

	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/jquery-migrate-3.0.0.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.sticky.js"></script>
	<script src="js/jquery.waypoints.min.js"></script>
	<script src="js/jquery.animateNumber.min.js"></script>
	<script src="js/jquery.fancybox.min.js"></script>
	<script src="js/jquery.stellar.min.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/bootstrap-datepicker.min.js"></script>
	<script src="js/isotope.pkgd.min.js"></script>
	<script src="js/aos.js"></script>


	<script src="js/typed.js"></script>
	<script>
		var typed = new Typed('.typed-words', {
			strings : [ "Business", " Startups", " Organization", " Company" ],
			typeSpeed : 80,
			backSpeed : 80,
			backDelay : 4000,
			startDelay : 1000,
			loop : true,
			showCursor : true
		});
	</script>


	<script src="js/main.js"></script>

</body>

</html>

