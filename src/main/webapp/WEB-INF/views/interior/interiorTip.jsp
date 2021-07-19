<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="imgPath" value="https://www.mydehome.com//whose/resources"/>
<c:set var="bmuser" value="${bmuser}" />
<c:set var="nick" value="${nick}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>DE:home</title>
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&display=swap" rel="stylesheet"/>
    <link rel="shortcut icon" type="image⁄x-icon" href="${path }/resources/images/x-icon.png" />
    <link rel="stylesheet" href="${path }/resources/css/header_footer.css" />
    <link rel="stylesheet" href="${path }/resources/css/reset.css" />
    <link rel="stylesheet" href="${path }/resources/css/interior_tip.css" />
    <script type="text/javascript" src="${path }/resources/js/bookmark.js" charset="utf-8"></script>
</head>
<body>
<jsp:include page="../headerfooter/header.jsp" /> 
	<div id="interior_tip_list">
<!--시공 TIP-->
	      <div class="tip_content">
	        <div class="tip_title">
	          <input type="button" value="더보기" class="more" 
	          		onclick="location.href='../interior/interiorTipList?category=construct'" />
	          <p>인테리어 시공 TIP</p>
	          <p>인테리어 시공 꿀팁</p>
	        </div>
			<c:forEach var="dto" items="${tipListConstruct}">
				<c:choose>
					<c:when test="${not empty nick}">
		           		<a href="../interior/interiorTipPage?tip_no=${dto.tip_no}">
					</c:when>
					<c:otherwise>
						<a href="../user/login">
					</c:otherwise>
				</c:choose>
	   	      	<div class="tipcon_box" id="tipcon_box">
	              	<div id="tipcon_img">
	                  <img src="${imgPath}${dto.tip_file}" />
		            </div>
		           	<c:choose>
	                	<c:when test="${not empty nick}">
	                		<c:choose>
					           	<c:when test="${fn:contains(dto.tip_bmuser, nick)}">
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
	                <p>${dto.tip_title}</p>
	                <p>
	                  조회수 <span class="font_green">${dto.tip_count}</span> 
	                  · 스크랩 <span id="bmCount" class="font_green">${dto.tip_bookmark}</span>
	                </p>
              	</div>
           	    </a>
			</c:forEach>
		</div>
<!-- 꾸미기 TIP -->
	      <div class="tip_content">
	        <div class="tip_title">
	          <input type="button" value="더보기" class="more" 
	          		onclick="location.href='../interior/interiorTipList?category=decorate'" />
	          <p>인테리어 꾸미기 TIP</p>
	          <p>꾸미기 꿀팁</p>
	        </div>
			<c:forEach var="dto" items="${tipListDecorate}">
           		<c:choose>
					<c:when test="${not empty nick}">
		           		<a href="../interior/interiorTipPage?tip_no=${dto.tip_no}">
					</c:when>
					<c:otherwise>
						<a href="../user/login">
					</c:otherwise>
				</c:choose>
	   	      	<div class="tipcon_box">
	              	<div id="tipcon_img">
	                  <img src="${imgPath}${dto.tip_file}" />
		            </div>
	                <c:choose>
	                	<c:when test="${not empty nick}">
	                		<c:choose>
					           	<c:when test="${fn:contains(dto.tip_bmuser, nick)}">
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
	                <p>${dto.tip_title}</p>
	                <p>
	                  조회수 <span class="font_green">${dto.tip_count}</span> 
	                  · 스크랩 <span class="font_green">${dto.tip_bookmark}</span>
	                </p>
              	</div>
           	    </a>
			</c:forEach>
		</div>
