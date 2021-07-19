<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DE:home</title>
<%@include file="../headerfooter/header.jsp" %>
<script type="text/javascript" src="${path }/resources/js/tr_board.js" charset="utf-8"></script>
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link rel="shortcut icon" type="image⁄x-icon" href="${path}/resources/images/x-icon.png" />
    <link
      href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&display=swap"
      rel="stylesheet"
    />
  	<link rel="stylesheet" href="${path }/resources/css/header_footer.css" />
    <link rel="stylesheet" href="${path }/resources/css/login.css" />
    <link rel="stylesheet" href="${path }/resources/css/reset.css" />
    <link rel="stylesheet" href="${path }/resources/css/trade_board.css" />
</head>
<body>
    <!-- --------------------- 컨텐츠 시작 ---------------------- -->

<center>
    <div id="trade_board">
         <div id="board_title">
                자유게시판
         <c:choose>

			<c:when test = "${nickname eq null}">
				<input type="button" value="글쓰기" onclick="no()">
			</c:when>
			
			<c:otherwise>
				<input type="button" value="글쓰기" onclick="location.href='../trade/tr_board_write'">
			</c:otherwise>
		</c:choose>
      	</div>
           <table id="table" width="800" cellspacing="0" >
               <tr class="table_top">
                   <td width="40" align="center" >번호</td>
                   <td width="450" align="center" >제목</td>
                   <td width="120" align="center" >작성자</td>
                   <td width="170" align="center" >날짜</td>
                   <td width="60" align="center" >조회수</td>
               </tr>
               <c:forEach items="${list }" var="list" varStatus="status">
               	<tr bgcolor="#f7f7f7" 
               		onmouseover="this.style.backgroundColor='#eeeeef'" 
					onmouseout="this.style.backgroundColor='#f7f7f7'">
               		<td> ${list.board_id }</td>
               		
               		<td>
                		<a href="tr_board_show?user_nick=${list.user_nick }&board_id=${list.board_id }&board_pagenum=${list.board_pagenum }">
							${list.board_title }
							
						</a>
					</td>
               		<td>${list.user_nick }</td>
               		<td><fmt:formatDate value="${ list.board_date }" pattern="yy/MM/dd HH:mm" /></td>
               		<td>${list.board_count}</td>
               </c:forEach>
               
           </table>
        </div>
    </center>
  <div>
  <div class="paging" align="center">
                    <c:if test="${paging.curRange ne 1 }">
                        <a href="#" onClick="fn_paging(1)">[처음]</a> 
                    </c:if>
                    <c:if test="${paging.curPage ne 1}">
                        <a href="#" onClick="fn_paging('${paging.prevPage }')">[이전]</a> 
                    </c:if>
                    <c:forEach var="pageNum" begin="${paging.startPage }" end="${paging.endPage }">
                        <c:choose>
                            <c:when test="${pageNum eq  paging.curPage}">
                                <span style="font-weight: bold;"><a href="#" onClick="fn_paging('${pageNum }')">${pageNum }</a></span> 
                            </c:when>
                            <c:otherwise>
                                <a href="#" onClick="fn_paging('${pageNum }')">${pageNum }</a> 
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${paging.curPage ne paging.pageCnt && paging.pageCnt > 0}">
                        <a href="#" onClick="fn_paging('${paging.nextPage }')">[다음]</a> 
                    </c:if>
                    <c:if test="${paging.curRange ne paging.rangeCnt && paging.rangeCnt > 0}">
                        <a href="#" onClick="fn_paging('${paging.pageCnt }')">[끝]</a> 
                    </c:if>
                </div>
                
	<script type="text/javascript">
	function fn_paging(curPage) {
		location.href = "../trade/tr_board_list?curPage=" + curPage;
		}
	</script>
<%@include file="../headerfooter/footer.jsp" %>


</body>
</html>