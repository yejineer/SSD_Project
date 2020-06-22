<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
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
function createGroupBuy() {
	
	groupBuyForm.submit();
}

function hasClass(target, className) {
    if( (' ' + target.className + ' ').replace(/[\n\t]/g, ' ').indexOf(' ' + className + ' ') > -1 ) return true;
    return false;
}
function removeClass(target, className){
    var elClass = ' ' + target.className + ' ';
    while(elClass.indexOf(' ' + className + ' ') !== -1){
         elClass = elClass.replace(' ' + className + ' ', '');
    }
    target.className = elClass;
}
function addClass(target, className){
    target.className += ' ' + className;   
}

if( hasClass( document.getElementsByTagName('html')[0], 'ie8' ) ) { // ie8 일 경우
    var radios = document.querySelectorAll('input[type="radio"]'),
        i,
        len = radios.length;
　
    for( i = 0; i < len; i++ ) {
        radios[i].attachEvent('onchange', function(e) {
            var siblingsChecked = this.parentNode.parentNode.querySelector('.checked'); // 이전 checked 버튼
            
            removeClass(siblingsChecked, 'checked'); // checked 삭제
            addClass(this, 'checked'); // checked 부여
        });
    }
}


function input_append(ff){
  app = document.getElementById("optionBox");
  app.innerHTML += "<input type=text id=groupBuy.options name=groupBuy.options class=form-control><br>";
}

</script>
<style>
* {
  margin: 0;
  padding: 0;
}

/* temp grid */

.only-sr {
  overflow: hidden !important;
  position: absolute !important;
  left: -9999px !important;
  width: 1px;
  height: 1px;
}

/* form | radio */
.radio-items {
  display: table;
  width: 100%;
  border: 1px solid #454a60;
  border-radius: 4px;
  box-sizing: border-box;
}
.radio-items > div {
  display: table-cell;
  line-height: 1.5;
  width:100px;
  border-left: 1px solid #454a60;
  text-align: center;
  vertical-align: middle;
}

.radio-items label {
  display: block;
  width: 100%;
  height: 100%;
  color: #454a60;
  vertical-align: middle;
  box-sizing: border-box;
  cursor: pointer;
}
.radio-items input[type="radio"]:checked + label {
  background-color: #454a60;
  color: #fff;
}

.ie8 .radio-items input[type="radio"].checked + label {
  background-color: #454a60;
  color: #fff;
}

#addOption{
	width:100px;
    background-color: #3a4bcf; border: none;
    color:#fff; padding: 15px 0; text-align: center; text-decoration: none;
    display: inline-block; font-size: 15px;
    margin: 4px; border-radius:10px; float: right;
    cursor: pointer;
}
</style>
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
						<h1 class="text-white mb-4">Add GroupBuy</h1>
						<p class="lead">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit maxime nemo placeat dolor.</p>

					</div>
				</div>
			</div>
		</div>

		<!-- start form -->
		<div class="site-section bg-left-half">
			<div class="container">
				<div class="row" >
					<div class="col-lg-8 mb-5">
					
						<form id="groupBuyForm" method="post" action="<c:url value='/groupBuy/detail.do' />" >
						
							<div class="form-group row">
								<div class="col-md-12">
									<label for="title">제목</label> 
									<input type="text" id="groupBuy.title" name="groupBuy.title" class="form-control" placeholder="ex) 학잠 공동구매">
								</div>
							</div>
							
							<div class="form-group row">
								<div class="col-md-12">
									<label for="img">대표 이미지</label> </br>
									<input type="text" id="groupBuy.img" name="groupBuy.img" class="form-control">
									<!--
                					<input type="file" id="img" value="input file" name="image"/>
                					-->
              					</div>
              				</div>
              				
							<div class="form-group row">
								<div class="col-md-12">
									<label for="price">가격</label> 
									<input type="number" id="groupBuy.price" name="groupBuy.price" class="form-control" placeholder="ex) 10000">
								</div>
							</div>
							
							<div class="form-group row">
								<div class="col-md-12">
									<label for="content">상세설명</label> 
									<textarea name="groupBuy.content" id="groupBuy.content" class="form-control"
										placeholder="상세 설명을 작성해주세요." cols="30" rows="10"></textarea>
									
								</div>
							</div>
							
							<div class="form-group">
								<label for="option">옵션</label>
								<!--
								<input type="text" id="groupBuy.option" name="groupBuy.option" class="form-control" placeholder="Options">
								
								<input type="text" id="title" class="form-control" placeholder="제목">
								<input type="button" onClick="" value="Add" /> &nbsp; ** 추가 버튼을 클릭해보세요 <br/>
								<input name="" id="iption" type="text" style="width:150px;" />
								  -->
							
								<input type="button" id="addOption" value="추가" onclick="input_append(this.form)">

								<div id="optionBox">
									<input type="text" id="groupBuy.options" name="groupBuy.options" class="form-control"><br>
								</div>
								
							</div>
							
							<div class="form-group">
								<label for="catId">태그</label> <br/>

							    <div class="radio-items">
							        <div class="col-2">  <!-- width auto important, 소수점 백그라운드 이슈로 인해 auto 설정 -->
							            <input type="radio" id="clothing" name="groupBuy.catId" class="only-sr" value="1">
							            <label for="clothing">의류</label>
							        </div>
							        <div class="col-2">
							        	<input type="radio" id="schoolUniform" name="groupBuy.catId" class="only-sr" value="2">
										<label for="schoolUniform">학잠</label>
							        </div>
							        <div class="col-2">
							            <input type="radio" id="writing" name="groupBuy.catId" class="only-sr" value="3">
							            <label for="writing">필기구</label>
							        </div>
							        <div class="col-2">
							            <input type="radio" id="tumbler" name="groupBuy.catId" class="only-sr" value="4">
										<label for="tumbler">텀블러</label>
							        </div>
							        <div class="col-2">
							            <input type="radio" id="sticker" name="groupBuy.catId" class="only-sr" value="5">
										<label for="sticker">스티커</label>
							        </div>
							        <div class="col-2">
							            <input type="radio" id="bagAndPouch" name="groupBuy.catId" class="only-sr" value="6">
										<label for="bagAndPouch">에코백/파우치</label>
							        </div>
							        <div class="col-2">
							            <input type="radio" id="etc" name="groupBuy.catId" class="only-sr" value="7">
										<label for="etc">기타</label>
							        </div>
							    </div>
								   
							</div>
							
							<div class="form-group row">
								<div class="col-md-12">
									<label for="minNo">최소수량</label> 
									<div class="d-flex">
										<div class="form-group mr-2">
										<input type="text" class="form-control" id="groupBuy.minNo" name = "groupBuy.minNo" placeholder="ex) 40">
										</div>
									</div>
								</div>
							</div>
			              	
			              	<div class="form-group">
			              	<label for="endDate">마감일</label>
				                <div class="d-flex">
					    		  <div class="form-group mr-2">
					                <input type="date" class="form-control" id="groupBuy.endDate" name = "groupBuy.endDate" placeholder="ex) 2020-10-22">
					              </div>
			              		</div>
			              	</div>

							
							<div class="form-group" align="right">
								<a class="btn btn-primary py-3 px-5" href="<c:url value='/groupbuy/list.do'></c:url>">취소</a> &nbsp;
								<input type="button" value="완료" onClick="createGroupBuy()" class="btn btn-primary py-3 px-5">
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

