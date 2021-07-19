<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.HttpCookie"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<% pageContext.setAttribute("replaceChar", "\n"); %>
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
    <fmt:formatDate  var="board_date" value="${ show.board_date }" pattern="yy/MM/dd HH:mm" />
    <!-- --------------------- 컨텐츠 시작 ---------------------- -->
     <center>
    <content>
      <div id="show">
        <div class="show_head">
          <p>자유게시판</p>
          <p>${board_date }</p>
        </div>
        <div>
          <table>
            <tr>
              <td>
                <p>${show.board_title }</p>
                <p>조회수  <span>${show.board_count }</span></p>
                <p>${show.user_nick }</p>
              </td>
            </tr>
            <tr>
              <td>
                ${fn:replace(show.board_content, replaceChar, "<br>") }
              </td>
            </tr>
            <tr>
              <td class="">
		         <c:choose>
		
					<c:when test = "${nickname eq null}">
						    <input type="button" value="목록으로"
			                		onclick="location.href='tr_board_list.jsp?board_pagenum=${show.board_pagenum }'" >
					</c:when>
					
					<c:when test = "${nickname eq show.user_nick}">
			                <input type="button" value="목록으로"
			                		onclick="location.href='tr_board_list?board_pagenum=${show.board_pagenum }'" >
			                <input type="button" value="수정하기" 
			                		onclick="location.href='tr_board_edit?board_id=${show.board_id }&board_pagenum=${show.board_pagenum }'">
			                <input type="button" value="삭제하기"
			                		onclick="location.href='tr_board_delete?board_id=${show.board_id }&board_pagenum=${show.board_pagenum }'">
					</c:when>
					
					<c:otherwise>
						    <input type="button" value="목록으로"
			                		onclick="location.href='tr_board_list?board_pagenum=${show.board_pagenum }'" >
					</c:otherwise>
				</c:choose>
              </td>
            </tr>
          </table>
        </div>
      </div>
    </content>
  </center>
  <%--
  //나중에 추가하기!!!!!!!--
  <c:choose>
		
					<c:when test = "${nickname eq null}">
						    <input type="button" value="목록으로"
			                		onclick="location.href='tr_board_list.jsp?board_pagenum=${show.board_pagenum }'" >
					</c:when>
					<c:when test = "${nickname eq show.user_nick}">
			                <input type="button" value="목록으로"
			                		onclick="location.href='tr_board_list?board_pagenum=${show.board_pagenum }'" >
			                <input type="button" value="수정하기" 
			                		onclick="location.href='tr_board_edit?board_id=${show.board_id }&board_pagenum=${show.board_pagenum }'">
			                <input type="button" value="삭제하기"
			                		onclick="location.href='tr_board_delete?board_id=${show.board_id }&board_pagenum=${show.board_pagenum }'">
					</c:when>
					
					<c:otherwise>
						    <input type="button" value="목록으로"
			                		onclick="location.href='tr_board_list?board_pagenum=${show.board_pagenum }'" >
					</c:otherwise>
				</c:choose>
   --%>
<%@include file="../headerfooter/footer.jsp" %>
</body>
</html>