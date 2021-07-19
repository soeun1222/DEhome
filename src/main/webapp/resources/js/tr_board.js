function write_ok(){
	
	if(document.form.board_title.value ==""){
		alert("제목을 입력하세요.");
		form.board_title.focus();
		return;
	}
	if(document.form.board_content.value == ""){
		alert("내용을 입력하세요.");
		form.board_content.focus();
		return;
	}

	document.form.submit();
}

function delete_ok(){
	if(document.delete_form.board_pw.value ==""){
		alert("비밀번호를 입력하세요.");
		delete_form.board_pw.focus();
		return;
	}
	document.delete_form.submit();
}

function no() {
	alert("로그인 후 이용하세요");
	
}
