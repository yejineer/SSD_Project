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
						<h1 class="text-white mb-4">My Page</h1>
						<p class="lead">회원 정보 조회 및 수정, 공동구매 및 경매에 등록한 목록이나 결제한 목록, 스크랩한 목록을 볼 수 있는 페이지입니다.</p>
					</div>
				</div>
			</div>
		</div>


		<div class="site-section">
			<div class="container">
				
				<!-- 구현 시작 -->
				<a class="btn btn-primary py-3 px-5" href="<c:url value='list.do'>
							<c:param name="menuId" value ="1" />
						</c:url>">경매 등록 목록 보기</a> &nbsp;&nbsp;
				<a class="btn btn-primary py-3 px-5" href="<c:url value='list.do'>
							<c:param name="menuId" value ="2" />
						</c:url>">공동 구매 등록 목록 보기</a> &nbsp;&nbsp;
				<a class="btn btn-primary py-3 px-5" href="<c:url value='list.do'>
							<c:param name="menuId" value ="0" />
						</c:url>">결제 목록 보기</a>
				<br><br>
				
				<c:if test="${menuId eq 0}">
					<h2><b>결제 목록 보기</b></h2><br>
				</c:if>
				<c:if test="${menuId eq 1}">
					<h2><b>경매 등록 목록 보기</b></h2><br>
				</c:if>
				<c:if test="${menuId eq 2}">
					<h2><b>공동 구매 등록 목록 보기</b></h2><br>
				</c:if>
				
				
					<!-- 결제 목록 보기 -->
					<c:if test="${menuId eq 0}">
						<h3>경매 결제 목록</h3><br />
						<div class="row">
						<c:forEach var="order" items="${auctionOrderList}" varStatus="status">
							<div class="col-lg-4 col-md-6 mb-4">
								<div class="post-entry-1 h-100">
									<!-- 이미지 출력 -->
									<a href="<c:url value='../auction/detail.do'>
												<c:param name="auctionId" value="${order.auctionId}" />
											</c:url>">
										<img src="${order.auction.img}" alt="Image" class="img-fluid">
									</a>
									<div class="post-entry-1-contents">

										<!-- 제목 출력 -->
										<h2>
											<a href="<c:url value='../auction/detail.do'>
														<c:param name="auctionId" value="${order.auctionId}" />
													</c:url>"> ${order.auction.title}</a>
										</h2>
										
										<!-- date, totalPrice, quantity, 상세보기 출력 -->
										<span class="meta d-inline-block mb-3">
											<fmt:formatDate value="${order.orderDate}" pattern="yyyy-MM-dd" /> 
											<span class="mx-2"> 총액 : ${order.totalPrice}원</span>
										</span><br /><br />
									</div>
									<p style="text-align : right; padding : 20px;"> <a href="<c:url value='../order/auction/detail.do'>
												<c:param name="orderId" value ="${order.orderId}" />
											</c:url>"> 상세보기 > </a></p>
								</div>
							</div>
						</c:forEach>
						</div>
						
						<h3>공동구매 결제 목록</h3><br />
						<div class="row">
						<c:forEach var="order" items="${groupBuyOrderList}" varStatus="status">
							<div class="col-lg-4 col-md-6 mb-4">
								<div class="post-entry-1 h-100">
									<a href="<c:url value='../groupBuy/detail.do'>
												<c:param name="groupBuyId" value="${order.groupBuyId}" />
											</c:url>">
										<img src="${order.groupBuy.img}" alt="Image" class="img-fluid">
									</a>
									<div class="post-entry-1-contents">
										<h2>
											<a href="<c:url value='../groupBuy/detail.do'>
														<c:param name="groupBuyId" value="${order.groupBuyId}" />
													</c:url>"> ${order.groupBuy.title}</a>
										</h2>
										
										<span class="meta d-inline-block mb-3">
											<fmt:formatDate value="${order.orderDate}" pattern="yyyy-MM-dd" /> 
											<span class="mx-2"> 총액 : ${order.totalPrice}원</span>
										</span>
									</div>
									<p style="text-align : right; padding : 20px;"> <a href="<c:url value='../order/groupBuy/detail.do'>
												<c:param name="orderId" value ="${order.orderId}" />
											</c:url>"> 상세보기 > </a></p>
								</div>
								
							</div>
						</c:forEach>
						</div>
					</c:if>

					<!-- 경매 목록 보기 -->
					<c:if test="${menuId eq 1}">
						<div class="row">
						<c:forEach var="auction" items="${auctionList}" varStatus="status">
							<div class="col-lg-4 col-md-6 mb-4">
								<div class="post-entry-1 h-100">
									<a href="<c:url value='../auction/detail.do'>
												<c:param name="auctionId" value ="${auction.auctionId}" />
											</c:url>">
										<img src="${auction.img}" alt="Image" class="img-fluid">
									</a>
									<div class="post-entry-1-contents">

										<h2>
											<a href="<c:url value='../auction/detail.do'>
														<c:param name="auctionId" value ="${auction.auctionId}" />
													</c:url>">
												${auction.title} </a>
										</h2>
										<span class="meta d-inline-block mb-3"><fmt:formatDate
												value="${auction.uploadDate}" pattern="yyyy-MM-dd" /> <span
											class="mx-2"> by</span> ${userSession.user.nickname} </span>
										<p>${auction.content}</p>
										<!-- 요약할 방법을 찾아보자. -->
									</div>
								</div>
							</div>
						</c:forEach>
						</div>
					</c:if>

					<!-- 공동구매 목록 보기 -->
					<c:if test="${menuId eq 2}">
						<div class="row">
						<c:forEach var="groupBuy" items="${groupBuyList}" varStatus="status">
							<div class="col-lg-4 col-md-6 mb-4">
								<div class="post-entry-1 h-100">
									<a href="<c:url value='../groupBuy/detail.do'>
												<c:param name="groupBuyId" value ="${groupBuy.groupBuyId}" />
											</c:url>">
										<img src="${groupBuy.img}" alt="Image" class="img-fluid">
									</a>
									<div class="post-entry-1-contents">

										<h2>
											<a
												href="<c:url value='../groupBuy/detail.do'>
												<c:param name="groupBuyId" value ="${groupBuy.groupBuyId}" />
											</c:url>">
												${groupBuy.title} </a>
										</h2>
										<span class="meta d-inline-block mb-3"><fmt:formatDate
												value="${groupBuy.uploadDate}" pattern="yyyy-MM-dd" /> <span
											class="mx-2"> by</span> ${userSession.user.nickname} </span>
										<p>${groupBuy.content}</p>
										<!-- 요약할 방법을 찾아보자. -->
									</div>
								</div>
							</div>
						</c:forEach>
						</div>
					</c:if>
					<!-- 구현 끝 -->

					<div class="col-12 mt-5 text-center">
					<span class="p-3">1</span> <a href="#" class="p-3">2</a> <a
						href="#" class="p-3">3</a> <a href="#" class="p-3">4</a>
				</div>

			</div>
		</div>

<%@ include file="../IncludeBottom.jsp" %>

