<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="imgPath" value="https://www.mydehome.com//whose/resources"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DE:home</title>
<%@include file="../headerfooter/header.jsp" %>
<script type="text/javascript" src="${path }/resources/js/mypage.js" charset="utf-8"></script>
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link rel="shortcut icon" type="image⁄x-icon" href="${path}/resources/images/x-icon.png" />
    <link
      href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&display=swap"
      rel="stylesheet"/>
    <link rel="stylesheet" href="${path }/resources/css/my_page.css" />
    <link rel="stylesheet" href="${path }/resources/css/reset.css" />
</head>
<body>


    <content>
      <div class="contents_mypage">
        <a href="mypage"><h2 class="page_title">MY PAGE</h2></a>
        <div class="mypage_header_box">
          <p class="my_page_label">${nickname }님 안녕하세요</p>
        </div>
       
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
              <li class="mypage_side_list_1" >
              <a href="my_trade_board">내가 작성한 글</a>
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
         
<div id="mypage_main">
<!-------  최근 거래  -------->
        <div class="mypage_content_box">
          <p class="mypage_label">진행중인 거래</p>
	          <c:forEach var="tr_list" items="${tr_list}" end="3" varStatus="status">
	          <div class="mypage_content_list_main" onclick="location.href='../trade/tradeShow?tr_no=${tr_list.trade_no}&ch=0&heart=none'">
          		<div>
			 	<img class="my_sell_image" src="${imgPath}${tr_list.trade_photo}"/>
          		</div>
				<div class="my_sell_text">
					<p class="my_sell_title">${tr_list.trade_title}</p>
					<p class="my_sell_addr">${tr_list.user_addr2}</p>
					
					<c:choose>
                         <c:when test="${tr_list.trade_interest != 0}">
                         <div class="my_ut_price_heart">
	                       <c:choose>
	                         <c:when test="${tr_list.trade_price  eq '0'}">
									<p class="my_sell_price">무료나눔</p>	
							 </c:when>	
							 <c:otherwise>					
									<p class="my_sell_price">${tr_list.trade_price} 원</p>		
							 </c:otherwise>		
							</c:choose> 				
							<div class="my_ut_heart_img_div">
								<img src="${path }/resources/images/heart.png" class="my_ut_heart" /> 
								<span class="my_ut_heart_cnt">${tr_list.trade_interest}</span>
							</div>
						</div>
							<c:choose>
								<c:when test="${tr_list.trade_complete == 1 }">
									<div class="my_sell_complete">
										<span>거래완료</span>
									</div>
								</c:when>
							</c:choose>
						</c:when>
						<c:otherwise>
                            <div class="my_ut_price_heart">
							<c:choose>
								<c:when test="${tr_list.trade_price eq '0'}">
									<p class="my_sell_price">무료나눔</p>			
								</c:when>
								<c:otherwise>					
									<p class="my_sell_price">${tr_list.trade_price} 원</p>		
							 	</c:otherwise>
							 </c:choose>
							 </div>
							 	<c:choose>
								<c:when test="${tr_list.trade_complete == 1 }">
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

