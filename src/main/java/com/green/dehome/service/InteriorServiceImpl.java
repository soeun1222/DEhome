package com.green.dehome.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.green.dehome.dao.InteriorDAO;
import com.green.dehome.dto.InteriorDTO;

@Service
public class InteriorServiceImpl implements InteriorService {
	
	@Inject InteriorDAO dao;

	@Override
	public String userAddr(String user_nick) throws Exception {
		return dao.userAddr(user_nick);
	}
	
	@Override
	public String addrKor(String popup_addr1, String popup_addr2) throws Exception {
		
		//popup_addr1 한글처리
		String addr1_kor = null;
		
		switch (popup_addr1) {
		case "seoul":
			addr1_kor = "서울";
			break;
		case "incheon":
			addr1_kor = "인천";
			break;
		case "busan":
			addr1_kor = "부산";
			break;
		case "ulsan":
			addr1_kor = "울산";
			break;
		case "gwangju":
			addr1_kor = "광주";
			break;
		case "daegu":
			addr1_kor = "대구";
			break;
		case "daejeon":
			addr1_kor = "대전";
			break;
		case "gyeonggi":
			addr1_kor = "경기도";
			break;
		case "gangwon":
			addr1_kor = "강원도";
			break;
		case "gyeongsangnamdo":
			addr1_kor = "경남";
			break;
		case "gyeongsangbukdo":
			addr1_kor = "경북";
			break;
		case "jeollanamdo":
			addr1_kor = "전남";
			break;
		case "jeollabukdo":
			addr1_kor = "전북";
			break;
		case "chungcheongnamdo":
			addr1_kor = "충남";
			break;
		case "chungcheongbukdo":
			addr1_kor = "충북";
			break;
		case "sejong":
			addr1_kor = "세종특별자치시";
			break;
		case "jeju":
			addr1_kor = "제주특별자치도";
			break;
		}
		
		//popup_addr2 한글처리
		String addr2_kor = null;
		switch (popup_addr2) {
		
		//서울
		case "seoul1":
			addr2_kor = "강남구";
			break;
		case "seoul2":
			addr2_kor = "강동구";
			break;
		case "seoul3":
			addr2_kor = "강북구";
			break;
		case "seoul4":
			addr2_kor = "강서구";
			break;
		case "seoul5":
			addr2_kor = "관악구";
			break;
		case "seoul6":
			addr2_kor = "광진구";
			break;
		case "seoul7":
			addr2_kor = "구로구";
			break;
		case "seoul8":
			addr2_kor = "금천구";
			break;
		case "seoul9":
			addr2_kor = "노원구";
			break;
		case "seoul10":
			addr2_kor = "도봉구";
			break;
		case "seoul11":
			addr2_kor = "동대문구";
			break;
		case "seoul12":
			addr2_kor = "동작구";
			break;
		case "seoul13":
			addr2_kor = "마포구";
			break;
		case "seoul14":
			addr2_kor = "서대문구";
			break;
		case "seoul15":
			addr2_kor = "서초구";
			break;
		case "seoul16":
			addr2_kor = "성동구";
			break;
		case "seoul17":
			addr2_kor = "성북구";
			break;
		case "seoul18":
			addr2_kor = "송파구";
			break;
		case "seoul19":
			addr2_kor = "양천구";
			break;
		case "seoul20":
			addr2_kor = "영등포구";
			break;
		case "seoul21":
			addr2_kor = "용산구";
			break;
		case "seoul22":
			addr2_kor = "은평구";
			break;
		case "seoul23":
			addr2_kor = "종로구";
			break;
		case "seoul24":
			addr2_kor = "중구";
			break;
		case "seoul25":
			addr2_kor = "중랑구";
			break;
			
		//인천	
		case "incheon1":
			addr2_kor = "강화군";
			break;
		case "incheon2":
			addr2_kor = "계양구";
			break;
		case "incheon3":
			addr2_kor = "남동구";
			break;
		case "incheon4":
			addr2_kor = "동구";
			break;
		case "incheon5":
			addr2_kor = "미추홀구";
			break;
		case "incheon6":
			addr2_kor = "부평구";
			break;
		case "incheon7":
			addr2_kor = "서구";
			break;
		case "incheon8":
			addr2_kor = "연수구";
			break;
		case "incheon9":
			addr2_kor = "옹진군";
			break;
		case "incheon10":
			addr2_kor = "중구";
			break;
			
		//부산
		case "busan1":
			addr2_kor = "강서구";
			break;
		case "busan2":
			addr2_kor = "금정구";
			break;
		case "busan3":
			addr2_kor = "기장군";
			break;
		case "busan4":
			addr2_kor = "남구";
			break;
		case "busan5":
			addr2_kor = "동구";
			break;
		case "busan6":
			addr2_kor = "동래구";
			break;
		case "busan7":
			addr2_kor = "부산진구";
			break;
		case "busan8":
			addr2_kor = "북구";
			break;
		case "busan9":
			addr2_kor = "사상구";
			break;
		case "busan10":
			addr2_kor = "사하구";
			break;
		case "busan11":
			addr2_kor = "서구";
			break;
		case "busan12":
			addr2_kor = "수영구";
			break;
		case "busan13":
			addr2_kor = "연제구";
			break;
		case "busan14":
			addr2_kor = "영도구";
			break;
		case "busan15":
			addr2_kor = "중구";
			break;
		case "busan16":
			addr2_kor = "해운대구";
			break;
			
		//울산	
		case "ulsan1":
			addr2_kor = "남구";
			break;
		case "ulsan2":
			addr2_kor = "동구";
			break;
		case "ulsan3":
			addr2_kor = "북구";
			break;
		case "ulsan4":
			addr2_kor = "울주군";
			break;
		case "ulsan5":
			addr2_kor = "중구";
			break;
			
		//광주
		case "gwangju1":
			addr2_kor = "광산구";
			break;
		case "gwangju2":
			addr2_kor = "남구";
			break;
		case "gwangju3":
			addr2_kor = "동구";
			break;
		case "gwangju4":
			addr2_kor = "북구";
			break;
		case "gwangju5":
			addr2_kor = "서구";
			break;
			
		//대구
		case "daegu1":
			addr2_kor = "남구";
			break;
		case "daegu2":
			addr2_kor = "달서구";
			break;
		case "daegu3":
			addr2_kor = "달성군";
			break;
		case "daegu4":
			addr2_kor = "동구";
			break;
		case "daegu5":
			addr2_kor = "북구";
			break;
		case "daegu6":
			addr2_kor = "서구";
			break;
		case "daegu7":
			addr2_kor = "수성구";
			break;
		case "daegu8":
			addr2_kor = "중구";
			break;
			
		//대전
		case "daejeon1":
			addr2_kor = "대덕구";
			break;	
		case "daejeon2":
			addr2_kor = "동구";
			break;	
		case "daejeon3":
			addr2_kor = "서구";
			break;	
		case "daejeon4":
			addr2_kor = "유성구";
			break;	
		case "daejeon5":
			addr2_kor = "중구";
			break;	
			
		//경기도
		case "gyeonggi1":
			addr2_kor = "가평군";
			break;		
		case "gyeonggi2":
			addr2_kor = "고양시덕양구";
			break;		
		case "gyeonggi3":
			addr2_kor = "고양시일산동구";
			break;		
		case "gyeonggi4":
			addr2_kor = "고양시일산서구";
			break;		
		case "gyeonggi5":
			addr2_kor = "과천시";
			break;		
		case "gyeonggi6":
			addr2_kor = "광명시";
			break;		
		case "gyeonggi7":
			addr2_kor = "광주시";
			break;		
		case "gyeonggi8":
			addr2_kor = "구리시";
			break;		
		case "gyeonggi9":
			addr2_kor = "군포시";
			break;		
		case "gyeonggi10":
			addr2_kor = "김포시";
			break;		
		case "gyeonggi11":
			addr2_kor = "남양주시";
			break;		
		case "gyeonggi12":
			addr2_kor = "동두천시";
			break;		
		case "gyeonggi13":
			addr2_kor = "부천시";
			break;		
		case "gyeonggi14":
			addr2_kor = "성남시분당구";
			break;		
		case "gyeonggi15":
			addr2_kor = "성남시수정구";
			break;		
		case "gyeonggi16":
			addr2_kor = "성남시중원구";
			break;		
		case "gyeonggi17":
			addr2_kor = "수원시권선구";
			break;		
		case "gyeonggi18":
			addr2_kor = "수원시영통구";
			break;		
		case "gyeonggi19":
			addr2_kor = "수원시장안구";
			break;		
		case "gyeonggi20":
			addr2_kor = "수원시팔달구";
			break;		
		case "gyeonggi21":
			addr2_kor = "시흥시";
			break;		
		case "gyeonggi22":
			addr2_kor = "안산시단원구";
			break;		
		case "gyeonggi23":
			addr2_kor = "안산시상록구";
			break;		
		case "gyeonggi24":
			addr2_kor = "안성시";
			break;		
		case "gyeonggi25":
			addr2_kor = "안양시동안구";
			break;		
		case "gyeonggi26":
			addr2_kor = "안양시만안구";
			break;		
		case "gyeonggi27":
			addr2_kor = "양주시";
			break;		
		case "gyeonggi28":
			addr2_kor = "양평군";
			break;		
		case "gyeonggi29":
			addr2_kor = "여주시";
			break;		
		case "gyeonggi30":
			addr2_kor = "연천군";
			break;		
		case "gyeonggi31":
			addr2_kor = "오산시";
			break;		
		case "gyeonggi32":
			addr2_kor = "용인시기흥구";
			break;		
		case "gyeonggi33":
			addr2_kor = "용인시수지구";
			break;		
		case "gyeonggi34":
			addr2_kor = "용인시처인구";
			break;		
		case "gyeonggi35":
			addr2_kor = "의왕시";
			break;		
		case "gyeonggi36":
			addr2_kor = "의정부시";
			break;		
		case "gyeonggi37":
			addr2_kor = "이천시";
			break;		
		case "gyeonggi38":
			addr2_kor = "파주시";
			break;		
		case "gyeonggi39":
			addr2_kor = "평택시";
			break;		
		case "gyeonggi40":
			addr2_kor = "포천시";
			break;		
		case "gyeonggi41":
			addr2_kor = "하남시";
			break;		
		case "gyeonggi42":
			addr2_kor = "화성시";
			break;	
			
		//강원도
		case "gangwon1":
			addr2_kor = "강릉시";
			break;
		case "gangwon2":
			addr2_kor = "고성군";
			break;
		case "gangwon3":
			addr2_kor = "동해시";
			break;
		case "gangwon4":
			addr2_kor = "삼척시";
			break;
		case "gangwon5":
			addr2_kor = "속초시";
			break;
		case "gangwon6":
			addr2_kor = "양구군";
			break;
		case "gangwon7":
			addr2_kor = "양양군";
			break;
		case "gangwon8":
			addr2_kor = "영월군";
			break;
		case "gangwon9":
			addr2_kor = "원주시";
			break;
		case "gangwon10":
			addr2_kor = "인제군";
			break;
		case "gangwon11":
			addr2_kor = "정선군";
			break;
		case "gangwon12":
			addr2_kor = "철원군";
			break;
		case "gangwon13":
			addr2_kor = "춘천시";
			break;
		case "gangwon14":
			addr2_kor = "태백시";
			break;
		case "gangwon15":
			addr2_kor = "평창군";
			break;
		case "gangwon16":
			addr2_kor = "홍천군";
			break;
		case "gangwon17":
			addr2_kor = "화천군";
			break;
		case "gangwon18":
			addr2_kor = "횡성군";
			break;
			
			
		//경상남도
		case "gyeongsangnamdo1":
			addr2_kor = "거제시";
			break;
		case "gyeongsangnamdo2":
			addr2_kor = "거창군";
			break;
		case "gyeongsangnamdo3":
			addr2_kor = "고성군";
			break;
		case "gyeongsangnamdo4":
			addr2_kor = "김해시";
			break;
		case "gyeongsangnamdo5":
			addr2_kor = "남해군";
			break;
		case "gyeongsangnamdo6":
			addr2_kor = "밀양시";
			break;
		case "gyeongsangnamdo7":
			addr2_kor = "사천시";
			break;
		case "gyeongsangnamdo8":
			addr2_kor = "산청군";
			break;
		case "gyeongsangnamdo9":
			addr2_kor = "양산시";
			break;
		case "gyeongsangnamdo10":
			addr2_kor = "의령군";
			break;
		case "gyeongsangnamdo11":
			addr2_kor = "진주시";
			break;
		case "gyeongsangnamdo12":
			addr2_kor = "창녕군";
			break;
		case "gyeongsangnamdo13":
			addr2_kor = "창원시 마산합포구";
			break;
		case "gyeongsangnamdo14":
			addr2_kor = "창원시 마산회원구";
			break;
		case "gyeongsangnamdo15":
			addr2_kor = "창원시 성산구";
			break;
		case "gyeongsangnamdo16":
			addr2_kor = "창원시 의창구";
			break;
		case "gyeongsangnamdo17":
			addr2_kor = "창원시 진해구";
			break;
		case "gyeongsangnamdo18":
			addr2_kor = "통영시";
			break;
		case "gyeongsangnamdo19":
			addr2_kor = "하동군";
			break;
		case "gyeongsangnamdo20":
			addr2_kor = "함안군";
			break;
		case "gyeongsangnamdo21":
			addr2_kor = "함양군";
			break;
		case "gyeongsangnamdo22":
			addr2_kor = "합천군";
			break;
			
		//경상북도
		case "gyeongsangbukdo1":
			addr2_kor = "경산시";
			break;
		case "gyeongsangbukdo2":
			addr2_kor = "경주시";
			break;
		case "gyeongsangbukdo3":
			addr2_kor = "고령군";
			break;
		case "gyeongsangbukdo4":
			addr2_kor = "구미시";
			break;
		case "gyeongsangbukdo5":
			addr2_kor = "군위군";
			break;
		case "gyeongsangbukdo6":
			addr2_kor = "김천시";
			break;
		case "gyeongsangbukdo7":
			addr2_kor = "문경시";
			break;
		case "gyeongsangbukdo8":
			addr2_kor = "봉화군";
			break;
		case "gyeongsangbukdo9":
			addr2_kor = "상주시";
			break;
		case "gyeongsangbukdo10":
			addr2_kor = "성주군";
			break;
		case "gyeongsangbukdo11":
			addr2_kor = "안동시";
			break;
		case "gyeongsangbukdo12":
			addr2_kor = "영덕군";
			break;
		case "gyeongsangbukdo13":
			addr2_kor = "영양군";
			break;
		case "gyeongsangbukdo14":
			addr2_kor = "영주시";
			break;
		case "gyeongsangbukdo15":
			addr2_kor = "영천시";
			break;
		case "gyeongsangbukdo16":
			addr2_kor = "예천군";
			break;
		case "gyeongsangbukdo17":
			addr2_kor = "울릉군";
			break;
		case "gyeongsangbukdo18":
			addr2_kor = "울진군";
			break;
		case "gyeongsangbukdo19":
			addr2_kor = "의성군";
			break;
		case "gyeongsangbukdo20":
			addr2_kor = "청도군";
			break;
		case "gyeongsangbukdo21":
			addr2_kor = "청송군";
			break;
		case "gyeongsangbukdo22":
			addr2_kor = "칠곡군";
			break;
		case "gyeongsangbukdo23":
			addr2_kor = "포항시 남구";
			break;
		case "gyeongsangbukdo24":
			addr2_kor = "포항시 북구";
			break;
			
			
		//전라남도
		case "jeollanamdo1":
			addr2_kor = "강진군";
			break;
		case "jeollanamdo2":
			addr2_kor = "고흥군";
			break;
		case "jeollanamdo3":
			addr2_kor = "곡성군";
			break;
		case "jeollanamdo4":
			addr2_kor = "광양시";
			break;
		case "jeollanamdo5":
			addr2_kor = "구례군";
			break;
		case "jeollanamdo6":
			addr2_kor = "나주시";
			break;
		case "jeollanamdo7":
			addr2_kor = "담양군";
			break;
		case "jeollanamdo8":
			addr2_kor = "목포시";
			break;
		case "jeollanamdo9":
			addr2_kor = "무안군";
			break;
		case "jeollanamdo10":
			addr2_kor = "보성군";
			break;
		case "jeollanamdo11":
			addr2_kor = "순천시";
			break;
		case "jeollanamdo12":
			addr2_kor = "신안군";
			break;
		case "jeollanamdo13":
			addr2_kor = "여수시";
			break;
		case "jeollanamdo14":
			addr2_kor = "영광군";
			break;
		case "jeollanamdo15":
			addr2_kor = "영암군";
			break;
		case "jeollanamdo16":
			addr2_kor = "완도군";
			break;
		case "jeollanamdo17":
			addr2_kor = "장성군";
			break;
		case "jeollanamdo18":
			addr2_kor = "장흥군";
			break;
		case "jeollanamdo19":
			addr2_kor = "진도군";
			break;
		case "jeollanamdo20":
			addr2_kor = "함평군";
			break;
		case "jeollanamdo21":
			addr2_kor = "해남군";
			break;
		case "jeollanamdo22":
			addr2_kor = "화순군";
			break;
		
			
		//전라북도
		case "jeollabukdo1":
			addr2_kor = "고창군";
			break;
		case "jeollabukdo2":
			addr2_kor = "군산시";
			break;
		case "jeollabukdo3":
			addr2_kor = "김제시";
			break;
		case "jeollabukdo4":
			addr2_kor = "남원시";
			break;
		case "jeollabukdo5":
			addr2_kor = "무주군";
			break;
		case "jeollabukdo6":
			addr2_kor = "부안군";
			break;
		case "jeollabukdo7":
			addr2_kor = "순창군";
			break;
		case "jeollabukdo8":
			addr2_kor = "완주군";
			break;
		case "jeollabukdo9":
			addr2_kor = "익산시";
			break;
		case "jeollabukdo10":
			addr2_kor = "임실군";
			break;
		case "jeollabukdo11":
			addr2_kor = "장수군";
			break;
		case "jeollabukdo12":
			addr2_kor = "전주시 덕진구";
			break;
		case "jeollabukdo13":
			addr2_kor = "전주시 완산구";
			break;
		case "jeollabukdo14":
			addr2_kor = "정읍시";
			break;
		case "jeollabukdo15":
			addr2_kor = "진안군";
			break;
		
			
		//충청남도
		case "chungcheongnamdo1":
			addr2_kor = "계룡시";
			break;
		case "chungcheongnamdo2":
			addr2_kor = "공주시";
			break;
		case "chungcheongnamdo3":
			addr2_kor = "금산군";
			break;
		case "chungcheongnamdo4":
			addr2_kor = "논산시";
			break;
		case "chungcheongnamdo5":
			addr2_kor = "당진시";
			break;
		case "chungcheongnamdo6":
			addr2_kor = "보령시";
			break;
		case "chungcheongnamdo7":
			addr2_kor = "부여군";
			break;
		case "chungcheongnamdo8":
			addr2_kor = "서산시";
			break;
		case "chungcheongnamdo9":
			addr2_kor = "서천군";
			break;
		case "chungcheongnamdo10":
			addr2_kor = "아산시";
			break;
		case "chungcheongnamdo11":
			addr2_kor = "예산군";
			break;
		case "chungcheongnamdo12":
			addr2_kor = "천안시 동남구";
			break;
		case "chungcheongnamdo13":
			addr2_kor = "천안시 서북구";
			break;
		case "chungcheongnamdo14":
			addr2_kor = "청양군";
			break;
		case "chungcheongnamdo15":
			addr2_kor = "태안군";
			break;
		case "chungcheongnamdo16":
			addr2_kor = "홍성군";
			break;
			
			
		//충청북도
		case "chungcheongbukdo1":
			addr2_kor = "괴산군";
			break;
		case "chungcheongbukdo2":
			addr2_kor = "단양군";
			break;
		case "chungcheongbukdo3":
			addr2_kor = "보은군";
			break;
		case "chungcheongbukdo4":
			addr2_kor = "영동군";
			break;
		case "chungcheongbukdo5":
			addr2_kor = "옥천군";
			break;
		case "chungcheongbukdo6":
			addr2_kor = "음성군";
			break;
		case "chungcheongbukdo7":
			addr2_kor = "제천시";
			break;
		case "chungcheongbukdo8":
			addr2_kor = "증평군";
			break;
		case "chungcheongbukdo9":
			addr2_kor = "진천군";
			break;
		case "chungcheongbukdo10":
			addr2_kor = "청주시 상당구";
			break;
		case "chungcheongbukdo11":
			addr2_kor = "청주시 서원구";
			break;
		case "chungcheongbukdo12":
			addr2_kor = "청주시 청원구";
			break;
		case "chungcheongbukdo13":
			addr2_kor = "청주시 흥덕구";
			break;
		case "chungcheongbukdo14":
			addr2_kor = "충주시";
			break;
			
			
		//세종특별자치시
		case "sejong1":
			addr2_kor = "고운동";
			break;
		case "sejong2":
			addr2_kor = "금남면";
			break;
		case "sejong3":
			addr2_kor = "다정동";
			break;
		case "sejong4":
			addr2_kor = "대평동";
			break;
		case "sejong5":
			addr2_kor = "도담동";
			break;
		case "sejong6":
			addr2_kor = "보람동";
			break;
		case "sejong7":
			addr2_kor = "부강면";
			break;
		case "sejong8":
			addr2_kor = "새롬동";
			break;
		case "sejong9":
			addr2_kor = "소담동";
			break;
		case "sejong10":
			addr2_kor = "소정면";
			break;
		case "sejong11":
			addr2_kor = "아름동";
			break;
		case "sejong12":
			addr2_kor = "연기면";
			break;
		case "sejong13":
			addr2_kor = "연동면";
			break;
		case "sejong14":
			addr2_kor = "연서면";
			break;
		case "sejong15":
			addr2_kor = "장군면";
			break;
		case "sejong16":
			addr2_kor = "전동면";
			break;
		case "sejong17":
			addr2_kor = "전의면";
			break;
		case "sejong18":
			addr2_kor = "조치원읍";
			break;
		case "sejong19":
			addr2_kor = "종촌동";
			break;
		case "sejong20":
			addr2_kor = "한솔동";
			break;
			
			
		//제주특별자치도
		case "jeju1":
			addr2_kor = "서귀포시";
			break;
		case "jeju2":
			addr2_kor = "이어도";
			break;
		case "jeju3":
			addr2_kor = "제주시";
			break;

		}
		
		return addr1_kor + " " + addr2_kor;
	}

