<%@ include file="../IncludeBanner.jsp" %> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
						<h1 class="text-white mb-4">GroupBuy</h1>
						<p class="lead">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit maxime nemo placeat dolor est.</p>

					</div>
				</div>
			</div>
		</div>
				
		<div class="site-section">
			<div class="container">
			
			<a class="btn btn-primary py-3 px-5" href="<c:url value='/groupBuy/form.do'></c:url>">공동구매 등록</a> <br/><br/>
			
				<div class="row">
					<c:forEach var="groupBuy" items="${groupBuyList}" varStatus="status">
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="post-entry-1 h-100">
								<a href="<c:url value='/groupBuy/detail.do'>
								<c:param name="groupBuyId" value="${groupBuy.groupBuyId}"/>
										</c:url>">
										<img src="${groupBuy.img}" alt="Image" class="img-fluid">
								</a>
								
								<div class="post-entry-1-contents">
									<h2>
										<a  href="<c:url value='/groupBuy/detail.do'>
													<c:param name="groupBuyId" value="${groupBuy.groupBuyId}"/>
												</c:url>">${groupBuy.title}</a>
									</h2>
									<span class="meta d-inline-block mb-3">
										~ <fmt:formatDate value="${groupBuy.endDate}" pattern="yyyy-MM-dd" />
									<span class="mx-2">가격</span> 
										<a href="#"><fmt:formatNumber value="${groupBuy.price}" pattern="#,###원"/></a> <br/><br/>
									
									<span class="mx-2">달성률</span> 
										<a href="#"><fmt:formatNumber value="${groupBuy.participants}"/>명 / </a>
										<a href="#"><fmt:formatNumber value="${groupBuy.minNo}"/>명</a>
										<a href="#"><fmt:formatNumber value="${groupBuy.rate}" pattern="###%"/></a>
									</span>
									<p>${groupBuy.content}</p>
								</div>
							</div>
						</div>
    				

					</c:forEach>
				</div>
			</div>
		</div>

<%@ include file="../IncludeBottom.jsp" %>

