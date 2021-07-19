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
	<link rel="stylesheet" href="${path }/resources/css/header_footer.css" />
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
            <form action="../customer/qna_modifyView?qna_no=${show.qna_no}" method="post" name="form">
<!--             <input type="hidden" name="qna_process" value="processing">   -->
              <p><span>QnA</span> 글수정하기</p>
              <table>
                <tr>
                  <td>
                    <input class="board_title" name="qna_title" type="text" placeholder="제목을 작성해주세요" value="${show.qna_title }"/>
                  </td>
                  <tr>
	                <td>
	                	<select name="qna_type" class="qna_type">
			              <option value="usedtrade" selected>중고거래</option>
			              <option value="interrior">인테리어</option>
			              <option value="membership">회원관련</option>
			            </select>
	                </td>
                </tr>  
                <tr>
                  <td>
                    <textarea name="qna_content" placeholder="내용을 작성헤주세요">${show.qna_content}</textarea>
                  </td>
                </tr>
                <tr>
                  <td>
                      <label for="tr_b_pw">암호 :   </label>
                      <input type="password" name="qna_pw">
                  </td>
                </tr>
                <tr>
                  <td>
<!--                     <input type="submit" value="수정하기"> -->
                    <input type="button" value="수정하기" onclick="qna_write_ok()">
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