	@Override
	public List<InteriorDTO> locList(String addr) throws Exception {
		return dao.locList(addr);
	}

	@Override
	public List<InteriorDTO> moreLocList(InteriorDTO dto) throws Exception {
		return dao.moreLocList(dto);
	}

	@Override
	public String userComName(String user_nick) throws Exception {
		return dao.userComName(user_nick);
	}

	@Override
	public InteriorDTO companyInfo(InteriorDTO dto) throws Exception {
		return dao.companyInfo(dto);
	}

	@Override
	public List<InteriorDTO> comReivew(String com_name) throws Exception {
		return dao.comReivew(com_name);
	}

	@Override
	public List<InteriorDTO> moreReList(InteriorDTO dto) throws Exception {
		return dao.moreReList(dto);
	}

	@Override
	public List<InteriorDTO> comExample(String com_name) throws Exception {
		return dao.comExample(com_name);
	}

	@Override
	public List<InteriorDTO> moreExList(InteriorDTO dto) throws Exception {
		return dao.moreExList(dto);
	}

	@Override
	public List<String> notInCompany() throws Exception {
		return dao.notInCompany();
	}

	@Override
	public void companyRegist(InteriorDTO dto) throws Exception {
		dao.companyRegist(dto);
		
	}

	@Override
	public void reviewRegist(InteriorDTO dto) throws Exception {
		dao.reviewRegist(dto);
		
	}

