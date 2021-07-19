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
      rel="stylesheet"
    />
  	<link rel="stylesheet" href="${path }/resources/css/header_footer.css" />
    <link rel="stylesheet" href="${path }/resources/css/my_page.css" />
    <link rel="stylesheet" href="${path }/resources/css/reset.css" />
    <link rel="stylesheet" href="${path }/resources/css/edit_account.css" />
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
              <li class="mypage_side_list_1"><a href="my_trade_board">내가 작성한 글</a>
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
        
 <!-- ---------- 개인정보 수정 -------------->
 <div class="contents_box_edit">
        	<form method="post" name="form" action="../mypage/edit_account">
            <div class="edit_account_box">
              <p class="mypage_edit_label">개인정보 수정</p>
            </div>
            <div class="edit_account_box">
              <p class="mypage_content_edit_list">이름</p>
              <p class="mypage_content_list_list">
                <input type="text" name="user_name" placeholder="회원이름" value="${userInfo.user_name}"  disabled="disabled"/>
              </p>
            </div>
            <div class="edit_account_box">
              <p class="mypage_content_edit_list">아이디</p>
              <p class="mypage_content_list_list">
                <input type="text" name="user_id2" placeholder="회원ID" value="${userInfo.user_id}"   disabled="disabled" />
                <input type="hidden" name="user_id" value="${userInfo.user_id}"/>
              </p>
            </div>
            <div class="edit_account_box">
              <p class="mypage_content_edit_list">닉네임</p>
              <p class="mypage_content_list_list">
                <input type="text" name="user_nick" placeholder="회원 닉네임" value="${userInfo.user_nick}" disabled="disabled" />
              </p>
            </div>
            <div class="edit_account_box">
              <p class="mypage_content_edit_list">기존 비밀번호</p>
              <p class="mypage_content_list_list">
                <input type="password" name="pre_pw" />
              </p>
            </div>
            <div class="edit_account_box">
              <p class="mypage_content_edit_list">새 비밀번호</p>
              <p class="mypage_content_list_list">
                <input type="password" name="user_pw" />
              </p>
            </div>
            <div class="edit_account_box">
              <p class="mypage_content_edit_list">새 비밀번호 확인</p>
              <p class="mypage_content_list_list">
                <input type="password" name="user_pw2" />
              </p>
            </div>
            <div class="edit_account_box">
              <p class="mypage_content_edit_list">휴대폰번호</p>
              <p class="mypage_content_list_list">
                <input type="tel" name="user_pnum" size="11" value="0${userInfo.user_pnum}"/>
              </p>
            </div>
              <div class="edit_account_box">
              <p class="mypage_content_edit_list">이메일</p>
              <p class="mypage_content_list_list">
                <input type="text" name="user_email" value="${userInfo.user_email}"  disabled="disabled"/>
                 @
	             <input type="text" name="user_email2" value="${userInfo.user_email2}"  disabled="disabled" style="height: 25px; margin-top: 5px"/>
	           <!-- <select style="height: 30px; margin-top: 5px"  name="email" onchange="email_change()">
	                <option value="0">선택</option>
	                <option value="9">직접 입력</option>
	                <option value="naver.com" id="naver">naver.com</option>
	                <option value="daum.net" id="daum">daum.net</option>
	                <option value="nate.com" id="nate">nate.com</option>
	                <option value="gmail.com" id="gmail">gmail.com</option>
	                <option value="hanmail.net" id="hanmail">hanmail.net</option>
              </select>
               -->   
              </p>
             
            </div>
            <div class="edit_account_box" style="height: 180px">
              <p class="mypage_content_edit_list">주소</p>
              <div class="mypage_content_list_list">
                <div>
                  <input type="text" name="user_addr" id="postcode" value="${userInfo.user_addr}"/>
                  <input
                    type="button"
                    value="우편번호 검색"
                    name="address_search_button"
                    onclick="execPostcode()"
                    style="height: 25px; border-radius: 2px"
                  /><br /><br />
                  <div>
                    <input
                      type="text"
                      name="user_addr2"
                      placeholder="기본주소"
                      id="address"
                       value="${userInfo.user_addr2}"
                    /><br /><br />
                  </div>
                  <div>
                    <input
                      type="text"
                      name="user_addr3"
                      placeholder="(참고항목)"
                      id="extraAddress"
                       value="${userInfo.user_addr3}"
                    />
                  </div>
                  <div>
                    <input
                      type="text"
                      name="user_addr4"
                      placeholder="상세주소"
                      id="detailAddress"
                       value="${userInfo.user_addr4}"
                    />
                  </div>
                </div>
              </div>
            </div>
            <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
			<script>
			    function execPostcode() {
			        new daum.Postcode({
			            oncomplete: function(data) {
			                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
			
			                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
			                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			                var addr = ''; // 주소 변수
			                var extraAddr = ''; // 참고항목 변수
			
			                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
			                    addr = data.roadAddress;
			                } else { // 사용자가 지번 주소를 선택했을 경우(J)
			                    addr = data.jibunAddress;
			                }
			
			                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			                if(data.userSelectedType === 'R'){
			                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
			                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
			                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
			                        extraAddr += data.bname;
			                    }
			                    // 건물명이 있고, 공동주택일 경우 추가한다.
			                    if(data.buildingName !== '' && data.apartment === 'Y'){
			                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
			                    }
			                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
			                    if(extraAddr !== ''){
			                        extraAddr = ' (' + extraAddr + ')';
			                    }
			                    // 조합된 참고항목을 해당 필드에 넣는다.
			                    document.getElementById("extraAddress").value = extraAddr;
			                
			                } else {
			                    document.getElementById("extraAddress").value = '';
			                }
			
			                // 우편번호와 주소 정보를 해당 필드에 넣는다.
			                document.getElementById('postcode').value = data.zonecode;
			                document.getElementById("address").value = addr;
			                // 커서를 상세주소 필드로 이동한다.
			                document.getElementById("detailAddress").focus();
			            }
			        }).open();
			    }
			</script>
            
            <div class="mypage_content_box_delete" style="border: 0">
              <div>
                <input
                  type="button"
                  value="정보수정"
                  class="edit_account_button"
                  onclick="edit_ok()"
                />
                <input
                  type="button"
                  value="수정취소"
                  class="edit_cancel_button"
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