<!--DIY TIP-->
	      <div class="tip_content">
	        <div class="tip_title">
	          <input type="button" value="더보기" class="more" 
		      		onclick="location.href='../interior/interiorTipList?category=diy'" />
	          <p>인테리어 DIY TIP</p>
	          <p>DIY 인테리어 꿀팁</p>
	        </div>
			<c:forEach var="dto" items="${tipListDiy}">
           		<c:choose>
					<c:when test="${not empty nick}">
		           		<a href="../interior/interiorTipPage?tip_no=${dto.tip_no}">
					</c:when>
					<c:otherwise>
						<a href="../user/login">
					</c:otherwise>
				</c:choose>
	   	      	<div class="tipcon_box">
	              	<div id="tipcon_img">
	                  <img src="${imgPath}${dto.tip_file}" />
		            </div>
	               <c:choose>
	                	<c:when test="${not empty nick}">
	                		<c:choose>
					           	<c:when test="${fn:contains(dto.tip_bmuser, nick)}">
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
	                <p>${dto.tip_title}</p>
	                <p>
	                  조회수 <span class="font_green">${dto.tip_count}</span> 
	                  · 스크랩 <span class="font_green">${dto.tip_bookmark}</span>
	                </p>
              	</div>
           	    </a>
			</c:forEach>
		</div>
<!--주방/욕실 TIP-->
	      <div class="tip_content">
	        <div class="tip_title">
	          <input type="button" value="더보기" class="more" 
	          		onclick="location.href='../interior/interiorTipList?category=kitchen'" />
	          <p>주방 및 욕실 TIP</p>
	          <p>주방/욕실 인테리어 꿀팁</p>
	        </div>
			<c:forEach var="dto" items="${tipListKitchen}">
           		<c:choose>
					<c:when test="${not empty nick}">
		           		<a href="../interior/interiorTipPage?tip_no=${dto.tip_no}">
					</c:when>
					<c:otherwise>
						<a href="../user/login">
					</c:otherwise>
				</c:choose>
	   	      	<div class="tipcon_box">
	              	<div id="tipcon_img">
	                  <img src="${imgPath}${dto.tip_file}" />
		            </div>
	                <c:choose>
	                	<c:when test="${not empty nick}">
	                		<c:choose>
					           	<c:when test="${fn:contains(dto.tip_bmuser, nick)}">
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
	                <p>${dto.tip_title}</p>
	                <p>
	                  조회수 <span class="font_green">${dto.tip_count}</span> 
	                  · 스크랩 <span class="font_green">${dto.tip_bookmark}</span>
	                </p>
              	</div>
           	    </a>
			</c:forEach> 
		</div>
<!--수납 TIP-->
	      <div class="tip_content">
	        <div class="tip_title">
	          <input type="button" value="더보기" class="more" 
	          		onclick="location.href='../interior/interiorTipList?category=storage'" />
	          <p>차곡차곡 수납 TIP</p>
	          <p>수납 인테리어 꿀팁</p>
	        </div>
			<c:forEach var="dto" items="${tipListStorage}">
           		<c:choose>
					<c:when test="${not empty nick}">
		           		<a href="../interior/interiorTipPage?tip_no=${dto.tip_no}">
					</c:when>
					<c:otherwise>
						<a href="../user/login">
					</c:otherwise>
				</c:choose>
	   	      	<div class="tipcon_box">
	              	<div id="tipcon_img">
	                  <img src="${imgPath}${dto.tip_file}" />
		            </div>
	                <c:choose>
	                	<c:when test="${not empty nick}">
	                		<c:choose>
					           	<c:when test="${fn:contains(dto.tip_bmuser, nick)}">
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
	                <p>${dto.tip_title}</p>
	                <p>
	                  조회수 <span class="font_green">${dto.tip_count}</span> 
	                  · 스크랩 <span class="font_green">${dto.tip_bookmark}</span>
	                </p>
              	</div>
           	    </a>
			</c:forEach>
		</div>
