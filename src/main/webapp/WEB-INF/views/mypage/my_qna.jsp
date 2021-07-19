<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="nick" value="${nick}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${path }/resources/css/my_qna.css">
    <link rel="stylesheet" href="${path }/resources/css/my_page.css">
    <link rel="stylesheet" href="${path }/resources/css/reset.css">
<title>내가 작성한 QNA</title>
</head>
<body>
<%@include file ="../headerfooter/header.jsp" %>
		<div class="contents_mypage"> 
          <h2 class="page_title">MY PAGE</h2>         
          <div class="mypage_header_box">
            <p class="my_page_label">${nick}님 안녕하세요</p>
          </div>
          <div class="mypage_sidebar_box">
            <ul class="mypage_ul1">
              <li class="mypage_side_label">회원정보</li>
              <li class="mypage_side_list" ><a href="edit_account">개인정보 수정</a></li>
              <li class="mypage_side_list"><a href="delete_account">회원탈퇴</a></li>
            </ul>
            <ul class="mypage_ul2">
              <li class="mypage_side_label">활동 및 문의</li>
              <li class="mypage_side_list"><a href="#">나의 거래</a>
                 <ul class="mypage_side_list_2">
                    <li><a href="../mypage/my_sell_list">내가 등록한 물품</a></li>
                    <li><a href="../mypage/my_buy_list">나의 구매 물품</a></li>
                 </ul>
              </li>
              <li class="mypage_side_list_1" style="color: #1B7850"><a href="my_trade_board">내가 작성한 글 ></a>
                 <ul class="mypage_side_list_2">
                    <li><a href="my_trade_board">자유게시판</a></li>
                    <li><a href="../mypage/my_interior_tip">인테리어 팁</a></li>
                    <li><a href="my_review">시공리뷰</a></li>
                    <li style="color: #1B7850"><a href="../mypage/my_qna">QNA ></a></li>
                 </ul>
              </li>
              <li class="mypage_side_list"><a href="../chat/chattingList">대화목록</a></li>
              <li class="mypage_side_list"><a href="../mypage/my_bookmark">북마크</a></li>
            </ul>
          </div>
          <div class="contents_box_my_qna">
            <form action="#" method="POST">
              <div class="ask_table_box">
                <p class="mypage_label">
                  1:1 문의 <input type="button" value="문의하기" class="ask_button"
                  		onclick="location.href='../customer/qna_write'"> 
                </p>
              </div>
              <div class="ask_box">
                <table>
                  <tr class="ask_table_header">
                    <td width="40" align="center" >번호</td>
                    <td width="120" align="center" >QnA종류</td>
                    <td width="450" align="center" >제목</td>
                    <td width="60" align="center" >닉네임</td>
                    <td width="170" align="center" >날짜</td>
                    <td width="60" align="center" >조회수</td>
                    <td width="120" align="center" >처리상태</td>
                  </tr>
                  <c:forEach var="dto" items="${myQnaList}">
	                  <tr bgcolor="#f7f7f7" class="ask_table_content"
                		onmouseover="this.style.backgroundColor='#eeeeef'" 
						onmouseout="this.style.backgroundColor='#f7f7f7'">
						<td width="40" align="center" >
							${dto.qna_no}
						</td>
						<td width="120" align="center" >
							${dto.qna_type }
						</td>
						<td width="450" align="center">
							<a href="../customer/qna_show?qna_no=${dto.qna_no}">
								${dto.qna_title}
							</a>
						</td>
						<td width="60" align="center">
							${dto.user_nick }
						</td>
						<td width="170" align="center">
							<fmt:formatDate value="${dto.qna_date}" pattern="yyyy-MM-dd"/>
						</td>
                		<td width="60" align="center">
                			${dto.qna_count}
                		</td>
                		<td width="120" align="center">
                			${dto.qna_process }
                		</td>
                	</tr>
	              </c:forEach>
                </table>  
              </div>
          	  </form>
             </div>
          </div>
<%@include file ="../headerfooter/footer.jsp" %>
</body>
</html>