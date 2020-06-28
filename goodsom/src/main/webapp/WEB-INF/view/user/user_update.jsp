<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="../IncludeTop.jsp" %> 

<%@ include file="../IncludeBanner.jsp" %> 

<style>
.error {
	color: #ff0000;
	/* font-weight: bold; */
}
</style>

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
									<form:input path="user.passwd" type="password" class="form-control" />
									<form:errors path="user.passwd" cssClass="error" /><br/>
								</div>
								
								<div class="form-group">	
									<label for="password">Check Password</label> &emsp;
									<form:input path="repeatedPassword" type="password" class="form-control" />
									<form:errors path="repeatedPassword" cssClass="error" /><br/>
								</div>
								
								<div class="form-group">	
									<label for="userName">Name</label> &emsp;
									<form:input path="user.userName" class="form-control" readonly="true"/><br/>
								</div>
								
								<div class="form-group">	
									<label for="nickname">Nickname</label> &emsp;
									<form:input path="user.nickname" class="form-control" />
									<form:errors path="user.nickname" cssClass="error" /><br/>
								</div>
								
								<div class="form-group">
									<label for="phone">Phone</label> &emsp;
									<form:input path="user.phone" class="form-control" />
									<form:errors path="user.phone" cssClass="error" /><br/>
								</div>
								
								<div class="form-group">	
									<label>Address</label> <br />
									<form:input path="user.address1" style="width:70px;"/>&nbsp;-&nbsp; 
									<form:input path="user.address2" style="width:70px;"/> &nbsp;&nbsp; 
									<form:input path="user.address3" style="width:70px;"/><br/>
								</div>
								
								<div class="form-group">
									<label>Account</label> &emsp;
									<div class="d-flex">
										<form:select path="user.refundBank" >
											<option value="">은행</option>
											<form:options items="${cardBanks}" />
										</form:select>
										<form:input path="user.refundAccount" class="form-control" />
										<form:errors path="user.refundAccount" cssClass="error" />
									</div><br/>
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

<%@ include file="../IncludeBottom.jsp" %>
