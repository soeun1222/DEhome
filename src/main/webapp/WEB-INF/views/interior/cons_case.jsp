<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% pageContext.setAttribute("replaceChar", "\n"); %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="imgPath" value="https://www.mydehome.com//whose/resources"/>
<c:set var="ex_no" value="${param.ex_no }"></c:set>
<c:set var="ex" value="${ex }"></c:set>
<c:set var="ex_date" value="${ex_date }"></c:set>
<c:set var="user_com_name" value="${user_com_name }"></c:set>
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

	<div id="case_page">
		<div class="case_title">
			<p>${ex_date }</p>
			<p>시공사례</p>
			<c:choose>
				<c:when test="${user_com_name eq ex.com_name }">
					<p><input type="button" value="사례 삭제하기" onclick="delete_ok()" class="editBtn"></p>
					<p><input type="button" value="사례 수정하기" onclick="location.href='cons_case_edit?ex_no=${ex_no}&com_name=${ex.com_name }'" class="editBtn"></p>
					<script type="text/javascript">
	      			function delete_ok() {
	      				var del = confirm("해당 게시글을 삭제하시겠습니까?");
	      				if(del == true) {
	      					document.location.href='../interior/cons_case_delete?ex_no=${ex_no}&com_name=${ex.com_name }';
	      				} else {
	      					return;
	      				}
	      			}
	      		</script>
				</c:when>
				<c:otherwise>
					<p style="margin-top: 20px">${ex.com_name }</p>
				</c:otherwise>
			</c:choose>
			<p>${ex.ex_title }</p>
		</div>
		<div class="case_content">
			<p>${fn:replace(ex.ex_content, replaceChar, "<br>") }</p>
			<div class="case_img">
				<img src="${imgPath}/${ex.ex_file}">
			</div>
		</div>
		<div id="list_btn">
			<input type="button" value="목록으로 돌아가기"
				onclick="history.go(-1)" />
		</div>
	</div>
	
<%@include file ="../headerfooter/footer.jsp" %>
</body>
</html>