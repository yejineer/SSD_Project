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
								<li><a href="<%=request.getContextPath()%>/auction/list.do" class="nav-link"">Auction</a></li>
								<li><a href="#">Community</a></li>
								<li><a href="#"><img src="<%=request.getContextPath()%>/resources/images/mypage.jpg" alt="Image" 
								width="30px" height="20px" class="img-fluid"></a></li>
							</ul>
						</nav>
					</div>


				</div>
			</div>

		</header>
		
		<!-- 구현 시작 -->
		<h1>결제 내역</h1>
		<table border="1">
		<tr>
			<td><b>공동구매</b></td>
			<td><b>경매</b></td>
		</tr>
		
		<c:forEach var="order" items="${orderList}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td><img src="${order.img}"></td>
				<td><a href="<c:url value="/order/detail.do">
								<c:param name="orderId" value="${order.orderId}" />
							</c:url>">${order.title}</a></td>
				<td>${order.date}</td>
				<td>${order.totalPrice}</td>
			</tr>
		</c:forEach>
		</table>
		
		<!-- 구현 끝 -->
		
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

		