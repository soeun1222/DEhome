<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DE:home</title>
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link
	href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&display=swap"
	rel="stylesheet" />
<link rel="shortcut icon" type="image⁄x-icon" href="${path}/resources/images/x-icon.png" />
<link rel="stylesheet" href="${path }/resources/css/login.css" />
<link rel="stylesheet" href="${path }/resources/css/reset.css" />
<link rel="stylesheet" href="${path }/resources/css/introduce.css" />
</head>
<body>
	<%@include file="../headerfooter/header.jsp"%>
	<div id="introduce">
		<div id="title">
			<h1>누구나 예쁜 집에 살 수 있도록</h1>
		</div>
		<div id="sub_title">
			<h2>
				우리는 인테리어 플랫폼 [De:home]을 통해 집을 꾸미는 방식을 새롭게 정의합니다.
				<br>
				이를 통해 누구나쉽고 재미있게 자신의 공간을 만들어가는 문화가 널리 퍼지기를 꿈꿉니다.
			</h2>
			<img src="${path }/resources/images/room_05.jpg" alt="room" >
		</div><br><br>
		
		<div id="title">
			<h1>탐색, 발견, 구매까지.</h1>
		</div>
		<div id="sub_title">
			<h2>
				인테리어의 모든 과정을<br>
				한 곳에서 경험할 수 있도록 돕습니다.
			</h2>
			<img src="${path }/resources/images/desk.png" alt="desk" >
		</div><br><br>
		
		<div id="table">
			<table>
				<tr>
					<td class="table_content">
						<img src="${path }/resources/images/tile.jpg" alt="tile" ><br>
						다양한 인테리어 사례가 가득한 콘텐츠<br>
						온라인 집들이와 인테리어 노하우 등 다양한 인테리어 콘텐츠들을
						제공하여 누구나 예쁜 집을 꾸밀 수 있도록 돕습니다.
					</td>
					<td>
					</td>
				</tr>
				<tr>					
					<td>
					</td>
					<td class="table_content">
						<img src="${path }/resources/images/wall.jpg" alt="wall" >
						제품 탐색부터 구매까지가능한 스토어<br>
						콘텐츠 속 제품 정보가 궁금하다면 태그를 클릭하여 제품의 상세 정보를 확인하고,
						구매까지 한 번에 이루어질 수 있도록 편리한 구매 경험을 제공합니다.
						
					</td>
				</tr>
				<tr>
					<td class="table_content">
						<img src="${path }/resources/images/kitchen.jpg" alt="kitchen" >
						<p>더욱 편리해진 리모델링,인테리어 시공</p>
						견적부터 전문가 상담까지 De:home에서 원스톱으로 해결해보세요.
						De:home과 제휴한 인증된 전문가 4천여 명의
						포트폴리오를 확인하고 상담 신청까지 손쉽게 할 수 있습니다.
					</td>
					<td>
					</td>
				</tr>
			</table>
		</div>
		<div id="title">
			<h1>De:home은</h1>
		</div>
		<div id="sub_title">
			
			<p class="sub_title_content">	
				오프라인 중심의 시공 산업을 온라인으로 확장해 고객과 전문가가 서로 신뢰할 수 있는 시장 구조를 만드는 데 앞장서고 있습니다.<br>
				까다로운 인증 절차를 통해 검증된 전문가와 다양한 시공을 원하는 유저가 다이렉트로 만날 수 있는 온라인 서비스를 제공합니다.<br>
				인테리어의 모든 고민을 한 곳에서 해결할 수 있는 서비스. 그것이 [De:home]이 꿈꾸는 원스톱 인테리어 플랫폼의 가치입니다.<br>
			</p>
		</div><br><br>
			<img src="${path }/resources/images/room_01.jpg" alt="room" width ="1000px">
		
		<div id="title">
			<h1>찾아오시는길</h1>
			<iframe  id = map src="https://map.naver.com/v5/search/%EA%B7%B8%EB%A6%B0%EC%BB%B4%ED%93%A8%ED%84%B0%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/place/11578164?c=14366934.9928180,4184824.6516653,17,0,0,0,dh&placePath=%3Fentry%253Dbmp"/>
		</div>
	</div>
<%@include file="../headerfooter/footer.jsp" %>
</body>
</html>