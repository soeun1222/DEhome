<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% pageContext.setAttribute("replaceChar", "\n"); %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="imgPath" value="https://www.mydehome.com//whose/resources"/>
<c:set var="com_name" value="${param.name }"></c:set>
<c:set var="user_com_name" value="${user_com_name }"></c:set>
<c:set var="comInfo" value="${comInfo }"></c:set>
<c:set var="fullStar" value="${fullStar }"></c:set>
<c:set var="emptyStar" value="${emptyStar }"></c:set>
<c:set var="reList" value="${reList }"></c:set>
<c:set var="exList" value="${exList }"></c:set>
<c:set var="realReCount" value="${realReCount }"></c:set>
<c:set var="realExCount" value="${realExCount }"></c:set>
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
<script type="text/javascript" src="${path }/resources/js/review.js" charset="utf-8"></script>
</head>
<body>
	<%@include file ="../headerfooter/header.jsp" %>

	<div id="company_page">
      <img src="${imgPath}${comInfo.com_file }" />
      <div class="company_top_box"></div>
      <div class="company_top">
        <p>${com_name }</p>
        <div class="company_star">
        <c:forEach begin="1" end="${fullStar }" step="1">
        	<img src="${path}/resources/images/star_green.png" />
        </c:forEach>
        <c:forEach begin="1" end="${emptyStar }" step="1">
        	<img src="${path}/resources/images/star_yellow.png" />
        </c:forEach>
          <span>${comInfo.com_rating }</span>
        </div>
        <p>${comInfo.com_title }</p>
        <p>${fn:replace(comInfo.com_content, replaceChar, "<br>") }</p>
        <p>
          <span>
            업체 리뷰 <span class="font_green font_bolder">${comInfo.re_count }건</span>
          </span>
          <span>
            최근 계약 <span class="font_green font_bolder">${comInfo.com_contract }건</span>
          </span>
        </p>
        <div class="company_btn">
        <c:choose>
      	<c:when test="${nickname eq null or nickname eq '' }"> <!-- 비로그인 -->
      		<input type="button" value="상담신청" onclick="login_no()" />
          	<input type="button" value="리뷰작성" onclick="login_no()" />
      	</c:when>
      	<c:otherwise> <!-- 로그인(해당 업체 로그인/매니저 로그인/일반 사용자 로그인) -->
      		<c:choose>
      			<c:when test="${user_com_name eq com_name}"> <!-- 해당 업체 로그인 -->
      				<input type="button" value="시공사례 작성" class="oneBtn" onclick="location.href='cons_case_write?com_name=${com_name}'" />
      			</c:when>
      			<c:when test="${nickname eq 'admin1' or nickname eq 'admin2' or nickname eq 'admin3'}"> <!-- 매니저 로그인 -->
      				<input type="button" value="업체정보 수정" class="oneBtn" onclick="location.href='edit_com?com_name=${com_name}'" />
      			</c:when>
      			<c:otherwise> <!-- 일반 사용자 로그인 -->
      				<input type="button" value="상담신청" onclick="location.href='../chat/coun_chatting?com_name=${com_name}&to_nick=${com_name}'" />
					<input type="button" value="리뷰작성" onclick="location.href='review_write?com_name=${com_name}'" />
      			</c:otherwise> 
      		</c:choose> 
      	</c:otherwise>
      </c:choose>   
        </div>
      </div>
    </div>
    
	<div id="company_title">
      <p>
        <span class="font_green">시공리뷰</span> 리뷰로 찾는 나만의 시공업체
      </p>
      <p>
        DE:home은 보다 객관적인 시공업체 판단을 위해 고객의 모든 리뷰를 투명하게
        공유합니다
      </p>
    </div>
    <div id="review_content">
		<c:forEach items="${reList }" var="reList">
			<a href="review_show?re_no=${reList.re_no }">
				<div class="recon_01">
		          <p class="like">
		          	<input type="button" value="${reList.re_interest }번 도움됨" >
		            <span>${reList.user_nick }</span>
		          </p>
		          <p>${fn:replace(reList.re_content, replaceChar, "<br>") }</p>
		          <img src="${imgPath}${reList.re_file }" />
		        </div>
	      	</a>
		</c:forEach>
		<div id="review_content_more"></div>
    </div>
    <input type="hidden" value="${com_name}" id="com_name">
    <input type="hidden" value="${realReCount }" id="com_re_count">
    <input type="hidden" value="${realExCount }" id="com_contract">
    <input type="hidden" value="${imgPath }" id="path">
	<div id="move_btn2">
  		<button type="button" id="moreReList" style="display: block;">더보기</button>
  		<button type="button" id="removeReList" style="display: none;">접기</button>
	</div>

	<div id="company_title">
      <p>
      	<span class="font_green">시공사례</span> 해당 시공업체의 대표작업들
      </p>
      <p>
        해당 시공업체의 대표적인 작업들을 확인하고 상담신청으로 시공업체와
        컨텍까지 가능합니다
      </p>
    </div>
    <div id="company_work">
	    	<c:forEach items="${exList }" var="exList">
				<a href="../interior/cons_case?ex_no=${exList.ex_no }">
				  <div>
				    <img src="${imgPath}/${exList.ex_file }" />
				  </div>
				  <p>${exList.ex_title }</p>
				</a>
			</c:forEach>
		<div id="cons_content_more"></div>
    </div>
    <div id="move_btn2">
  		<button type="button" id="moreExList" style="display: block;">더보기</button>
  		<button type="button" id="removeExList" style="display: none;">접기</button>
	</div>
	
    
    <script type="text/javascript" src="${path }/resources/js/moreBtn.js" charset="utf-8"></script>
	
<%@include file ="../headerfooter/footer.jsp" %>
</body>
</html>