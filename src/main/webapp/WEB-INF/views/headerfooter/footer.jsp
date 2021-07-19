<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="${path }/resources/css/header_footer.css" />
    <link rel="stylesheet" href="${path }/resources/css/reset.css" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
	<footer>
      <hr />
      <div class="footer_menu_list">
        <ul>
          <li>
            <a href="../customer/introduce">DE:home 소개</a>
          </li>
          <li>
            <a href="#">이용약관</a>
          </li>
          <li>
            <a href="#"> 개인정보보호취급방침 </a>
          </li>
          <li>
            <a href="../customer/not_list">공지사항</a>
          </li>
          <li>
            <a href="#">광고문의</a>
          </li>
          <li>
            <a href="https://twitter.com/?lang=ko" target="_blank">Twitter</a>
          </li>
          <li>
            <a href="https://m.facebook.com/?locale2=ko_KR" target="_blank"
              >Facebook</a
            >
          </li>
          <li>
            <a href="https://github.com/rla9709/DEhome" target="_blank">Github</a>
          </li>
          <li>
            <a href="#">고객센터</a> : Tel. 0000-0000, 평일 09:00~12:00, 주말
            휴무, 공휴일 휴무
          </li>
        </ul>
      </div>
      <div class="footer_info">
        <ul>
          <li>DE:home</li>
          <li>대표이사 : 000</li>
          <li>문의 : dehome@home.com</li>
          <li>
            주소 : 부산광역시 부산남구 수영로 299, 루미너스 빌딩 10층 1004호
          </li>
          <li>사업자등록번호 : 000-000-0000-00</li>
          <li>통신판매업 신고번호 : 0000-부산남-00000 호</li>
        </ul>
      </div>
      <div class="footer_copyright">
        <ul>
          <li>copyright ⓒ 2021 etah. All rights reserved.</li>
        </ul>
      </div>
    </footer>
</body>
</html>