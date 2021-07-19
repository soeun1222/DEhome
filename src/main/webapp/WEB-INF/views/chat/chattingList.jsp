<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="imgPath" value="https://www.mydehome.com//whose/resources"/>
<c:set var="list" value="${list}"/>
<c:set var="list2" value="${list2}"/>
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
				<span class="font_green">채팅목록</span> 나의 거래 및 구매내역을 확인해보세요
			</p>
		</div>

		<!-- 내가 판매한 내역 -->
		<div id="sub_title">
			<span>내가 판매한 목록</span> <span> 내가 판매하거나 현재 판매를 진행중인 거래 상품의 채팅
				목록입니다 </span>
		</div>
		<c:forEach var="list" items="${list}">
			<div id="chatting_box" onclick="location.href='../chat/tr_chatting?tr_no=${list.trade_no}&to_nick=${list.user_nick}'">
				<div class="img_box">
					<img src="${imgPath}${list.trade_photo}">
				</div>
				<div class="text_box">
					<p>구매자 : ${list.user_nick}</p>
					<span class="title">${list.trade_title}</span>
					<p class="price">${list.trade_price}</p>
					<c:choose>
						<c:when test="${list.trade_complete eq 0}">
							<button>거래 진행중</button>
						</c:when>
						<c:otherwise>
							<button class="over">거래 완료</button>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</c:forEach>
		<!-- 내가 구매한 내역 -->
		<div id="sub_title2">
			<span>내가 구매한 목록</span> <span> 내가 구매하거나 현재 구매를 진행중인 거래 상품의 채팅
				목록입니다 </span>
		</div>
		<c:forEach var="list2" items="${list2}">
			<div id="chatting_box" onclick="location.href='../chat/tr_chatting?tr_no=${list2.trade_no}&to_nick=${list2.to_nick}'">
				<div class="img_box">
					<img src="${imgPath}${list2.trade_photo}">
				</div>
				<div class="text_box">
					<p>판매자 : ${list2.to_nick}</p>
					<span class="title">${list2.trade_title}</span>
					<p class="price">${list2.trade_price}</p>
					<c:choose>
						<c:when test="${list2.trade_complete eq 0}">
							<button>거래 진행중</button>
						</c:when>
						<c:otherwise>
							<button class="over">거래 완료</button>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</c:forEach>
	</div>
<%@include file="../headerfooter/footer.jsp"%>
</body>
</html>