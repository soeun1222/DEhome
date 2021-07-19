<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<% response.setContentType("text/html"); %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="imgPath" value="https://www.mydehome.com//whose/resources"/>
<c:set var="com_name" value="${param.com_name }"></c:set>
<c:set var="comInfo" value="${comInfo }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DE:home</title>
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link rel="shortcut icon" type="image⁄x-icon" href="${path}/resources/images/x-icon.png" />
    <link
      href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="${path}/resources/css/reset.css" />
    <link rel="stylesheet" href="${path}/resources/css/register_com.css" />
    
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>	
<script type="text/javascript" src="${path }/resources/js/interior.js" charset="utf-8"></script>
</head>
<body>
	<%@include file ="../headerfooter/header.jsp" %>
	<main>
		<form action="edit_com" name="edit_com_form" method="post" enctype="multipart/form-data">
			<div class="sell_form">
				<p class="regi_form_main_title">업체 수정</p>
				<select name="com_name" class="regi_select" disabled="disabled">
					<option value="${comInfo.com_name }" selected="selected">${comInfo.com_name }</option>
				</select>
				<input type="hidden" name="com_name" value="${comInfo.com_name }">
				<div class="com_regi_form regi_form_title">
					<input type="text" maxlength="50" name="com_title" value="${comInfo.com_title }"/>
				</div>
				<p class="address_reg">업체 주소 수정</p>
				<div class="addrNow">
					<p><span class="bold">현재 주소 :</span> ${comInfo.com_addr }</p>
					<button id="addrBtn" type="button">주소수정</button>
				</div>
				<div class="reg_addr" id="addrShow" style="display: none;">
					<input type="text" class="addr1" id="postcode" placeholder="우편번호">
					<input type="button" class="addr_btn" onclick="execPostcode()" value="우편번호 찾기"><br>
					<input type="text" class="addr2" name="com_addr" id="address" placeholder="주소" value="${comInfo.com_addr }"><br>
					<input type="text" class="addr3" id="extraAddress" placeholder="참고항목"><br>
					<input type="text" class="addr4" id="detailAddress" placeholder="상세주소">
				</div>
				
				<div class="com_regi_form_file">
					<label for="ex_file">대표 이미지 수정</label>
					<input type="file" id="ex_file" name="file"
						onchange="javascript:document.getElementById('fileName').value = this.value.split('\\')[this.value.split('\\').length-1]" accept="image/*" />
					<input type="text" id="fileName" readonly name="in_com_file" value="${imgPath}${comInfo.com_file}" />
				</div>
				
				<div id="imgShow">
					<img src="${path}/${comInfo.com_file }" />
				</div>
				
				<script>
					$("#addrBtn").click(function(){
						$("#addrShow").css("display","block");
					});
					
					var file = document.getElementById('fileName').value;
			        document.getElementById('fileName').value = file.split('_')[file.split('_').length-1];
					
					  $("#ex_file").change(function(){
					   if(this.files && this.files[0]) {
					    var reader = new FileReader;
					    reader.onload = function(data) {
					     $("#imgShow img").attr("src", data.target.result).width(500);        
					    }
					    reader.readAsDataURL(this.files[0]);
					   }
					  });
				</script>
				
				<textarea name="com_content" class="com_regi_form_content" cols="48"rows="10" maxlength="1000">${comInfo.com_content }</textarea>
				<div class="com_submit_btn">
					<input type="reset" value="새로고침" /> 
					<input type="button" value="업체수정" onclick="editCom_check()"  />
				</div>
			</div>
		</form>
	</main>
    <%@include file ="../headerfooter/footer.jsp" %>
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
</body>
</html>