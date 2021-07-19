<%@page import="com.green.dehome.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="kakaoaddcheck" value="${kakaoaddcheck}"/>
<c:set var="naveraddcheck" value="${naveraddcheck}"/>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
	<link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="${path }/resources/css/header_footer.css" />
    <link rel="stylesheet" href="${path }/resources/css/reset.css" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script>
navigator.geolocation.getCurrentPosition(function(pos) {
		$("#localAddr").empty(); // 다시 주소 초기화 시켜주기
	
	    var latitude = pos.coords.latitude;
	    var longitude = pos.coords.longitude;
	    console.log("현재 위치는 : " + latitude + ", "+ longitude);

	    $.ajax({
	    	url : 'https://dapi.kakao.com/v2/local/geo/coord2address.json?x=' + longitude +'&y=' + latitude,
	        type : 'GET',
	        headers : {
	        	'Authorization' : 'KakaoAK 64ff2913ec81fc3b116829aeab1e3e03'
	        },
	        success : function(data) {
	          var addr1 = data.documents[0].address.region_1depth_name;
	          var addr2 = data.documents[0].address.region_2depth_name;
	          var addr3 = data.documents[0].address.region_3depth_name;
	          
	          $("#localAddr").append(addr1 + " " + addr2 + " " + addr3);
	          
	          
	        },
	        error: function(e) {
	          console.log(e);
	        }
	      });
	    
	    getWeather(latitude, longitude); // 위도. 경도 값 넣어서 날씨 가져오기 실행
	    
	    /*--날씨 얻어오기--*/
     	
	    function getWeather(lat, lon){
	        fetch(
	          "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=082c1c2e2596b19c9a94af3006f0d769&units=metric"
	        )
	          .then(function(response){
	          return response.json();
	        })
	          .then(function(json){
	            
	            var weather = json.weather[0].icon;
	            var icon = "${path}/resources/images/" + weather + ".png"; // 사진결정
	            
	            $("#weatherIcon").attr('src', icon);
	            
	          });
	      }


	});
	
