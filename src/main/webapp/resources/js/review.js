function reWrite_ok() {
	if(document.rw_form.re_title.value.length == 0) {
		alert("글제목을 입력해주세요.");
		document.rw_form.re_title.focus();
		return;
	}
	if(document.rw_form.file.value.length == 0) {
		alert("리뷰용 사진을 입력해주세요.");
		document.rw_form.file.focus();
		return;
	}

	if(document.rw_form.re_content.value.length == 0) {
		alert("글내용을 입력해주세요.");
		document.rw_form.re_content.focus();
		return;
	}
	document.rw_form.submit();
}

function reEdit_ok() {
	if(document.re_form.re_title.value.length == 0) {
		alert("글제목을 입력해주세요.");
		document.re_form.re_title.focus();
		return;
	}

	if(document.re_form.re_content.value.length == 0) {
		alert("글내용을 입력해주세요.");
		document.re_form.re_content.focus();
		return;
	}
	document.re_form.submit();
}

function login_no() {
	alert("로그인이 필요한 서비스입니다.");
	return;
}

