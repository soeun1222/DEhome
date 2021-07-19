<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DE:home</title>
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link rel="shortcut icon" type="image⁄x-icon" href="${path}/resources/images/x-icon.png" />
<link
	href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&display=swap"
	rel="stylesheet" />
<link rel="stylesheet" href="${path }/resources/css/header_footer.css" />
<link rel="stylesheet" href="${path }/resources/css/my_page.css" />
<link rel="stylesheet" href="${path }/resources/css/sign_up.css" />
<link rel="stylesheet" href="${path }/resources/css/reset.css" />
<link rel="stylesheet" href="${path }/resources/css/qna_board.css" />
<script type="text/javascript" src="${path }/resources/js/customer.js"
	charset="utf-8"></script>
</head>
<body>
	<%@include file="../headerfooter/header.jsp"%>
	<!-- --------------------- 컨텐츠 시작 ---------------------- -->
	<div id="write2" align="center">
		<form action="../customer/qna_c_modifyView?qna_no=${qna_no}" method="post" name="form">
			<p>
				<span>QnA</span> 답글수정하기
			</p>
			<table>
				<tr>
					<td><textarea name="qna_c_content" placeholder="내용을 작성해주세요">${c_show.qna_c_content}</textarea>
					</td>
				</tr>
				<tr>
					<td class="menu">
						<input type="button" value="작성하기" onclick="qna_c_write_ok()"> 
						<input type="reset" value="다시작성">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<%@include file="../headerfooter/footer.jsp"%>
</body>
</html>