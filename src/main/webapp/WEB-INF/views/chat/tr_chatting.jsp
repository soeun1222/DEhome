<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="imgPath" value="https://www.mydehome.com//whose/resources"/>
<c:set var="dto"  value="${dto}"/>
<c:set var="dto3"  value="${dto3}"/>
<c:set var="nick"  value="${nick}"/>
<fmt:formatDate var="reg_date" value="${dto.tr_date}" pattern="yyyy년 MM월 dd일 HH시mm분" />
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
	var nick = '${nick}'
	var tr_no = '${dto.tr_no}';
	var trade_chatcontent = $('#chatbox').val();
	$.ajax({
			type: 'POST',
			url: '../chatInsert.do',
			data: {
				tr_no,
				user_nick: encodeURIComponent(user_nick),
				to_nick: encodeURIComponent(to_nick),
				nick: encodeURIComponent(nick),
				trade_chatcontent: encodeURIComponent(trade_chatcontent),
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
	var nick = '${nick}'
	var tr_no = '${dto.tr_no}';
	$.ajax({
		type: 'POST',
		url: '../chatList.do?tr_no=${dto.tr_no}&to_nick=${to_nick}',
		data: {
			user_nick: encodeURIComponent(user_nick),
			to_nick: encodeURIComponent(to_nick),
			nick: encodeURIComponent(nick),
			listType: type,
		},
		success: function(data) {
			if(data == "") return;
			var parsed = JSON.parse(data);
			var result = parsed.result;
			console.log(result);
			for(var i = 0; i < result.length; i++) {
				if(result[i][1].value !=  user_nick) { //받는사람이 본인이 아닐때
					addChat2(result[i][2].value);				
				}else {
					addChat(result[i][2].value);
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

function complete_ok() {
	var okCheck = confirm("거래 완료 상품으로 전환하시겠습니까?")
	if(okCheck == true) {
		document.location.href = "<c:url value='../trade/tradeShow?tr_no=${dto.tr_no}&ch=1&heart=on&to_nick=${to_nick}' />";
	}
}
</script>
<title>중고거래 대화</title>
</head>
<body>
<%@include file ="../headerfooter/header.jsp" %>
	<!--컨텐츠 시작부분-->
	<div id="chatting">
		<div id="chatting_title">
			<p>중고거래 채팅</p>
			<p>
				<span class="font_green">${to_nick}</span> 님과 대화중입니다
			</p>
		</div>

		<!-- 내가 판매한 내역 -->
		<div id="chat_box">
			<div id="chat_top">
				<div class="chat_img">
					<img src="${imgPath}${dto.tr_photo}">
				</div>
				<div class="chat_txt">
					<p>${dto.tr_title}</p>
					<p>
						<span>${reg_date}</span>
					</p>
					<p class="go">
						<a href="../trade/tradeShow?tr_no=${dto.tr_no}&ch=0&heart=none">해당 게시글 <span>자세히 보기 >></span></a>
						<c:if test="${dto.tr_user_nick eq dto3.user_nick }">
						<a href="javascript:void(0);" onclick="complete_ok()"class="trade_btn">${to_nick}님과 <span>거래확정</span>하기</a>
						</c:if>
					</p>
					<p>${dto.tr_price}</p>
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