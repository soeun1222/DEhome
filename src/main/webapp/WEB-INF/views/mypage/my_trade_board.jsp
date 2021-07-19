<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
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

</head>
 <div class="contents_mypage">
        <a href="mypage"><h2 class="page_title">MY PAGE</h2></a>
        <div class="mypage_header_box">
          <p class="my_page_label">${nickname }님 안녕하세요</p>
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
                    <li><a href="../mypage/my_sell_list">나의 판매 물품</a></li>
                    <li><a href="../mypage/my_buy_list">나의 구매 물품</a></li>
                 </ul>
              </li>
              <li class="mypage_side_list_1" style="color: #1B7850"><a href="my_trade_board">내가 작성한 글 ></a>
                 <ul class="mypage_side_list_2">
                    <li><a href="my_trade_board">자유게시판</a></li>
                    <li><a href="../mypage/my_interior_tip">인테리어 팁</a></li>
                    <li><a href="my_review">시공리뷰</a></li>
                    <li><a href="../mypage/my_qna">QNA</a></li>
                 </ul>
              </li>
              <li class="mypage_side_list"><a href="../chat/chattingList">대화목록</a></li>
              <li class="mypage_side_list"><a href="../mypage/my_bookmark">북마크</a></li>
            </ul>
          </div>
          
          
          
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
            <table id="table" width="650" cellspacing="0" >
                <tr class="table_top">
                    <td width="40" align="center" >번호</td>
                    <td width="360" align="center" >제목</td>
                    <td width="100" align="center" >작성자</td>
                    <td width="110" align="center" >날짜</td>
                    <td width="40" align="center" >조회수</td>
                </tr> 
                <c:forEach items="${list }" var="list" varStatus="status">
               	<tr bgcolor="#f7f7f7" 
               		onmouseover="this.style.backgroundColor='#eeeeef'" 
					onmouseout="this.style.backgroundColor='#f7f7f7'">
               		<td> ${list.board_id }</td>
               		
               		<td>
                		<a href="../trade/tr_board_show?user_nick=${list.user_nick }&board_id=${list.board_id }&board_pagenum=${list.board_pagenum }">
							${list.board_title }
							
						</a>
					</td>
               		<td>${list.user_nick }</td>
               		<td><fmt:formatDate value="${ list.board_date }" pattern="yy/MM/dd HH:mm" /></td>
               		<td>${list.board_count}</td>
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
		location.href = "../mypage/my_trade_board?curPage=" + curPage;
		}
	</script>
<%@include file="../headerfooter/footer.jsp" %>
</body>
</html>