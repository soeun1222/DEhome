<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>DE:home</title>
	<link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&display=swap"
      rel="stylesheet"
    />
    <link rel="shortcut icon" type="image⁄x-icon" href="${path }/resources/images/x-icon.png" />
    <link rel="stylesheet" href="${path }/resources/css/reset.css" />
    <link rel="stylesheet" href="${path }/resources/css/interior_write.css" />
<script type="text/javascript" src="${path }/resources/js/tip.js" charset="utf-8"></script>

</head>
<body>
<jsp:include page="../headerfooter/header.jsp" />  
	<div id="write_title">
      <p>인테리어 팁 작성</p>
      <p>나만의 인테리어 팁을 모두에게 공유해보세요</p>
    </div>
    <form name="tip_write_frm" action="../interior/interiorTipList" enctype="multipart/form-data" accept-charset="UTF-8" method="post">
	    <div id="write_content">
	      <div class="write_select">
	        <select name="tip_category">
	          <option value="construct">시공</option>
	          <option value="decorate">꾸미기 팁</option>
	          <option value="diy">DIY</option>
	          <option value="kitchen">주방/욕실</option>
	          <option value="storage">수납</option>
	          <option value="cleaning">청소</option>
	          <option value="reform">리폼</option>
	          <option value="lighting">전기/조명</option>
	        </select>
	        <input type="text" name="tip_title" placeholder="제목을 작성해주세요" />
	      </div>
	      <div class="write_file">
	      	<label for="ex_file">사진 선택</label>
	        <input 
	        	multiple="multiple" type="file" name="file" id="ex_file"
	        	onchange="javascript:document.getElementById('fileName').value = this.value.split('\\')[this.value.split('\\').length-1]"
              	accept="image/*"
            />
            <div id="imgShow" style="display: none;">
            	<img src="" />
	  		</div>
	  		<input type="text" id="fileName" readonly name="in_com_file" />
	      </div>
	      <script>
		  $("#ex_file").change(function(){
		   if(this.files && this.files[0]) {
		    var reader = new FileReader;
		    reader.onload = function(data) {
		     $("#imgShow").css("display", "block");
		     $("#imgShow img").attr("src", data.target.result).width(50);        
		    }
		    reader.readAsDataURL(this.files[0]);
		   }
		  });
		  </script>	      
	      <textarea name="tip_content" placeholder="나만의 인테리어 팁을 작성해주세요"></textarea>
	    </div>
	    <div id="write_btn" >
	      <input type="button" value="작성완료" onclick="tip_write_check()"/>
	      <input type="reset" value="다시작성" />
	    </div>
    </form>
<jsp:include page="../headerfooter/footer.jsp" />
</body>
</html>