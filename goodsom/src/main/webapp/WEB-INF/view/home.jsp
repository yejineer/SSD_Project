<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	

<!doctype html>
<html lang="en">

<head>

<head>
<title>Goodsom &mdash; SSD Final Project</title>
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

<body data-spy="scroll" data-target=".site-navbar-target"
	data-offset="300">


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
							<a href="index.html" class="font-weight-bold">Goodsom</a>
						</div>
					</div>

					<div class="col-9  text-right">


						<span class="d-inline-block d-lg-none"><a href="#"
							class="text-primary site-menu-toggle js-menu-toggle py-5"><span
								class="icon-menu h3 text-primary"></span></a></span>



						<nav class="site-navigation text-right ml-auto d-none d-lg-block"
							role="navigation">
							<ul class="site-menu main-menu js-clone-nav ml-auto ">
								<li><a href="<%=request.getContextPath()%>/home.do" class="nav-link">Home</a></li>
								<li><a href="<%=request.getContextPath()%>/groupBuy/list.do" class="nav-link">GroupBuy</a></li>
								<li><a href="<%=request.getContextPath()%>/auction/list.do" class="nav-link">Auction</a></li>
								<li><a href="#">Community</a></li>
								<li><a href="#"><img src="<%=request.getContextPath()%>/resources/images/mypage.jpg" alt="Image" 
								width="30px" height="20px" class="img-fluid"></a></li>
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
						<h1 class="text-white mb-4">Don’t worry if it doesn’t work right. If everything did, you’d be out of a job.</h1>
						<p class="lead">올바로 동작하지 않더라도 걱정말아라. 모든 것이 그랬다면, 넌 직업을 잃었을테니까.</p>
						<p>
							<a href="<c:url value='/order/list.do' />" data-fancybox
								class="btn-video_38929"><span class="icon-play"></span></a>
						</p>
					</div>
				</div>
			</div>
		</div>

		<div class="container-fluid portfolio-wrap bg-light pt-0 site-section">
			<div class="col-md-6 mr-auto">
				<a href="<c:url value='/groupBuy/list.do'></c:url>" class="nav-link">공동구매 더보기</a>
			</div>
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
			
			<div class="col-md-6 mr-auto">
				<a href="<c:url value='/auction/list.do'></c:url>">경매 더보기</a>
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
						<h2 class="text-white font-weight-bold">Dongduk Women's University</h2>
						<p class="text-white lead">Computer Science 17th grade</p>
						<p class="text-white lead">Software System Development Final Project Goodsom</p>
					</div>
				</div>
			</div>
			<div class="container-fluid">
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

