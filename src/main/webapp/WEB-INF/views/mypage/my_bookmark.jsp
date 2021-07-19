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
	<meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&display=swap"
      rel="stylesheet"
    />
    <link rel="shortcut icon" type="image⁄x-icon" href="${path }/resources/images/x-icon.png" />
    <link rel="stylesheet" href="${path }/resources/css/reset.css" />
    <link rel="stylesheet" href="${path }/resources/css/my_page.css">
    <link rel="stylesheet" href="${path }/resources/css/my_interior_tip.css" />
<title>DE:home</title>
</head>
<body>
<%@include file ="../headerfooter/header.jsp" %>
	<div class="contents_mypage"> 
          <h2 class="page_title">MY PAGE</h2>         
          <div class="mypage_header_box">
            <p class="my_page_label">${ nick }님 안녕하세요</p>
          </div>
          <!-- 마이페이지 사이드메뉴 인클루드 예정 -->
          <div class="mypage_sidebar_box">
            <ul class="mypage_ul1">
              <li class="mypage_side_label">회원정보</li>
              <li class="mypage_side_list" ><a href="edit_account">개인정보 수정</a></li>
              <li class="mypage_side_list"><a href="delete_account">회원탈퇴</a></li>
            </ul>
            <ul class="mypage_ul2">
              <li class="mypage_side_label">활동 및 문의</li>
              <li class="mypage_side_list"><a href="#">나의 거래</a>
                 <ul class="mypage_side_list_2">
                    <li><a href="../mypage/my_sell_list">나의 판매 물품</a></li>
                    <li><a href="../mypage/my_buy_list">나의 구매 물품</a></li>
                 </ul>
              </li>
              <li class="mypage_side_list_1"><a href="my_trade_board">내가 작성한 글</a>
                 <ul class="mypage_side_list_2">
                    <li><a href="my_trade_board">자유게시판</a></li>
                    <li><a href="../mypage/my_interior_tip">인테리어 팁</a></li>
                    <li><a href="my_review">시공리뷰</a></li>
                    <li><a href="../mypage/my_qna">QNA</a></li>
                 </ul>
              </li>
              <li class="mypage_side_list"><a href="../chat/chattingList">대화목록</a></li>
              <li class="mypage_side_list" style="color: #1B7850"><a href="../mypage/my_bookmark">북마크 ></a></li>
            </ul>
          </div>
          <!-- 콘텐트 시작  -->
      <div id="my_interior_tip_list">
	      <div class="my_tip_content">
	        <div class="my_tip_title">
	          <p>내가 북마크한 인테리어 TIP</p>
	        </div>
            <c:forEach var="dto" items="${myBmTipList}">
            	<a href="../interior/interiorTipPage?tip_no=${dto.tip_no}">
		          <div class="my_tipcon_box">
	              	<div id="my_tipcon_img">
	                  <img src="${imgPath}${dto.tip_file}" />
		            </div>
		            <c:choose>
					  <c:when test="${fn:contains(dto.tip_bmuser, nick)}">
					     <input type="button" class="bm_on">
					  </c:when>
					  <c:otherwise>
					  	  <input type="button">
					  </c:otherwise>
		            </c:choose>
	                  <p>${dto.tip_title}</p>
	                  <p>
	                    조회수 
	                    <span class="my_font_green">${dto.tip_count}</span> 
	                    · 스크랩 
	                    <span class="my_font_green">${dto.tip_bookmark}</span>
	                  </p>
	              </div>
	            </a>
	        </c:forEach>
		</div>
	</div>
 </div>
<%@include file ="../headerfooter/footer.jsp" %>
</body>
</html>