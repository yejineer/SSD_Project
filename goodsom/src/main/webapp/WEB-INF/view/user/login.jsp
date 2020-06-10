<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<title>Approach &mdash; Website Template by Colorlib</title>
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
function login() {
	form.submit();
}
</script>

<body bgcolor="black">
	<div class="container" style="padding: 100px">
		<div class="row block-9 justify-content-center mb-5">
			<div class="col-md-8 mb-md-5">

				<h2 class="text-center">Login</h2>
				<br/>

				<form name="form" method="POST" action="<c:url value='/user/login.do' />" class="bg-light p-5 contact-form">

					<div class="form-group">
						<label for="name">ID</label> <input name="id" id="id" type="text"
							class="form-control" placeholder="ID">
					</div>

					<div class="form-group">
						<label for="name">Password</label> <input name="password"
							id="password" type="password" class="form-control"
							placeholder="Password">
					</div>
					<br />

					<div class="form-group" align="center">
						<input type="button" value="Login" onClick="login()" class="btn btn-primary py-3 px-5"> &nbsp;
				        <a class="btn btn-primary py-3 px-5" href="<c:url value='/user/register.do'></c:url>">Register</a>
					</div>
					
				</form>
			</div>
		</div>
	</div>
</body>
</html>