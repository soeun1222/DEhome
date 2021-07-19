<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% pageContext.setAttribute("replaceChar", "\n"); %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="imgPath" value="https://www.mydehome.com//whose/resources"/>
<c:set value="${dto2}" var="dto" />
<c:set value="${addr}" var="addr" />
<c:set var="time" value="${time}"/>
<c:set var="num" value="${num}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DE:home</title>
	<link rel="preconnect" href="https://fonts.gstatic.com" />
	<link rel="shortcut icon" type="image⁄x-icon" href="${path}/resources/images/x-icon.png" />
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&display=swap" rel="stylesheet"/>
    
	<link rel="stylesheet" href="${path }/resources/css/reset.css" />
	<link rel="stylesheet" href="${path }/resources/css/postDetail.css" />
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" charset="utf-8">
		function like_off() {
			alert("이미 관심 등록을 한 상품입니다.");
		}
	</script>
</head>
<body>

<%@include file="../headerfooter/header.jsp" %>
	<main>
		<div class="detail_container">
			<div class="img_div">
				<img src="${imgPath}${dto.tr_photo}" class="detail_img" />
			</div>
			<div class="content_div">
				<div class="content_div_wirter_div">
					<div>
						<p class="nick">${dto.tr_user_nick}</p>
						<p class="address">${addr}</p>
					</div>
					<!--(ajax로 비동기 구현) 관심 누르기 전 ->beforeheart.png/ 누른 후 -> afterheart.png -->
					<div class="heart_btn">
						<c:choose>
							<c:when test="${num >= 1}">
								<img onclick="like_off()" src="${path}/resources/images/afterheart.png" alt="관심버튼on" />
							</c:when>
							<c:otherwise>
								<img onclick="location.href='../trade/tradeShow?tr_no=${dto.tr_no}&ch=0&heart=on'" src="${path}/resources/images/beforeheart.png" alt="관심버튼off" />	
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="content_div_content_div">
					<p class="content_div_title">${dto.tr_title }</p>
					<p class="content_div_category">${dto.tr_category}·${time}</p>
					<p class="content_div_price">${dto.tr_price}</p>
					<p class="content_div_content">${fn:replace(dto.tr_content, replaceChar, "<br>") }</p>
					<p class="content_div_like">관심${dto.tr_evalue}·조회${dto.tr_count}</p>
					<div class="btn_div">
					<c:choose>
						<c:when test="${nickname eq dto.tr_user_nick}">
							<c:choose>
								<c:when test="${dto.tr_complete eq 0 }">
						       		<input type="button" value="글 수정하기" onclick="location.href='../trade/registerEdit?tr_no=${dto.tr_no}'"/>
						       		<input type="button" value="글 삭제하기" onclick="deleteCheck()"/>
						       		<script type="text/javascript">
										function deleteCheck() {
											if (!confirm("게시글을 삭제하시겠습니까?")) {
											} else {
												location.href='../trade/registerDelete?tr_no=${dto.tr_no}';
											}
										}
									</script>
								</c:when>
								<c:otherwise>
									<input type="button" value="판매 완료 상품" disabled="disabled" style="background-color: #ccc; color: #333" />		
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
				       		<input type="button" value="채팅으로 거래하기" onclick="location.href='../chat/tr_chatting?tr_no=${dto.tr_no}&to_nick=${dto.tr_user_nick}'" />
						</c:otherwise>
					</c:choose>
					</div>
				</div>
			</div>
		</div>
	</main>
	<jsp:include page="../headerfooter/footer.jsp"/>
</body>
</html>