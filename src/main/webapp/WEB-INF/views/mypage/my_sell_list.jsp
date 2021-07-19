<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="imgPath" value="https://www.mydehome.com//whose/resources"/>
<c:set var="nick" value="${nick}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>DE:home</title>
<meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&display=swap"
      rel="stylesheet"
    />
    <link rel="shortcut icon" type="image⁄x-icon" href="${path }/resources/images/x-icon.png" />
    <link rel="stylesheet" href="${path }/resources/css/reset.css" />
    <link rel="stylesheet" href="${path }/resources/css/my_page_tr.css">
</head>
<body>
<%@include file ="../headerfooter/header.jsp" %>
 	<div class="contents_mypage">
        <a href="mypage"><h2 class="page_title">MY PAGE</h2></a>
        <div class="mypage_header_box">
          <p class="my_page_label">${nick}님 안녕하세요</p>
        </div>
          <div class="mypage_sidebar_box">
            <ul class="mypage_ul1">
              <li class="mypage_side_label">회원정보</li>
              <li class="mypage_side_list" ><a href="edit_account">개인정보 수정</a></li>
              <li class="mypage_side_list"><a href="delete_account">회원탈퇴</a></li>
            </ul>
            <ul class="mypage_ul2">
              <li class="mypage_side_label">활동 및 문의</li>
              <li class="mypage_side_list" style="color: #1B7850"><a href="#">나의 거래 ></a>
                 <ul class="mypage_side_list_2">
                    <li style="color: #1B7850"><a href="../mypage/my_sell_list">나의 판매 물품 </a></li>
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
              <li class="mypage_side_list"><a href="../mypage/my_bookmark">북마크</a></li>
            </ul>
          </div>
          <!-- 콘텐트 시작 -->
          <div class="mypage_content_box">
	          <p class="mypage_label">나의 판매 물품</p>
	          <c:forEach var="mySellList" items="${mySellList}">
	         	 <div class="mypage_content_list_main" 
	          		   onclick="location.href='../trade/tradeShow?tr_no=${mySellList.tr_no}&ch=0&heart=none'">
	          		<div>
						<img class="my_sell_image" src="${imgPath}${mySellList.tr_photo}"/>
	          		</div>
					<div class="my_sell_text">
						<p class="my_sell_title">${mySellList.tr_title}</p>
						<p class="my_sell_addr">${mySellList.user_addr2}</p>
						<c:choose>
	                         <c:when test="${mySellList.like != 0}">
	                         <div class="my_ut_price_heart">
		                       <c:choose>
		                         <c:when test="${mySellList.tr_price eq '0' }">
										<p class="my_sell_price">무료나눔</p>	
								 </c:when>	
								 <c:otherwise>					
										<p class="my_sell_price">${mySellList.tr_price} 원</p>		
								 </c:otherwise>		
								</c:choose> 				
								<div class="my_ut_heart_img_div">
									<img src="${path }/resources/images/heart.png" class="my_ut_heart" /> 
									<span class="my_ut_heart_cnt">${mySellList.like}</span>
								</div>
							</div>
								<c:choose>
									<c:when test="${mySellList.tr_complete == 1 }">
										<div class="my_sell_complete">
											<span>거래완료</span>
										</div>
									</c:when>
								</c:choose>
							</c:when>
							<c:otherwise>
	                            <div class="my_ut_price_heart">
								<c:choose>
									<c:when test="${mySellList.tr_price eq '0'}">
										<p class="my_sell_price">무료나눔</p>			
									</c:when>
									<c:otherwise>					
										<p class="my_sell_price">${mySellList.tr_price} 원</p>		
								 	</c:otherwise>
								 </c:choose>
								 </div>
								 	<c:choose>
									<c:when test="${mySellList.tr_complete == 1 }">
										<div class="my_sell_complete">
											<span>거래완료</span>
										</div>
									</c:when>
								</c:choose>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
<%@include file ="../headerfooter/footer.jsp" %>
</body>
</html>