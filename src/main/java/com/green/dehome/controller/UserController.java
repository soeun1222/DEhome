package com.green.dehome.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.green.dehome.dto.UserDTO;
import com.green.dehome.kakao.KakaoLogout;
import com.green.dehome.naver.NaverLoginBO;
import com.green.dehome.service.UserService;

@Controller
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Inject
	UserService service;

	@Autowired
	private JavaMailSender mailSender;

	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;

	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	// 회원가입 페이지로 이동(get)
	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
	public void getRegister() throws Exception {
	}

	// 닉네임 중복확인 팝업창 이동
	@RequestMapping(value = "/user/nick_popup", method = RequestMethod.GET)
	public String goNickPopUp() throws Exception {
		return "user/nick_popup";
	}

	// 닉네임 중복확인
	@RequestMapping(value = "/user/nick_popup", method = RequestMethod.POST)
	public ModelAndView nickCheckAfter(HttpServletRequest request) throws Exception {
		String input_nick = request.getParameter("user_nick");

		String nick = service.nickCheck(input_nick);
		if (nick == null) { // 닉네임이 존재하지 않을 경우
			nick = input_nick;
		} else if (nick.equals(input_nick)) {
			nick = "중복";
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/nick_popup");
		mav.addObject("nick", nick);
		return mav;
	}

	// 아이디 중복확인 팝업창 이동
	@RequestMapping(value = "/user/id_popup", method = RequestMethod.GET)
	public String goIdPopUp() throws Exception {
		return "user/id_popup";
	}

	// 아이디 중복확인
	@RequestMapping(value = "/user/id_popup", method = RequestMethod.POST)
	public ModelAndView idCheckAfter(HttpServletRequest request) throws Exception {
		String input_id = request.getParameter("user_id"); // jsp 에서 입력한 아이디값

		String id = service.idCheck(input_id); // 비교하기위해 디비에서 가져온 아이디값
		if (id == null) { // 닉네임이 존재하지 않을 경우
			id = input_id;
		} else if (id.equals(input_id)) {
			id = "중복";
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/id_popup");
		mav.addObject("id", id);
		return mav;
	}

	/* 이메일 인증 */
	@RequestMapping(value = "/user/mailCheck", method = RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String email) throws Exception {
		/* 뷰(View)로부터 넘어온 데이터 확인 */
		
//		 LOGGER.info("이메일 데이터 전송 확인"); 
//		 LOGGER.info("인증번호 : " + email);
		

		/* 인증번호(난수) 생성 */
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
//        LOGGER.info("인증번호 " + checkNum);

		/* 이메일 보내기 */
		String setFrom = "ruddbs273@naver.com";
		String toMail = email;
		String title = "DE:home 회원가입 인증 이메일 입니다.";
		String content = "DE:home을 방문해주셔서 감사합니다." + "<br><br>" + "인증 번호는 " + "<strong style='color:#1B7850'>" + checkNum
				+ "</strong>" + "입니다." + "<br>" + "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}

		String num = Integer.toString(checkNum);
		return num;
	}

	// 회원가입 성공하면 로그인 페이지로 이동
	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public String postRegister(Model model, UserDTO dto, HttpServletRequest req, HttpServletResponse response,
			HttpSession session) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		// email2를 선택한 경우 null값이 들어와서 select 값으로 치환해서 넣어줌
		if (req.getParameter("user_email2") == null) {
			dto.setUser_email2(req.getParameter("email"));
		}
//		String check_num = service.pnumCheck(Integer.parseInt(req.getParameter("user_pnum")));
//		String check_com = service.comCheck(req.getParameter("com_name"));
		out.println("<script>alert('회원가입에 성공하셨습니다. 로그인을 해주세요.');</script>");
		out.flush();
		service.register(dto); //insert

		// 네이버 url던져주기
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		model.addAttribute("url", naverAuthUrl);

		return "/user/login";
	}

	// 그냥 로그인 클릭했을때 페이지이동
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String goLogin(Model model, HttpSession session) throws Exception {
		// 네이버 url던져주기
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		model.addAttribute("url", naverAuthUrl);
		return "user/login";
	}

	// 로그인 후 메인페이지로 이동
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public String login(HttpSession session, UserDTO dto, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String returnURL = "";

		if (session.getAttribute("login") != null) {
			// 기존에 login이란 세션 값이 존재한다면 기존값을 제거해 준다.
			session.removeAttribute("login");
		}

		// 로그인 성공하면 UserDTO 객체를 반환함.
		UserDTO userDTO = service.loginCheck(dto);

		if (userDTO != null) {
			// 세션에 userDTO객체를 담아놓음
			session.setAttribute("login", userDTO);
			session.setAttribute("nickname", userDTO.getUser_nick());
			// 로그인 성공시
			returnURL = "redirect:../main/mainpage";
		} else {
			// 로그인에 실패시
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 정보를 확인해주세요.'); history.go(-1);</script>");
			out.flush();
			returnURL = "/user/login";
		}
		return returnURL;
	}

	// 로그아웃(새로고침시켜주는 방식 - 서비스단에서 처리)
	@RequestMapping(value = "/logout.do")
	public void logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		session.invalidate();
		service.logout(response);
	}

	// 카카오 로그인했을때 추가정보입력하게 이동시키기
	@RequestMapping(value = "/user/register_kakao", method = RequestMethod.GET)
	public void getRegisterAddKakao() throws Exception {
		LOGGER.info("Register page -->(method = get)");
	}

	// 추가정보 입력후 로그인창으로 이동(카톡로그인)
	@RequestMapping(value = "/user/registerKakao.do", method = RequestMethod.POST)
	public String kakaoAddRegister(UserDTO dto, HttpServletRequest req,
			HttpSession session) throws Exception {
		// email2를 선택한 경우 null값이 들어와서 select 값으로 치환해서 넣어줌
//		String check_num = service.pnumCheck(Integer.parseInt(req.getParameter("user_pnum")));
//		String check_com = service.comCheck(req.getParameter("com_name"));
		dto.setUser_email2((String) session.getAttribute("kakaoemail2"));
		dto.setLogin_type("kakao");
		
		service.register(dto);
		session.invalidate();
		
		return "redirect:../main/mainpage";
	}

	// 카카오 로그아웃
	@RequestMapping(value = "/logoutKakao", produces = "application/json")
	public String kakaoLogout(HttpSession session, Model model) {
		KakaoLogout kl = new KakaoLogout();
		// 노드에 로그아웃한 결과값음 담아줌 매개변수는 세션에 잇는 token을 가져와 문자열로 변환
		JsonNode node = kl.Logout(session.getAttribute("kakaoaccess_token").toString());
		// 결과 값 출력
		session.invalidate();

		return "redirect:/user/login";
	}

	// 네이버 로그인했을때 추가정보입력하게 이동시키기
	@RequestMapping(value = "/user/register_naver", method = RequestMethod.GET)
	public void getRegisterAddNaver() throws Exception {
		LOGGER.info("Register page -->(method = get)");
	}

	// 추가정보 입력후 로그인페이지로 이동(네이버로그인)
	@RequestMapping(value = "/user/registerNaver.do", method = RequestMethod.POST)
	public String naverAddRegister(UserDTO dto, HttpServletRequest req,
			HttpSession session) throws Exception {

//		String check_num = service.pnumCheck(Integer.parseInt(req.getParameter("user_pnum")));
//		String check_com = service.comCheck(req.getParameter("com_name"));
		dto.setUser_email2((String) session.getAttribute("naverEmail2"));
		dto.setLogin_type("naver");
		
		service.register(dto);
		session.invalidate();
		
		return "redirect:../main/mainpage";
	}

	// 네이버 로그아웃
	@RequestMapping(value = "/logoutNaver")
	public String naverLogout(HttpSession session) {

		session.invalidate();
		return "redirect:/user/login";
	}

	// 로그인 -> 아이디 찾기
	@RequestMapping(value = "/user/find_id", method = RequestMethod.GET)
	public void findId() {
	}

	// 아이디 찾기 -> 아이디 확인하는 창
	@RequestMapping(value = "/user/find_id_confirm", method = RequestMethod.POST)
	public ModelAndView findIdConfirm(HttpSession session, UserDTO dto, HttpServletRequest request) throws Exception {
		String email2 = request.getParameter("user_email2");

		if (email2 == null) {
			dto.setUser_email2(request.getParameter("email"));
		}
//		System.out.println(name + "/" + email1 + "/" + dto.getUser_email2());
		List<UserDTO> list = service.findID(dto);

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getLogin_type().equals("kakao")) {
				list.get(i).setLogin_type("카카오");
			} else if (list.get(i).getLogin_type().equals("naver")) {
				list.get(i).setLogin_type("네이버");
			} else {
				list.get(i).setLogin_type("DE:home");
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/find_id_confirm");
		mav.addObject("list", list);
		mav.addObject("length", list.size());
		return mav;
	}

	// 로그인 -> 비밀번호 찾기
	@RequestMapping(value = "/user/find_pw", method = RequestMethod.GET)
	public void findPW() {
	}

	// 비밀번호 찾기 -> 비밀번호 확인하는 창
	@RequestMapping(value = "/user/find_pw_confirm", method = RequestMethod.POST)
	public ModelAndView findPwConfirm(HttpSession session, UserDTO dto, HttpServletRequest request) throws Exception {
//		String id = request.getParameter("user_id");
//		String name = request.getParameter("user_name");
//		String email1 = request.getParameter("user_email");
		String email2 = request.getParameter("user_email2");

		if (email2 == null) {
			dto.setUser_email2(request.getParameter("email"));
		}
//		System.out.println(name + "/" + email1 + "/" + dto.getUser_email2());
		String pw = service.findPW(dto);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/find_pw_confirm");
		mav.addObject("pw", pw);
		return mav;
	}
}
