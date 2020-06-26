<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="../IncludeTop.jsp" %> 

<%@ include file="../IncludeBanner.jsp" %> 

		<div class="site-section-cover">
			<div class="container">
				<div
					class="row align-items-center text-center justify-content-center">
					<div class="col-lg-6">
						<h1 class="text-white mb-4">GroupBuy</h1>
						<p class="lead">솜솜이들의 공동구매를 위한 공간</p>

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
							
								<c:if test="${groupBuy.state=='proceeding' || groupBuy.state=='achieved'}" >
									<c:if test="${groupBuy.state eq 'achieved'}">
										<a>달성된 공동구매입니다.<br> 마감일까지 참여 가능합니다.</a>
									</c:if>
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
											<a href="#"><fmt:formatNumber value="${groupBuy.rate}"/>%</a>
										</span>
										<p>${groupBuy.content}</p>
									</div>
								</c:if>
								<c:if test="${groupBuy.state eq 'closed'}">
									<a>마감된 공동구매입니다.</a>
									<img src="${groupBuy.img}" alt="Image" class="img-fluid">
									<div class="post-entry-1-contents">
										<h2>
											<a>${groupBuy.title}</a>
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
								</c:if>
							</div>
						</div>
    				

					</c:forEach>
				</div>
			</div>
		</div>

<%@ include file="../IncludeBottom.jsp" %>

