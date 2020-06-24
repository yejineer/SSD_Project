<%@ include file="../IncludeBanner.jsp" %> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script>

function update() {		
	form.submit();
}

</script>

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
							<a href="<%=request.getContextPath()%>/home.do" class="font-weight-bold">GoodSom</a>
						</div>
					</div>

					<div class="col-9  text-right">


						<span class="d-inline-block d-lg-none"><a href="#"
							class="text-primary site-menu-toggle js-menu-toggle py-5"><span
								class="icon-menu h3 text-primary"></span></a></span>



						<nav class="site-navigation text-right ml-auto d-none d-lg-block" role="navigation">
							<ul class="site-menu main-menu js-clone-nav ml-auto ">
								<li><a href="<%=request.getContextPath()%>/home.do" class="nav-link">Home</a></li>
								<li><a href="<%=request.getContextPath()%>/groupBuy/list.do" class="nav-link">GroupBuy</a></li>
								<li><a href="<%=request.getContextPath()%>/auction/list.do" class="nav-link">Auction</a></li>
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
						<h1 class="text-white mb-4">My Page</h1>
						<p class="lead">회원 정보 조회 및 수정, 공동구매 및 경매에 등록한 목록이나 결제한 목록, 스크랩한 목록을 볼 수 있는 페이지입니다.</p>
					</div>
				</div>
			</div>
		</div>


		<div class="site-section">
			<div class="container" style="padding: 100px">
				<div class="row block-9 justify-content-center mb-5">
					<div class="col-md-8 mb-md-5">
		
						<h2 class="text-center">Update</h2><br/>
		
							<form:form modelAttribute="userForm" method="POST" action="update.do" class="bg-light p-5 contact-form">
								
								<div class="form-group">
									<label for="email">Email</label> &emsp;
									<form:input path="user.email" class="form-control" /><br/>
								</div>
								
						        <div class="form-group">
									<label for="password">Password</label> &emsp;
									<form:input path="user.password" type="password" class="form-control" /><br/>
								</div>
								
								<div class="form-group">	
									<label for="password">Check Password</label> &emsp;
									<form:input path="repeatedPassword" type="password" class="form-control" /><br/>
								</div>
								
								<div class="form-group">	
									<label for="nickname">Nickname</label> &emsp;
									<form:input path="user.nickname" class="form-control" />
									<form:errors path="user.nickname" /><br/>
								</div>
								
								<div class="form-group">	
									<label for="userName">Name</label> &emsp;
									<form:input path="user.userName" class="form-control" /><br/>
								</div>
								
								<div class="form-group">
									<label for="phone">Phone</label> &emsp;
									<form:input path="user.phone" class="form-control" />
									<form:errors path="user.phone" /><br/>
								</div>
								
								<div class="form-group">	
									<label>Address</label> &emsp;
									<form:input path="user.address1" class="form-control"/>
									<form:errors path="user.address1" />
									
									<form:input path="user.address2" class="form-control"/>
									<form:errors path="user.address2" />
									
									<form:input path="user.address3" class="form-control"/>
									<form:errors path="user.address3" /><br/>
								</div>
								
								<div class="form-group">
									<label>Account</label> &emsp;
									<form:input path="user.refundBank" class="form-control" />
									<form:errors path="user.refundBank" />
			
									<form:input path="user.refundAccount" class="form-control" />
									<form:errors path="user.refundAccount" /><br/>
								</div>
		
								<div class="form-group" align="center">
									<input type="submit" value="Save" onClick="update()" class="btn btn-primary py-3 px-5"> &nbsp;
									<a class="btn btn-primary py-3 px-5" href="<c:url value='/user/detail.do'></c:url>">Cancel</a> 
								</div>
							
						</form:form>
					</div>
				</div>
			</div>
		</div>


<%@ include file="../IncludeBottom.jsp" %>
