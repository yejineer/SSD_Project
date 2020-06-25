<%@ include file="../IncludeTop.jsp" %> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../IncludeBanner.jsp" %> 

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
									<form:input path="user.email" class="form-control" readonly="true"/><br/>
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
									<form:input path="user.userName" class="form-control" readonly="true"/><br/>
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
									<input type="submit" value="Save" class="btn btn-primary py-3 px-5"> &nbsp;
									<a class="btn btn-primary py-3 px-5" href="<c:url value='/user/detail.do'></c:url>">Cancel</a> 
								</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
</div>

<%@ include file="../IncludeBottom.jsp" %>
