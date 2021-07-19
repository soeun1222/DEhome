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
	<link rel="shortcut icon" type="image⁄x-icon" href="${path}/resources/images/x-icon.png" />
	<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&display=swap" rel="stylesheet"/>
	<link rel="stylesheet" href="${path }/resources/css/my_page.css" />
	<link rel="stylesheet" href="${path }/resources/css/sign_up.css" />
	<link rel="stylesheet" href="${path }/resources/css/reset.css" />
	<link rel="stylesheet" href="${path }/resources/css/qna_board.css" />
	<script type="text/javascript" src="${path }/resources/js/customer.js" charset="utf-8"></script>
</head>
<body>
	<%@include file="../headerfooter/header.jsp"%>
    <!-- --------------------- 컨텐츠 시작 ---------------------- -->
      <center>
      <content>
        <div id="write">
            <form action="../customer/not_modifyView?not_no=${show.not_no }" method="post" name="form">
              <p><span>Notice</span> 공지사항수정하기</p>
              <table>
                <tr>
                  <td>
                    <input class="board_title" name="not_title" type="text" placeholder="제목을 작성해주세요" value="${show.not_title}"/>
                  </td>
                  <tr>
	                <td>
	                	<select name="not_menu" class="qna_type">
			              <option value="usedtrade" selected>중고거래</option>
			              <option value="interrior">인테리어</option>
			              <option value="membership">회원관련</option>
			            </select>
	                </td>
                </tr>  
                <tr>
                  <td>
                    <textarea name="not_content" placeholder="내용을 작성헤주세요">${show.not_content}</textarea>
                  </td>
                </tr>
                <tr>
                  <td>
                  </td>
                </tr>
                <tr>
                  <td>
<!--                     <input type="submit" value="수정하기"> -->
                    <input type="button" value="수정하기" onclick="not_write_ok()">
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