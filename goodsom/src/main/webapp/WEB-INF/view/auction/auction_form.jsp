<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	

<!doctype html>
<html lang="ko">

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
<script>
function createAuction() {
	
	auctionForm.submit();
	alert("경매를 등록합니다.");
}
</script>
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
								<li><a href="<%=request.getContextPath()%>/user/detail.do"><img src="<%=request.getContextPath()%>/resources/images/mypage.jpg" alt="Image" 
								width="30px" height="20px" class="img-fluid"> ${userSession.user.nickname}</a></li>
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
					<div class="col-lg-6">
						<h1 class="text-white mb-4">Add Auction</h1>
						<p class="lead">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit maxime nemo placeat dolor.</p>

					</div>
				</div>
			</div>
		</div>


		<div class="site-section bg-left-half">
			<div class="container">
				<div class="row" >
					<div class="col-lg-8 mb-5">
						<form id="auctionForm" method="post" action="<c:choose>
									<c:when test='${createAuction eq true}'><c:url value='/auction/create.do'/></c:when>
									<c:otherwise><c:url value='/auction/update.do'/></c:otherwise></c:choose>">
						
							<div class="form-group row">
								<div class="col-md-12">
									<label for="title">제목</label> 
									<c:choose>
										<c:when test="${createAuction eq true}">
											<input type="text" id="title" name="auction.title" class="form-control" placeholder="Title" >
										</c:when>
										<c:otherwise>
											<input type="text" id="title" name="auction.title" class="form-control" placeholder="${auctionForm.auction.title}" >
										</c:otherwise>
									</c:choose>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-12">
									<label for="img">대표 이미지</label>
                					<input type="file" id="img" name="auction.img" value="input file" />
              					</div>
              				</div>
							
							<div class="form-group row">
								<div class="col-md-12">
									<label for="content">상세 설명</label>
									<c:choose>
										<c:when test="${createAuction eq true}">
											<textarea id="content" name="auction.content" class="form-control"
											placeholder="Write description." cols="30" rows="10"></textarea>
										</c:when>
										<c:otherwise>
											<textarea id="content" name="auction.content" class="form-control"
											placeholder="${auctionForm.auction.content}" cols="30" rows="10"></textarea>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
							
							<div class="form-group row">
								<div class="col-md-12">
									<label for="startPrice">최소 입찰 금액</label> 
									<div class="d-flex">
										<div class="form-group mr-2">
										<c:choose>
											<c:when test="${createAuction eq true}">
												<input type="text" id="startPrice" class="form-control" name="auction.startPrice" placeholder="ex) 5000">
											</c:when>
											<c:otherwise>
												<input type="text" id="startPrice" class="form-control" name="auction.startPrice" placeholder="${auctionForm.auction.startPrice}">
											</c:otherwise>
										</c:choose>
										</div>
									</div>
								</div>
							</div>
							
							<div class="form-group">
			              	<label for="endDate">마감일</label>
				                <div class="d-flex">
					    		  <div class="form-group mr-2">
					    		  	<c:choose>
										<c:when test="${createAuction eq true}">
							                <input type="date" id="endDate" class="form-control" name="auction.endDate">
										</c:when>
										<c:otherwise>
											<input type="date" id="endDate" class="form-control" name="auction.endDate" 
													value="<fmt:formatDate value='${auctionForm.auction.endDate}' pattern='yyyy-MM-dd'/>">
										</c:otherwise>
									</c:choose>
					              </div>
			              		</div>
			              	</div>

							
							<div class="form-group" align="right">
								<a class="btn btn-primary py-3 px-5" href="<c:url value='/auction/list.do'></c:url>">Cancel</a> &nbsp;
								<input type="button" value="Save" onClick="createAuction()" class="btn btn-primary py-3 px-5">
							</div>
						</form>
					</div>
				</div>

			</div>
		</div>
		<!-- END .site-section -->


		<div class="footer site-section bg-light">
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<div class="site-logo-footer">
							<a href="index.html"></a>
						</div>
					</div>
					<div class="col-md-8 ml-auto">
						<div class="row">
							<div class="col-md-4 ml-auto">
								<ul class="list-unstyled links">
									<!-- <li><a href="#">Contact Us</a></li>
									<li><a href="#">hello@mydomain.com</a></li>
									<li><a href="#">+1 829 2293 382</a></li>
									<li><a href="#">Support</a></li> -->
								</ul>
							</div>
							<div class="col-md-4">
								<ul class="list-unstyled links">
									<!-- <li><a href="#">Home</a></li>
									<li><a href="#">Blog</a></li>
									<li><a href="#">Services</a></li>
									<li><a href="#">About Us</a></li> -->
								</ul>
							</div>
							<div class="col-md-4">
								<ul class="list-unstyled links">
									<!-- <li><a href="#">Home</a></li>
									<li><a href="#">Blog</a></li>
									<li><a href="#">Services</a></li>
									<li><a href="#">About Us</a></li> -->
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section bg-light">
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
							<script>document.write(new Date().getFullYear());</script>
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
            strings: ["Business"," Startups"," Organization", " Company"],
            typeSpeed: 80,
            backSpeed: 80,
            backDelay: 4000,
            startDelay: 1000,
            loop: true,
            showCursor: true
            });
            </script>


	<script src="js/main.js"></script>

</body>

</html>

