function findID() {
	if(document.find_id_form.user_name.value.length == 0) {
		alert("이름을 입력해주세요.");
		document.find_id_form.user_name.focus();
		return;
	}
	
	if(document.find_id_form.user_email.value.length == 0) {
		alert("이메일을 입력해주세요.");
		document.find_id_form.user_email.focus();
		return;
	}
	if(document.find_id_form.user_email2.value.length == 0) {
		alert("이메일을 입력해주세요.");
		document.find_id_form.user_email.focus();
		return;
	}
	if(document.find_id_form.email.value.length == 0) {
		alert("이메일을 입력해주세요.");
		document.find_id_form.user_email.focus();
		return;
	}
	
	document.find_id_form.submit();
}

function findPW() {
	if(document.find_pw_form.user_id.value.length == 0) {
		alert("아이디를 입력해주세요.");
		document.find_pw_form.user_id.focus();
		return;
	}
	
	if(document.find_pw_form.user_name.value.length == 0) {
		alert("이름을 입력해주세요.");
		document.find_pw_form.user_name.focus();
		return;
	}
	
	if(document.find_pw_form.user_email.value.length == 0) {
		alert("이메일을 입력해주세요.");
		document.find_pw_form.user_email.focus();
		return;
	}
	if(document.find_pw_form.user_email2.value.length == 0) {
		alert("이메일을 입력해주세요.");
		document.find_pw_form.user_email2.focus();
		return;
	}
	if(document.find_pw_form.email.value.length == 0) {
		alert("이메일을 입력해주세요.");
		document.find_pw_form.email.focus();
		return;
	}
	
	document.find_pw_form.submit();
}