
function search_check() {
	if(document.search_form.search_area.value == '') {
		alert("지역을 입력해주세요");
		search_form.search_area.focus();
		return;
	}

	document.search_form.submit();
}