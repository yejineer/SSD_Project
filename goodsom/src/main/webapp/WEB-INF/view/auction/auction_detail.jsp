<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="../IncludeTop.jsp" %> 

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

function bid() {
	
	if (form.bidPrice.value == "") {
		alert("Input your bidPrice")
		form.bidPrice.focus();
		return false;
	}

	if (confirm("배팅 하시겠습니까?")) {
		form.submit();
	}
	
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
						
						<p>${bid.bidDate} <br/> ${writer}</p>
						
					</div><br/><br/>
					
					<!-- betting -->
					<div class="d-flex">
						<form name="form" method="post" action="<c:url value='/auction/bid/create.do'/>">
						
							<h5>베팅 금액</h5>
							<input type="text" id="bidPrice" name="bidPrice" class="form-control" placeholder="ex) 4000">
							<input type="hidden" id="auctionId" name="auctionId" value="${auction.auctionId}">
							<c:if test="${auction.state eq 'proceeding'}">
								<input type="button" value="신청하기" onClick="bid()" > 
							</c:if>
								
							<c:if test="${auction.state eq 'closed'}">
								<input type="button" value="신청하기" onClick="bid()" disabled> 
							</c:if>
							
						</form>
					</div>

				</div>
			</div><br/><br/>
			
			<div>
 				<h5>${auction.content}</h5>
			</div><br/><br/><br/>
			
			<div class="form-group" align="right">
			</div><br/>
			
			<div class="form-group" align="right">
				<c:if test="${isWriter eq true}">
					<a class="btn btn-primary py-3 px-5" href="javascript:updateAuction()" >수정</a>
					<a class="btn btn-primary py-3 px-5" href="javascript:deleteAuction()" >삭제</a>
				</c:if>
					<a class="btn btn-primary py-3 px-5" href="<c:url value='/auction/list.do'></c:url>">목록</a>
			</div>
		</div>

<%@ include file="../IncludeBottom.jsp" %>

