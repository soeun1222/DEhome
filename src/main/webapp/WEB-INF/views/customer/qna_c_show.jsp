<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
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
	<div id="show" align="center">
		<div class="show_head">
			<p>QnA답글</p>
		</div>
		<div>
			<table>
				<tr>
					<td>
						<p>${c_show.user_nick2}</p>
						<p>
							<fmt:formatDate value="${c_show.qna_c_date}"
								pattern="yyyy-MM-dd HH:mm" />
						</p>
					</td>
				</tr>
				<tr>
					<td>${c_show.qna_c_content}</td>
				</tr>
				<tr>
					<td class="">
						<c:choose>
							<c:when
								test="${(nickname eq 'admin1' || nickname eq 'admin2' || nickname eq 'admin3')}">
								<c:choose>
									<c:when test="${c_show.qna_c_content eq null}">
										<input type="button" value="QnA목록으로"
											onclick="location.href='../customer/qna_list'">
									</c:when>
									<c:otherwise>
										<input type="button" value="답글수정하기"
											onclick="location.href='../customer/qna_c_modifyView?qna_no=${qna_no}'">
										<input type="button" value="답글삭제하기"
											onclick="location.href='../customer/qna_c_delete?qna_no=${qna_no}'">
										<input type="button" value="QnA목록으로"
											onclick="location.href='../customer/qna_list'">
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<input type="button" value="QnA목록으로"
									onclick="location.href='../customer/qna_list'">
							</c:otherwise>
						</c:choose>
				</tr>
			</table>
		</div>

	</div>
	<%@include file="../headerfooter/footer.jsp"%>
</body>
</html>