<!--청소 TIP-->
	      <div class="tip_content">
	        <div class="tip_title">
	          <input type="button" value="더보기" class="more"
	          		onclick="location.href='../interior/interiorTipList?category=cleaning'"/>
	          <p>꼼꼼한 청소 TIP</p>
	          <p>청소 꿀팁</p>
	        </div>
			<c:forEach var="dto" items="${tipListCleaning}">
           		<c:choose>
					<c:when test="${not empty nick}">
		           		<a href="../interior/interiorTipPage?tip_no=${dto.tip_no}">
					</c:when>
					<c:otherwise>
						<a href="../user/login">
					</c:otherwise>
				</c:choose>
	   	      	<div class="tipcon_box">
	              	<div id="tipcon_img">
	                  <img src="${imgPath}${dto.tip_file}" />
		            </div>
	                <c:choose>
	                	<c:when test="${not empty nick}">
	                		<c:choose>
					           	<c:when test="${fn:contains(dto.tip_bmuser, nick)}">
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
	                <p>${dto.tip_title}</p>
	                <p>
	                  조회수 <span class="font_green">${dto.tip_count}</span> 
	                  · 스크랩 <span class="font_green">${dto.tip_bookmark}</span>
	                </p>
              	</div>
           	    </a>
			</c:forEach>
		</div>
<!--리폼 TIP-->
	      <div class="tip_content">
	        <div class="tip_title">
	          <input type="button" value="더보기" class="more"
	            	onclick="location.href='../interior/interiorTipList?category=reform'"/>
	          <p>새 것 같은 리폼 TIP</p>
	          <p>인테리어 리폼 꿀팁</p>
	        </div>
			<c:forEach var="dto" items="${tipListReform}">
           		<c:choose>
					<c:when test="${not empty nick}">
		           		<a href="../interior/interiorTipPage?tip_no=${dto.tip_no}">
					</c:when>
					<c:otherwise>
						<a href="../user/login">
					</c:otherwise>
				</c:choose>
	   	      	<div class="tipcon_box">
	              	<div id="tipcon_img">
	                  <img src="${imgPath}${dto.tip_file}" />
		            </div>
	                <c:choose>
	                	<c:when test="${not empty nick}">
	                		<c:choose>
					           	<c:when test="${fn:contains(dto.tip_bmuser, nick)}">
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
	                <p>${dto.tip_title}</p>
	                <p>
	                  조회수 <span class="font_green">${dto.tip_count}</span> 
	                  · 스크랩 <span class="font_green">${dto.tip_bookmark}</span>
	                </p>
              	</div>
           	    </a>
			</c:forEach>
		</div>
<!--전기/조명 TIP-->
	      <div class="tip_content">
	        <div class="tip_title">
	          <input type="button" value="더보기" class="more"
	            	onclick="location.href='../interior/interiorTipList?category=lighting'" />
	          <p>전기 및 조명 TIP</p>
	          <p>전기/조명 인테리어 꿀팁</p>
	        </div>
			<c:forEach var="dto" items="${tipListLighting}">
           		<c:choose>
					<c:when test="${not empty nick}">
		           		<a href="../interior/interiorTipPage?tip_no=${dto.tip_no}">
					</c:when>
					<c:otherwise>
						<a href="../user/login">
					</c:otherwise>
				</c:choose>
	   	      	<div class="tipcon_box">
	              	<div id="tipcon_img">
	                  <img src="${imgPath}${dto.tip_file}" />
		            </div>
	                <c:choose>
	                	<c:when test="${not empty nick}">
	                		<c:choose>
					           	<c:when test="${fn:contains(dto.tip_bmuser, nick)}">
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
	                <p>${dto.tip_title}</p>
	                <p>
	                  조회수 <span class="font_green">${dto.tip_count}</span> 
	                  · 스크랩 <span class="font_green">${dto.tip_bookmark}</span>
	                </p>
              	</div>
           	    </a>
			</c:forEach>
		</div>
		<input type="hidden" id="tip_no" value="${dto.tip_no}">
	</div>
<jsp:include page="../headerfooter/footer.jsp" />
</body>
</html>