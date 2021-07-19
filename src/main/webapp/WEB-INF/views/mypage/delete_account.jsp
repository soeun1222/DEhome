<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DE:home</title>
<%@include file="../headerfooter/header.jsp" %>
<script type="text/javascript" src="${path }/resources/js/mypage.js" charset="utf-8"></script>
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link rel="shortcut icon" type="image⁄x-icon" href="${path}/resources/images/x-icon.png" />
    <link
      href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&display=swap"
      rel="stylesheet"/>
  	<link rel="stylesheet" href="${path }/resources/css/header_footer.css" />
    <link rel="stylesheet" href="${path }/resources/css/my_page.css" />
    <link rel="stylesheet" href="${path }/resources/css/reset.css" />
    <link rel="stylesheet" href="${path }/resources/css/delete_account.css" />
</head>
<body>

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
              <li class="mypage_side_list_1" ><a href="my_trade_board">내가 작성한 글 </a>
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
        
       <!-- -------회원탈퇴 ---------- -->
  
        <div class="contents_box_delete">
          <form method="POST" name="delete_form">
            <div class="mypage_content_delete_box">
              <p class="mypage_label">회원탈퇴 사유</p>
              <label
                ><input
                  type="radio"
                  name="delete_reason"
                  value="re_sign_up"
                />  탈퇴 후 재가입</label
              >
              <label
                ><input
                  type="radio"
                  name="delete_reason"
                  value="long_absence"
                />  장기간 부재(군입대, 유학 등)</label
              >
              <label
                ><input
                  type="radio"
                  name="delete_reason"
                  value="privacy"
                />  개인정보 누출우려 </label
              ><br /><br /><br />
              <label
                ><input
                  type="radio"
                  name="delete_reason"
                  value="frequency_down"
                />  이용빈도 저하</label
              >
              <label>
              	<input
                  type="radio"
                  name="delete_reason"
                  value="follow_up"
                />  사후조치 불만</label>
              <label>
                <input 
                type="radio" 
                name="delete_reason" 
                value="etc" 
                />  기타 &nbsp;
                <input type="text" height="20px" name="etc_text"/>
              </label>
            </div>
            <div class="delete_account_tip">
              <p>
                - 회원 탈퇴 요청 후, 처리 기간이 일주일 정도 소요됩니다. 양해 부탁드립니다.
              </p>
            </div>
            <div class="delete_account_agree">
              <p>
                <label><input type="checkbox" name="delete" value="delete_agree" />
                회원탈퇴 안내를 모두 확인하였으며 회원 탈퇴에 동의합니다.</label>
              </p>
            </div>
           
            <div class="mypage_content_box_delete" style="border: 0">
              <div>
                <input
                  type="button"
                  value="회원탈퇴"
                  class="delete_account_button"
                  onclick="check_ok()"
                />
              </div>
              <div>
                <input
                  type="button"
                  value="탈퇴취소"
                  class="delete_cancel_button"
                  onclick="location.href='mypage'"
                />
              </div>
            </div>
          </form>
        </div>
      </div>
    </content>
    
<%@include file="../headerfooter/footer.jsp" %>
</body>
</html>