<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<% response.setContentType("text/html"); %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="imgPath" value="https://www.mydehome.com//whose/resources"/>
<c:set var="addr" value="${addr }"></c:set>
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
    <link rel="stylesheet" href="${path}/resources/css/interior.css" />
    
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>	
<script type="text/javascript" src="${path }/resources/js/interior.js" charset="utf-8"></script>
</head>
<body>
	<%@include file ="../headerfooter/header.jsp" %>
	<div id="interior_company">
      <div id="company_title">
      
      <c:choose>
      	<c:when test="${nickname eq 'admin1' or nickname eq 'admin2' or nickname eq 'admin3'}">
      		<input type="button" value="업체등록" onclick="location.href='register_com'" />
      	</c:when>
      	<c:when test="${nickname eq null or nickname eq '' }">
      		<input type="button" value="대화목록" onclick="login_no()" >
      	</c:when>
      	<c:otherwise>
      		<input type="button" value="대화목록" onclick="location.href='../chat/coun_chattingList'" /> 
      	</c:otherwise>
      </c:choose>
      
        <p><span class="font_green">시공상담</span> 나에게 딱 맞는 업체 찾기</p>
        <p>
          원하는 업체와 쉽고 빠르게 컨텍하여 시공을 상담받아볼 수 있는
          DE:home만의 서비스입니다
        </p>
      </div>
      
      <div id="company_location_search">
        <span style="font-size:15px;" class="font_bolder">${addr}</span>
        <span>위치 설정을 원하시면 우측의 주소변경을 클릭해주세요</span>
        <input type="button" value="주소변경" onclick="location_popup()" />
        <input type="hidden" value="${param.popup_addr1}" id="popup_addr1">
        <input type="hidden" value="${param.popup_addr2}" id="popup_addr2">
        <input type="hidden" value="${imgPath}" id="path">
        <!-- 임시 사진 경로용 -->
        <input type="hidden" value="${path}/resources" id="imgPath">
      </div>
      
      <div id="company_total_box">
      	<c:forEach items="${locList }" var="locList">
      		<div class="company_box">
            	<a href="company_page?name=${locList.com_name}">
              	<div id="shop">
                	<div class="shop_img">
                  		<img src="${imgPath}${locList.com_file}" /> <!-- 사진경로 들어가야한다 -->
                	</div>
	                <div class="shop_ex">
	                  <div class="star">
	                    <img src="${path}/resources/images/star_green.png" />
	                    <span>${locList.com_rating}</span>
	                  </div>
	                  <div class="shop_name">${locList.com_name}</div>
	                  <p>${locList.com_addr}</p>
	                  <p>
	                    <span>
	                    	업체 리뷰
	                    	<span class="shop_count font_green font_bolder">${locList.re_count}건</span>
	                    </span>
	                    <span>
							최근 계약
							<span class="shop_count font_green font_bolder">${locList.com_contract}건</span>
	                    </span>
	                  </p>
	                </div>
              	</div>
            	</a>
        	</div>
	      </c:forEach>
      </div>
      <div id="move_btn">
        <button type="button" id="more">더보기</button>
      </div>
    </div>
    
    <script type="text/javascript" src="${path }/resources/js/moreBtn.js" charset="utf-8"></script>
	
<%@include file ="../headerfooter/footer.jsp" %>
</body>
</html>