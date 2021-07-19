<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@include file="../headerfooter/header.jsp" %>
<title>DE:home</title>
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
    <link rel="stylesheet" href="${path }/resources/css/my_page.css" />
</head>
<body>
    
    
    <!-- --------------------- 컨텐츠 시작 ---------------------- -->
      <center>
      <content>
        <div id="edit">
          <%-- <form action="tr_board_show?board_id=${show.board_id}" method="post" name="form"> --%> 
          <form method="post" name="form" action="../trade/tr_board_edit?board_id=${show.board_id}">
              <p><span>자유게시판</span> 글수정하기</p>
              <table>
                <tr>
                  <td>
                    <input class="board_title" name="board_title" type="text" value="${show.board_title }" />
                  </td>
                </tr>
                <tr>
                  <td>
                    <textarea name="board_content" >${show.board_content }</textarea>
                  </td>
                </tr>
                <tr>
                  <td>
                    <input type="button" value="수정하기" onclick="write_ok()">
                    <input type="reset" value="다시작성">
                  </td>
                </tr>
              </table>
            </form>
        </div>
      </content>
    </center>
    
  
<%@include file="../headerfooter/footer.jsp" %>
</body>
</html>