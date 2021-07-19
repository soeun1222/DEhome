<%@page import="com.green.dehome.dto.TradeDTO"%>
<%@page import="com.green.dehome.service.TradeServiceImpl"%>
<%@page import="com.green.dehome.service.TradeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="imgPath" value="https://www.mydehome.com//whose/resources"/>
<c:set var="title" value="${title}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DE:home</title>
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link rel="shortcut icon" type="image⁄x-icon" href="${path}/resources/images/x-icon.png" />
<link
	href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&display=swap"
	rel="stylesheet" />
<link rel="stylesheet" href="${path }/resources/css/reset.css" />
<link rel="stylesheet" href="${path }/resources/css/usedTrade.css" />
<script type="text/javascript" src="${path }/resources/js/trade.js" charset="utf-8"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<%@include file="../headerfooter/header.jsp"%>
	<main>
		<div class="mainForm">
			<form action="../trade/used_trade.search" method="post" name="search_form">
				<div class="usedTrade_addressForm">
					<div class="input_form">
						<input type="text" placeholder="동네 이름을 검색해 보세요!" maxlength="40" name="search_area" />
						<button type="button" class="goods_search_btn" onclick="search_check()">
						<img src="https://d1unjqcospf8gs.cloudfront.net/assets/home/base/header/search-icon-7008edd4f9aaa32188f55e65258f1c1905d7a9d1a3ca2a07ae809b5535380f14.svg" />
						</button>
						<a href="../chat/chattingList" class="chat_index">대화목록</a> 
						<a href="../trade/registerGoods" class="sell_btn">내 상품팔기</a>
					</div>
				</div>
			</form>
			<span class="popularity_used">${title}</span>
			<br><br>
			<div class="used_post_box" id="used_post_box">
				<c:forEach var="list" items="${list}">
					<div class="used_post" onclick="location.href='../trade/tradeShow?tr_no=${list.tr_no}&ch=0&heart=none'">
						<div class="post_image_div">
							<img class="post_image" src="${imgPath}${list.tr_photo}" />
						</div>
						<div class="post_content_div">
							<p class="post_title">${list.tr_title }</p>
							<p class="post_address">${list.user_addr2 }</p>
							<c:choose>
							<c:when test="${list.tr_price eq '0'}">
								<div class="price_heart">
									<p class="post_price">무료나눔</p>
									<c:if test="${list.tr_evalue != 0}">
									<div class="heart_img_div">
										<img src="${path }/resources/images/heart.png" class="heart" /> 
										<span class="heart_cnt">${list.tr_evalue}</span>
									</div>
									</c:if>
								</div>
							</c:when>
							<c:otherwise>
								<div class="price_heart">
									<p class="post_price">${list.tr_price}</p>
									<c:if test="${list.tr_evalue != 0}">
									<div class="heart_img_div">
										<img src="${path }/resources/images/heart.png" class="heart" /> 
										<span class="heart_cnt">${list.tr_evalue}</span>
									</div>
									</c:if>
								</div>
							</c:otherwise>
							</c:choose>
						</div>
					</div>
				</c:forEach>
			</div>
			<c:if test="${title eq '방금 올라온 물건'}">
				<div class="more_btn">
					<button type="button" id="more">더보기(MORE)</button>
				</div>
			</c:if>
			<input type="hidden" id="path" value="${path}">
			<input type="hidden" id="imgPath" value="${imgPath}">
			<script type="text/javascript">
			var more = -1;
			$(function(){$('#more').on('click',function(){
				var path = document.getElementById("path").value;
				var imgPath = document.getElementById("imgPath").value;
				more = more + 1
				console.log(more);
					$.ajax({
						url : "used_trade.more",
						type : "post",
						data: { more : more},	
						dataType: "json",
						success: function(data) {
							var addListHtml = "";
							for(var i in data.list) {
								addListHtml += "<div class='used_post' onclick='location.href=\"../trade/tradeShow?tr_no=" + data.list[i].tr_no + "\"'>";	
								addListHtml += "<div class='post_image_div'>";	
								addListHtml += "<img class='post_image' src='" + imgPath + data.list[i].tr_photo + "'/>";	
								addListHtml += "</div>";	
								addListHtml += "<div class='post_content_div'>";	
								addListHtml += "<p class='post_title'>" + decodeURIComponent(data.list[i].tr_title) + "</p>";	
								addListHtml += "<p class='post_address'>" + decodeURIComponent(data.list[i].user_addr2) + "</p>";	
								if(data.list[i].tr_price == 0) {
									addListHtml += "<div class='price_heart'>";	
									addListHtml += "<p class='post_price'>무료나눔</p>";	
									if(data.list[i].tr_count != 0) {
										addListHtml += "<div class='heart_img_div'>";	
										addListHtml += "<img src='" + path + "/resources/images/heart.png' class='heart' />";	
										addListHtml += "<span class='heart_cnt'>"+ data.list[i].tr_evalue+"</span>";	
										addListHtml += "</div>";	
									}
									addListHtml += "</div>";	
								} else {
									addListHtml += "<div class='price_heart'>";	
									addListHtml += "<p class='post_price'>" + data.list[i].tr_price + "</p>";	
									if(data.list[i].tr_count != 0) {
										addListHtml += "<div class='heart_img_div'>";	
										addListHtml += "<img src='" + path + "/resources/images/heart.png' class='heart' />";	
										addListHtml += "<span class='heart_cnt'>"+ data.list[i].tr_evalue+"</span>";	
										addListHtml += "</div>";	
									}
									addListHtml += "</div>";	
								}
								addListHtml += "</div>";	
								addListHtml += "</div>";	
							}
							if(data.list.length >= 1) {
			                  $("#used_post_box").append($(addListHtml).fadeIn());
			             	} else {
			            	  //$("#move_btn").css('display','none'); -> 한번 더 클릭해야 사라진다
			                  alert("다음페이지가 없습니다.");
			              	}
						},
						error:function (request,status,errorData) {
			              alert('error code: ' + request.status + "\n"
			                      + 'message: ' + request.responseText + "\n"
			                      + 'error: ' + errorData);
			          	}
					})
				})
			});
			</script>
		</div>
	</main>
	<%@include file="../headerfooter/footer.jsp"%>
</body>
</html>
</html>