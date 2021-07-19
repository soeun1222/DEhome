package com.green.dehome.controller;


import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.green.dehome.dto.UserDTO;
import com.green.dehome.kakao.KakaoAccessToken;
import com.green.dehome.kakao.KakaoUserInfo;
import com.green.dehome.naver.NaverLoginBO;
import com.green.dehome.service.UserService;

@Controller
public class MainController {
	
	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
	this.naverLoginBO = naverLoginBO;
	}
	
	@Inject
	UserService service;

	//메인화면으로 이동
	@RequestMapping(value="/main/mainpage", method = RequestMethod.GET)
	public ModelAndView mainpage(UserDTO dto) throws Exception {
		
		/*--중고거래 최신글 5개 가지고오기--*/
		ModelAndView mav = new ModelAndView();
		List<UserDTO> list = service.mainPageList(dto);
		
		/*--중고거래 상품 카테고리 분류 및 다시 셋팅하기--*/
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTr_category().equals("furniture")) {
				list.get(i).setTr_category("가구");
			} else if (list.get(i).getTr_category().equals("fabric")) {
				list.get(i).setTr_category("FABRIC");
			} else if (list.get(i).getTr_category().equals("interior_prop")) {
				list.get(i).setTr_category("인테리어 소품");
			} else if (list.get(i).getTr_category().equals("light")) {
				list.get(i).setTr_category("조명");
			} else if (list.get(i).getTr_category().equals("storage_furniture")) {
				list.get(i).setTr_category("수납");
			} else if (list.get(i).getTr_category().equals("life_bath")) {
				list.get(i).setTr_category("생활/욕실");
			} else if (list.get(i).getTr_category().equals("kitchen")) {
				list.get(i).setTr_category("주방");
			} else {
				list.get(i).setTr_category("DIY");
			}
		}
	
		
		mav.addObject("list", list);
		mav.setViewName("main/mainpage");
		return mav;
	}
	//카카오로그인한 후 메인화면으로 이동
	@RequestMapping(value="/main/kakaoMainpage", method = RequestMethod.GET)
	public String kakaologingo(@RequestParam(value = "code", required = false) String kakaocode, HttpSession session) throws Exception {
        
		JsonNode kakaoaccess_token;
        // JsonNode트리형태로 토큰받아온다
        JsonNode jsonToken = KakaoAccessToken.getKakaoAccessToken(kakaocode);
        // 여러 json객체 중 access_token을 가져온다
        kakaoaccess_token = jsonToken.get("access_token");
        // access_token을 통해 사용자 정보 요청
        JsonNode userInfo = KakaoUserInfo.getKakaoUserInfo(kakaoaccess_token);
 
        // id얻기
        String kakaoid = userInfo.path("id").asText();
        String kakaonickname = null;
        String kakaoemail = null;
        String kakaoemail1 = null;
        String kakaoemail2 = null;
        String kakaogender = null;
 
        // 유저정보 카카오에서 가져오기 Get properties
        JsonNode properties = userInfo.path("properties");
        JsonNode kakao_account = userInfo.path("kakao_account");
        kakaonickname = properties.path("nickname").asText();
        kakaoemail = kakao_account.path("email").asText();
        kakaogender = kakao_account.path("gender").asText();
        kakaoemail1 = kakaoemail.substring(0,kakaoemail.indexOf("@"));
        kakaoemail2 = kakaoemail.substring(kakaoemail.indexOf("@") + 1);
        
        session.setAttribute("kakaoemail1", kakaoemail1);
        session.setAttribute("kakaoemail2", kakaoemail2);
        session.setAttribute("kakaogender", kakaogender); // male / female
        session.setAttribute("nickname", kakaonickname);
        session.setAttribute("kakaoaccess_token", kakaoaccess_token);
        
        String checkNick = service.kakaonickCheck((String) session.getAttribute("nickname"));
        
        if(checkNick != null) {
        	session.setAttribute("kakaoaddcheck", "Y");
        } else {
        	session.setAttribute("kakaoaddcheck", "N");
        }
        return "redirect:../main/mainpage";
	}
	
	// 네이버 로그인후 메인화면 이동
	@RequestMapping(value = "/main/naverMainpage", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws Exception {
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);
		// 1. 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken); // String형식의 json데이터
		// 2. String형식인 apiResult를 json형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;
		// 3. 데이터 파싱
		// Top레벨 단계 _response 파싱
		JSONObject response_obj = (JSONObject) jsonObj.get("response");
		// response의 nickname값 파싱
		String naverNickname = (String) response_obj.get("nickname");
		String naverGender = (String) response_obj.get("gender");
		String naverPNum = (String)response_obj.get("mobile");
		String naverName = (String)response_obj.get("name");
		String naverEmail = (String)response_obj.get("email");
		String naverEmail1 = naverEmail.substring(0,naverEmail.indexOf("@"));
		String naverEmail2 = naverEmail.substring(naverEmail.indexOf("@") + 1);
		
		session.setAttribute("nickname", naverNickname);
		session.setAttribute("naverGender", naverGender);
		session.setAttribute("naverPNum", naverPNum);
		session.setAttribute("naverName", naverName);
		session.setAttribute("naverEmail1", naverEmail1);
		session.setAttribute("naverEmail2", naverEmail2);
		model.addAttribute("result", apiResult);
		
		String checkNick = service.navernickCheck((String) session.getAttribute("nickname"));
		
        if(checkNick != null) {
        	session.setAttribute("naveraddcheck", "Y");
        } else {
        	session.setAttribute("naveraddcheck", "N");
        }
        return "redirect:../main/mainpage";
	}
}
