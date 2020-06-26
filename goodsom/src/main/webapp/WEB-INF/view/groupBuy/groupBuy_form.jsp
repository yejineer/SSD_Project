<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="../IncludeTop.jsp" %> 
	
<script>
// submit
function groupBuySubmit(url) {
	document.groupBuyForm.action=url;
	document.groupBuyForm.submit();
}

// radio
function hasClass(target, className) {
    if( (' ' + target.className + ' ').replace(/[\n\t]/g, ' ').indexOf(' ' + className + ' ') > -1 ) 
        return true;
    return false;
}
function removeClass(target, className){
    var elClass = ' ' + target.className + ' ';
    while(elClass.indexOf(' ' + className + ' ') !== -1){
         elClass = elClass.replace(' ' + className + ' ', '');
    }
    target.className = elClass;
}
function addClass(target, className){
    target.className += ' ' + className;   
}

// option
function input_append(ff){
 	var list = document.getElementsByName("groupBuy.optionList");

 	for(var i = 0; i < list.length; i++){
		list[i].setAttribute("value", list[i].value);
 	}
   	app = document.getElementById("optionBox")
  	app.innerHTML += "<input type='text' id='groupBuy.options' name='groupBuy.optionList' class='form-control'><br>";
}

</script>
<style>
* {
  margin: 0;
  padding: 0;
}

/* temp grid */

.only-sr {
  overflow: hidden !important;
  position: absolute !important;
  left: -9999px !important;
  width: 1px;
  height: 1px;
}

/* form | radio */
.radio-items {
  display: table;
  width: 100%;
  border: 1px solid #454a60;
  border-radius: 4px;
  box-sizing: border-box;
}
.radio-items > div {
  display: table-cell;
  line-height: 1.5;
  width:100px;
  border-left: 1px solid #454a60;
  text-align: center;
  vertical-align: middle;
}

.radio-items label {
  display: block;
  width: 100%;
  height: 100%;
  color: #454a60;
  vertical-align: middle;
  box-sizing: border-box;
  cursor: pointer;
}
.radio-items input[type="radio"]:checked + label {
  background-color: #454a60;
  color: #fff;
}

.ie8 .radio-items input[type="radio"].checked + label {
  background-color: #454a60;
  color: #fff;
}

#addOption{
	width:100px;
    background-color: #3a4bcf; border: none;
    color:#fff; padding: 15px 0; text-align: center; text-decoration: none;
    display: inline-block; font-size: 15px;
    margin: 4px; border-radius:10px; float: right;
    cursor: pointer;
}
</style>