	@Override
	public void reSum(InteriorDTO dto) throws Exception {
		dao.reSum(dto);
		
	}

	@Override
	public void reCount(InteriorDTO dto) throws Exception {
		dao.reCount(dto);
		
	}

	@Override
	public void reRating(InteriorDTO dto) throws Exception {
		dao.reRating(dto);
		
	}

	@Override
	public InteriorDTO reviewShow(InteriorDTO dto) throws Exception {
		return dao.reviewShow(dto);
	}
	
	@Override
	public InteriorDTO likeOnOff(InteriorDTO dto) throws Exception {
		return dao.likeOnOff(dto);
	}

	@Override
	public void reviewLikeOn(InteriorDTO dto) throws Exception {
		dao.reviewLikeOn(dto);
		
	}

	@Override
	public void reInterestCountUp(InteriorDTO dto) throws Exception {
		dao.reInterestCountUp(dto);
		
	}

	@Override
	public void reviewLikeOff(InteriorDTO dto) throws Exception {
		dao.reviewLikeOff(dto);
		
	}

	@Override
	public void reInterestCountDown(InteriorDTO dto) throws Exception {
		dao.reInterestCountDown(dto);
		
	}

	@Override
	public String likeCount(InteriorDTO dto) throws Exception {
		return dao.likeCount(dto);
	}

