<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<c:set var="nick" value="${nickname}"></c:set>
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
<link rel="stylesheet" href="${path }/resources/css/header_footer.css" />
<link rel="stylesheet" href="${path }/resources/css/my_page.css" />
<link rel="stylesheet" href="${path }/resources/css/sign_up.css" />
<link rel="stylesheet" href="${path }/resources/css/reset.css" />
<link rel="stylesheet" href="${path }/resources/css/qna_board.css" />
</head>
<body>
	<%@include file="../headerfooter/header.jsp"%>
	<!-- --------------------- 컨텐츠 시작 ---------------------- -->
	<center>
		<content>
		<div id="show">
			<div class="show_head">
				<p>공지사항</p>
			</div>
			<div>
				<table>
					<tr>
						<td>
							<p>${show.not_title}</p>
							<p>
								조회수 <span>${show.not_count}</span>
							</p>
							<p>
								<fmt:formatDate value="${show.not_date}"
									pattern="yyyy-MM-dd HH:mm" />
							</p>
						</td>
					</tr>
					<tr>
						<td>${show.not_content}</td>
					</tr>
					<tr>
						<td class="">
							<c:choose>
								<c:when test="${nick eq 'admin1'}">
									<input type="button" value="목록으로"
										onclick="location.href='../customer/not_list'">
									<input type="button" value="수정하기"
										onclick="location.href='../customer/not_modifyView?not_no=${show.not_no}'">
									<input type="button" value="삭제하기"
										onclick="location.href='../customer/not_delete?not_no=${show.not_no}'">
								</c:when>
								<c:when test="${nick eq 'admin2'}">
									<input type="button" value="목록으로"
										onclick="location.href='../customer/not_list'">
									<input type="button" value="수정하기"
										onclick="location.href='../customer/not_modifyView?not_no=${show.not_no}'">
									<input type="button" value="삭제하기"
										onclick="location.href='../customer/not_delete?not_no=${show.not_no}'">
								</c:when>
								<c:when test="${nick eq 'admin3'}">
									<input type="button" value="목록으로"
										onclick="location.href='../customer/not_list'">
									<input type="button" value="수정하기"
										onclick="location.href='../customer/not_modifyView?not_no=${show.not_no}'">
									<input type="button" value="삭제하기"
										onclick="location.href='../customer/not_delete?not_no=${show.not_no}'">
								</c:when>
								<c:otherwise>
									<input type="button" value="목록으로"
										onclick="location.href='../customer/not_list'">
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</table>
			</div>
		</div>
		</content>
	</center>
	<%@include file="../headerfooter/footer.jsp"%>
</body>
</html>