<%@ include file="../IncludeBanner.jsp" %> 

		<div class="site-section-cover">
			<div class="container">
				<div
					class="row align-items-center text-center justify-content-center">
					<div class="col-lg-6">
						<h1 class="text-white mb-4">Add GroupBuy</h1>
						<p class="lead">솜솜이들의 공동구매를 위한 공간</p>

					</div>
				</div>
			</div>
		</div>

		<!-- start form -->
		<div class="site-section bg-left-half">
			<div class="container">
				<div class="row" >
					<div class="col-lg-8 mb-5">
					
						<form:form modelAttribute="groupBuyForm" method="post" name="groupBuyForm">
						
							<div class="form-group row">
								<div class="col-md-12">
									<label for="title">제목</label> 
									<form:errors path="groupBuy.title" cssClass="error"/> 
									
									<c:choose>
										<c:when test="${createGroupBuy eq true}">
											<form:input type="text" id="title" path="groupBuy.title" class="form-control" placeholder="Title" />
										</c:when>
										<c:otherwise>
											<form:input type="text" id="title" path="groupBuy.title" class="form-control" value="${groupBuyForm.groupBuy.title}" />
										</c:otherwise>
									</c:choose>
								
								</div>
							</div>
							
							<div class="form-group row">
								<div class="col-md-12">
									<label for="img">대표 이미지</label> <br>
									<form:input type="file" id="img" path="groupBuy.img" class="form-control" value="input file"/>
              					</div>
              				</div>
              				
							<div class="form-group row">
								<div class="col-md-12">
									<label for="price">가격</label>
									<c:choose>
										<c:when test="${createGroupBuy eq true}">
											<form:input type="number" id="price" path="groupBuy.price" class="form-control" placeholder="price" />
										</c:when>
										<c:otherwise>
											<form:input type="number" id="price" path="groupBuy.price" class="form-control" value="${groupBuyForm.groupBuy.price}" />
										</c:otherwise>
									</c:choose>
								
								</div>
							</div>
							
							<div class="form-group row">
								<div class="col-md-12">
									<label for="content">상세설명</label> 
									<form:errors path="groupBuy.content" cssClass="error"/>
									
									<c:choose>
										<c:when test="${createGroupBuy eq true}">
											<form:textarea id="content" path="groupBuy.content" class="form-control"
												placeholder="상세 설명을 작성해주세요." cols="30" rows="10"></form:textarea>
										</c:when>
										<c:otherwise>
											<form:textarea id="content" path="groupBuy.content" class="form-control"
												placeholder="상세 설명을 작성해주세요." cols="30" rows="10" items="${groupBuyForm.groupBuy.content}" ></form:textarea>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
							
							<div class="form-group">
								<label for="option">옵션</label>
								<input type="button" id="addOption" value="추가" onclick="input_append(this.form)"/> 
								
								<div id="optionBox">
									<c:choose>
										<c:when test="${createGroupBuy eq true}">
											<form:input type="text" id="groupBuy.options" path="groupBuy.optionList" class="form-control"/><br>
										</c:when>
										<c:otherwise>
											<c:forEach var="option" items="${groupBuyForm.groupBuy.options}" varStatus="status">
												<form:input type="text" id="groupBuy.options" path="groupBuy.optionList" 
														class="form-control" value="${option.name}"/><br>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</div>
								
							</div>
							
							<div class="form-group">
								<label for="catId">태그</label> <br/>

							    <div class="radio-items">
							        <div class="col-2">  <!-- width auto important, 소수점 백그라운드 이슈로 인해 auto 설정 -->
							        	<form:radiobutton id="clothing" path="groupBuy.catId" class="only-sr" value="1" checked="${groupBuyForm.groupBuy.catId==1 ? 'checked':''}"  />
							            <label for="clothing">의류</label>
							        </div>
							        <div class="col-2">
							        	<form:radiobutton id="schoolUniform" path="groupBuy.catId" class="only-sr" value="2" checked="${groupBuyForm.groupBuy.catId==2 ? 'checked':''}" />
										<label for="schoolUniform">학잠</label>
							        </div>
							        <div class="col-2">
							            <form:radiobutton id="writing" path="groupBuy.catId" class="only-sr" value="3" checked="${groupBuyForm.groupBuy.catId==3 ? 'checked':''}" />
							            <label for="writing">필기구</label>
							        </div>
							        <div class="col-2">
							            <form:radiobutton id="tumbler" path="groupBuy.catId" class="only-sr" value="4" checked="${groupBuyForm.groupBuy.catId==4 ? 'checked':''}" />
										<label for="tumbler">텀블러</label>
							        </div>
							        <div class="col-2">
							            <form:radiobutton id="sticker" path="groupBuy.catId" class="only-sr" value="5" checked="${groupBuyForm.groupBuy.catId==5 ? 'checked':''}" />
										<label for="sticker">스티커</label>
							        </div>
							        <div class="col-2">
							            <form:radiobutton id="bagAndPouch" path="groupBuy.catId" class="only-sr" value="6" checked="${groupBuyForm.groupBuy.catId==6 ? 'checked':''}" />
										<label for="bagAndPouch">에코백/파우치</label>
							        </div>
							        <div class="col-2">
							            <form:radiobutton id="etc" path="groupBuy.catId" class="only-sr" value="7" checked="${groupBuyForm.groupBuy.catId==7 ? 'checked':''}" />
										<label for="etc">기타</label>
							        </div>
							    </div>
								   
							</div>
							
							<div class="form-group row">
								<div class="col-md-12">
									<label for="minNo">최소수량</label> 
									
									<div class="d-flex">
										<div class="form-group mr-2">
										<c:choose>
											<c:when test="${createGroupBuy eq true}">
												<form:input type="text" id="minNo" path="groupBuy.minNo" class="form-control" placeholder="ex) 40" />
											</c:when>
											<c:otherwise>
												<form:input type="text" id="minNo" path="groupBuy.minNo" class="form-control" value="${groupBuyForm.groupBuy.minNo}" />
											</c:otherwise>
										</c:choose>
										
										</div>
									</div>
								</div>
							</div>
			              	
			              	<div class="form-group">
			              	<label for="endDate">마감일</label>
			              	<form:errors path="groupBuy.endDate" cssClass="error"/>
			              	
				                <div class="d-flex">
					    		  <div class="form-group mr-2">
					              		<c:choose>
											<c:when test="${createGroupBuy eq true}">
												<form:input type="date" id="endDate" path="groupBuy.endDate" class="form-control" placeholder="ex) 2020-6-30 14:22" />
											</c:when>
											<c:otherwise>
												<fmt:formatDate value='${groupBuyForm.groupBuy.endDate}' pattern='yyyy-MM-dd' var="dateFormat"/>
												<form:input type="date" id="endDate" path="groupBuy.endDate" class="form-control" value="${dateFormat}"/>
											</c:otherwise>
										</c:choose>
					              
					              </div>
			              		</div>
			              	</div>

							
							<div class="form-group" align="right">
								<a class="btn btn-primary py-3 px-5" href="<c:url value='/groupBuy/list.do'></c:url>">취소</a> &nbsp;
								<input type="button" value="완료"  class="btn btn-primary py-3 px-5"
										onClick="groupBuySubmit( <c:if test="${createGroupBuy eq true}">'<c:url value='/groupBuy/create.do'></c:url>'</c:if>
																	<c:if test="${createGroupBuy eq false}">'<c:url value='/groupBuy/update.do'></c:url>'</c:if> )"/>
							</div>
						</form:form>
					</div>
				</div>

			</div>
		</div>
		<!-- END .site-section -->


		<div class="footer site-section bg-light">
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<div class="site-logo-footer">
							<a href="index.html"></a>
						</div>
					</div>
					<div class="col-md-8 ml-auto">
						<div class="row">
							<div class="col-md-4 ml-auto">
								<ul class="list-unstyled links">
									<!-- <li><a href="#">Contact Us</a></li>
									<li><a href="#">hello@mydomain.com</a></li>
									<li><a href="#">+1 829 2293 382</a></li>
									<li><a href="#">Support</a></li> -->
								</ul>
							</div>
							<div class="col-md-4">
								<ul class="list-unstyled links">
									<!-- <li><a href="#">Home</a></li>
									<li><a href="#">Blog</a></li>
									<li><a href="#">Services</a></li>
									<li><a href="#">About Us</a></li> -->
								</ul>
							</div>
							<div class="col-md-4">
								<ul class="list-unstyled links">
									<!-- <li><a href="#">Home</a></li>
									<li><a href="#">Blog</a></li>
									<li><a href="#">Services</a></li>
									<li><a href="#">About Us</a></li> -->
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section bg-light">
			<div class="container">
				<div class="row mb-4 text-center">
					<div class="col">
						<a href="#"><span class="m-2 icon-facebook"></span></a> <a
							href="#"><span class="m-2 icon-twitter"></span></a> <a href="#"><span
							class="m-2 icon-linkedin"></span></a> <a href="#"><span
							class="m-2 icon-instagram"></span></a> <a href="#"><span
							class="m-2 icon-skype"></span></a>
					</div>
				</div>
				<div class="row mt-5 justify-content-center">
					<div class="col-md-7 text-center">
						<p>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							Copyright &copy;
							<script>document.write(new Date().getFullYear());</script>
							All rights reserved | This template is made with <i
								class="icon-heart text-danger" aria-hidden="true"></i> by <a
								href="https://colorlib.com" target="_blank">Colorlib</a>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						</p>
					</div>
				</div>
			</div>
		</div>

<%@ include file="../IncludeBottom.jsp" %>