<!--     판매 내역     -->

        <div class="mypage_content_box">
          <p class="mypage_label">판매 내역</p>
          <c:forEach var="tr_sell_list" items="${tr_sell_list}" end="3" varStatus="status">
          <div class="mypage_content_list_main" 
          	   onclick="location.href='../trade/tradeShow?tr_no=${tr_sell_list.trade_no}&ch=0&heart=none'">
          		<div>
			<img class="my_sell_image" src="${imgPath}${tr_sell_list.trade_photo}"/>
          		</div>
				<div class="my_sell_text">
					<p class="my_sell_title">${tr_sell_list.trade_title}</p>
					<p class="my_sell_addr">${tr_sell_list.user_addr2}</p>
					
					<c:choose>
                         <c:when test="${tr_sell_list.trade_interest != 0}">
                         <div class="my_ut_price_heart">
	                       <c:choose>
	                         <c:when test="${tr_sell_list.trade_price eq '0' }">
									<p class="my_sell_price">무료나눔</p>	
							 </c:when>	
							 <c:otherwise>					
									<p class="my_sell_price">${tr_sell_list.trade_price} 원</p>		
							 </c:otherwise>		
							</c:choose> 				
							<div class="my_ut_heart_img_div">
								<img src="${path }/resources/images/heart.png" class="my_ut_heart" /> 
								<span class="my_ut_heart_cnt">${tr_sell_list.trade_interest}</span>
							</div>
						</div>
							<c:choose>
								<c:when test="${tr_sell_list.trade_complete == 1 }">
									<div class="my_sell_complete">
										<span>거래완료</span>
									</div>
								</c:when>
							</c:choose>
						</c:when>
						<c:otherwise>
                            <div class="my_ut_price_heart">
							<c:choose>
								<c:when test="${tr_sell_list.trade_price eq '0'}">
									<p class="my_sell_price">무료나눔</p>			
								</c:when>
								<c:otherwise>					
									<p class="my_sell_price">${tr_sell_list.trade_price} 원</p>		
							 	</c:otherwise>
							 </c:choose>
							 </div>
							 	<c:choose>
								<c:when test="${tr_sell_list.trade_complete == 1 }">
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
				<c:if test="${fn:length(tr_sell_list) >4}">
					<div>
						<button class="moreTrade" onclick="location.href='../mypage/my_sell_list'">
							더<br>보<br>기</button>
					</div>
				</c:if>
				
			</div>
<!--   구매 내역  --> 
        <div class="mypage_content_box">
          <p class="mypage_label">구매한 상품</p>
          <c:forEach var="tr_buy_list" items="${tr_buy_list}" end="3" varStatus="status">
          <div class="mypage_content_list_main" 
          	   onclick="location.href='../trade/tradeShow?tr_no=${tr_buy_list.trade_no}&ch=0&heart=none'">
          		<div>
					<img class="my_sell_image" src="${path}${tr_buy_list.trade_photo}"/> 
          		</div>
				<div class="my_sell_text">
					<p class="my_sell_title">${tr_buy_list.trade_title}</p>
					<p class="my_sell_addr">${tr_buy_list.user_addr2}</p>
					
					<c:choose>
                         <c:when test="${tr_buy_list.trade_interest != 0}">
                         <div class="my_ut_price_heart">
	                       <c:choose>
	                         <c:when test="${tr_buy_list.trade_price eq '0' }">
									<p class="my_sell_price">무료나눔</p>	
							 </c:when>	
							 <c:otherwise>					
									<p class="my_sell_price">${tr_buy_list.trade_price} 원</p>		
							 </c:otherwise>		
							</c:choose> 				
							<div class="my_ut_heart_img_div">
								<img src="${path }/resources/images/heart.png" class="my_ut_heart" /> 
								<span class="my_ut_heart_cnt">${tr_buy_list.trade_interest}</span>
							</div>
						</div>
							<c:choose>
								<c:when test="${tr_buy_list.trade_complete == 1 }">
									<div class="my_sell_complete">
										<span>거래완료</span>
									</div>
								</c:when>
							</c:choose>
						</c:when>
						<c:otherwise>
                            <div class="my_ut_price_heart">
							<c:choose>
								<c:when test="${tr_buy_list.trade_price eq '0'}">
									<p class="my_sell_price">무료나눔</p>			
								</c:when>
								<c:otherwise>					
									<p class="my_sell_price">${tr_buy_list.trade_price} 원</p>		
							 	</c:otherwise>
							 </c:choose>
							 </div>
							 	<c:choose>
								<c:when test="${tr_buy_list.trade_complete == 1 }">
									<div class="my_sell_complete">
										<span>거래완료</span>
									</div>
								</c:when>
							</c:choose>
						</c:otherwise>
					</c:choose>
					</div>
					</div>
				</c:forEach>	<c:if test="${fn:length(tr_buy_list) >4}">
					<div>
						<button class="moreTrade" onclick="location.href='../mypage/my_buy_list'">
							더<br>보<br>기</button>
					</div>
				</c:if>
			</div>
 
</div>
</div>
    </content>
<%@include file="../headerfooter/footer.jsp" %>
</body>
</html>