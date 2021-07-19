<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="imgPath" value="https://www.mydehome.com//whose/resources"/>
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
    <link rel="stylesheet" href="${path}/resources/css/main.css" />
</head>
<body>
<%@include file ="../headerfooter/header.jsp" %>
	    <div id="main_banner">
      <div class="banner">
        <img src="${path}/resources/images/main_3.jpg">
      </div>
    </div>

    <div id="trade_con">
        <div id="content">

          <div class="tr_title">
            <p>중고거래 <span class="font_green">인기</span>매물</p>
          </div>
          <c:choose>
          	<c:when test="${nickname ne null }">
	          <c:forEach items="${list }" var="list">
	          	<a href="../trade/tradeShow?tr_no=${list.tr_no}&ch=0&heart=none">
	            <div class="trade_box">
	                <div class="tr_img">
	                    <img src="${imgPath}${list.tr_photo}">
	                </div>
	                <div class="tr_txt">
	                    <p>${list.tr_title}</p>
	                    <p>${list.user_addr2 } · ${list.tr_category }</p>
	                    <p>
	                    	<c:choose>
	                    		<c:when test="${list.tr_price eq '0'}">
	                    			무료나눔
	                    		</c:when>
	                    		<c:otherwise>
	                    			${list.tr_price }원
	                    		</c:otherwise>
	                    	</c:choose>
	                    </p>
	                </div>
	            </div>
	          </a>
	          </c:forEach>
          	</c:when>
          	<c:otherwise>
	          <c:forEach items="${list }" var="list">
	          	<a href="../user/login">
	            <div class="trade_box">
	                <div class="tr_img">
	                    <img src="${imgPath}${list.tr_photo}">
	                </div>
	                <div class="tr_txt">
	                    <p>${list.tr_title}</p>
	                    <p>${list.user_addr2 } · ${list.tr_category }</p>
	                    <p>
	                    	<c:choose>
	                    		<c:when test="${list.tr_price eq '0'}">
	                    			무료나눔
	                    		</c:when>
	                    		<c:otherwise>
	                    			${list.tr_price }원
	                    		</c:otherwise>
	                    	</c:choose>
	                    </p>
	                </div>
	            </div>
	          </a>
	          </c:forEach>
          	</c:otherwise>
          </c:choose>

        </div>
    </div>

    <div id="tip_banner">
      <div class="tip_banner">
        <img src="${path}/resources/images/main_paint.jpg">
        <div class="tip_txt">
          <p>
            이젠 혼자서도 척척,<br>
            <span>인테리어 꿀TIP</span>
          </p>
          <p>
            나만의 다양하고 기발한 인테리어 방법들을 <br>
            사람들과 간편하게 공유하고 나눠보세요
          </p>

          <div class="moreBtn">
            <button onclick="location.href='../interior/interiorTip'">more</button>
          </div>
        </div>
      </div>
    </div>
<%@include file ="../headerfooter/footer.jsp" %>
</body>
</html>