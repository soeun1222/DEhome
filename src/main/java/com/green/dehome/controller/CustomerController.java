package com.green.dehome.controller;

import java.net.URLEncoder;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.green.dehome.dto.CustomerDTO;
import com.green.dehome.dto.CustomerPaging;
import com.green.dehome.service.CustomerService;
import com.green.dehome.service.CustomerServiceImpl;

@Controller
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	CustomerService CService;

	@RequestMapping(value = "/customer/qna_write", method = RequestMethod.GET)
	public void qna_write() throws Exception {
		logger.info("qna_write");
	}

	@RequestMapping(value = "/customer/qna_write", method = RequestMethod.POST)
	public String qna_insert(CustomerDTO customerDTO, HttpServletRequest request) throws Exception {
		logger.info("qna_write");
		String content = request.getParameter("qna_content");
		content = content.replace("\r\n", "<br>");
		customerDTO.setQna_content(content);

		CService.qna_insert(customerDTO);
		return "redirect:../customer/qna_list";
	}

	@RequestMapping(value = "/customer/qna_list", method = RequestMethod.GET)
	public String qna_list(@ModelAttribute("CustomerDTO") CustomerDTO customerDTO,
			@RequestParam(defaultValue = "1") int curPage, HttpServletRequest request, Model model, CustomerDTO dto)
			throws Exception {

		// 페이지 시작 인덱스
		int startIndex = (curPage - 1) * 10;
		dto.setStartIndex(startIndex);

		List<CustomerDTO> qna_list = CService.qna_list(dto);

		int listCnt = CService.countList();
		CustomerPaging paginDto = new CustomerPaging(listCnt, curPage);

		for (int i = 0; i < qna_list.size(); i++) {
			if (qna_list.get(i).getQna_type().equals("usedtrade")) {
				qna_list.get(i).setQna_type("중고거래");
			} else if (qna_list.get(i).getQna_type().equals("membership")) {
				qna_list.get(i).setQna_type("회원관련");
			} else if (qna_list.get(i).getQna_type().equals("interrior")) {
				qna_list.get(i).setQna_type("인테리어");
			}
		}
		for (int i = 0; i < qna_list.size(); i++) {
			if (qna_list.get(i).getQna_process().equals("processing")) {
				qna_list.get(i).setQna_process("처리중");
			} else if (qna_list.get(i).getQna_process().equals("complete")) {
				qna_list.get(i).setQna_process("답변완료");
			}
		}
		model.addAttribute("list", qna_list);
		model.addAttribute("listCnt", listCnt);

		model.addAttribute("paging", paginDto);
		return "customer/qna_list";
	}

	// 게시판 글 가져오기(조회)
	@RequestMapping(value = "/customer/qna_show", method = RequestMethod.GET)
	public String qna_show(HttpServletRequest request, @RequestParam("qna_no") int qna_no, Model model,
			HttpSession session, HttpServletResponse response) throws Exception {

		String nickname = (String) session.getAttribute("nickname");
		System.out.println(nickname);

		CustomerDTO customerDTO = CService.qna_show(qna_no);
		// 조회수 중복 쿠키
		Cookie[] cookies = request.getCookies();
		// 비교하기 위해 새로운 쿠키
		Cookie viewCookie = null;

		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("|" + qna_no + "|")) {
					viewCookie = cookies[i];

				}
			}
		}

		if (viewCookie == null) {
			Cookie newCookie = new Cookie("|" + qna_no + "|", URLEncoder.encode(nickname, "UTF-8"));
			if (!customerDTO.getUser_nick().equals(nickname)) {
				newCookie.setMaxAge(1 * 24 * 60 * 60);
				response.addCookie(newCookie);
				CService.qna_hitUp(qna_no);
			}

		} else {
			String value = viewCookie.getValue();
		}

		int count = CService.qna_getHit(qna_no);
		customerDTO.setQna_count(count);
		model.addAttribute("qna_no", qna_no);
		model.addAttribute("show", customerDTO);
		return "customer/qna_show";
	}

	// 게시판 글 수정
	@RequestMapping(value = "/customer/qna_modifyView", method = RequestMethod.GET)
	public void qna_modifyView(@RequestParam("qna_no") int qna_no, Model model) throws Exception {
		CustomerDTO customerDTO = CService.qna_show(qna_no);

		model.addAttribute("show", customerDTO);
	}

	@RequestMapping(value = "/customer/qna_modifyView", method = RequestMethod.POST)
	public String qna_modify(CustomerDTO customerDTO, HttpServletRequest request) throws Exception {

		int qna_no = Integer.parseInt(request.getParameter("qna_no"));
		String title = request.getParameter("qna_title");
		String content = request.getParameter("qna_content");
		String type = request.getParameter("qna_type");
		customerDTO.setQna_type(type);
		customerDTO.setQna_title(title);
		customerDTO.setQna_content(content);
		customerDTO.setQna_no(qna_no);

		CService.qna_modify(customerDTO);

		return "redirect:../customer/qna_list";
	}

	// 게시물 삭제
	@RequestMapping(value = "/customer/qna_delete", method = RequestMethod.GET)
	public String qna_delete(@RequestParam("qna_no") int qna_no) throws Exception {
		
		CService.qna_c_delete(qna_no);
		CService.qna_delete(qna_no);

		return "redirect:../customer/qna_list";
	}

	// QNA_C
	@RequestMapping(value = "/customer/qna_c_write", method = RequestMethod.GET)
	public ModelAndView qna_c_write(HttpServletRequest request) throws Exception {
		logger.info("qna_c_write");
		int qna_no = Integer.parseInt(request.getParameter("qna_no"));
		ModelAndView mav = new ModelAndView();
		mav.addObject("qna_no", qna_no);
		mav.setViewName("customer/qna_c_write");

		return mav;
	}

	@RequestMapping(value = "/customer/qna_c_write", method = RequestMethod.POST)
	public String qna_c_insert(CustomerDTO customerDTO, HttpServletRequest request, HttpSession session, Model model)
			throws Exception {
		logger.info("qna_c_write");
		int qna_no = Integer.parseInt(request.getParameter("qna_no"));
		String nickname = (String) session.getAttribute("nickname");
		String content = request.getParameter("qna_c_content");
		content = content.replace("\r\n", "<br>");
		customerDTO.setQna_c_content(content);
		customerDTO.setUser_nick2(nickname);
		customerDTO.setQna_no(qna_no);

		CService.qna_c_insert(customerDTO);
		CService.qna_c_processing(customerDTO);
		String url = "redirect:../customer/qna_c_show?qna_no=";
		String num = Integer.toString(qna_no);

		return url + num;
	}
	
	@RequestMapping(value = "/customer/qna_c_show", method = RequestMethod.GET)
	public String qna_c_show(HttpServletRequest request, @RequestParam("qna_no") int qna_no, Model model,
			HttpSession session, HttpServletResponse response) throws Exception {

		CustomerDTO customerDTO = CService.qna_c_show(qna_no);
		model.addAttribute("qna_no", qna_no);
		model.addAttribute("c_show", customerDTO);
		return "customer/qna_c_show";
	}


	// 게시판 글 수정
	@RequestMapping(value = "/customer/qna_c_modifyView", method = RequestMethod.GET)
	public void qna_c_modifyView(@RequestParam("qna_no") int qna_no, Model model) throws Exception {
		CustomerDTO customerDTO = CService.qna_c_show(qna_no);
		model.addAttribute("qna_no", qna_no);
		model.addAttribute("c_show", customerDTO); 
	}

	@RequestMapping(value = "/customer/qna_c_modifyView", method = RequestMethod.POST)
	public String qna_c_modify(CustomerDTO customerDTO, HttpServletRequest request,HttpSession session, Model model)
			throws Exception {
		logger.info("qna_c_modify");
		int qna_no = Integer.parseInt(request.getParameter("qna_no"));
		String content = request.getParameter("qna_c_content");
		content = content.replace("\r\n", "<br>");
		customerDTO.setQna_c_content(content);
		customerDTO.setQna_no(qna_no);

		CService.qna_c_modify(customerDTO);
		String url = "redirect:../customer/qna_c_show?qna_no=";
		String num = Integer.toString(qna_no);

		return url + num;
	}

	// 게시물 삭제
	@RequestMapping(value = "/customer/qna_c_delete", method = RequestMethod.GET)
	public String qna_c_delete(CustomerDTO customerDTO, @RequestParam("qna_no") int qna_no) throws Exception {
		logger.info("qna_c_delete");
		CService.qna_c_processing_re(customerDTO);
		CService.qna_c_delete(qna_no);
		
		logger.info("qna_c_delete_complete");
		return "redirect:../customer/qna_list";
	}

	// Notice
	@RequestMapping(value = "/customer/not_write", method = RequestMethod.GET)
	public void not_write() throws Exception {
		logger.info("not_write");
	}

	@RequestMapping(value = "/customer/not_write", method = RequestMethod.POST)
	public String not_insert(CustomerDTO customerDTO, HttpSession session, HttpServletRequest request)
			throws Exception {
		logger.info("not_write");
		String not_content = request.getParameter("not_content");
		not_content = not_content.replace("\r\n", "<br>");
		customerDTO.setNot_content(not_content);
		String nickname = (String) session.getAttribute("nickname");
		customerDTO.setUser_nick(nickname);
		CService.not_insert(customerDTO);
		return "redirect:../customer/not_list";
	}

	@RequestMapping(value = "/customer/not_list", method = RequestMethod.GET)
	public String not_list(@ModelAttribute("CustomerDTO") CustomerDTO customerDTO,
			@RequestParam(defaultValue = "1") int curPage, HttpServletRequest request, HttpSession session, Model model,
			CustomerDTO dto) throws Exception {
		// 페이지 시작 인덱스
		int startIndex = (curPage - 1) * 10;
		dto.setStartIndex(startIndex);
		String nickname = (String) session.getAttribute("nickname");
		List<CustomerDTO> not_list = CService.not_list(dto);

		int listCnt = CService.countList();
		CustomerPaging paginDto = new CustomerPaging(listCnt, curPage);

		for (int i = 0; i < not_list.size(); i++) {
			if (not_list.get(i).getNot_menu().equals("usedtrade")) {
				not_list.get(i).setNot_menu("중고거래");
			} else if (not_list.get(i).getNot_menu().equals("membership")) {
				not_list.get(i).setNot_menu("회원관련");
			} else if (not_list.get(i).getNot_menu().equals("interrior")) {
				not_list.get(i).setNot_menu("인테리어");
			}
		}
		model.addAttribute("list", not_list);
		model.addAttribute("nickname", nickname);
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("paging", paginDto);

		return "customer/not_list";
	}

	// 게시판 글 가져오기(조회)
	@RequestMapping(value = "/customer/not_show", method = RequestMethod.GET)
	public String not_show(HttpServletRequest request, @RequestParam("not_no") int not_no, Model model,
			HttpSession session, HttpServletResponse response) throws Exception {

		String nickname = (String) session.getAttribute("nickname");
		System.out.println(nickname); // 쿠키에 사용

		CustomerDTO customerDTO = CService.not_show(not_no);
		// 조회수 중복 쿠키
		Cookie[] cookies = request.getCookies();
		// 비교하기 위해 새로운 쿠키
		Cookie viewCookie = null;

		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("|" + not_no + "|")) {
					viewCookie = cookies[i];

				}
			}
		}

		if (viewCookie == null) {
			Cookie newCookie = new Cookie("|" + not_no + "|", URLEncoder.encode(nickname, "UTF-8"));
			if (!customerDTO.getUser_nick().equals(nickname)) {
				newCookie.setMaxAge(1 * 24 * 60 * 60);
				response.addCookie(newCookie);
				CService.not_hitUp(not_no);
			}

		} else {
			String value = viewCookie.getValue();
		}

		int count = CService.not_getHit(not_no);
		customerDTO.setNot_count(count);
		model.addAttribute("show", customerDTO);
		return "customer/not_show";
	}

	// 게시판 글 수정
	@RequestMapping(value = "/customer/not_modifyView", method = RequestMethod.GET)
	public void not_modifyView(@RequestParam("not_no") int not_no, Model model) throws Exception {
		CustomerDTO customerDTO = CService.not_show(not_no);

		model.addAttribute("show", customerDTO);
	}

	@RequestMapping(value = "/customer/not_modifyView", method = RequestMethod.POST)
	public String not_modify(CustomerDTO customerDTO, HttpServletRequest request) throws Exception {
		int not_no = Integer.parseInt(request.getParameter("not_no"));
		String title = request.getParameter("not_title");
		String menu = request.getParameter("not_menu");
		String content = request.getParameter("not_content");
		content = content.replace("\r\n", "<br>");
		customerDTO.setNot_menu(menu);
		customerDTO.setNot_title(title);
		customerDTO.setNot_content(content);
		customerDTO.setNot_no(not_no);

		CService.not_modify(customerDTO);
		return "redirect:../customer/not_list";
	}

	// 게시물 삭제
	@RequestMapping(value = "/customer/not_delete", method = RequestMethod.GET)
	public String not_delete(@RequestParam("not_no") int not_no) throws Exception {

		CService.not_delete(not_no);

		return "redirect:../customer/not_list";
	}
	//서비스 소개 이동
	@RequestMapping(value = "/customer/introduce", method = RequestMethod.GET)
	public void goIntroduce() throws Exception {
		
	}
}
