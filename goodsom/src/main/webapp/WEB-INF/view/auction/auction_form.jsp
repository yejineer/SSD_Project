<%@ include file="../IncludeTop.jsp" %> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<script>
function submit() {
	
	auctionForm.submit();
	alert("경매를 등록합니다.");
}
</script>

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
						<form id="auctionForm" method="post" enctype="multipart/form-data" 
							action="<c:choose>
										<c:when test='${auctionForm.newAuction}'><c:url value='/auction/create.do'/></c:when>
									<c:otherwise>
										<c:url value='/auction/update.do'/></c:otherwise>
									</c:choose>">
						
							<c:if test='${!auctionForm.newAuction}'>
								<input hidden="originalAuction" value='${auction}'>
							</c:if>
							
							<div class="form-group row">
								<div class="col-md-12">
									<label for="title">제목</label> 
									<c:choose>
										<c:when test="${auctionForm.newAuction}">
											<input type="text" id="title" name="auction.title" class="form-control" placeholder="Title" >
										</c:when>
										<c:otherwise>
											<input type="text" id="title" name="auction.title" class="form-control" value="${auctionForm.auction.title}" >
										</c:otherwise>
									</c:choose>
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
									<label for="content">상세 설명</label>
									<c:choose>
										<c:when test="${createAuction eq true}">
											<textarea id="content" name="auction.content" class="form-control"
											placeholder="Write description." cols="30" rows="10"></textarea>
										</c:when>
										<c:otherwise>
											<textarea id="content" name="auction.content" class="form-control"
											placeholder="${auctionForm.auction.content}" cols="30" rows="10">${auctionForm.auction.content}</textarea>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
							
							<div class="form-group row">
								<div class="col-md-12">
									<label for="startPrice">최소 입찰 금액</label> 
									<div class="d-flex">
										<div class="form-group mr-2">
										<c:choose>
											<c:when test="${createAuction eq true}">
												<input type="text" id="startPrice" class="form-control" name="auction.startPrice" placeholder="ex) 5000">
											</c:when>
											<c:otherwise>
												<input type="text" id="startPrice" class="form-control" name="auction.startPrice" value="${auctionForm.auction.startPrice}">
											</c:otherwise>
										</c:choose>
										</div>
									</div>
								</div>
							</div>
							
							<div class="form-group">
			              	<label for="endDate">마감일</label>
				                <div class="d-flex">
					    		  <div class="form-group mr-2">
					    		  	<c:choose>
										<c:when test="${createAuction eq true}">
							                <input type="date" id="endDate" class="form-control" name="auction.endDate">
										</c:when>
										<c:otherwise>
											<input type="date" id="endDate" class="form-control" name="auction.endDate" 
													value="<fmt:formatDate value='${auctionForm.auction.endDate}' pattern='yyyy-MM-dd'/>">
										</c:otherwise>
									</c:choose>
					              </div>
			              		</div>
			              	</div>

							
							<div class="form-group" align="right">
								<a class="btn btn-primary py-3 px-5" href="<c:url value='/auction/list.do'></c:url>">Cancel</a> &nbsp;
								<input type="button" value="Save" onClick="submit()" class="btn btn-primary py-3 px-5">
							</div>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>

<%@ include file="../IncludeBottom.jsp" %>

