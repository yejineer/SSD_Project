<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<title>Goodsom &mdash; SSD Final Project</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="https://fonts.googleapis.com/css?family=Poppins:400,900|Source+Serif+Pro&display=swap" rel="stylesheet">

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

	function userCreate() {
		var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
		if (emailExp.test(form.emailId.value) == false) {
			alert("Check your email");
			form.email.focus();
			return false;
		}
		if (form.password.value == "") {
			alert("Input password");
			form.password.focus();
			return false;
		}
		if (form.password.value != form.password2.value) {
			alert("Not correct password");
			form.name.focus();
			return false;
		}
		if (form.userName.value == "") {
			alert("Input name");
			form.name.focus();
			return false;
		}
		if (form.nickname.value == "") {
			alert("Input nickname");
			form.nickname.focus();
			return false;
		}
		/*var phoneExp = /^\d{2,3}-\d{3,4}-\d{4}$/;
		if(phoneExp.test(form.phone.value)==false) {
			alert("check your phone number");
			form.phone.focus();
			return false;
		}*/
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

				<h2 class="text-center">Register</h2><br/>

				<form name="form" method="POST" action="<c:url value='/user/register.do' />" class="bg-light p-5 contact-form">

					<div class="form-group">
						<label for="name">ID</label> 
						<input name="user.email" id="emailId" type="text" class="form-control" placeholder="ID">
					</div>

					<div class="form-group">
						<label for="name">Password</label> 
						<input name="user.password" id="password" type="password" class="form-control" placeholder="Password">
					</div>

					<div class="form-group">
						<label for="name">Check Password</label> 
						<input name="user.password2" id="password2" type="password" class="form-control" placeholder="Password">
					</div>

					<div class="form-group">
						<label for="name">Name</label> <input name="user.userName" id="userName"
							type="text" class="form-control" placeholder="Name">
					</div>
					
					<div class="form-group">
						<label for="name">Nickname</label>
						<input name="user.nickname" id="nickname" type="text" class="form-control" placeholder="Nickname">
					</div>

					<div class="form-group">
						<label for="name">Phone</label> 
						<input name="user.phone" id="phone" type="text" class="form-control" placeholder="Phone">
					</div>

					<div class="form-group">
						<label for="name">Address</label> <br/> 
						<input id="address1" name="user.address1" type="text" value="" style="width:70px;" />&nbsp;-&nbsp; 
						<input id="address2" name="user.address2" type="text" value="" style="width:70px;" /> &nbsp;&nbsp; 
						<input id="address3" name="user.address3" type="text" value="" style="width:70px;" />
						<!-- <input id="zonecode" name="addr3" type="text" value="" style="width: 50px;" readonly /> &nbsp; 
						<input type="button" onClick="openDaumZipAddress();" value="find address" /> <br/> 
						<input type="text" name="addr4" id="address" value="" style="width: 240px;" readonly /> 
						<input type="text" name="addr5" id="address_etc" value="" style="width: 200px;" />  -->
					</div>

					<div class="form-group">
						<label for="name">Account</label>
						<input name="user.refundAccount" id="refundAccount" type="text" class="form-control" placeholder="Account"> 
						<select name="user.refundBank" id="refundBank">
							<option value="신한은행">신한은행</option>
							<option value="우리은행">우리은행</option>
							<option value="하나은행">하나은행</option>
							<option value="카카오뱅크">카카오뱅크</option>
						</select>
					</div>
					<br/>

					<div class="form-group" align="center">
						<input type="button" value="Register" onClick="userCreate()" class="btn btn-primary py-3 px-5"> 
					</div>
					
				</form>
			</div>
		</div>
	</div>
</body>
</html>