</script>
</head>
<body>
	<c:choose>
	<c:when test="${nickname ne null}">
	<header id="header_body">
      <div id="header_top">
        <div class="header_top_left">
          <img src="${path}/resources/images/dh_logo.png" />
          <a href="../main/mainpage">DE:home</a>
        </div>
        <c:choose>
			<c:when test="${login != null}">		 
				<div class="header_top_right">
					<a href="../logout.do">로그아웃</a> &nbsp;&nbsp;&nbsp;
					<a href="../mypage/mypage">마이페이지</a>&nbsp;&nbsp;&nbsp;
					<div id="localAddr"></div>
					<div id="weather" class="weatherBox">
						<img alt="weather" id="weatherIcon" src="${path}/resources/images/01d.png">
					</div>
					<!-- 
					<input type="text"placeholder="search" />
					<button>검색</button>
					 -->
				</div>
			</c:when>
			<c:when test="${(login == null && kakaoaddcheck != null) || (login == null && naveraddcheck != null)}">
				<div class="header_top_right">
				<c:choose>
					<c:when test="${kakaoaddcheck == 'Y'}">
						<a href="../logoutKakao">로그아웃</a> &nbsp;&nbsp;&nbsp;
					</c:when> 
					<c:when test="${kakaoaddcheck == 'N'}">
						<a href="../logoutKakao">로그아웃</a> &nbsp;&nbsp;&nbsp;
						<a href="../user/register_kakao">추가정보 등록</a>&nbsp;&nbsp;&nbsp;
					</c:when>
					<c:when test="${naveraddcheck == 'Y'}">
						<a href="../logoutNaver">로그아웃</a> &nbsp;&nbsp;&nbsp;
					</c:when> 
					<c:when test="${naveraddcheck == 'N'}">
						<a href="../logoutNaver">로그아웃</a> &nbsp;&nbsp;&nbsp;
						<a href="../user/register_naver">추가정보 등록</a>&nbsp;&nbsp;&nbsp;
					</c:when>
				</c:choose>
					<a href="../mypage/mypage">마이페이지</a>&nbsp;&nbsp;&nbsp;
					<div id="localAddr"></div>
					<div id="weather" class="weatherBox">
						<img alt="weather" id="weatherIcon" src="${path}/resources/images/01d.png">
					</div>
				</div>
			</c:when>
			<c:when test="${login == null && kakaoaddcheck == null && naveraddcheck == null}">
				<div class="header_top_right">
					<a href="../user/login">로그인</a> &nbsp;&nbsp;&nbsp; 
					<a href="../user/register">회원가입</a>&nbsp;&nbsp;&nbsp; 
					<div id="localAddr"></div>
					<div id="weather" class="weatherBox">
						<img alt="weather" id="weatherIcon" src="${path}/resources/images/01d.png">
					</div>
					<!--   
					<input type="text"placeholder="search" />
					<button>검색</button>
					-->
				</div>		
			</c:when>
		</c:choose>	
      </div>
      <div id="menu_bar">
        <div class="menu_bar_property1">
          <div class="trade"><a href="../trade/used_trade.do?category=none">중고거래</a></div>
          <div class="category1">
            <div class="category1_word">
              <div class="category1_1"><a href="#">카테고리</a></div>
              <div class="category2">
                <table class="category2_table1">
                  <tr>
                    <td><a href="../trade/used_trade.do?category=furniture">가구</a></td>
                    <td><a href="../trade/used_trade.do?category=fabric">fabric</a></td>
                  </tr>
                  <tr>
                    <td><a href="../trade/used_trade.do?category=interior_prop">인테리어 소품</a></td>
                    <td><a href="../trade/used_trade.do?category=light">조명</a></td>
                  </tr>
                  <tr>
                    <td><a href="../trade/used_trade.do?category=storage_furniture">수납</a></td>
                    <td><a href="../trade/used_trade.do?category=life_bath">생활/욕실</a></td>
                  </tr>
                  <tr>
                    <td><a href="../trade/used_trade.do?category=kitchen">주방</a></td>
                    <td><a href="../trade/used_trade.do?category=diy">DIY</a></td>
                  </tr>
                </table>
              </div>
            </div>
            <div><a href="../trade/tr_board_list">자유 게시판</a></div>
          </div>
        </div>
        <div class="menu_bar_property2">
          <div class="interior">
          	<a href="../interior/interiorTip">인테리어</a>
          </div>
          <div class="category1">
            <div class="category1_word">
              <div class="category1_1">
                <a href="../interior/interiorTip">인테리어 팁</a>
              </div>
              <div class="category2">
                <table class="category2_table2">
                  <tr>
                    <td><a href="../interior/interiorTipList?category=construct">시공</a></td>
                    <td><a href="../interior/interiorTipList?category=storage">수납</a></td>
                  </tr>
                  <tr>
                    <td><a href="../interior/interiorTipList?category=decorate">꾸미기 팁</a></td>
                    <td><a href="../interior/interiorTipList?category=cleaning">청소</a></td>
                  </tr>
                  <tr>
                    <td><a href="../interior/interiorTipList?category=diy">DIY</a></td>
                    <td><a href="../interior/interiorTipList?category=reform">리폼</a></td>
                  </tr>
                  <tr>
                    <td><a href="../interior/interiorTipList?category=kitchen">주방/욕실</a></td>
                    <td><a href="../interior/interiorTipList?category=lighting">전기/조명</a></td>
                  </tr>
                </table>
              </div>
            </div>
            <div><a href="../interior/interiorList">시공상담</a></div>
          </div>
        </div>
        <div class="menu_bar_property3">
          <div class="customer"><a href="#">고객센터</a></div>
          <div class="category1">
            <div><a href="../customer/introduce">서비스 소개</a></div>
            <div><a href="../customer/qna_list">QNA</a></div>
            <div><a href="../customer/not_list">공지사항</a></div>
          </div>
        </div>
      </div>
    </header>
	</c:when>
	<c:otherwise>
		<header id="header_body">
      <div id="header_top">
        <div class="header_top_left">
          <img src="${path}/resources/images/dh_logo.png" />
          <a href="../main/mainpage">DE:home</a>
        </div>
        <c:choose>
			<c:when test="${login != null}">		 
				<div class="header_top_right">
					<a href="../logout.do">로그아웃</a> &nbsp;&nbsp;&nbsp;
					<a href="../mypage/mypage">마이페이지</a>&nbsp;&nbsp;&nbsp;
					<div id="localAddr"></div>
					<div id="weather" class="weatherBox">
						<img alt="weather" id="weatherIcon" src="${path}/resources/images/01d.png">
					</div>
					<!-- 
					<input type="text"placeholder="search" />
					<button>검색</button>
					 -->
				</div>
			</c:when>
			<c:when test="${(login == null && kakaoaddcheck != null) || (login == null && naveraddcheck != null)}">
				<div class="header_top_right">
				<c:choose>
					<c:when test="${kakaoaddcheck == 'Y'}">
						<a href="../logoutKakao">로그아웃</a> &nbsp;&nbsp;&nbsp;
					</c:when> 
					<c:when test="${kakaoaddcheck == 'N'}">
						<a href="../logoutKakao">로그아웃</a> &nbsp;&nbsp;&nbsp;
						<a href="../user/register_kakao">추가정보 등록</a>&nbsp;&nbsp;&nbsp;
					</c:when>
					<c:when test="${naveraddcheck == 'Y'}">
						<a href="../logoutNaver">로그아웃</a> &nbsp;&nbsp;&nbsp;
					</c:when> 
					<c:when test="${naveraddcheck == 'N'}">
						<a href="../logoutNaver">로그아웃</a> &nbsp;&nbsp;&nbsp;
						<a href="../user/register_naver">추가정보 등록</a>&nbsp;&nbsp;&nbsp;
					</c:when>
				</c:choose>
					<a href="../mypage/mypage">마이페이지</a>&nbsp;&nbsp;&nbsp;
					<div id="localAddr"></div>
					<div id="weather" class="weatherBox">
						<img alt="weather" id="weatherIcon" src="${path}/resources/images/01d.png">
					</div>
				</div>
			</c:when>
			<c:when test="${login == null && kakaoaddcheck == null && naveraddcheck == null}">
				<div class="header_top_right">
					<a href="../user/login">로그인</a> &nbsp;&nbsp;&nbsp; 
					<a href="../user/register">회원가입</a>&nbsp;&nbsp;&nbsp; 
					<div id="localAddr"></div>
					<div id="weather" class="weatherBox">
						<img alt="weather" id="weatherIcon" src="${path}/resources/images/01d.png">
					</div>
					<!--   
					<input type="text"placeholder="search" />
					<button>검색</button>
					-->
				</div>		
			</c:when>
		</c:choose>	
      </div>
      <div id="menu_bar">
        <div class="menu_bar_property1">
          <div class="trade"><a href="../user/login">중고거래</a></div>
          <div class="category1">
            <div class="category1_word">
              <div class="category1_1"><a href="#">카테고리</a></div>
              <div class="category2">
                <table class="category2_table1">
                  <tr>
                    <td><a href="../user/login">가구</a></td>
                    <td><a href="../user/login">fabric</a></td>
                  </tr>
                  <tr>
                    <td><a href="../user/login">인테리어 소품</a></td>
                    <td><a href="../user/login">조명</a></td>
                  </tr>
                  <tr>
                    <td><a href="../user/login">수납</a></td>
                    <td><a href="../user/login">생활/욕실</a></td>
                  </tr>
                  <tr>
                    <td><a href="../user/login">주방</a></td>
                    <td><a href="../user/login">DIY</a></td>
                  </tr>
                </table>
              </div>
            </div>
            <div><a href="../user/login">자유 게시판</a></div>
          </div>
        </div>
        <div class="menu_bar_property2">
          <div class="interior">
          	<a href="../user/login">인테리어</a>
          </div>
          <div class="category1">
            <div class="category1_word">
              <div class="category1_1">
                <a href="../user/login">인테리어 팁</a>
              </div>
              <div class="category2">
                <table class="category2_table2">
                  <tr>
                    <td><a href="../user/login">시공</a></td>
                    <td><a href="../user/login">수납</a></td>
                  </tr>
                  <tr>
                    <td><a href="../user/login">꾸미기 팁</a></td>
                    <td><a href="../user/login">청소</a></td>
                  </tr>
                  <tr>
                    <td><a href="../user/login">DIY</a></td>
                    <td><a href="../user/login">리폼</a></td>
                  </tr>
                  <tr>
                    <td><a href="../user/login">주방/욕실</a></td>
                    <td><a href="../user/login">전기/조명</a></td>
                  </tr>
                </table>
              </div>
            </div>
            <div><a href="../user/login">시공상담</a></div>
          </div>
        </div>
        <div class="menu_bar_property3">
          <div class="customer"><a href="#">고객센터</a></div>
          <div class="category1">
            <div><a href="../customer/introduce">서비스 소개</a></div>
            <div><a href="../user/login">QNA</a></div>
            <div><a href="../user/login">공지사항</a></div>
          </div>
        </div>
      </div>
    </header>
	</c:otherwise>
	</c:choose>
</body>
</html>