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
			<p>QnA</p>
		</div>
		<div>
			<table>
				<tr>
					<td>
						<p>${show.qna_title}</p>
						<p>
							조회수 <span>${show.qna_count}</span>
						</p>
						<p>
							<fmt:formatDate value="${show.qna_date}"
								pattern="yyyy-MM-dd HH:mm" />
						</p>
					</td>
				</tr>
				<tr>
					<td>${show.qna_content}</td>
				</tr>
				
				<tr>
					<td class="">
						<c:if test="${nickname eq 'admin1' || nickname eq 'admin2' || nickname eq 'admin3'}">
							<input type="button" value="답글작성하기"
								onclick="location.href='../customer/qna_c_write?qna_no=${show.qna_no}'">
						</c:if>
					<c:choose>
							<c:when test="${nickname eq show.user_nick}">
								<input type="button" value="목록으로"
									onclick="location.href='../customer/qna_list'">
								<input type="button" value="삭제하기"
									onclick="location.href='qna_delete?qna_no=${show.qna_no }'">
								<input type="button" value="수정하기"
									onclick="location.href='qna_modifyView?qna_no=${show.qna_no }'">
								<input type="button" value="답글보기"
									onclick="location.href='../customer/qna_c_show?qna_no=${show.qna_no }'">
							</c:when>
							<c:otherwise>
								<input type="button" value="목록으로"
									onclick="location.href='../customer/qna_list'">
								<input type="button" value="답글보기"
									onclick="location.href='../customer/qna_c_show?qna_no=${show.qna_no}'">
							</c:otherwise>
						</c:choose> </td>
				</tr>
			</table>
		</div>

	</div>
	<%@include file="../headerfooter/footer.jsp"%>
</body>
</html>