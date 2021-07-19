<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="imgPath" value="https://www.mydehome.com//whose/resources"/>
<c:set var="list" value="${list}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 채팅목록</title>
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&display=swap"
      rel="stylesheet"
    />
    <link rel="shortcut icon" type="image⁄x-icon" href="${path}/resources/images/x-icon.png" />
    <link rel="stylesheet" href="${path}/resources/css/reset.css" />
    <link rel="stylesheet" href="${path}/resources/css/chatting.css" />
</head>
<body>
<%@include file="../headerfooter/header.jsp"%>
	<!--컨텐츠 시작부분-->
	<div id="chatting_list">
		<div id="chatting_title">
			<p>
				<span class="font_green">상담목록</span> 나의 시공상담 내역을 확인해보세요
			</p>
		</div>

		<!-- 내가 판매한 내역 -->
		<div id="sub_title">
			<span>내가 상담한 목록</span> <span> 내가 상담했거나 현재 상담을 진행중인 시공상담의 채팅
				목록입니다 </span>
		</div>
		<c:forEach var="list" items="${list}">
			<div id="chatting_box">
				<div class="img_box">
					<img src="${imgPath}${list.com_file}">
				</div>
				<div class="text_box">
					<c:if test="${list.user_nick ne nickname}">
						<p class="other">상대방 : ${list.user_nick}</p>
					</c:if>
					<span class="com_name">${list.com_name}</span>
					<p class="com_addr">${list.com_addr}</p>
					<img src="${path}/resources/images/star_green.png" />
					<span class="com_rating">${list.com_rating}</span>
					<c:choose>
						<c:when test="${list.user_nick ne nickname}">
							<button onclick="location.href='../chat/coun_chatting?com_name=${list.com_name}&to_nick=${list.user_nick}'">채팅 바로가기</button>
						</c:when>
						<c:otherwise>
							<button onclick="location.href='../chat/coun_chatting?com_name=${list.com_name}&to_nick=${list.to_nick}'">채팅 바로가기</button>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</c:forEach>
		
	</div>
<%@include file="../headerfooter/footer.jsp"%>
</body>
</html>