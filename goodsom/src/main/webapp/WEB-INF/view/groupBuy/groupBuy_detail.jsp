<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="../IncludeTop.jsp" %> 

<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script>
var optionStatus = 1;
// delete
function deleteGroupBuy(url) {
	
	var deleteCheck = confirm("등록하신 공동구매를 삭제하시겠습니까?")
	return deleteCheck;
}

// 수량 증감
function change(num) {
	var x = document.form;
	var y = Number(x.quantity.value) + num;
	if (y < 1)
		y = 1;
	x.quantity.value = y;
}

// (option, quantity) 선택
function addItem() {
	var list = document.getElementsByName("item");
	var target = document.getElementById("options");
	
	var selectedOption = target.options[target.selectedIndex].text;
	var selectedQuantity = document.getElementById("quantity").value;

	var id = list.length;
	
 	for(var i = 0; i < list.length; i++){
		list[i].setAttribute("value", list[i].value);
 	}
   	app = document.getElementById("itemBox")
  	app.innerHTML += "<div id='itemDiv' class='d-flex'><input type='text' id='item' name='item' value='"
  	  	+ selectedOption + ", " + selectedQuantity + "' class='form-control' readonly>" 
  	  	+ "&nbsp;&nbsp;<input type='button' name='del_btn' id='" + id 
  	  	+ "' value='X' onClick='javascript:delItem(this.id);'></div>";

}

// (option, quantity) 삭제(선택취소)
function delItem(id) {
	var oaqList = document.getElementsByName("item");
	var btnList = document.getElementsByName("del_btn");

	oaqList[id].outerHTML="";
	btnList[id].outerHTML="";
	
	btnList = document.getElementsByName("del_btn");
 	for(var i = 0; i < btnList.length; i++){
 		btnList[i].id = i;
 	}  
}
</script>

<%@ include file="../IncludeBanner.jsp" %> 
    
    <div class="site-section-cover">
      <div class="container">
        <div class="row align-items-center text-center justify-content-center">
          <div class="col-lg-6">
            <h1 class="text-white mb-4">About GroupBuy</h1>
            <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit maxime nemo placeat dolor est.</p>
            
          </div>
        </div>
      </div>
    </div>


    <!-- start groupBuy detail -->
	<br/>    
    <div align="center">
    	<br/><h2 class="text-primary mb-5 font-weight-bold">${groupBuy.title}</h2><br/>
    </div>
         	
     <div class="container">
       <div class="row align-items-center">
         <div class="col-md-6 mb-5 mb-md-0">
         	<img src="<%=request.getContextPath()%>/resources/images/img_5.jpg" alt="Image" class="img-fluid">
         </div>
         
         <div class="col-md-5 ml-auto">
         	
         	<p>작성자 : &nbsp; &nbsp; ${writer} <br/> 
         	작성일 : &nbsp; &nbsp; <fmt:formatDate value="${groupBuy.uploadDate}" pattern="yyyy-MM-dd" />
      		</p>
         	<h2 align="center">$ ${groupBuy.price}</h2><br/>
         	<h5>참여자 수 : &nbsp; &nbsp; ${groupBuy.participants} / ${groupBuy.minNo}</h5>
					<h5>남은 시간 : &nbsp; &nbsp; ${dDay}</h5>
					<br />
					
					<form:form name="form" modelAttribute="lineGroupBuyForm" action="../order/groupBuy/create.do" method="GET">
							
					<div class="alert alert-primary" role="alert">
							<div class="d-flex" style="margin-bottom: 10px;">
								<h5>옵션</h5> &nbsp;&nbsp; 
								<select name="option" id="options">
									<option selected disabled>옵션 선택</option>
									<c:forEach var="option" items="${groupBuy.options}"
										varStatus="status">
										<option value="${option.name}">${option.name}</option>
									</c:forEach>

								</select> <br />
							</div>

							<div class="d-flex">
								<h5>수량</h5> &nbsp;&nbsp; 
								<input type="button" name="minus" value="-"
									onclick="change(-1)" /> &nbsp; 
								<input type="text" id="quantity" name="quantity" value="1"
									style="text-align: center; width: 50px;" readonly /> &nbsp; 
								<input type="button" name="plus" value="+"
									onclick="change(1)" /> &nbsp; &nbsp; 
								<input type="button" value="추가하기" onclick="addItem()" />
							</div>
					</div>
					<div id="itemBox"> </div>
					<input type="submit" value="신청하기" />
					</form:form>
					<br/><br/>
  
         </div>
       </div> 
       
       <br/><br/>
       <div>
	       <h3>상세정보</h3><br/>
		   <h5>${groupBuy.content}</h5>       
       </div>
	   
	   <br/><br/><br/>
	   
	 
	    <c:if test="${isWriter eq true}">
		   <div class="form-group" align="right">
		   		<a class="btn btn-primary py-3 px-5" href="<c:url value='/groupBuy/form.do'>
					<c:param name="groupBuyId" value="${groupBuy.groupBuyId}"/>
					</c:url>">수정</a>
	   			<a class="btn btn-primary py-3 px-5" href="<c:url value='/groupBuy/delete.do'>
	   				<c:param name="groupBuyId" value="${groupBuy.groupBuyId}"/></c:url>" 
			   		onClick="return deleteGroupBuy();">삭제</a>	
	   		</div>	
	    </c:if>						
   </div>
    
<%@ include file="../IncludeBottom.jsp" %>
