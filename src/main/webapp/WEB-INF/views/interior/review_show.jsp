<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% pageContext.setAttribute("replaceChar", "\n"); %>
<c:set var="imgPath" value="https://www.mydehome.com//whose/resources"/>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="re_no" value="${param.re_no }"></c:set>
<c:set var="review" value="${review }"></c:set>
<c:set var="re_date" value="${re_date }"></c:set>
<c:set var="like" value="${like }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DE:home</title>
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link rel="shortcut icon" type="image⁄x-icon" href="${path}/resources/images/x-icon.png" />
    <link
      href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="${path}/resources/css/reset.css" />
    <link rel="stylesheet" href="${path}/resources/css/interior.css" />
    
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>	
<script type="text/javascript" src="${path }/resources/js/review.js" charset="utf-8"></script>
</head>
<body>
	<%@include file ="../headerfooter/header.jsp" %>

	<div id="review_page">
    <div id="review_title">
      <p>${re_date }</p>
      <p>시공리뷰</p>
      <p id="likeCount">
        이 리뷰가 도움이 된 횟수 <span class="font_green">${review.re_interest }</span>
      </p>
      <p>${review.re_title}</p>
      <input type="hidden" id="re_no" value="${re_no }">
      <div id="btnBox">
      <c:choose>
	      	<c:when test="${nickname eq review.user_nick }">
	      		<div id="editDel">
		      		<p><input type="button" value="리뷰 수정하기" onclick="location.href='review_edit?re_no=${re_no}&com_name=${review.com_name }'" class="editBtn"></p>
		      		<p><input type="button" value="리뷰 삭제하기" onclick="delete_ok()" class="deleteBtn"></p>
	      		</div>
	      		<script type="text/javascript">
	      			function delete_ok() {
	      				var del = confirm("해당 게시글을 삭제하시겠습니까?");
	      				if(del == true) {
	      					document.location.href='../interior/review_delete?re_no=${re_no}&com_name=${review.com_name }';
	      				} else {
	      					return;
	      				}
	      			}
	      		</script>
	      	</c:when>
	      	<c:when test="${nickname eq null }">
	      		<p class="helpBtn"><input type="button" value="도움 되었나요?" onclick="login_no()"></p>
	      	</c:when>
	      	<c:when test="${like == 1 }">
	      		<p class="helpBtn"><input type="button" value="도움되었습니다" onclick="like_off()" class="like_on"></p> 
	      	</c:when>
	      	<c:otherwise>
	      		<p class="helpBtn"><input type="button" value="도움 되었나요?" onclick="like_on()" ></p>
	      	</c:otherwise>
	      </c:choose>
	</div>
	
      <p>${review.user_nick}</p>
    </div>
    <div class="review_content">
      <p>${fn:replace(review.re_content, replaceChar, "<br>") }</p>
      <div class="review_img">
        <img src="${imgPath}${review.re_file}">
      </div>
    </div>
    <div id="list_btn">
      <input type="button" value="목록으로 돌아가기" onclick="location.href='company_page?name=${review.com_name}'">
    </div>
  </div>
  
  <script type="text/javascript" src="${path }/resources/js/likeBtn.js" charset="utf-8"></script>
	
<%@include file ="../headerfooter/footer.jsp" %>
</body>
</html>