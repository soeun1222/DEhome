<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="nick" value="${nick}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DE:home</title>
<link rel="stylesheet" href="${path }/resources/css/popup.css" />
<link rel="shortcut icon" type="image⁄x-icon" href="${path}/resources/images/x-icon.png" />
<script type="text/javascript" src="${path }/resources/js/register.js" charset="utf-8"></script>
</head>
<body>
	<p>닉네임 중복 검사</p>
    <form action="nick_popup" method="post" name="nick_chk_form">
		<c:choose>
			<c:when test="${nick eq null}"> <!-- get으로 받을때 -->
    			<input type="text" name="user_nick" id="user_nick" class="id_input" />
    			<input type="button" onclick="nick_ok()" value="중복확인" class="btn">
 			</c:when>
    		<c:when test="${nick eq '중복'}">
    			<script type="text/javascript">
    				alert("중복되는 닉네임이 존재합니다.");
    			</script>
    			<input type="text" name="user_id" id="user_id" class="id_input" />
    			<input type="button" onclick="nick_ok()" class="btn" value="중복확인">
    		</c:when>
 			<c:when test="${nick ne null}"> <!-- post로 중복되지 않은 값 받을때 -->
    			<input type="text" name="user_nick" id="user_nick" class="id_input" value="${nick}" />
    			<input type="button" onclick="nick_ok()" value="중복확인" class="btn">	
    			<input type="button" onclick="nick_use()" value="위의 닉네임 사용하기" class="use">
    		</c:when>
		</c:choose>
    </form>
</body>
</html>