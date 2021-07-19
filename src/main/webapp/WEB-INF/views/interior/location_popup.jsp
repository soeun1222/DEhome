<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
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
    <link rel="stylesheet" href="${path}/resources/css/locpopup.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>	
	<script type="text/javascript" src="${path }/resources/js/interior.js" charset="utf-8"></script>
</head>
<body>
	<p class="title">업체리스트 주소 변경</p>
    <form method="post" name="loc_form">
        <div class="box1">
            <p class="sel_title">시/도</p>
            <select name="popup_addr1" id="select_first" onchange="select_top(this.value)">
                <option value="seoul">서울특별시</option>
                <option value="incheon">인천광역시</option>
                <option value="busan">부산광역시</option>
                <option value="ulsan">울산광역시</option>
                <option value="gwangju">광주광역시</option>
                <option value="daegu">대구광역시</option>
                <option value="daejeon">대전광역시</option>
                <option value="gyeonggi">경기도</option>
                <option value="gangwon">강원도</option>
                <option value="gyeongsangnamdo">경상남도</option>
                <option value="gyeongsangbukdo">경상북도</option>
                <option value="jeollanamdo">전라남도</option>
                <option value="jeollabukdo">전라북도</option>
                <option value="chungcheongnamdo">충청남도</option>
                <option value="chungcheongbukdo">충청북도</option>
                <option value="sejong">세종특별자치시</option>
                <option value="jeju">제주특별자치도</option>
            </select>
        </div>
		
        <div class="box2">
            <p class="sel_title">구/군</p>
            
            <!-- 서울_seoul -->
            <select name="seoul" class="select_second" id="seoul" style="display: inline-block;">
                <option value="seoul1">강남구</option>
                <option value="seoul2">강동구</option>
                <option value="seoul3">강북구</option>
                <option value="seoul4">강서구</option>
                <option value="seoul5">관악구</option>
                <option value="seoul6">광진구</option>
                <option value="seoul7">구로구</option>
                <option value="seoul8">금천구</option>
                <option value="seoul9">노원구</option>
                <option value="seoul10">도봉구</option>
                <option value="seoul11">동대문구</option>
                <option value="seoul12">동작구</option>
                <option value="seoul13">마포구</option>
                <option value="seoul14">서대문구</option>
                <option value="seoul15">서초구</option>
                <option value="seoul16">성동구</option>
                <option value="seoul17">성북구</option>
                <option value="seoul18">송파구</option>
                <option value="seoul19">양천구</option>
                <option value="seoul20">영등포구</option>
                <option value="seoul21">용산구</option>
                <option value="seoul22">은평구</option>
                <option value="seoul23">종로구</option>
                <option value="seoul24">중구</option>
                <option value="seoul25">중랑구</option>
            </select>
            
            <!-- 인천_incheon -->
            <select name="incheon" class="select_second" id="incheon" style="display: none;">
                <option value="incheon1">강화군</option>
                <option value="incheon2">계양구</option>
                <option value="incheon3">남동구</option>
                <option value="incheon4">동구</option>
                <option value="incheon5">미추홀구</option>
                <option value="incheon6">부평구</option>
                <option value="incheon7">서구</option>
                <option value="incheon8">연수구</option>
                <option value="incheon9">옹진군</option>
                <option value="incheon10">중구</option>
            </select>
            
            <!-- 부산_busan -->
            <select name="busan" class="select_second" id="busan" style="display: none;">
                <option value="busan1">강서구</option>
                <option value="busan2">금정구</option>
                <option value="busan3">기장군</option>
                <option value="busan4">남구</option>
                <option value="busan5">동구</option>
                <option value="busan6">동래구</option>
                <option value="busan7">부산진구</option>
                <option value="busan8">북구</option>
                <option value="busan9">사상구</option>
                <option value="busan10">사하구</option>
                <option value="busan11">서구</option>
                <option value="busan12">수영구</option>
                <option value="busan13">연제구</option>
                <option value="busan14">영도구</option>
                <option value="busan15">중구</option>
                <option value="busan16">해운대구</option>
            </select>
            
            <!-- 울산_ulsan -->
            <select name="ulsan" class="select_second" id="ulsan" style="display: none;">
                <option value="ulsan1">남구</option>
                <option value="ulsan2">동구</option>
                <option value="ulsan3">북구</option>
                <option value="ulsan4">울주군</option>
                <option value="ulsan5">중구</option>
            </select>
            
            <!-- 광주_gwangju -->
            <select name="gwangju" class="select_second" id="gwangju" style="display: none;">
                <option value="gwangju1">광산구</option>
                <option value="gwangju2">남구</option>
                <option value="gwangju3">동구</option>
                <option value="gwangju4">북구</option>
                <option value="gwangju5">서구</option>
            </select>
            
            <!-- 대구_daegu -->
            <select name="daegu" class="select_second" id="daegu" style="display: none;">
                <option value="daegu1">남구</option>
                <option value="daegu2">달서구</option>
                <option value="daegu3">달성군</option>
                <option value="daegu4">동구</option>
                <option value="daegu5">북구</option>
                <option value="daegu6">서구</option>
                <option value="daegu7">수성구</option>
                <option value="daegu8">중구</option>
            </select>
            
            <!-- 대전_daejeon -->
            <select name="daejeon" class="select_second" id="daejeon" style="display: none;">
                <option value="daejeon1">대덕구</option>
                <option value="daejeon2">동구</option>
                <option value="daejeon3">서구</option>
                <option value="daejeon4">유성구</option>
                <option value="daejeon5">중구</option>
            </select>
            
            <!-- 경기도_gyeonggi -->
            <select name="gyeonggi" class="select_second" id="gyeonggi" style="display: none;">
                <option value="gyeonggi1">가평군</option>
                <option value="gyeonggi2">고양시덕양구</option>
                <option value="gyeonggi3">고양시일산동구</option>
                <option value="gyeonggi4">고양시일산서구</option>
                <option value="gyeonggi5">과천시</option>
                <option value="gyeonggi6">광명시</option>
                <option value="gyeonggi7">광주시</option>
                <option value="gyeonggi8">구리시</option>
                <option value="gyeonggi9">군포시</option>
                <option value="gyeonggi10">김포시</option>
                <option value="gyeonggi11">남양주시</option>
                <option value="gyeonggi12">동두천시</option>
                <option value="gyeonggi13">부천시</option>
                <option value="gyeonggi14">성남시분당구</option>
                <option value="gyeonggi15">성남시수정구</option>
                <option value="gyeonggi16">성남시중원구</option>
                <option value="gyeonggi17">수원시권선구</option>
                <option value="gyeonggi18">수원시영통구</option>
                <option value="gyeonggi19">수원시장안구</option>
                <option value="gyeonggi20">수원시팔달구</option>
                <option value="gyeonggi21">시흥시</option>
                <option value="gyeonggi22">안산시단원구</option>
                <option value="gyeonggi23">안산시상록구</option>
                <option value="gyeonggi24">안성시</option>
                <option value="gyeonggi25">안양시동안구</option>
                <option value="gyeonggi26">안양시만안구</option>
                <option value="gyeonggi27">양주시</option>
                <option value="gyeonggi28">양평군</option>
                <option value="gyeonggi29">여주시</option>
                <option value="gyeonggi30">연천군</option>
                <option value="gyeonggi31">오산시</option>
                <option value="gyeonggi32">용인시기흥구</option>
                <option value="gyeonggi33">용인시수지구</option>
                <option value="gyeonggi34">용인시처인구</option>
                <option value="gyeonggi35">의왕시</option>
                <option value="gyeonggi36">의정부시</option>
                <option value="gyeonggi37">이천시</option>
                <option value="gyeonggi38">파주시</option>
                <option value="gyeonggi39">평택시</option>
                <option value="gyeonggi40">포천시</option>
                <option value="gyeonggi41">하남시</option>
                <option value="gyeonggi42">화성시</option>
            </select>
            
            <!-- 강원도_gangwon -->
            <select name="gangwon" class="select_second" id="gangwon" style="display: none;">
                <option value="gangwon1">강릉시</option>
                <option value="gangwon2">고성군</option>
                <option value="gangwon3">동해시</option>
                <option value="gangwon4">삼척시</option>
                <option value="gangwon5">속초시</option>
                <option value="gangwon6">양구군</option>
                <option value="gangwon7">양양군</option>
                <option value="gangwon8">영월군</option>
                <option value="gangwon9">원주시</option>
                <option value="gangwon10">인제군</option>
                <option value="gangwon11">정선군</option>
                <option value="gangwon12">철원군</option>
                <option value="gangwon13">춘천시</option>
                <option value="gangwon14">태백시</option>
                <option value="gangwon15">평창군</option>
                <option value="gangwon16">홍천군</option>
                <option value="gangwon17">화천군</option>
                <option value="gangwon18">횡성군</option>
            </select>
            
            <!-- 경상남도_gyeongsangnamdo -->
            <select name="gyeongsangnamdo" class="select_second" id="gyeongsangnamdo" style="display: none;">
                <option value="gyeongsangnamdo1">거제시</option>
                <option value="gyeongsangnamdo2">거창군</option>
                <option value="gyeongsangnamdo3">고성군</option>
                <option value="gyeongsangnamdo4">김해시</option>
                <option value="gyeongsangnamdo5">남해군</option>
                <option value="gyeongsangnamdo6">밀양시</option>
                <option value="gyeongsangnamdo7">사천시</option>
                <option value="gyeongsangnamdo8">산청군</option>
                <option value="gyeongsangnamdo9">양산시</option>
                <option value="gyeongsangnamdo10">의령군</option>
                <option value="gyeongsangnamdo11">진주시</option>
                <option value="gyeongsangnamdo12">창녕군</option>
                <option value="gyeongsangnamdo13">창원시 마산합포구</option>
                <option value="gyeongsangnamdo14">창원시 마산회원구</option>
                <option value="gyeongsangnamdo15">창원시 성산구</option>
                <option value="gyeongsangnamdo16">창원시 의창구</option>
                <option value="gyeongsangnamdo17">창원시 진해구</option>
                <option value="gyeongsangnamdo18">통영시</option>
                <option value="gyeongsangnamdo19">하동군</option>
                <option value="gyeongsangnamdo20">함안군</option>
                <option value="gyeongsangnamdo21">함양군</option>
                <option value="gyeongsangnamdo22">합천군</option>
            </select>
            
            <!-- 경상북도_gyeongsangbukdo -->
            <select name="gyeongsangbukdo" class="select_second" id="gyeongsangbukdo" style="display: none;">
                <option value="gyeongsangbukdo1">경산시</option>
                <option value="gyeongsangbukdo2">경주시</option>
                <option value="gyeongsangbukdo3">고령군</option>
                <option value="gyeongsangbukdo4">구미시</option>
                <option value="gyeongsangbukdo5">군위군</option>
                <option value="gyeongsangbukdo6">김천시</option>
                <option value="gyeongsangbukdo7">문경시</option>
                <option value="gyeongsangbukdo8">봉화군</option>
                <option value="gyeongsangbukdo9">상주시</option>
                <option value="gyeongsangbukdo10">성주군</option>
                <option value="gyeongsangbukdo11">안동시</option>
                <option value="gyeongsangbukdo12">영덕군</option>
                <option value="gyeongsangbukdo13">영양군</option>
                <option value="gyeongsangbukdo14">영주시</option>
                <option value="gyeongsangbukdo15">영천시</option>
                <option value="gyeongsangbukdo16">예천군</option>
                <option value="gyeongsangbukdo17">울릉군</option>
                <option value="gyeongsangbukdo18">울진군</option>
                <option value="gyeongsangbukdo19">의성군</option>
                <option value="gyeongsangbukdo20">청도군</option>
                <option value="gyeongsangbukdo21">청송군</option>
                <option value="gyeongsangbukdo22">칠곡군</option>
                <option value="gyeongsangbukdo23">포항시 남구</option>
                <option value="gyeongsangbukdo24">포항시 북구</option>
            </select>
            
            <!-- 전라남도_jeollanamdo -->
            <select name="jeollanamdo" class="select_second" id="jeollanamdo" style="display: none;">
                <option value="jeollanamdo1">강진군</option>
                <option value="jeollanamdo2">고흥군</option>
                <option value="jeollanamdo3">곡성군</option>
                <option value="jeollanamdo4">광양시</option>
                <option value="jeollanamdo5">구례군</option>
                <option value="jeollanamdo6">나주시</option>
                <option value="jeollanamdo7">담양군</option>
                <option value="jeollanamdo8">목포시</option>
                <option value="jeollanamdo9">무안군</option>
                <option value="jeollanamdo10">보성군</option>
                <option value="jeollanamdo11">순천시</option>
                <option value="jeollanamdo12">신안군</option>
                <option value="jeollanamdo13">여수시</option>
                <option value="jeollanamdo14">영광군</option>
                <option value="jeollanamdo15">영암군</option>
                <option value="jeollanamdo16">완도군</option>
                <option value="jeollanamdo17">장성군</option>
                <option value="jeollanamdo18">장흥군</option>
                <option value="jeollanamdo19">진도군</option>
                <option value="jeollanamdo20">함평군</option>
                <option value="jeollanamdo21">해남군</option>
                <option value="jeollanamdo22">화순군</option>
            </select>
            
            <!-- 전라북도_jeollabukdo -->
            <select name="jeollabukdo" class="select_second" id="jeollabukdo" style="display: none;">
                <option value="jeollabukdo1">고창군</option>
                <option value="jeollabukdo2">군산시</option>
                <option value="jeollabukdo3">김제시</option>
                <option value="jeollabukdo4">남원시</option>
                <option value="jeollabukdo5">무주군</option>
                <option value="jeollabukdo6">부안군</option>
                <option value="jeollabukdo7">순창군</option>
                <option value="jeollabukdo8">완주군</option>
                <option value="jeollabukdo9">익산시</option>
                <option value="jeollabukdo10">임실군</option>
                <option value="jeollabukdo11">장수군</option>
                <option value="jeollabukdo12">전주시 덕진구</option>
                <option value="jeollabukdo13">전주시 완산구</option>
                <option value="jeollabukdo14">정읍시</option>
                <option value="jeollabukdo15">진안군</option>
            </select>
            
            <!-- 충청남도_chungcheongnamdo -->
            <select name="chungcheongnamdo" class="select_second" id="chungcheongnamdo" style="display: none;">
                <option value="chungcheongnamdo1">계룡시</option>
                <option value="chungcheongnamdo2">공주시</option>
                <option value="chungcheongnamdo3">금산군</option>
                <option value="chungcheongnamdo4">논산시</option>
                <option value="chungcheongnamdo5">당진시</option>
                <option value="chungcheongnamdo6">보령시</option>
                <option value="chungcheongnamdo7">부여군</option>
                <option value="chungcheongnamdo8">서산시</option>
                <option value="chungcheongnamdo9">서천군</option>
                <option value="chungcheongnamdo10">아산시</option>
                <option value="chungcheongnamdo11">예산군</option>
                <option value="chungcheongnamdo12">천안시 동남구</option>
                <option value="chungcheongnamdo13">천안시 서북구</option>
                <option value="chungcheongnamdo14">청양군</option>
                <option value="chungcheongnamdo15">태안군</option>
                <option value="chungcheongnamdo16">홍성군</option>
            </select>
            
            <!-- 충청북도_chungcheongbukdo -->
            <select name="chungcheongbukdo" class="select_second" id="chungcheongbukdo" style="display: none;">
                <option value="chungcheongbukdo1">괴산군</option>
                <option value="chungcheongbukdo2">단양군</option>
                <option value="chungcheongbukdo3">보은군</option>
                <option value="chungcheongbukdo4">영동군</option>
                <option value="chungcheongbukdo5">옥천군</option>
                <option value="chungcheongbukdo6">음성군</option>
                <option value="chungcheongbukdo7">제천시</option>
                <option value="chungcheongbukdo8">증평군</option>
                <option value="chungcheongbukdo9">진천군</option>
                <option value="chungcheongbukdo10">청주시 상당구</option>
                <option value="chungcheongbukdo11">청주시 서원구</option>
                <option value="chungcheongbukdo12">청주시 청원구</option>
                <option value="chungcheongbukdo13">청주시 흥덕구</option>
                <option value="chungcheongbukdo14">충주시</option>
            </select>
            
            <!-- 세종특별자치시_sejong -->
            <select name="sejong" class="select_second" id="sejong" style="display: none;">
                <option value="sejong1">고운동</option>
                <option value="sejong2">금남면</option>
                <option value="sejong3">다정동</option>
                <option value="sejong4">대평동</option>
                <option value="sejong5">도담동</option>
                <option value="sejong6">보람동</option>
                <option value="sejong7">부강면</option>
                <option value="sejong8">새롬동</option>
                <option value="sejong9">소담동</option>
                <option value="sejong10">소정면</option>
                <option value="sejong11">아름동</option>
                <option value="sejong12">연기면</option>
                <option value="sejong13">연동면</option>
                <option value="sejong14">연서면</option>
                <option value="sejong15">장군면</option>
                <option value="sejong16">전동면</option>
                <option value="sejong17">전의면</option>
                <option value="sejong18">조치원읍</option>
                <option value="sejong19">종촌동</option>
                <option value="sejong20">한솔동</option>
            </select>
            
            <!-- 제주특별자치도_jeju -->
            <select name="jeju" class="select_second" id="jeju" style="display: none;">
                <option value="jeju1">서귀포시</option>
                <option value="jeju2">이어도</option>
                <option value="jeju3">제주시</option>
            </select>
        </div>	
		<input type="button" value="주소보내기" onclick="location_ok()">
    </form>
</body>
</html>