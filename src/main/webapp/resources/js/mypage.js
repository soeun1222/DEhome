var pwdCheck = /^(?=.*[a-zA-Z])(?=.*[~!@#$%^&*()_+-=|<>?:{}])(?=.*[0-9].{8,25}$)/;
var pattern_num = /[0-9]/;
var pattern_eng = /[a-zA-Z]/;
var pattern_spc = /[~!@#$%^&*()_+|<>?:{}]/;
var pattern_kor = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;

function email_change(){
	if(document.form.email.options[document.form.email.selectedIndex].value == '0'){
		document.form.user_email2.disabled = true; 
 		document.form.user_email2.value = ""
		return;
	}
	if(document.form.email.options[document.form.email.selectedIndex].value == '9'){ 
		document.form.user_email2.disabled = false;
 		document.form.user_email2.value = "";
 		document.form.user_email2.focus();
		return;  
	} else { 
		document.form.user_email2.disabled = true;
 		document.form.user_email2.value 
			= document.form.email.options[document.form.email.selectedIndex].value;
		return;
	} 
}

function edit_ok(){
	if(document.form.user_nick.value.length == 0) {
		alert("닉네임는 필수 입력 사항입니다.");
		document.form.user_nick.focus();
		return;
	}
	if(document.form.pre_pw.value.length == 0) {
		alert("기존 비밀번호는 필수 입력 사항입니다.");
		document.form.pre_pw.focus();
		return;
	}
	
	if(document.form.user_pw.value.length == 0) {
		alert("새 비밀번호는 필수 입력 사항입니다.");
		document.form.user_pw.focus();
		return;
	}
	
		if(document.form.user_pw.value.length < 8) {
			alert("비밀번호는 최소 8자리 이상 입력해주세요.");
			document.form.user_pw.focus();
			return;
		} else if(!pattern_num.test(document.form.user_pw.value)) {
			alert("비밀번호에 숫자를 사용하세요.");
			document.form.user_pw.focus();
			return;
		} else if(!pattern_eng.test(document.form.user_pw.value)) {
			alert("비밀번호에 영문자를 사용하세요.");
			document.form.user_pw.focus();
			return;
		} else if(!pattern_spc.test(document.form.user_pw.value)) {
			alert("비밀번호에 특수문자를 사용하세요.");
			document.form.user_pw.focus();
			return;
		} else if(document.form.user_pw.value.length > 16) {
			alert("비밀번호는 16자리 이하로 입력해주세요.");
			document.form.user_pw.focus();
			return;
		}

	if(document.form.user_pnum.value.length == 0) {
		alert("휴대폰번호는 필수 입력 사항입니다.");
		document.form.user_pnum.focus();
		return;
	}

	if(document.form.user_email.value.length == 0 || document.form.user_email2.value.length == 0) {
		alert("이메일 형식을 확인하세요.");
		document.form.user_email.focus();
		return;
	}

	if(document.form.user_addr.value.length == 0) {
		alert("우편번호를 검색하세요.");
		document.form.user_addr.focus();
		return;
	}

	if(document.form.user_addr2.value.length == 0 || document.form.user_addr3.value.length == 0) {
		alert("주소는 필수 입력 사항입니다.");
		document.form.user_addr2.focus();
		return;
	}
	if(document.form.user_addr4.value.length == 0) {
		alert("상세주소는 필수 입력 사항입니다.");
		document.form.user_addr4.focus();
		return;
	}
	
	
	/*비밀번호 확인*/
	if(document.form.user_pw.value != document.form.user_pw2.value) {
		alert("새 비밀번호가 일치하지 않습니다.");
		document.form.user_pw.focus();
		return;
	}
	
	document.form.submit();
}





function check_ok(){
	ckType = document.getElementsByName("delete_reason")
	ckBox = document.getElementsByName("delete")
	
	for (i=0;i<ckType.length ;i++){
		 if (ckType[i].checked == true){
			 reason = ckType[i].value;
			 break;
		 }
		if (i == ckType.length-1){
		 alert("회원탈퇴 사유를 선택하세요");
		 return;
		}
	}
	
	if(ckType[5].checked == true){
		if(document.delete_form.etc_text.value == ""){
			alert("기타 내용을 입력하세요.")
			return;
		}
	}
	if(document.getElementsByName("delete")[0].checked == false){
		alert("회원 탈퇴에 동의하세요");
			return;
	}
	document.delete_form.submit();
}










