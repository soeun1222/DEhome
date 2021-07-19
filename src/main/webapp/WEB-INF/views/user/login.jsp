<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

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
    <link rel="stylesheet" href="${path }/resources/css/header_footer.css" />
    <link rel="stylesheet" href="${path }/resources/css/my_page.css" />
    <link rel="stylesheet" href="${path }/resources/css/login.css" />
    <link rel="stylesheet" href="${path }/resources/css/reset.css" />
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    
</head>
  <body>
<%@include file ="../headerfooter/header.jsp" %>
      <div class="contents_login">
        <h2 class="page_title">LOGIN</h2>
        <form name="loginform" method="post" action="login">
          <div class="login_box">
            <p class="login_label">아이디</p>
            <p><input type="text" name="user_id" class="login_input" /></p>
            <br />
            <p class="login_label">비밀번호</p>
            <p><input type="password" name="user_pw" class="login_input" /></p>
           	<br>
            <p class="loginform_tip">
              (개인정보 보호를 위해 개인 PC에서만 이용해 주세요.)
            </p>
            <br>
            <div>
              <input type="submit" value="로그인" class="login_button" />
            </div>
            <div>
				<input type="button" value="네이버 로그인" class="login_button_naver" onclick="location.href='${url}'"/>
			</div>
			<div>
				<input type="button" value="카카오 로그인" class="login_button_kakao" onclick="loginWithKakao()"/>
			</div>
			<script type="text/javascript">
				function loginWithKakao() {
					location.href="https://kauth.kakao.com/oauth/authorize?client_id=a432da059b4de91d00d92037e8bb2578&redirect_uri=http://3.37.182.146:8080/dehome/main/kakaoMainpage&response_type=code";
				}
			</script>
			<div class="login_menu">
              <ul>
                <li><a href="../user/find_id">아이디 찾기</a></li>
                <li><a href="../user/find_pw">비밀번호 찾기</a></li>
                <li><a href="../user/register">회원 가입</a></li>
              </ul>
            </div>
          </div>
        </form>
      </div>
<%@include file ="../headerfooter/footer.jsp" %>
  </body>
</html>