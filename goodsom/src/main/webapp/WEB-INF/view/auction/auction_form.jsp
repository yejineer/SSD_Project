<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="../IncludeTop.jsp" %> 

<script>
function submit(isNewAuction) {

	alert("경매를 등록합니다.");
	if (isNewAuction) {
		auctionForm.action="/auction/create.do";
	} else {
		auctionForm.action="/auction/update.do";
	}
	auctionForm.submit();
}
</script>
<style>
.error {
	color: #ff0000;
	/* font-weight: bold; */
}
</style>

<%@ include file="../IncludeBanner.jsp" %> 

		<div class="site-section-cover">
			<div class="container">
				<div
					class="row align-items-center text-center justify-content-center">
					<div class="col-lg-6">
						<h1 class="text-white mb-4">Add Auction</h1>
						<p class="lead">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit maxime nemo placeat dolor.</p>

					</div>
				</div>
			</div>
		</div>

		<div class="site-section bg-left-half">
			<div class="container">
				<div class="row" >
					<div class="col-lg-8 mb-5">
						<form:form modelAttribute="auctionForm" method="post" enctype="multipart/form-data">
							
							<div class="form-group row">
								<div class="col-md-12">
									<label for="auction.title">제목</label> &nbsp;&nbsp;&nbsp; <form:errors path="auction.title" cssClass="error"/> 
										<form:input path="auction.title" class="form-control" placeholder="Title"/>
										
									<%-- <c:choose>
										<c:when test="${auctionForm.newAuction}">
											<form:input path="auction.title" class="form-control" placeholder="Title" />
										</c:when>
										<c:otherwise>
											<form:input path="auction.title" class="form-control" value="${auctionForm.auction.title}" />
										</c:otherwise>
									</c:choose> --%>
								</div>
							</div>
							
							<div class="form-group row">
								<div class="col-md-12">
									<label for="img">대표 이미지</label>
                					<input type="file" id="img" name="report" value="input file" />
              					</div>
              				</div>
							
							<div class="form-group row">
								<div class="col-md-12">
									<label for="auction.content">상세 설명</label> &nbsp;&nbsp;&nbsp;<form:errors path="auction.content" cssClass="error"/>
									<c:choose>
										<c:when test="${auctionForm.newAuction}">
											<form:textarea path="auction.content" class="form-control"
											placeholder="Write description." cols="30" rows="10"/>
										</c:when>
										<c:otherwise>
											<form:textarea path="auction.content" class="form-control" cols="30" rows="10"/>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
							
							<div class="form-group row">
								<div class="col-md-12">
									<label for="inputPrice">최소 입찰 금액</label> &nbsp;&nbsp;&nbsp; <form:errors path="inputPrice" cssClass="error"/>
									<div class="d-flex">
										<div class="form-group mr-2">
										<c:choose>
											<c:when test="${auctionForm.newAuction}">
												<form:input path="inputPrice" class="form-control" placeholder="10000"/>
											</c:when>
											<c:otherwise>
												<form:input path="inputPrice" class="form-control" value="${auctionForm.auction.startPrice}"/>
											</c:otherwise>
										</c:choose>
										</div>
									</div>
								</div>
							</div>
							
							<div class="form-group">
			              	<label for="auction.endDate">마감일</label> &nbsp;&nbsp;&nbsp; 
			              		<form:errors path="auction.endDate" cssClass="error"/>
				                <div class="d-flex">
					    		  <div class="form-group mr-2">
					    		  	<c:choose>
										<c:when test="${auctionForm.newAuction}">
							                <input type="date" id="auction.endDate" class="form-control" name="auction.endDate" placeholder="yyyy-MM-dd">
										</c:when>
										<c:otherwise>
											<input type="date" id="auction.endDate" class="form-control" name="auction.endDate" 
													value="<fmt:formatDate value='${auctionForm.auction.endDate}' pattern='yyyy-MM-dd'/>">
										</c:otherwise>
									</c:choose>
					              </div>
			              		</div>
			              		
			              		<form:radiobuttons items="${amPm}" path="auction.isAmPm"/>
					            
								<form:select path="auction.hour">
									<form:options items="${hourData}" itemLabel="label" itemValue="code"/>
								</form:select>
								
								<form:select path="auction.minute">
									<form:options items="${minuteData}" itemLabel="label" itemValue="code"/>
								</form:select>
			              	</div>

							
							<div class="form-group" align="right">
								<a class="btn btn-primary py-3 px-5" href="<c:url value='/auction/list.do'></c:url>">Cancel</a> &nbsp;
								<input type="button" value="Save" onClick="submit(${auctionForm.newAuction})" class="btn btn-primary py-3 px-5">
							</div>
						</form:form>
					</div>
					
				</div>
				

			</div>
			
		</div>


<%@ include file="../IncludeBottom.jsp" %>

