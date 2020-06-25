<%@ include file="../IncludeTop.jsp" %> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../IncludeBanner.jsp" %> 

		<div class="site-section-cover">
			<div class="container">
				<div
					class="row align-items-center text-center justify-content-center">
					<div class="col-lg-6">
						<h1 class="text-white mb-4">GroupBuy</h1>
						<p class="lead">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit maxime nemo placeat dolor est.</p>

					</div>
				</div>
			</div>
		</div>
				
		<div class="site-section">
			<div class="container">
			
			<a class="btn btn-primary py-3 px-5" href="<c:url value='/groupBuy/form.do'></c:url>">공동구매 등록</a> <br/><br/>
			
				<div class="row">
					<c:forEach var="groupBuy" items="${groupBuyList}" varStatus="status">
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="post-entry-1 h-100">
								<a href="<c:url value='/groupBuy/detail.do'>
								<c:param name="groupBuyId" value="${groupBuy.groupBuyId}"/>
										</c:url>">
										<img src="${groupBuy.img}" alt="Image" class="img-fluid">
								</a>
								
								<div class="post-entry-1-contents">
									<h2>
										<a  href="<c:url value='/groupBuy/detail.do'>
													<c:param name="groupBuyId" value="${groupBuy.groupBuyId}"/>
												</c:url>">${groupBuy.title}</a>
									</h2>
									<span class="meta d-inline-block mb-3">
										~ <fmt:formatDate value="${groupBuy.endDate}" pattern="yyyy-MM-dd" />
									<span class="mx-2">가격</span> 
										<a href="#"><fmt:formatNumber value="${groupBuy.price}" pattern="#,###원"/></a> <br/><br/>
									
									<span class="mx-2">달성률</span> 
										<a href="#"><fmt:formatNumber value="${groupBuy.participants}"/>명 / </a>
										<a href="#"><fmt:formatNumber value="${groupBuy.minNo}"/>명</a>
										<a href="#"><fmt:formatNumber value="${groupBuy.rate}" pattern="###%"/></a>
									</span>
									<p>${groupBuy.content}</p>
								</div>
							</div>
						</div>
    				

					</c:forEach>
				</div>
			</div>
		</div>

<%@ include file="../IncludeBottom.jsp" %>

