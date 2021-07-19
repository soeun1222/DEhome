<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="length" value="${length}"/>
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
	<form method="post" name="find_id_form">
		<c:choose>
			<c:when test="${length == 0 }">
				<script type="text/javascript">
					alert("해당 이름과 이메일로 등록된 아이디가 존재하지 않습니다.");
					history.go(-1);
				</script>
			</c:when>
			<c:otherwise>
				<div class="contents_login">
					<h2 class="page_title">아이디 찾기</h2>
					<div class="login_box">
					<p class="p_length">해당 이름과 이메일이 등록된 아이디는 <span>${length}개</span> 입니다.</p>
						<table>
							<tr>
								<td class="td_id">아이디</td>
								<td class="td_date">가입날짜</td>
								<td class="td_type">로그인 유형</td>
							</tr>
							<c:forEach var="list" items="${list}">
							<c:set var="list_date" value="${list.reg_date}" />
							<c:set var="reg_date"><fmt:formatDate value="${list_date}" pattern="yyyy-MM-dd" /></c:set> 
								<tr>
									<td class="td_id_val">${list.user_id}</td>
									<td class="td_date_val"><c:out value="${reg_date}" /></td>
									<td class="td_type_val">${list.login_type}</td>
								</tr>
							</c:forEach>
						</table>
						<div class="id_info_btn_div">
							<input type="button" value="로그인하기" onclick="location.href='login'" class="id_info_btn"/>
							<input type="button" value="비밀번호 찾기" onclick="location.href='find_pw'" class="id_info_btn"/>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</form>
<%@include file ="../headerfooter/footer.jsp" %>
</body>
</html>