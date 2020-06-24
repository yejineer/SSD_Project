<%@ include file="../IncludeBanner.jsp" %> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
         	<img src="${auction.img}" alt="Image" class="img-fluid">
         </div>
         
         <div class="col-md-5 ml-auto">
         	
         	<p>작성자 : &nbsp; &nbsp; ${writer} <br/> 
         		작성일 : &nbsp; &nbsp; <fmt:formatDate value="${auction.uploadDate}" pattern="yyyy-MM-dd" /> <br/>
         		조회수 : &nbsp; &nbsp; ${auction.count} <br/>
         	</p>
         	<h5>시작 금액 : &nbsp; &nbsp; <fmt:formatNumber value="${auction.startPrice}" pattern="#,###원"/></h5>
           	<h5>마감일  : &nbsp; &nbsp; <fmt:formatDate value="${auction.endDate}" pattern="yyyy-MM-dd" /></h5>
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
	   <c:if test="${isWriter eq true}">
		   <div class="form-group" align="right">
		   		<a class="btn btn-primary py-3 px-5" href="<c:url value='/auction/form.do'>
												<c:param name="auctionId" value="${auction.auctionId}"/>
											</c:url>">수정</a>
		   		<a class="btn btn-primary py-3 px-5" href="<c:url value='/auction/delete.do'>
												<c:param name="auctionId" value="${auction.auctionId}"/>
											</c:url>">삭제</a>	
		   </div>
	   </c:if>							
   </div>

    
<%@ include file="../IncludeBottom.jsp" %>

