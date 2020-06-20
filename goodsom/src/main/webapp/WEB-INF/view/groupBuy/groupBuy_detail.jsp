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
        <div class="row align-items-center text-center justify-content-center">
          <div class="col-lg-6">
            <h1 class="text-white mb-4">About GroupBuy</h1>
            <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit maxime nemo placeat dolor est.</p>
            
          </div>
        </div>
      </div>
    </div>


    <!-- start groupBuy detail -->
	<br/>    
    <div align="center">
    	<br/><h2 class="text-primary mb-5 font-weight-bold">${groupBuy.title}</h2><br/>
    </div>
         	
     <div class="container">
       <div class="row align-items-center">
         <div class="col-md-6 mb-5 mb-md-0">
         	<img src="<%=request.getContextPath()%>/resources/images/img_5.jpg" alt="Image" class="img-fluid">
         </div>
         
         <div class="col-md-5 ml-auto">
         	
         	<p>작성자 : &nbsp; &nbsp; ${writer} <br/> 
         	작성일 : &nbsp; &nbsp; <fmt:formatDate value="${groupBuy.uploadDate}" pattern="yyyy-MM-dd" />
      		</p>
         	<h2 align="center">$ ${groupBuy.price}</h2><br/>
         	<h5>참여자 수 : &nbsp; &nbsp; ${groupBuy.participants} / ${groupBuy.minNo}</h5>
           	<h5>남은 시간  : &nbsp; &nbsp; ${dDay}</h5> <br/>
           	
           	<div class="alert alert-primary" role="alert">
           		<div class="d-flex">
	           		<h5>옵션</h5>&nbsp;&nbsp;
	           		<!-- 
	           		<select name="groupBuy.options" id="options">
	           			<option value="">옵션 선택</option>
		           		<c:forEach var="option" items="${groupBuy.getOptions()}" varStatus="status">
		           			<option>   <c:out value="${option}"/> </option>
						</c:forEach>
					</select><br/>
					 -->
				</div>
				<div class="d-flex">
					<h5>수량</h5>&nbsp;&nbsp;
					<form>
						<input type="button" onClick="" value="--">
						<input type="text" id="" placeholder="1">
						<input type="button" onClick="" value="+">
						&nbsp; &nbsp;
						<input type="button" onClick="" value="신청하기" />
					</form>
				</div>
			</div>
			
			<br/><br/>
  
         </div>
       </div> 
       
       <br/><br/>
       <div>
	       <h3>상세정보</h3><br/>
		   <h5>${groupBuy.content}</h5>       
       </div>
	   
	   <br/><br/><br/>
	   <div class="form-group" align="right">
	   		<input type="button" value="수정" onClick="" class="btn btn-primary py-3 px-5">  &nbsp;
	   		<a class="btn btn-primary py-3 px-5" href="<c:url value=''></c:url>">삭제</a>	
	   </div>							
   </div>

    
    <div class="site-section">
      <div class="container">
        <div class="row mb-5">
          <div class="col">
            <h2 class="text-primary font-weight-bold">Our Services</h2>
          </div>
        </div>
        <div class="row">
          <div class="col-md-4">
            <div class="service-29191">
              <span class="wrap-icon mb-4 d-block">
                <span class="icon-desktop_windows"></span>
              </span>
              <h3 class="mb-3">Interface Design</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Deleniti voluptatem reiciendis minus, a dolores.</p>
            </div>
          </div>
          <div class="col-md-4">
            <div class="service-29191">
              <span class="wrap-icon mb-4 d-block">
                <span class="icon-explore"></span>
              </span>
              <h3 class="mb-3">Product Design</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Deleniti voluptatem reiciendis minus, a dolores.</p>
            </div>
          </div>
          <div class="col-md-4">
            <div class="service-29191">
              <span class="wrap-icon mb-4 d-block">
                <span class="icon-layers"></span>
              </span>
              <h3 class="mb-3">Quality Results</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Deleniti voluptatem reiciendis minus, a dolores.</p>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="site-section">
      <div class="container">
        <div class="row mb-4 text-center">
          <div class="col">
            <a href="#"><span class="m-2 icon-facebook"></span></a>
            <a href="#"><span class="m-2 icon-twitter"></span></a>
            <a href="#"><span class="m-2 icon-linkedin"></span></a>
            <a href="#"><span class="m-2 icon-instagram"></span></a>
            <a href="#"><span class="m-2 icon-skype"></span></a>
          </div>
        </div>
        <div class="row mt-5 justify-content-center">
          <div class="col-md-7 text-center">
            <p>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart text-danger" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" >Colorlib</a>
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

