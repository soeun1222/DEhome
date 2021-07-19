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
    <link rel="stylesheet" href="${path }/resources/css/my_page.css" />
    <link rel="stylesheet" href="${path }/resources/css/login.css" />
    <link rel="stylesheet" href="${path }/resources/css/reset.css" />
    <link rel="stylesheet" href="${path }/resources/css/trade_board.css" />
</head>
<body>
    <!-- --------------------- 컨텐츠 시작 ---------------------- -->
    <center>
      <content>
        <div id="write">
            <form method="post" name="form" action="../trade/tr_board_write">
            <input type="hidden" name="user_nick" value="${nickname}">
            <input type="hidden" name="board_count" value="0">
              <p><span>자유게시판</span> 글쓰기</p>
              <table>
                <tr>
                  <td>
                    <input class="board_title" name="board_title" type="text" placeholder="제목을 작성해주세요" />
                  </td>
                </tr>
                <tr>
                  <td>
                    <textarea name="board_content" placeholder="내용을 작성해주세요"></textarea>
                  </td>
                </tr>
            	<tr>
                  <td>
                    <input type="button" value="작성하기" onclick="write_ok()">
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