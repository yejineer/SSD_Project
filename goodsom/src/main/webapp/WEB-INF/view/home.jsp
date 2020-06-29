<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	

<!doctype html>
<html lang="ko">

<head>

<head>
<title>Goodsom &mdash; SSD Final Project</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="https://fonts.googleapis.com/css?family=Poppins:400,900|Source+Serif+Pro&display=swap" rel="stylesheet">

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
							<a href="<%=request.getContextPath()%>/home.do" class="font-weight-bold">Goodsom</a>
						</div>
					</div>

					<div class="col-9 text-right">

						<span class="d-inline-block d-lg-none"><a href="#"
							class="text-primary site-menu-toggle js-menu-toggle py-5"><span
								class="icon-menu h3 text-primary"></span></a></span>

						<nav class="site-navigation text-right ml-auto d-none d-lg-block" role="navigation">
							<ul class="site-menu main-menu js-clone-nav ml-auto ">
								<li><a href="<%=request.getContextPath()%>/home.do" class="nav-link">Home</a></li>
								<li><a href="<%=request.getContextPath()%>/groupBuy/list.do" class="nav-link">GroupBuy</a></li>
								<li><a href="<%=request.getContextPath()%>/auction/list.do" class="nav-link">Auction</a></li>
								<li><a href="<%=request.getContextPath()%>/user/detail.do"><img src="<%=request.getContextPath()%>/resources/images/userIcon.png" alt="Image" 
								width="30px" height="20px" class="img-fluid"> ${userSession.user.nickname}</a>
									<a href="<%=request.getContextPath()%>/noti/list.do"><img src="<%=request.getContextPath()%>/resources/images/noti.png" alt="Image" width="30px" height="20px" class="img-fluid"></a>
								</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>

		</header>


		<div class="site-section-cover">
			<div class="container">
				<div class="row align-items-center text-center justify-content-center">
					<div class="col-lg-10">
						<h1 class="text-white mb-4">GOODSOM</h1>
						<p class="lead">Dongduk Women's University Goods Market</p><br/>
						<p><a href="<c:url value='/order/list.do' />" data-fancybox class="btn-video_38929"><span class="icon-play"></span></a></p>
					</div>
				</div>
			</div>
		</div>

		<div class="container-fluid portfolio-wrap bg-light pt-0 site-section">
		
			<div class="col-md-6 mr-auto">
				<a href="<c:url value='/groupBuy/list.do'></c:url>" class="btn btn-primary py-3 px-5">공동구매 더보기 &nbsp;></a>
			</div>
			
			<div class="row align-items-end mb-4">
				<c:forEach var="groupBuy" items="${recentGroupBuy}" varStatus="status">
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="post-entry-1 h-100">
							
								<a href="<c:url value='/groupBuy/detail.do'>
									<c:param name="groupBuyId" value="${groupBuy.groupBuyId}"/></c:url>">
										<img src="${groupBuy.img}" alt="Image" class="img-fluid">
								</a>
								<div style="float:right">조회수: ${groupBuy.count}&nbsp;&nbsp;</div>
								<div class="post-entry-1-contents">
									<div class="price-wrap d-flex" style="color:blue;">
										<c:if test="${groupBuy.state eq 'proceeding'}" >
											<h5>Proceeding</h5>
										</c:if>
										<c:if test="${groupBuy.state eq 'achieved'}" >
											<h5>Achieved</h5>
										</c:if>
										<c:if test="${groupBuy.state eq 'closed'}" >
											<h5>Closed</h5>
										</c:if>
									
										<span class="meta d-inline-block mb-3">
											
											&nbsp; ~ <fmt:formatDate value="${groupBuy.endDate}" pattern="yyyy-MM-dd" />
										</span>
									</div>
									
									<h2><a  href="<c:url value='/groupBuy/detail.do'>
													<c:param name="groupBuyId" value="${groupBuy.groupBuyId}"/>
												</c:url>">${groupBuy.title}</a>
									</h2>
									
										<span class="mx-2">가격</span> 
											<a href="#"><fmt:formatNumber value="${groupBuy.price}" pattern="#,###원"/></a> <br/><br/>
										
										<span class="mx-2">달성률</span> 
											<a href="#"><fmt:formatNumber value="${groupBuy.participants}"/>명 / </a>
											<a href="#"><fmt:formatNumber value="${groupBuy.minNo}"/>명</a>
											<a href="#"><fmt:formatNumber value="${groupBuy.rate}"/>%</a>
										
									
									<p>${groupBuy.content}</p>
									
								</div>
							</div>
						</div>
    				

					</c:forEach>
			</div>
			
			<div class="col-md-6 mr-auto">
				<a href="<c:url value='/auction/list.do'></c:url>" class="btn btn-primary py-3 px-5">경매 더보기 &nbsp;></a>
			</div>
			
			<div class="row align-items-start">
				<c:forEach var="auction" items="${recentAuction}" varStatus="status">
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="post-entry-1 h-100">
								
								<a href="<c:url value='/auction/detail.do'><c:param name="auctionId" value="${auction.auctionId}"/></c:url>">
									<img src="${auction.img}" alt="Image" class="img-fluid">
								</a>
								<div style="float:right">조회수: ${auction.count}&nbsp;&nbsp;</div>
								<div class="post-entry-1-contents">
									<div class="price-wrap d-flex" style="color:blue;">
									
										<c:if test="${auction.state eq 'proceeding'}">
											<h5>Proceeding</h5> 
										</c:if>
										
										<c:if test="${auction.state eq 'closed'}">
											<h5>Closed</h5>
										</c:if>
										
			    						<span class="meta d-inline-block mb-3">
											&nbsp; ~ <fmt:formatDate value="${auction.endDate}" pattern="yyyy-MM-dd" />
										</span>
			    					</div>
										
									<h2><a  href="<c:url value='/auction/detail.do'>
											<c:param name="auctionId" value="${auction.auctionId}"/>
											</c:url>">${auction.title}</a>
									</h2>
										
									<span class="meta d-inline-block mb-3">
										<span>현재 최고 금액</span> &nbsp;
										<a href="#"><fmt:formatNumber value="${auction.maxPrice}" pattern="#,###원"/></a>
									</span>
										
									<p>${auction.content}</p>
								</div>
							</div>
						</div>
					</c:forEach>
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

