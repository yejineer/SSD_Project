<%@ include file="../IncludeBanner.jsp" %> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<body data-spy="scroll" data-target=".site-navbar-target"
	data-offset="300">


	<div class="site-wrap" id="home-section">

		<div class="site-mobile-menu site-navbar-target">
			<div class="site-mobile-menu-header">
				<div class="site-mobile-menu-close mt-3">
					<span class="icon-close2 js-menu-toggle"></span>
				</div>
			</div>
			<div class="site-mobile-menu-body"></div>
		</div>


		<header class="site-navbar site-navbar-target" role="banner">

			<div class="container">
				<div class="row align-items-center position-relative">

					<div class="col-3">
						<div class="site-logo">
							<a href="<%=request.getContextPath()%>/home.do" class="font-weight-bold">Goodsom</a>
						</div>
					</div>

					<div class="col-9  text-right">


						<span class="d-inline-block d-lg-none"><a href="#"
							class="text-primary site-menu-toggle js-menu-toggle py-5"><span
								class="icon-menu h3 text-primary"></span></a></span>



						<nav class="site-navigation text-right ml-auto d-none d-lg-block"
							role="navigation">
							<ul class="site-menu main-menu js-clone-nav ml-auto ">
								<li><a href="<%=request.getContextPath()%>/home.do" class="nav-link">Home</a></li>
								<li><a href="<%=request.getContextPath()%>/groupBuy/list.do" class="nav-link">GroupBuy</a></li>
								<li><a href="<%=request.getContextPath()%>/auction/list.do" class="nav-link">Auction</a></li>
								<li><a href="#">Community</a></li>
								<li><a href="<%=request.getContextPath()%>/user/detail.do"><img src="<%=request.getContextPath()%>/resources/images/mypage.jpg" alt="Image" 
								width="30px" height="20px" class="img-fluid"> ${userSession.user.nickname}</a></li>
							</ul>
						</nav>
					</div>


				</div>
			</div>

		</header>

    
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

    
    <div class="site-section">
      <div class="container">
        <div class="row mb-5">
          <div class="col">
            <h2 class="text-primary font-weight-bold">Our Services</h2>
          </div>
        </div>
        <div class="row">
          <div class="col-md-4">
            <div class="service-29191">
              <span class="wrap-icon mb-4 d-block">
                <span class="icon-desktop_windows"></span>
              </span>
              <h3 class="mb-3">Interface Design</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Deleniti voluptatem reiciendis minus, a dolores.</p>
            </div>
          </div>
          <div class="col-md-4">
            <div class="service-29191">
              <span class="wrap-icon mb-4 d-block">
                <span class="icon-explore"></span>
              </span>
              <h3 class="mb-3">Product Design</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Deleniti voluptatem reiciendis minus, a dolores.</p>
            </div>
          </div>
          <div class="col-md-4">
            <div class="service-29191">
              <span class="wrap-icon mb-4 d-block">
                <span class="icon-layers"></span>
              </span>
              <h3 class="mb-3">Quality Results</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Deleniti voluptatem reiciendis minus, a dolores.</p>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="site-section">
      <div class="container">
        <div class="row mb-4 text-center">
          <div class="col">
            <a href="#"><span class="m-2 icon-facebook"></span></a>
            <a href="#"><span class="m-2 icon-twitter"></span></a>
            <a href="#"><span class="m-2 icon-linkedin"></span></a>
            <a href="#"><span class="m-2 icon-instagram"></span></a>
            <a href="#"><span class="m-2 icon-skype"></span></a>
          </div>
        </div>
        <div class="row mt-5 justify-content-center">
          <div class="col-md-7 text-center">
            <p>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart text-danger" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" >Colorlib</a>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            </p>
          </div>
        </div>
      </div>
    </div>
</div>
    
<%@ include file="../IncludeBottom.jsp" %>
