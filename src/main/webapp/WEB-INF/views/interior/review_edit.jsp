<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<% response.setContentType("text/html"); %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="imgPath" value="https://www.mydehome.com//whose/resources"/>
<c:set var="re_no" value="${param.re_no }"></c:set>
<c:set var="com_name" value="${param.com_name }"></c:set>
<c:set var="review" value="${review }"></c:set>
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
    <link rel="stylesheet" href="${path}/resources/css/interior_write.css" />
    
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>	
<script type="text/javascript" src="${path }/resources/js/review.js" charset="utf-8"></script>
</head>
<body>
	<%@include file ="../headerfooter/header.jsp" %>
	<div id="write_title">
	    <p>시공리뷰 수정</p>
	    <p>해당 업체에 대한 솔직한 시공 리뷰를 남겨주세요</p>
	</div>
	<form action="review_edit?re_no=${re_no }&com_name=${com_name }" method="post" name="re_form" enctype="multipart/form-data">
	<div id="write_content">
	  <div class="write_select">
	    <P>${com_name }</P>
	    <input type="text" name="re_title" placeholder="제목을 작성해주세요" value="${review.re_title}">
	  </div>
	  <div class="write_select2">
	  		<select name="com_rating">
	             <option value="0" style="color: white">평점은 변경할 수 없습니다</option>
	          </select>
	     </div>
	  <div class="write_file">
	  	<label for="ex_file">사진 선택</label>
	    <input type="file" id="ex_file" name="file"
			onchange="javascript:document.getElementById('fileName').value = this.value.split('\\')[this.value.split('\\').length-1]" accept="image/*" />
		<div id="imgShow">
			<img src="${imgPath}/${review.re_file }" />
	  	</div>
		<input type="text" id="fileName" readonly name="in_com_file" value="${review.re_file}" />
	  </div>

	  
	  <script>
	  var file = document.getElementById('fileName').value;
      document.getElementById('fileName').value = file.split('_')[file.split('_').length-1];
      
	  $("#ex_file").change(function(){
	   if(this.files && this.files[0]) {
	    var reader = new FileReader;
	    reader.onload = function(data) {
	     $("#imgShow img").attr("src", data.target.result).width(50);        
	    }
	    reader.readAsDataURL(this.files[0]);
	   }
	  });
	  
	  
	</script>
	  
	  <textarea name="re_content" placeholder="해당 업체에 대한 솔직한 시공 리뷰를 남겨주세요">${review.re_content}</textarea>
	</div>
	<div id="write_btn">
	  <input type="button" value="수정완료" onclick="reEdit_ok()">
	   <input type="reset" value="새로고침">
	 </div>
	</form>
  
    <%@include file ="../headerfooter/footer.jsp" %>
    
</body>
</html>