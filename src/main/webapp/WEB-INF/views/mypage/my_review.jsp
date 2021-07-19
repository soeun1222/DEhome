<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="imgPath" value="https://www.mydehome.com//whose/resources"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DE:home</title>
<%@include file="../headerfooter/header.jsp" %>
<script type="text/javascript" src="${path }/resources/js/mypage.js" charset="utf-8"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link rel="shortcut icon" type="image⁄x-icon" href="${path}/resources/images/x-icon.png" />
    <link
      href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&display=swap"
      rel="stylesheet"
    />
  	<link rel="stylesheet" href="${path }/resources/css/header_footer.css" />
    <link rel="stylesheet" href="${path }/resources/css/my_page.css" />
    <link rel="stylesheet" href="${path }/resources/css/login.css" />
</head>
<body>
 <div class="contents_mypage">
        <a href="mypage"><h2 class="page_title">MY PAGE</h2></a>
        <div class="mypage_header_box">
          <p class="my_page_label">${nickname }님 안녕하세요</p>
        </div>
       
         <div class="mypage_sidebar_box">
            <ul class="mypage_ul1">
              <li class="mypage_side_label">회원정보</li>
              <li class="mypage_side_list" ><a href="edit_account">개인정보 수정</a></li>
              <li class="mypage_side_list"><a href="delete_account">회원탈퇴</a></li>
            </ul>
            <ul class="mypage_ul2">
              <li class="mypage_side_label">활동 및 문의</li>
              <li class="mypage_side_list"><a href="#">나의 거래</a>
                 <ul class="mypage_side_list_2">
                    <li><a href="../mypage/my_sell_list">나의 판매 물품</a></li>
                    <li><a href="../mypage/my_buy_list">나의 구매 물품</a></li>
                 </ul>
              </li>
              <li class="mypage_side_list_1" style="color: #1B7850"><a href="my_trade_board">내가 작성한 글 ></a>
                 <ul class="mypage_side_list_2">
                    <li><a href="my_trade_board">자유게시판</a></li>
                    <li><a href="../mypage/my_interior_tip">인테리어 팁</a></li>
                    <li><a href="my_review">시공리뷰</a></li>
                    <li><a href="../mypage/my_qna">QNA</a></li>
                 </ul>
              </li>
              <li class="mypage_side_list"><a href="../chat/chattingList">대화목록</a></li>
              <li class="mypage_side_list"><a href="../mypage/my_bookmark">북마크</a></li>
            </ul>
          </div>
      
      
<%--나중에,,,,,,,,,,,,,,,,,,,, --%>
      <div id="company_title">
        <!-- <input type="button" value="더보기"> -->
        <p>
          <span class="font_green">시공리뷰</span>
      </div>
      <div id="review_content">
		 <c:forEach items="${myReview }" var="myReview" end="5" varStatus="status">
		 
		 <c:if test="${status.index%2==0}">
			<a class="content_left" href="../interior/review_show?re_no=${myReview.re_no }">
	          <div class="recon_01">
	            <p>
	              <span>${myReview.re_title}</span>
	              <span>${myReview.com_name}</span>
	          	  <img src="${path }/resources/images/star_yellow_15.png" /> 
	              <span>${myReview.com_rating }</span>
	            </p>
	            <p>${myReview.re_content}
	            </p>
	            
	          </div>
	        </a>
		 </c:if>	
		 <c:if test="${status.index%2==1}">
			<a class="content_right" href="../interior/review_show?re_no=${myReview.re_no }">
	          <div class="recon_01">
	            <p>
	              <span>${myReview.re_title}</span>
	              <span>${myReview.com_name}</span>
	          	  <img src="${path }/resources/images/star_yellow_15.png" /> 
	              <span>${myReview.com_rating }</span>
	            </p>
	            <p>${myReview.re_content}
	            </p>
	            
	          </div>
	        </a>
		 </c:if>	
		 </c:forEach>	
		 
      <input type="hidden" id="path" value="${path}">
      <input type="hidden" id="imgPath" value="${imgPath}">
	</div>	           
    	<c:choose>
			<c:when test="${myReview == null or fn:length(myReview) == 0}">
				 <span class="noReview">작성한 리뷰가 없습니다</span>
			</c:when>    	
			<c:otherwise>
		        <div id="move_btn2">
		          <input type="button" id="more" value="더보기" />
		        </div>
		    </c:otherwise>
	    </c:choose>
		 <script type="text/javascript">
		  	var more = -1;
			$(function(){$('#more').on('click',function(){
				var path = document.getElementById("path").value;
				var imgPath = document.getElementById("imgPath").value;
				more = more + 1
				console.log(more);
					$.ajax({
						url : "my_review.more",
						type : "post",
						data: { more : more},	
						dataType: "json",
						success: function(data) {
							var html = "";
							for(var i in data.myReview) {
								if( i % 2 == 0 ){
									html+= "<a class='content_left' href='../interior/review_show?re_no="+data.myReview[i].re_no+"'>";
									html+= "<div class='recon_01'>";
									html+= "<p>";
									html+= "<span>"+ decodeURIComponent(data.myReview[i].re_title)+"</span>";
									html+= "<span>"+ decodeURIComponent(data.myReview[i].com_name)+"</span>";
									html+= "<img src='"+ path +"/resources/images/star_yellow_15.png' /> ";
									html+= "<span>"+data.myReview[i].com_rating +"</span>";
									html+= "</p>";
									html+= "<p>"+  decodeURIComponent(data.myReview[i].re_content)+"</p>";
									html+= "</div>";
									html+= "</a>";
								}else{
									html+= "<a class='content_right' href='../interior/review_show?re_no="+data.myReview[i].re_no+"'>";
									html+= "<div class='recon_01'>";
									html+= "<p>";
									html+= "<span>"+decodeURIComponent(data.myReview[i].re_title)+"</span>";
									html+= "<span>"+ decodeURIComponent(data.myReview[i].com_name)+"</span>";
									html+= "<img src='"+ path +"/resources/images/star_yellow_15.png' /> ";
									html+= "<span>"+data.myReview[i].com_rating +"</span>";
									html+= "</p>";
									html+= "<p>"+  decodeURIComponent(data.myReview[i].re_content)+ "</p>";
									html+= "</div>";
									html+= "</a>";
								}
							}
							
							if(data.myReview.length >= 1) {
				                 $("#review_content").append($(html).fadeIn());
				            } else {
				            	alert("마지막 페이지입니다");
							}
							},
								error:function (request,status,errorData) {
					              alert('error code: ' + request.status + "\n"
					                      + 'message: ' + request.responseText + "\n"
					                      + 'error: ' + errorData);
					          	}
							})
						})
					});
					</script>
         		
<%@include file="../headerfooter/footer.jsp" %>		          	  
</body>
</html>