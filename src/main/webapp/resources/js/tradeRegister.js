function check_ok(){
	if(document.form.tr_category.value.length == 0){
		alert("카테고리를 선택하세요.");
		return;
	}
	if(document.form.tr_title.value.length == 0){
		alert("글제목을 입력해주세요.");
		form.tr_title.focus();
		return;
	}
	if(document.form.tr_photo.value.length == 0){
		alert("사진을 첨부해주세요.");
		form.tr_photo.focus();
		return;
	}
	if(document.form.tr_content.value.length == 0){
		alert("글내용을 입력해주세요.");
		form.tr_contente.focus();
		return;
	}
	document.form.submit();
	
}
