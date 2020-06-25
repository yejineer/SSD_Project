<%@ include file="../IncludeTop.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<script type="text/javascript">

function deleteAuction(auctionId) {
	if (confirm("경매를 삭제하시겠습니까?")) {
		location.href= "delete.do?auctionId=${auction.auctionId}";
	}
}

function updateAuction(auctionId) {
	if (confirm("경매를 수정하시겠습니까?")) {
		location.href= "update.do?auctionId=${auction.auctionId}";
	}
}

</script>

<script >
function insertBid() {
	bidForm.submit();
}
</script>

<%@ include file="../IncludeBanner.jsp" %> 

		<div class="site-section-cover">
			<div class="container">
				<div
					class="row align-items-center text-center justify-content-center">
					<div class="col-lg-6">
						<h1 class="text-white mb-4">About Auction</h1>
						<p class="lead">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit maxime nemo placeat dolor est.</p>

					</div>
				</div>
			</div>
		</div>


		<br />
		<div align="center">
			<br />
			<h2 class="text-primary mb-5 font-weight-bold">${auction.title}</h2>
			<br />
		</div>

		<div class="container">
			<div class="row align-items-center">
				<div class="col-md-6 mb-5 mb-md-0">
					<img src="${auction.img}" alt="Image" class="img-fluid">
				</div>

				<div class="col-md-5 ml-auto">

					<p>
						작성자 : &nbsp; &nbsp; ${writer} <br /> 작성일 : &nbsp; &nbsp;
						<fmt:formatDate value="${auction.uploadDate}" pattern="yyyy-MM-dd" />
						<br /> 조회수 : &nbsp; &nbsp; ${auction.count} <br />
					</p>
					<h5>
						시작 금액 : &nbsp; &nbsp;
						<fmt:formatNumber value="${auction.startPrice}" pattern="#,###원" />
					</h5>
					<h5>
						마감일 : &nbsp; &nbsp;
						<fmt:formatDate value="${auction.endDate}" pattern="yyyy-MM-dd" />
					</h5>
					<br />

					<h5 align="center">
						<b>현재 최고가</b>
					</h5>

					<div class="alert alert-primary" role="alert">
						<h4 class="text-danger">
							<fmt:formatNumber value="${auction.maxPrice}" pattern="#,###원" />
						</h4>
						<p>
							2020-06-14 <br /> 22 : 02 : 13
						</p>
					</div><br/><br/>
					
					<div class="d-flex">
						<form:form modelAttribute="BidForm" method="POST" action="/bid/create.do">
							<h5>베팅 금액</h5>
							<input type="text" id="bidPrice" class="form-control" placeholder="Input Your Bid Price">
							<input type="button" value="신청하기" onClick="insertBid()" > 
						</form:form>
					</div>

				</div>
			</div><br/><br/>
			
			<div>
 				<h5>${auction.content}</h5>
			</div><br/><br/><br/>
			
			<c:if test="${isWriter eq true}">
				<div class="form-group" align="right">
					<a class="btn btn-primary py-3 px-5" href="javascript:updateAuction()" >수정</a>
					<a class="btn btn-primary py-3 px-5" href="javascript:deleteAuction()" >삭제</a>
					<a class="btn btn-primary py-3 px-5" href="<c:url value='/auction/list.do'></c:url>">목록</a>
				</div>
			</c:if>
		</div>

<%@ include file="../IncludeBottom.jsp" %>

