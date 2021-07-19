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
	<div id="qna_board" align="center">
		<div id="board_title">
			QnA <input type="button" value="글쓰기" class="more_btn"
				onclick="location.href='../customer/qna_write'">
		</div>

		<table id="table" width="800" cellspacing="0">
			<tr class="table_top">
				<td width="40" align="center">번호</td>
				<td width="120" align="center">QnA종류</td>
				<td width="450" align="center">제목</td>
				<td width="60" align="center">작성자</td>
				<td width="170" align="center">날짜</td>
				<td width="60" align="center">조회수</td>
				<td width="120" align="center">처리상태</td>
			</tr>
			<c:forEach var="row" items="${list}">
				<tr bgcolor="#f7f7f7"
					onmouseover="this.style.backgroundColor='#eeeeef'"
					onmouseout="this.style.backgroundColor='#f7f7f7'">
					<td>${row.qna_no}</td>
					<td>${row.qna_type }</td>
					<td><a
						href="../customer/qna_show?user_nick=${row.user_nick }&qna_no=${row.qna_no}">${row.qna_title}
					</a></td>
					<td>${row.user_nick }</td>
					<td align="center"><fmt:formatDate value="${row.qna_date}"
							pattern="yyyy-MM-dd" /></td>
					<td>${row.qna_count}</td>
					<td>${row.qna_process }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="paging" align="center">
		<c:if test="${paging.curRange ne 1 }">
			<a href="#" onClick="fn_paging(1)">[처음]</a>
		</c:if>
		<c:if test="${paging.curPage ne 1}">
			<a href="#" onClick="fn_paging('${paging.prevPage }')">[이전]</a>
		</c:if>
		<c:forEach var="pageNum" begin="${paging.startPage }"
			end="${paging.endPage }">
			<c:choose>
				<c:when test="${pageNum eq  paging.curPage}">
					<span style="font-weight: bold;"><a href="#"
						onClick="fn_paging('${pageNum }')">${pageNum }</a></span>
				</c:when>
				<c:otherwise>
					<a href="#" onClick="fn_paging('${pageNum }')">${pageNum }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.curPage ne paging.pageCnt && paging.pageCnt > 0}">
			<a href="#" onClick="fn_paging('${paging.nextPage }')">[다음]</a>
		</c:if>
		<c:if
			test="${paging.curRange ne paging.rangeCnt && paging.rangeCnt > 0}">
			<a href="#" onClick="fn_paging('${paging.pageCnt }')">[끝]</a>
		</c:if>
	</div>

	<script type="text/javascript">
		function fn_paging(curPage) {
			location.href = "../customer/qna_list?curPage=" + curPage;
		}
	</script>
	<%@include file="../headerfooter/footer.jsp"%>


</body>
</html>