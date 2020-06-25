<%@ include file="../IncludeTop.jsp" %> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script>

	function logoutCheck() {
		return confirm("로그아웃 하시겠습니까?")
	}
	
	function removeCheck() {
		return confirm("정말 탈퇴하시겠습니까?");
	}

</script>

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
			<section class="ftco-section ftco-car-details">
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-md-12">
							<div class="car-details">
								<div class="text text-left">
									<span class="subheading">회원 정보</span>
									<h1>
										<b>${userForm.user.userName}</b>
									</h1>
								</div>
								<br>

								<div class="text text-left">
									<table class="table table-striped">
										<tbody>
											<tr>
												<th scope="row">Email</th>
												<td>${userForm.user.email}</td>
											</tr>
											<tr>
												<th scope="row">Nickname</th>
												<td>${userForm.user.nickname}</td>
											</tr>
											<tr>
												<th scope="row">Phone</th>
												<td>${userForm.user.phone}</td>
											</tr>
											<tr>
												<th scope="row">Address</th>
												<td>${userForm.user.address1} - ${userForm.user.address2} - ${userForm.user.address3}</td>
											</tr>
											<tr>
												<th scope="row">Account</th>
												<td>${userForm.user.refundBank} &nbsp; ${userForm.user.refundAccount}</td>
											</tr>
										</tbody>
									</table>
								</div><br><br>
								
								<div class="container">
									<a class="btn btn-primary py-3 px-5"href="<c:url value='/mypage/list.do'></c:url>">목록 보기</a> &nbsp;
									<a class="btn btn-primary py-3 px-5"href="<c:url value='/user/update.do'></c:url>">회원 정보 수정</a> &nbsp; 
									<a class="btn btn-primary py-3 px-5"href="<c:url value='/user/logout.do'></c:url>" onclick="logoutCheck()">로그아웃</a> &nbsp; 
									<a class="btn btn-primary py-3 px-5"href="<c:url value='/user/delete.do'></c:url>" onclick="removeCheck()">회원 탈퇴</a> 
								</div>
								
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</div>
		
<%@ include file="../IncludeBottom.jsp" %>

