<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="imgPath" value="https://www.mydehome.com//whose/resources"/>
<c:set var="dto"  value="${dto}"/>
<c:set var="to_nick"  value="${param.to_nick}"/>
<c:set var="com_name"  value="${param.com_name}"/>
<c:set var="user_nick_com"  value="${user_nick_com}"/>
<%
	String sessionNick = (String)session.getAttribute("nickname");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&display=swap"
      rel="stylesheet"
    />
    <link rel="shortcut icon" type="image⁄x-icon" href="${path}/resources/images/x-icon.png" />
    <link rel="stylesheet" href="${path}/resources/css/reset.css" />
    <link rel="stylesheet" href="${path}/resources/css/chatting.css" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
// 채팅 입력ajax
var lastID = 0;
function insertFunction(){
	var user_nick = '<%=sessionNick%>';
	var to_nick = '${to_nick}';
	var com_name = '${com_name}';
	var coun_chatcontent = $('#chatbox').val();
	console.log('인서트펑션' + user_nick);
	console.log('인서트펑션' + com_name);
	
	$.ajax({
			type: 'POST',
			url: '../chatInsertCoun.do',
			data: {
				com_name: encodeURIComponent(com_name),
				user_nick: encodeURIComponent(user_nick),
				to_nick: encodeURIComponent(to_nick),
				coun_chatcontent: encodeURIComponent(coun_chatcontent),
			}, 
			success: function(result) {
				$('#chatbox').val('');			
			},
			error:function(request,status,error){
				alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
			}
	});
}
function chatListFunction(type) {
	var user_nick = '<%=sessionNick%>';
	var to_nick = '${to_nick}';
	var com_name = '${com_name}';
	var user_nick_com = '${user_nick_com}';
	console.log('리스트펑션' + user_nick);
	console.log('리스트펑션' + com_name);
	$.ajax({
		type: 'POST',
		url: '../chatListCoun.do?com_name=${com_name}&to_nick${to_nick}',
		data: {
			user_nick: encodeURIComponent(user_nick),
			to_nick: encodeURIComponent(to_nick),
			listType: type,
		},
		success: function(data) {
			if(data == "") return;
			var parsed = JSON.parse(data);
			var result = parsed.result;
			console.log(result.length);
			for(var i = 0; i < result.length; i++) {
				console.log('for' + user_nick);
				console.log('for' + com_name);
				if(user_nick_com == com_name) { //세션닉이 해당 업체일때
					if(result[i][1].value == com_name) { // 받는 사람이 본인(해당업체)일때
						addChat(result[i][2].value);
					} else {
						addChat2(result[i][2].value);
					}
				} else {
					if(result[i][1].value != com_name) { // 받는 사람이 업체가 아닐때(유저가 받는 채팅)
						addChat(result[i][2].value);
					} else {
						addChat2(result[i][2].value);
					}
				}
				
			}
			
			lastID = Number(parsed.last);
		},
		error:function(request,status,error){
			alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
		}
	});
}	
/* 받은 메세지 */
function addChat(chatContent) {
	$('#chatting_part').append('<div id="chat">' 
						+ '<div class="other_chat">'
						+ chatContent
						+ '</div>'
						+ '</div>');
	$('#chatting_part').scrollTop($('#chatting_part')[0].scrollHeight);
} 
/* 내가 보낸 메세지 */
function addChat2(chatContent) {
	$('#chatting_part').append('<div id="chat">' 
			+ '<div class="my_chat">'
			+ chatContent
			+ '</div>'
			+ '</div>');
	$('#chatting_part').scrollTop($('#chatting_part')[0].scrollHeight);
} 
function getInfiniteChat() {
	setInterval(function() {
		chatListFunction(lastID);	
	}, 500);
}	
</script>
<title>시공상담 대화</title>
</head>
<body>
<%@include file ="../headerfooter/header.jsp" %>
	<!--컨텐츠 시작부분-->
	<div id="chatting">
		<div id="chatting_title">
			<p>시공상담 채팅</p>
			<p>
				<span class="font_green">${to_nick}</span> 님과 대화중입니다
			</p>
		</div>

		<!-- 내가 판매한 내역 -->
		<div id="chat_box">
			<div id="chat_top">
				<div class="chat_img">
					<img src="${imgPath}${dto.com_file}">
				</div>
				<div class="chat_txt">
					<p>${dto.com_name}</p>
					<p>
						<span>${dto.com_addr}</span>
					</p>
					<p class="go">
						<a href="../interior/company_page?name=${dto.com_name}">해당 업체 <span>자세히 보기 >></span></a>
					</p>
					<p>
					 <img src="${path}/resources/images/star_green.png" />
					 ${dto.com_rating}
					 </p>
				</div>
			</div>
			<div id="chatting_part">
			</div>
		</div>

		<textarea id="chatbox"></textarea>
		<input type="button" class="submitBtn" id="transport" onclick="insertFunction()" value="전송" />
	</div>
	<script type="text/javascript">
    	$(document).ready(function() {
    		chatListFunction('ten');
    		getInfiniteChat();
    	})
    </script>
	<%@include file ="../headerfooter/footer.jsp" %>
</body>
</html>