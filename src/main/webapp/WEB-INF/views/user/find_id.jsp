<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
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
<script type="text/javascript" src="${path }/resources/js/login.js" charset="utf-8"></script>
</head>
<body>
<%@include file ="../headerfooter/header.jsp" %>
	<form method="post" name="find_id_form" action="../user/find_id_confirm">
		<div class="contents_login">
			<h2 class="page_title">아이디 찾기</h2>
			<div class="login_box">
				<h3 class="login_box_title">회원 가입정보로 찾기</h3>
				<p class="login_label">이름</p>
				<p>
					<input type="text" name="user_name" class="login_input">
				</p>
				<p class="loginform_tip">회원정보에 등록된 이름, 이메일을 입력해주세요.</p>
				<br>
				<p class="login_label">이메일</p>
				<input type="text" name="user_email" class="find_login_input" onfocus="this.value='';">@
				<input type="text" name="user_email2" class="find_login_input" value="" disabled="disabled">
				<select style="height: 45px; width:105px" name="email" onchange="email_change()">
					<option value="0" selected="selected">선택</option>
					<option value="9">직접 입력</option>
					<option value="naver.com">naver.com</option>
					<option value="daum.net">daum.net</option>
					<option value="nate.com">nate.com</option>
					<option value="gmail.com">gmail.com</option>
					<option value="hanmail.net">hanmail.net</option>
				</select><br><br>
				<div>
					<input type="button" value="확인" class="login_button" onclick="findID()">
				</div>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		function email_change(){
			if(document.find_id_form.email.options[document.find_id_form.email.selectedIndex].value == '0'){
				document.find_id_form.user_email2.disabled = true; 
		 		document.find_id_form.user_email2.value = "";
				return;
			}
			if(document.find_id_form.email.options[document.find_id_form.email.selectedIndex].value == '9'){ 
				document.find_id_form.user_email2.disabled = false;
		 		document.find_id_form.user_email2.value = "";
		 		document.find_id_form.user_email2.focus();
				return;  
			} else { 
				document.find_id_form.user_email2.disabled = true;
		 		document.find_id_form.user_email2.value = document.find_id_form.email.options[document.find_id_form.email.selectedIndex].value;
				return;
			}
		}
	</script>
<%@include file ="../headerfooter/footer.jsp" %>
</body>
</html>