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
						<h1 class="text-white mb-4">Proceed Order</h1>
						<p class="lead">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit maxime nemo placeat dolor.</p>

					</div>
				</div>
			</div>
		</div>

		<div class="site-section bg-left-half">
			<div class="container">
			
				<h2>주문 내역 확인</h2>	<br />
				
				<c:choose>
					<c:when test="${lineGroupBuyForm ne null}">  <!-- 공동구매, List<LineGroupBuy> lineGroupBuys를 넘겨준다고 가정 -->
						<%-- <c:forEach var="lineGroupBuy" items="${lineGroupBuys}" varStatus="status"> --%>
							<div class="col-lg-4 col-md-6 mb-4">
								<div class="post-entry-1 h-100">
									<div class="post-entry-1-contents">
										<h3>
											<a href="<c:url value='../../groupBuy/detail.do'>
															<c:param name="groupBuyId" value="${lineGroupBuyForm.groupBuyId}" />
													 </c:url>"> ${lineGroupBuyForm.groupBuy.title}</a>
										</h3>
		
										<span class="meta d-inline-block mb-3">
											<span class="mx-2"> ${lineGroupBuyForm.unitPrice}원</span> &nbsp;&nbsp; 
											<span class="mx-2"> ${lineGroupBuyForm.quantity}개</span> &nbsp;&nbsp;
											<span class="mx-2"> 옵션 : ${lineGroupBuyForm.option}</span> <br>
										</span>
									</div>
								</div>
								<br />
								<div class="d-flex">
									<h4>TotalPrice : ${lineGroupBuyForm.unitPrice}원</h4> &nbsp;
								</div>
							</div>
						<%-- </c:forEach> --%>
					</c:when>
					<c:otherwise> <!-- 경매 auction, 객체를 넘겨준다고 가정-->
							<div class="col-lg-4 col-md-6 mb-4">
								<div class="post-entry-1 h-100">
									<div class="post-entry-1-contents">
										<h3>
											<a href="<c:url value='../auction/detail.do'>
															<c:param name="auctionId" value="${auction.auctionId}" />
													 </c:url>"> ${lineGroupBuy.groupBuy.title}</a>
										</h3>
		
										<span class="meta d-inline-block mb-3">
											<span class="mx-2"> ${lineGroupBuy.unitPrice}원</span> &nbsp;&nbsp; 
											<span class="mx-2"> ${lineGroupBuy.quantity}개</span> &nbsp;&nbsp;
											<span class="mx-2"> 옵션 : ${lineGroupBuy.option}</span> <br>
										</span>
									</div>
								</div>
							</div>
					</c:otherwise>
				</c:choose>

				<div class="row" >
					<div class="col-lg-8 mb-5">
						<h2>결제 정보 입력</h2>
						<form:form modelAttribute="orderForm" class="bg-light p-5 contact-form">
							<div class="form-group">
								<label for="account">카드정보</label> 
								<div class="d-flex">
								<form:select path="order.cardBank" items="${cardBanks}" />
								<form:errors path="order.cardBank" />
								<form:input path="order.cardNo" type="text"
									class="form-control" placeholder="카드번호를 입력하세요" /> 
								</div>
								<form:errors path="order.cardNo" />
							</div>
							
							<div class="form-group">
								<label for="validDate">유효기간</label> 
								<form:input path="order.validDate" type="text"
									class="form-control" placeholder="MM/YY" />
								<form:errors path="order.validDate" />	
							</div>

							<div class="form-group">
								<label for="cvc">CVC</label> 
								<form:input path="order.cvc" type="text" 
									class="form-control" placeholder="123" />
								<form:errors path="order.cvc" />	
							</div>

							<div class="form-group">
								<label for="phone">전화번호</label> 
								<form:input path="order.phone" type="text"
									class="form-control" placeholder="010-1234-5678" />
								<form:errors path="order.phone" />	
							</div>

							<div class="form-group">
								<label for="name">Address</label> <br /> 
								<form:input path="order.address1" type="text"
									style="width: 70px;" />&nbsp;-&nbsp;
								<form:input path="order.address2" type="text"
									style="width: 70px;" /> &nbsp;&nbsp; 
								<form:input path="order.address3" type="text" 
								value="" style="width: 70px;" />
								<form:errors path="order.address1" />	
								<form:errors path="order.address2" />	
								<form:errors path="order.address3" />	
							</div>

							<div class="form-group">
								<label for="refundAccount">환불계좌</label> 
								<div class="d-flex">
									<form:select path="order.refundBank" items="${cardBanks}" />
									<form:errors path="order.refundBank" />	
									<form:input path="order.refundAccount" type="text"
										class="form-control" placeholder="환불계좌를 입력하세요" />
								</div>
								<form:errors path="order.refundAccount" />	 
							</div>
							
							<br />

							<div class="form-group" align="center">
								<input type="submit" value="Order" class="btn btn-primary py-3 px-5"> &nbsp;
								<a class="btn btn-primary py-3 px-5" href="<c:url value='../../groupBuy/detail.do'>
																				<c:param name="groupBuyId" value="${orderForm.order.groupBuyId}" />
																			</c:url>">Cancel</a> 
							</div>
						</form:form>
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

