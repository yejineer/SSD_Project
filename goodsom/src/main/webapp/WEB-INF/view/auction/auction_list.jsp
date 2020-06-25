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
						<h1 class="text-white mb-4">Auction</h1>
						<p class="lead">솜솜이들이 갖고 있던 학교 굿즈를 경매하는 공간</p>

					</div>
				</div>
			</div>
		</div>
		
		
		<div class="site-section">
			<div class="container">
			<a class="btn btn-primary py-3 px-5" href="<c:url value='/auction/form.do'></c:url>">경매 등록</a> <br/> <br/>
				<div class="row">
					<c:forEach var="auction" items="${auctionList}" varStatus="status">
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="post-entry-1 h-100">
							
								<a href="<c:url value='/auction/detail.do'><c:param name="auctionId" value="${auction.auctionId}"/></c:url>">
									<img src="${auction.img}" alt="Image" class="img-fluid">
								</a>
								
								<div class="post-entry-1-contents">
								
									<div class="price-wrap d-flex" style="color:blue;">
		    							<c:if test="${aution.state le '0'}"><span class="rate">Proceeding</span></c:if>
		    							<c:if test="${aution.state le '1'}"><span class="rate">Completed</span></c:if>&nbsp;
		    							<p class="from-day">
		    								<span>End Date/ </span>
		    								<span>${auction.endDate}</span>
		    							</p>
		    						</div>
									
									<h2><a  href="<c:url value='/auction/detail.do'>
											<c:param name="auctionId" value="${auction.auctionId}"/>
											</c:url>">${auction.title}</a>
									</h2>
									
									<span class="meta d-inline-block mb-3">
										~ <fmt:formatDate value="${auction.endDate}" pattern="yyyy-MM-dd" />
									<span class="mx-2">현재 최고 금액</span> 
										<a href="#"><fmt:formatNumber value="${auction.maxPrice}" pattern="#,###원"/></a>
									</span>
									<p>${auction.content}</p>
								</div>
							</div>
						</div>
    				

					</c:forEach>
					<%-- <div class="col-lg-4 col-md-6 mb-4">
						<div class="post-entry-1 h-100">
							<a href="<c:url value='/auction/detail.do'>
										<c:param name="email" value="${member.email}"/>
									</c:url>">
									<img src="<%=request.getContextPath()%>/resources/images/img_1.jpg"
								alt="Image" class="img-fluid">
							</a>
							<div class="post-entry-1-contents">
								<h2>
									<a href="single.html">Lorem ipsum dolor sit amet</a>
								</h2>
								<span class="meta d-inline-block mb-3">July 17, 2019 <span
									class="mx-2">by</span> <a href="#">Admin</a></span>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Dolores eos soluta, dolore harum molestias consectetur.</p>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="post-entry-1 h-100">
							<a href="single.html"> <img src="<%=request.getContextPath()%>/resources/images/img_2.jpg"
								alt="Image" class="img-fluid">
							</a>
							<div class="post-entry-1-contents">
								<h2>
									<a href="single.html">Lorem ipsum dolor sit amet</a>
								</h2>
								<span class="meta d-inline-block mb-3">July 17, 2019 <span
									class="mx-2">by</span> <a href="#">Admin</a></span>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Dolores eos soluta, dolore harum molestias consectetur.</p>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="post-entry-1 h-100">
							<a href="single.html"> <img src="<%=request.getContextPath()%>/resources/images/img_3.jpg"
								alt="Image" class="img-fluid">
							</a>
							<div class="post-entry-1-contents">
								<h2>
									<a href="single.html">Lorem ipsum dolor sit amet</a>
								</h2>
								<span class="meta d-inline-block mb-3">July 17, 2019 <span
									class="mx-2">by</span> <a href="#">Admin</a></span>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Dolores eos soluta, dolore harum molestias consectetur.</p>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="post-entry-1 h-100">
							<a href="single.html"> <img src="<%=request.getContextPath()%>/resources/images/img_1.jpg"
								alt="Image" class="img-fluid">
							</a>
							<div class="post-entry-1-contents">
								<h2>
									<a href="single.html">Lorem ipsum dolor sit amet</a>
								</h2>
								<span class="meta d-inline-block mb-3">July 17, 2019 <span
									class="mx-2">by</span> <a href="#">Admin</a></span>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Dolores eos soluta, dolore harum molestias consectetur.</p>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="post-entry-1 h-100">
							<a href="single.html"> <img src="<%=request.getContextPath()%>/resources/images/img_2.jpg"
								alt="Image" class="img-fluid">
							</a>
							<div class="post-entry-1-contents">
								<h2>
									<a href="single.html">Lorem ipsum dolor sit amet</a>
								</h2>
								<span class="meta d-inline-block mb-3">July 17, 2019 <span
									class="mx-2">by</span> <a href="#">Admin</a></span>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Dolores eos soluta, dolore harum molestias consectetur.</p>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="post-entry-1 h-100">
							<a href="single.html"> <img src="<%=request.getContextPath()%>/resources/images/img_3.jpg"
								alt="Image" class="img-fluid">
							</a>
							<div class="post-entry-1-contents">
								<h2>
									<a href="single.html">Lorem ipsum dolor sit amet</a>
								</h2>
								<span class="meta d-inline-block mb-3">July 17, 2019 <span
									class="mx-2">by</span> <a href="#">Admin</a></span>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Dolores eos soluta, dolore harum molestias consectetur.</p>
							</div>
						</div>
					</div>
 --%>

					<div class="col-12 mt-5 text-center">
						<span class="p-3">1</span> <a href="#" class="p-3">2</a> <a
							href="#" class="p-3">3</a> <a href="#" class="p-3">4</a>
					</div>

				</div>
			</div>
		</div>

<%@ include file="../IncludeBottom.jsp" %>