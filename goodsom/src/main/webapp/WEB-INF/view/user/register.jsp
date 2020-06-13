<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<title>Goodsom &mdash; SSD Final Project</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="https://fonts.googleapis.com/css?family=Poppins:400,900|Source+Serif+Pro&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/fonts/icomoon/style.css">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap-datepicker.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/jquery.fancybox.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/owl.theme.default.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/fonts/flaticon/font/flaticon.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/aos.css">

<!-- MAIN CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css">

</head>

<script>
function userCreate() {
	form.submit();
}
function home(targetUri) {
	form.action = targetUri;
	form.submit();
}
</script>

<body bgcolor="black">
	<div class="container" style="padding: 100px">
		<div class="row block-9 justify-content-center mb-5">
			<div class="col-md-8 mb-md-5">

				<h2 class="text-center">Register</h2>
				<br/>

				<form name="form" method="POST" action="<c:url value='/user/register.do' />" class="bg-light p-5 contact-form">

					<div class="form-group">
						<label for="name">ID</label> <input name="id" id="id" type="text"
							class="form-control" placeholder="ID">
					</div>

					<div class="form-group">
						<label for="name">Password</label> <input name="password"
							id="password" type="password" class="form-control"
							placeholder="Password">
					</div>

					<div class="form-group">
						<label for="name">Check Password</label> <input name="password2"
							id="password2" type="password" class="form-control"
							placeholder="Password">
					</div>

					<div class="form-group">
						<label for="name">Name</label> <input name="name" id="Name"
							type="text" class="form-control" placeholder="Name">
					</div>

					<div class="form-group">
						<label for="name">Phone</label> <input name="phone" id="phone"
							type="text" class="form-control" placeholder="Phone">
					</div>

					<div class="form-group">
						<label for="name">Address</label> <br/> 
						<input id="postcode1" name="addr1" type="text" value="" style="width: 50px;" readonly />&nbsp;-&nbsp; 
						<input id="postcode2" name="addr2" type="text" value="" style="width: 50px;" readonly /> &nbsp;&nbsp; 
						<!-- <input id="zonecode" name="addr3" type="text" value="" style="width: 50px;" readonly /> &nbsp; 
						<input type="button" onClick="openDaumZipAddress();" value="find address" /> <br/> 
						<input type="text" name="addr4" id="address" value="" style="width: 240px;" readonly /> 
						<input type="text" name="addr5" id="address_etc" value="" style="width: 200px;" />  -->
					</div>

					<div class="form-group">
						<label for="name">Account</label> <input name="account"
							id="account" type="text" class="form-control"
							placeholder="Account"> <select name="bank" id="bank">
							<option value="shinhan">신한은행</option>
							<option value="woorie">우리은행</option>
							<option value="hana">하나은행</option>
							<option value="kakao">카카오뱅크</option>
						</select>
					</div>
					<br/>

					<div class="form-group" align="center">
						<input type="button" value="Register" onClick="userCreate()" class="btn btn-primary py-3 px-5"> &nbsp;
				        <a class="btn btn-primary py-3 px-5" href="<c:url value='/user/login.do'></c:url>">Login</a>
					</div>
					
				</form>
			</div>
		</div>
	</div>
</body>
</html>