<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="../IncludeTop.jsp" %> 

<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script>
//delete
function deleteNoti() {
	var deleteCheck = confirm("알림을 삭제하시겠습니까?")
	
	return deleteCheck;
	
}
</script>

<%@ include file="../IncludeBanner.jsp" %> 
    
    <div class="site-section-cover">
      <div class="container">
        <div class="row align-items-center text-center justify-content-center">
          <div class="col-lg-6">
            <h1 class="text-white mb-4">Noti Page</h1>
            <p class="lead">알림을 통해 참여한 경매/공동구매 등의 낙찰/마감 여부를 확인할 수 있습니다.</p>
            
          </div>
        </div>
      </div>
    </div>


    <!-- start groupBuy detail -->
	<br/>    
    <div align="center">
    	<br/><h2 class="text-primary mb-5 font-weight-bold">알림함</h2><br/>
    </div>
         	
     <div class="container">
       <div>
         
          <div align="right">
         	<p>&nbsp; &nbsp;${type} : ${nickname}님의 알림함 <br/></p>
          </div>
          
         	<h2 align="center">제목: ${noti.title}</h2><br/>
         	
          <div align="right">
         	수신일 : &nbsp; &nbsp; <fmt:formatDate value="${noti.notiDate}" pattern="yyyy-MM-dd HH:mm" />
		  </div>
			<h5>내용</h5>
			<h6>${content}</h6>
        
       </div> 
       
       <br/><br/>
	
	   <div class="form-group" align="right">
	   		<a class="btn btn-primary py-3 px-5" href="<c:url value='/noti/list.do'>
				</c:url>">확인</a>
   			<a class="btn btn-primary py-3 px-5" href="<c:url value='/noti/delete.do'>
   				<c:param name="notiId" value="${noti.notiId}"/>
   				<c:param name="type" value="${type}"/>
   				</c:url>" 
		   		onClick="return deleteNoti();">삭제</a>	
   		</div>	
	    					
   </div>
    
<%@ include file="../IncludeBottom.jsp" %>