	@Override
	public void exRegist(InteriorDTO dto) throws Exception {
		dao.exRegist(dto);
		
	}

	@Override
	public void exCount(InteriorDTO dto) throws Exception {
		dao.exCount(dto);
		
	}

	@Override
	public InteriorDTO exShow(InteriorDTO dto) throws Exception {
		return dao.exShow(dto);
	}

	@Override
	public void comEdit(InteriorDTO dto) throws Exception {
		dao.comEdit(dto);
		
	}

	@Override
	public void comEditFile(InteriorDTO dto) throws Exception {
		dao.comEditFile(dto);
		
	}

	@Override
	public void reEdit(InteriorDTO dto) throws Exception {
		dao.reEdit(dto);
		
	}

	@Override
	public void reEditFile(InteriorDTO dto) throws Exception {
		dao.reEditFile(dto);
		
	}

	@Override
	public void reDelete(InteriorDTO dto) throws Exception {
		dao.reDelete(dto);
		
	}
	
	@Override
	public void exEdit(InteriorDTO dto) throws Exception {
		dao.exEdit(dto);
		
	}

	@Override
	public void exEditFile(InteriorDTO dto) throws Exception {
		dao.exEditFile(dto);
		
	}

	@Override
	public void exDelete(InteriorDTO dto) throws Exception {
		dao.exDelete(dto);
		
	}

	@Override
	public int realReCount(InteriorDTO dto) throws Exception {
		return dao.realReCount(dto);
	}

	@Override
	public int realExCount(InteriorDTO dto) throws Exception {
		return dao.realExCount(dto);
	}

	@Override
	public void reLikeDelete(InteriorDTO dto) throws Exception {
		dao.reLikeDelete(dto);
		
	}

	@Override
	public String checkComNameforCons(InteriorDTO dto) throws Exception {
		return dao.checkComNameforCons(dto);
	}


}
