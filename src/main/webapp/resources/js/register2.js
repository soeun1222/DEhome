var pwdCheck = /^(?=.*[a-zA-Z])(?=.*[~!@#$%^&*()_+-=|<>?:{}])(?=.*[0-9].{8,25}$)/;
var pattern_num = /[0-9]/;
var pattern_eng = /[a-zA-Z]/;
var pattern_spc = /[~!@#$%^&*()_+|<>?:{}]/;
var pattern_kor = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;


function doDisplay() {
		var con = document.getElementById("comCheck");
		var chkbox = document.getElementById("comCheckBtn");
		var com_chk_span = document.getElementById("com_chk_span");
		var com_name = document.getElementById("com_name");
		if(chkbox.checked == true) {
			con.style.display = "block";
			com_chk_span.style.color = "#1b7850";
		} else {
			con.style.display = "none";
			com_chk_span.style.color = "#ccc";
		}
	}


/*--닉네임 중복체크 팝업부분--*/
function nick_popup() {
	window.open("nick_popup","nick_check_popup","width=400, height=600, left=100, top=50");
}

function nick_ok() {
	if(document.nick_chk_form.user_nick.value.length == 0) {
		alert("닉네임을 입력해주세요.");
		document.nick_chk_form.user_nick.focus();
		return;
	}
	if(pattern_spc.test(document.nick_chk_form.user_nick.value)) {
		alert("닉네임은 한글과 영어만 사용이 가능합니다.\n특수문자를 제거해주세요.");
		document.nick_chk_form.user_nick.focus();
		return;
	}
	
	document.nick_chk_form.submit();
}

function nick_use() {
	opener.document.getElementById("user_nick_fake").value = document.getElementById("user_nick").value;
	opener.document.getElementById("user_nick").value = document.getElementById("user_nick").value;
	opener.document.getElementById("overlap_chk").disabled = true;
	opener.document.getElementById("user_nick_fake").disabled = true;
	window.close();
}

/*--아이디 중복체크 팝업부분--*/
function id_popup() {
	window.open("id_popup","id_check_popup","width=400, height=600, left=100, top=50");
}

function id_ok() {
	if(document.id_chk_form.user_id.value.length == 0) {
		alert("아이디를 입력해주세요.");
		document.id_chk_form.user_id.focus();
		return;
	}
	if(pattern_spc.test(document.id_chk_form.user_id.value)) {
		alert("아이디는 영어와 숫자만 사용이 가능합니다.\n특수문자를 제거해주세요.");
		document.id_chk_form.user_id.focus();
		return;
	}
	if(pattern_kor.test(document.id_chk_form.user_id.value)) {
		alert("아이디는 영어와 숫자만 사용이 가능합니다.\n한글을 제거해주세요.");
		document.id_chk_form.user_id.focus();
		return;
	}
	
	document.id_chk_form.submit();
}

function id_use() {
	opener.document.getElementById("user_id_fake").value = document.getElementById("user_id").value;
	opener.document.getElementById("user_id").value = document.getElementById("user_id").value;
	opener.document.getElementById("overlap_chk2").disabled = true;
	opener.document.getElementById("user_id_fake").disabled = true;
	window.close();
}






function register_ok() {
	if(document.register_form.user_nick_fake.value.length == 0) {
		alert("닉네임은 필수 입력 사항입니다.");
		document.register_form.user_nick_fake.focus();
		return;
	}
	
	if(document.register_form.overlap_chk.disabled == false) {
		alert("닉네임 중복확인은 필수 입력 사항입니다.");
		document.register_form.overlap_chk.focus();
		return;
	}
	
	
	
	if(document.register_form.user_id_fake.value.length == 0) {
		alert("아이디는 필수 입력 사항입니다.");
		document.register_form.user_id_fake.focus();
		return;
	}
	
	if(document.register_form.overlap_chk2.disabled == false) {
		alert("아이디 중복확인은 필수 입력 사항입니다.");
		document.register_form.overlap_chk2.focus();
		return;
	}
	
	if(document.register_form.user_name.value.length == 0) {
		alert("이름은 필수 입력 사항입니다.");
		document.register_form.user_name.focus();
		return;
	}
	if(pattern_spc.test(document.register_form.user_name.value) || pattern_num.test(document.register_form.user_name.value)) {
		alert("이름은 한글 혹은 영문으로만 입력해주십시오.");
		document.register_form.user_name.focus();
		return;
	}
	
	
	if(document.register_form.user_pnum.value.length == 0) {
		alert("전화번호는 필수 입력 사항입니다.");
		document.register_form.user_pnum.focus();
		return;
	} else if(document.register_form.user_pnum.value.length > 11) {
		alert("전화번호는 11자리 이내로 입력해주십시오.");
		document.register_form.user_pnum.focus();
		return;
	} else if(pattern_spc.test(document.register_form.user_pnum.value) || pattern_eng.test(document.register_form.user_pnum.value) || pattern_kor.test(document.register_form.user_pnum.value)) {
		alert("전화번호는 숫자만 입력해주십시오.");
		document.register_form.user_pnum.focus();
		return;
	}
	
	if(!/01[01689][1-9]{1}[0-9]{2,3}[0-9]{4}$/.test(document.register_form.user_pnum.value)){
		alert("휴대폰 번호 양식이 아닙니다.");
		return;
	}
	
	
	
	if(document.register_form.user_email.value.length == 0) {
		alert("이메일은 필수 입력 사항입니다.");
		document.register_form.user_email.focus();
		return;
	}
	if(pattern_spc.test(document.register_form.user_email.value) || pattern_kor.test(document.register_form.user_email.value)) {
		alert("이메일은 숫자와 영문의 조합으로만 입력해주십시오.");
		document.register_form.user_email.focus();
		return;
	}
	
	if(document.register_form.user_email2.value.length == 0) {
		alert("이메일 주소를 다시 확인해주세요.");
		document.register_form.user_email2.focus();
		return;
	}
	if(pattern_spc.test(document.register_form.user_email2.value) || pattern_kor.test(document.register_form.user_email2.value)) {
		alert("이메일은 숫자와 영문의 조합으로만 입력해주십시오.");
		document.register_form.user_email2.focus();
		return;
	}
	
	if(document.register_form.mail_valid.disabled == false) {
		alert("이메일 본인인증을 진행 해주셔야 회원가입을 할 수 있습니다.");
		return;
	}
	
	
	if(document.register_form.user_addr1.value.length == 0) {
		alert("주소는 필수 입력 사항입니다.");
		document.register_form.user_addr1.focus();
		return;
	}
	if(document.register_form.user_addr2.value.length == 0) {
		alert("주소는 필수 입력 사항입니다.");
		document.register_form.user_addr2.focus();
		return;
	}
	if(document.register_form.user_addr3.value.length == 0) {
		alert("주소는 필수 입력 사항입니다.");
		document.register_form.user_addr3.focus();
		return;
	}
	if(document.register_form.user_addr4.value.length == 0) {
		alert("원활한 중고거래를 위해 상세 주소까지 입력 부탁드립니다.");
		document.register_form.user_addr4.focus();
		return;
	}
	
	document.register_form.submit();

}




function email_change(){
	if(document.register_form.email.options[document.register_form.email.selectedIndex].value == '0'){
		document.register_form.user_email2.disabled = true; 
 		document.register_form.user_email2.value = "";
		return;
	}
	if(document.register_form.email.options[document.register_form.email.selectedIndex].value == '9'){ 
		document.register_form.user_email2.disabled = false;
 		document.register_form.user_email2.value = "";
 		document.register_form.user_email2.focus();
		return;  
	} else { 
		document.register_form.user_email2.disabled = true;
 		document.register_form.user_email2.value = document.register_form.email.options[document.register_form.email.selectedIndex].value;
		return;
	} 
}