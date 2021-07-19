function qna_write_ok(){
	
	if(document.form.qna_title.value ==""){
		alert("제목을 입력하세요.");
		form.qna_title.focus();
		return;
	}
	if(document.form.qna_content.value == ""){
		alert("내용을 입력하세요.");
		form.qna_content.focus();
		return;
	}
	if(document.form.qna_pw.value ==""){
		alert("비밀번호를 입력하세요.");
		form.qna_pw.focus();
		return;
	}

	document.form.submit();
	
}

function qna_c_write_ok(){
	
	if(document.form.qna_c_content.value == ""){
		alert("내용을 입력하세요.");
		form.qna_c_content.focus();
		return;
	}

	document.form.submit();
	
}
function qna_delete_ok(){
	if(document.delete_form.qna_pw.value ==""){
		alert("비밀번호를 입력하세요.");
		delete_form.qna_pw.focus();
		return;
	}
	document.delete_form.submit();
}

function not_write_ok(){
	
	if(document.form.not_title.value ==""){
		alert("제목을 입력하세요.");
		form.not_title.focus();
		return;
	}
	if(document.form.not_content.value == ""){
		alert("내용을 입력하세요.");
		form.not_content.focus();
		return;
	}

	document.form.submit();
	
}
