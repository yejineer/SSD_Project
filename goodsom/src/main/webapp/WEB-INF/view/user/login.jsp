<%@ include file="../IncludeTop.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<script>
function login() {
	if (form.emailId.value == "") {
		alert("Input Your ID.");
		form.id.focus();
		return false;
	} 
	if (form.password.value == "") {
		alert("Input Your Password.");
		form.password.focus();
		return false;
	}		
	form.submit();
}
</script>

<c:choose>
	<c:when test="${deleteComplete == 1}">
		<body onLoad="alert('회원탈퇴가 완료되었습니다.')">
	</c:when>
	<c:when test="${deleteComplete == 0}">
		<body onLoad="alert('회원탈퇴에 실패했습니다.')">
	</c:when>
	<c:otherwise>
		<body>
	</c:otherwise>
</c:choose>

<body bgcolor="black">
	<div class="container" style="padding: 100px">
		<div class="row block-9 justify-content-center mb-5">
			<div class="col-md-8 mb-md-5">

				<h2 class="text-center">Login</h2>
				<br/>

				<form name="form" method="POST" action="<c:url value='/user/login.do' />" class="bg-light p-5 contact-form">

					<div class="form-group">
						<label for="name">ID</label> <input name="emailId" id="emailId" type="text" class="form-control" placeholder="ID">
					</div>

					<div class="form-group">
						<label for="name">Password</label> <input name="password"id="password" type="password" class="form-control" placeholder="Password">
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