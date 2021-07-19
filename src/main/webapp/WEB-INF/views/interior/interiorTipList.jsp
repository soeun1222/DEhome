<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<c:set var="imgPath" value="https://www.mydehome.com//whose/resources"/>
<c:set var="bmuser" value="${bmuser}" />
<c:set var="nick" value="${nick}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DE:home</title>
	<link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&display=swap"
      rel="stylesheet"
    />
    <link rel="shortcut icon" type="image⁄x-icon" href="${path }/resources/images/x-icon.png" />
    <link rel="stylesheet" href="${path }/resources/css/reset.css" />
    <link rel="stylesheet" href="${path }/resources/css/interior_tip.css" />
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${path }/resources/js/tip.js" charset="utf-8"></script>
    <script type="text/javascript" src="${path }/resources/js/bookmark.js" charset="utf-8"></script>
</head>
<body>
<%@include file ="../headerfooter/header.jsp" %> 
	<%-- 콘텐트 헤더 --%> 
	<div id="part_tip_list">
      <div id="company_title">
      <c:choose>
      	<c:when test="${empty nick}">
	        <input type="button" value="팁 작성하기"
    	      	   onclick="location.href='../user/login'" />
      	</c:when>
      	<c:otherwise>
	        <input type="button" value="팁 작성하기"
    	      	   onclick="location.href='../interior/interiorTipWrite'" />
      	</c:otherwise>
      </c:choose>
      <c:choose>
      		<c:when test="${category eq 'construct'}">
				<p>
        			<span class="font_green">인테리어 시공 TIP</span>
        			인테리어 시공 꿀팁
        		</p>
      		</c:when>
      		<c:when test="${category eq 'storage' }">
				<p>
        			<span class="font_green">차곡차곡 수납 TIP</span>
        			수납 인테리어 꿀팁
        		</p>
      		</c:when>
      		<c:when test="${category eq 'decorate' }">
				<p>
        			<span class="font_green">인테리어 꾸미기 TIP</span>
        			꾸미기 꿀팁
        		</p>
      		</c:when>
      		<c:when test="${category eq 'cleaning' }">
				<p>
        			<span class="font_green">꼼꼼한 청소 TIP</span>
        			청소 꿀팁
        		</p>
      		</c:when>
      		<c:when test="${category eq 'diy' }">
				<p>
        			<span class="font_green">인테리어 DIY TIP</span>
        			DIY 인테리어 꿀팁
        		</p>
      		</c:when>
      		<c:when test="${category eq 'reform' }">
				<p>
        			<span class="font_green">새 것 같은 리폼 TIP</span>
        			인테리어 리폼 꿀팁
        		</p>
      		</c:when>
      		<c:when test="${category eq 'kitchen' }">
				<p>
        			<span class="font_green">주방 및 욕실 TIP</span>
        			주방/욕실 인테리어 꿀팁
        		</p>
      		</c:when>
      		<c:when test="${category eq 'lighting' }">
				<p>
        			<span class="font_green">전기 및 조명 TIP</span>
        			전기/조명 인테리어 꿀팁
        		</p>
      		</c:when>
      		<c:otherwise>
      			<p>
        			<span class="font_green">전기 및 조명 TIP</span>
        			전기/조명 인테리어 꿀팁
        		</p>
      		</c:otherwise>
      </c:choose>
		</div>
      	<div id="tip_sub_title">
       		<span>
       			다양한 사람들과 공유하는, 누구나 할 수 있지만
       			알려주기 전엔 모르는 오직 나 만의 꿀팁
	        </span>
    	</div>
      <!-- 콘텐트 -->
	      <table>
	        <tr>
	          <td>
				 <c:forEach var="dto" items="${tipListCategory}">
					<c:choose>
						<c:when test="${empty nick}">
				            <a href="../user/login">
						</c:when>
						<c:otherwise>
			           		<a href="../interior/interiorTipPage?tip_no=${dto.tip_no}">
						</c:otherwise>
					</c:choose>
		   	      	<div id="shop">
	                	<div class="shop_img">
	                	<c:choose>
	                	<c:when test="${not empty nick}">
	                		<c:choose>
					           	<c:when test="${fn:contains(dto.tip_bmuser, dto.tip_user_nick)}">
					                <input type="button" class="bm_on">
					           	</c:when>
					           	<c:otherwise>
					                <input type="button">
					           	</c:otherwise>
	                		</c:choose>
	                	</c:when>
	                	<c:otherwise>
			                <input type="button">
	                	</c:otherwise>
		           	</c:choose>
	                		<img src="${imgPath}${dto.tip_file}" />
			            </div>
		                <div class="shop_ex">
	                  		<div class="shop_name">${dto.tip_title}</div>
			                <p>
			                  조회수 <span class="font_green">${dto.tip_count}</span> 
			                  · 스크랩 <span class="font_green">${dto.tip_bookmark}</span>
			                </p>
		                </div>
	                </div>
	           	  </a>
				</c:forEach>
	          </td>
	        </tr>
	      </table>
      	</div>
		<input type="hidden" id="path" value="${path}">
<%@include file ="../headerfooter/footer.jsp" %>
</body>
</html>