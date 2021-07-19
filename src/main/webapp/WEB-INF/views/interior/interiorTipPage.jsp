<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% pageContext.setAttribute("replaceChar", "\n"); %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="imgPath" value="https://www.mydehome.com//whose/resources"/>
<c:set var="dto" value="${dto2}"/>
<c:set var="time" value="${time}"/>
<c:set var="bm" value="${bm}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
	<link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&display=swap"
      rel="stylesheet"
    />
    <link rel="shortcut icon" type="image⁄x-icon" href="${path }/resources/images/x-icon.png" />
    <link rel="stylesheet" href="${path }/resources/css/reset.css" />
    <link rel="stylesheet" href="${path }/resources/css/interior_tip.css" />
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="${path }/resources/js/bookmark.js" charset="utf-8"></script>
<title>DE:home</title> 
</head>
<body>
<%@include file="../headerfooter/header.jsp" %>
<input type="hidden" id="tip_no" value="${dto.tip_no}">
	<div id="tip_page">
      <div class="tip_title">
        <p>${time}</p>
        <c:choose>
        	<c:when test="${category eq 'construct'}">
				<p>시공 TIP</p>
        	</c:when>
        	<c:when test="${category eq 'storage'}">
				<p>수납 TIP</p>
        	</c:when>
        	<c:when test="${category eq 'decorate'}">
				<p>꾸미기 TIP</p>
        	</c:when>
        	<c:when test="${category eq 'cleaning'}">
				<p>청소 TIP</p>
        	</c:when>
        	<c:when test="${category eq 'diy'}">
				<p>DIY TIP</p>
        	</c:when>
        	<c:when test="${category eq 'reform'}">
				<p>리폼 TIP</p>
        	</c:when>
        	<c:when test="${category eq 'kitchen'}">
				<p>주방/욕실 TIP</p>
        	</c:when>
        	<c:when test="${category eq 'lighting'}">
				<p>전기/조명 TIP</p>
        	</c:when>
        </c:choose>
        <p>
          조회수 
          <span class="font_green">${dto.tip_count}</span> 
          · 스크랩
          <span class="font_green" id="bmCount">${dto.tip_bookmark}</span>
        </p>
        <p>${dto.tip_title}</p>
		<p id="bmBtn">
			<c:choose>
				<c:when test="${bm == 0}">
					<input type="button" onclick="bm_on()">
				</c:when>
				<c:otherwise>
					<input type="button" class="bm_on" onclick="bm_off()">
				</c:otherwise>
			</c:choose>
			</p>
        <p>${dto.tip_user_nick}</p>
      </div>
      <div class="tip_content">
      	<p>
      		<img src="${imgPath}${dto.tip_file}" class="tip_img">
      	</p>
        <p>
    		${fn:replace(dto.tip_content, replaceChar, "<br>") }
        </p>
      </div>
      <div id="list_btn">
        <input
          type="button"
          value="목록으로 돌아가기"
          onclick="location.href='../interior/interiorTipList?category=${category}'"
        />
      </div>
    </div>
<%@include file="../headerfooter/footer.jsp" %>
</body>
</html>