<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="password" value="${pw}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DE:home</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="shortcut icon" type="image⁄x-icon" href="${path}/resources/images/x-icon.png" />
<link
	href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="${path }/resources/css/header_footer.css">
<link rel="stylesheet" href="${path }/resources/css/my_page.css">
<link rel="stylesheet" href="${path }/resources/css/login.css">
<link rel="stylesheet" href="${path }/resources/css/reset.css">
</head>
<body>
<%@include file ="../headerfooter/header.jsp" %>
	<form method="post" name="find_pw_form" action="find_pw_confirm.jsp">
		<div class="contents_login">
			<h2 class="page_title">비밀번호 찾기</h2>
			<div class="login_box">
				<p class="pw_info">비밀번호 : ${password}</p>
				<div class="pw_info_btn_div">
					<input type="button" value="로그인하기" onclick="location.href='login'" class="pw_info_btn"/>
					<input type="button" value="비밀번호 변경" onclick="location.href='#'" class="pw_info_btn"/>
				</div>
			</div>
		</div>
	</form>
<%@include file ="../headerfooter/footer.jsp" %>
</body>
</html>