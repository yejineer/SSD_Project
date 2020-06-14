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
								<li><a href="<%=request.getContextPath()%>/mypage/list.do"><img src="<%=request.getContextPath()%>/resources/images/mypage.jpg" alt="Image" 
								width="30px" height="20px" class="img-fluid"></a></li>
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
            <h1 class="text-white mb-4">About Auction</h1>
            <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit maxime nemo placeat dolor est.</p>
            
          </div>
        </div>
      </div>
    </div>


    <br/>    
    <div align="center">
    	<br/><h2 class="text-primary mb-5 font-weight-bold">${auction.title}</h2><br/>
    </div>
         	
     <div class="container">
       <div class="row align-items-center">
         <div class="col-md-6 mb-5 mb-md-0">
         	<img src="<%=request.getContextPath()%>/resources/images/img_5.jpg" alt="Image" class="img-fluid">
         </div>
         
         <div class="col-md-5 ml-auto">
         	
         	<p>작성자 : &nbsp; &nbsp; ${writer} <br/> 
         		작성일 : &nbsp; &nbsp; <fmt:formatDate value="${auction.uploadDate}" pattern="yyyy-MM-dd" />
         	</p>
         	<h5>시작 금액 : &nbsp; &nbsp; <fmt:formatNumber value="${auction.startPrice}" pattern="#,###원"/></h5>
           	<h5>마감 시각  : &nbsp; &nbsp; <fmt:formatDate value="${auction.endDate}" pattern="yyyy-MM-dd" /></h5>
           	<br/>
           	
           	<h5 align="center"><b>현재 최고가</b></h5>
           	
           	<div class="alert alert-primary" role="alert">
           		<h4 class="text-danger">  <fmt:formatNumber value="${auction.maxPrice}" pattern="#,###원"/></h4>
 				<p>2020-06-14 <br/> 22 : 02 : 13</p>
			</div>
			
			<br/><br/>
			<div class="d-flex">
		   		<h5>베팅 금액</h5>
				<input type="text" id="" class="form-control" placeholder="$30">
				<input type="button" onClick="" value="신청하기" />
			</div>
  
         </div>
       </div> 
       
       <br/><br/>
       <div>
       
       	<h5>${auction.content}</h5>
       
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

    
    <div class="site-section bg-light">
      
      <div class="container">
        <div class="row mb-5 text-center">
          <div class="col">
            <h2 class="text-primary font-weight-bold">Our Clients</h2>
          </div>
        </div>
        <div class="row">
          <div class="col-md-3">
            <img src="<%=request.getContextPath()%>/resources/images/client_google.png" alt="Image" class="img-fluid">
          </div>
          <div class="col-md-3">
            <img src="<%=request.getContextPath()%>/resources/images/client_invision.png" alt="Image" class="img-fluid">
          </div>
          <div class="col-md-3">
            <img src="<%=request.getContextPath()%>/resources/images/client_nike.png" alt="Image" class="img-fluid">
          </div>
          <div class="col-md-3">
            <img src="<%=request.getContextPath()%>/resources/images/client_microsoft.png" alt="Image" class="img-fluid">
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

