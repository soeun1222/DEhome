package com.green.dehome.controller;


import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.green.dehome.dto.TradeDTO;
import com.green.dehome.service.TradeService;
import com.green.dehome.utils.UploadFileUtils;

@Controller
public class TradeController {

	@Inject
	TradeService service;

	@Resource(name = "uploadPath")
	private String uploadPath;

	// 물건등록 폼으로 이동
	@RequestMapping(value = "/trade/registerGoods", method = RequestMethod.GET)
	public void registerGoods() {
	}

	// 물건 등록 폼 -> 리스트
	@RequestMapping(value = "/trade/used_trade", method = RequestMethod.POST)
	public ModelAndView goGoodsList(MultipartFile file, TradeDTO dto, HttpSession session, HttpServletRequest request)
			throws Exception {
		// 세션에 닉네임 받아서 넣기
		String user_nick = (String) session.getAttribute("nickname");
		dto.setTr_user_nick(user_nick);

		// 무료나눔일 경우 0 넣기
		String tr_price = request.getParameter("tr_price");
		if (tr_price == null) {
			dto.setTr_price("무료나눔");
		}

		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String fileName = null;

		if (file != null) {
			fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes());
		} else {
			fileName = uploadPath + File.separator + "images" + File.separator + "logo.png";
		}

		dto.setTr_photo(File.separator + "imgUpload" + File.separator + fileName);
		dto.setTr_thumb(
				File.separator + "imgUpload" + File.separator + "s" + File.separator + "s_" + fileName);

		service.tradeRegister(dto);

		List<TradeDTO> list = service.tradeList(dto);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("title", "방금 올라온 물건");
		mav.setViewName("trade/used_trade");
		return mav;
	}

	// 헤더에서 중고거래 or 카테고리 클릭 시 나오는 리스트 메인화면
	@RequestMapping(value = "/trade/used_trade.do", method = RequestMethod.GET)
	public ModelAndView usedTrade(TradeDTO dto, @RequestParam String category, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<TradeDTO> list = null;
		if (category.equals("none")) {
			list = service.tradeList(dto);
			mav.addObject("list", list);
			mav.addObject("title", "방금 올라온 물건");
			mav.setViewName("trade/used_trade");
		} else if (category.equals("furniture")) {
			list = service.tradeListCategory(dto, category);
			mav.addObject("list", list);
			mav.addObject("title", "가구");
			mav.setViewName("trade/used_trade");
		} else if (category.equals("fabric")) {
			list = service.tradeListCategory(dto, category);
			mav.addObject("list", list);
			mav.addObject("title", "FABRIC");
			mav.setViewName("trade/used_trade");
		} else if (category.equals("interior_prop")) {
			list = service.tradeListCategory(dto, category);
			mav.addObject("list", list);
			mav.addObject("title", "인테리어 소품");
			mav.setViewName("trade/used_trade");
		} else if (category.equals("light")) {
			list = service.tradeListCategory(dto, category);
			mav.addObject("list", list);
			mav.addObject("title", "조명");
			mav.setViewName("trade/used_trade");
		} else if (category.equals("storage_furniture")) {
			list = service.tradeListCategory(dto, category);
			mav.addObject("list", list);
			mav.addObject("title", "수납");
			mav.setViewName("trade/used_trade");
		} else if (category.equals("life_bath")) {
			list = service.tradeListCategory(dto, category);
			mav.addObject("list", list);
			mav.addObject("title", "생활/욕실");
			mav.setViewName("trade/used_trade");
		} else if (category.equals("kitchen")) {
			list = service.tradeListCategory(dto, category);
			mav.addObject("list", list);
			mav.addObject("title", "주방");
			mav.setViewName("trade/used_trade");
		} else {
			list = service.tradeListCategory(dto, category);
			mav.addObject("list", list);
			mav.addObject("title", "DIY");
			mav.setViewName("trade/used_trade");
		}
		return mav;
	}

	// 더보기 중고거래 리스트 컨트롤러
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/trade/used_trade.more", method = RequestMethod.POST)
	public String getMoreUsedTradeList(TradeDTO dto, String more) throws Exception {
		List<TradeDTO> list = null;

		int page = Integer.parseInt(more);
		int startPage = 9 + (3 * page);

		dto.setStartPage(startPage);
		list = service.tradeListMore(dto, startPage);

		// 전송용 최종 json객체
		JSONObject sendJson = new JSONObject();
		// JSONArray에 담기
		JSONArray jarr = new JSONArray();

		for (TradeDTO trade : list) {
			JSONObject jboard = new JSONObject();

			String tr_title = URLEncoder.encode(trade.getTr_title(), "UTF-8");
			tr_title = tr_title.replaceAll("\\+", "%20");
			String user_addr2 = URLEncoder.encode(trade.getUser_addr2(), "UTF-8");
			user_addr2 = user_addr2.replaceAll("\\+", "%20");
			jboard.put("tr_photo", trade.getTr_photo());
			jboard.put("tr_title", tr_title);
			jboard.put("user_addr2", user_addr2);
			jboard.put("tr_price", trade.getTr_price());
			jboard.put("tr_count", trade.getTr_count());
			jboard.put("tr_no", trade.getTr_no());

			jarr.add(jboard);
		}
		sendJson.put("list", jarr);
		return sendJson.toJSONString();
	}

	// 중고거래 지역검색시 나오는 메인화면 리스트
	@RequestMapping(value = "/trade/used_trade.search", method = RequestMethod.POST)
	public ModelAndView usedTradeSearch(TradeDTO dto, @Param("search_area") String search_area) throws Exception {
		List<TradeDTO> list = service.tradeListSearch(dto, search_area);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("trade/used_trade");
		return mav;
	}

	// 중고거래 상세페이지 이동
	@RequestMapping(value = "/trade/tradeShow", method = RequestMethod.GET)
	public ModelAndView goTradeShow(@RequestParam int tr_no, TradeDTO dto, HttpServletRequest request,
			HttpSession session, HttpServletResponse response) throws UnsupportedEncodingException {
		if(request.getParameter("ch").equals("1")) {
			service.completeChange(tr_no);
			String buyer = request.getParameter("to_nick");
			dto.setTr_buyer(buyer);
			dto.setTr_no(tr_no);
			service.completeAdd(dto);
		}
		//하트 클릭했을때 속이 찬 하트로 변하게 함
		String heart = request.getParameter("heart");
		dto.setTr_no(tr_no);
		dto.setTr_user_nick((String) session.getAttribute("nickname"));
		if(request.getParameter("heart").equals("on")) {
			service.heartIn(dto);
		}
		// 하트 누른채로 상세페이지로 이동할때
		int num = service.heartCheck(dto);
		
		TradeDTO dto2 = service.tradeShow(dto, tr_no);
		String nick = (String) session.getAttribute("nickname");
		
		// 조회수 중복 쿠키
		Cookie[] cookies = request.getCookies();
		// 비교하기 위해 새로운 쿠키
		Cookie viewCookie = null;
		
		if (cookies != null && cookies.length > 0) {
		    for (int i = 0; i < cookies.length; i++){
		        if (cookies[i].getName().equals("|" + tr_no + "|") ){ 
		            viewCookie = cookies[i];
		        }
		    }
		}
		
		if (viewCookie == null) {
			Cookie newCookie = new Cookie("|" + tr_no + "|", URLEncoder.encode(nick, "UTF-8"));
			if(!dto2.getTr_user_nick().equals(nick)) {
				newCookie.setMaxAge(1*24*60*60);
				response.addCookie(newCookie);
				service.setCount(tr_no);
			}
			
		} else {
			String value = viewCookie.getValue();
		}


		String user_addr2 = service.getAddr2(dto2.getTr_user_nick());
		// 시간 설정.
		String time = null;
		if (dto2.getYear() == 0) {
			if (dto2.getMonth() == 0) {
				if (dto2.getDay() == 0) {
					if (dto2.getHour() == 0) {
						if (dto2.getMinute() == 0) {
							if (dto2.getSecond() != 0) {
								time = dto2.getSecond() + "초 전";
							} else {
								time = "방금 전";
							}
						} else {
							time = dto2.getMinute() + "분 전";
						}
					} else {
						time = dto2.getHour() + "시간 전";
					}
				} else {
					time = dto2.getDay() + "일 전";
				}
			} else {
				time = dto2.getHour() + "달 전";
			}
		} else {
			time = dto2.getHour() + "년 전";
		}

		if (dto2.getTr_price().equals("0")) {
			dto2.setTr_price("무료나눔");
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("time", time);
		mav.addObject("dto2", dto2);
		mav.addObject("tr_no", tr_no);
		mav.addObject("heart", heart);
		mav.addObject("num", num);
		mav.addObject("addr", user_addr2);
		mav.setViewName("trade/tradeShow");
		return mav;
	}
	
	//중고거래 물품등록 글 수정페이지로 이동
	@RequestMapping(value = "/trade/registerEdit", method = RequestMethod.GET)
	public ModelAndView goTradeEdit(TradeDTO dto, @RequestParam("tr_no") int tr_no) {
		
		TradeDTO dto2 = service.tradeShowEdit(dto, tr_no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", dto2);
		return mav;
	}
	
	// 물건 수정 폼 -> 리스트
	@RequestMapping(value = "/trade/used_trade_edit", method = RequestMethod.POST)
	public ModelAndView goGoodsListEdit(MultipartFile file, TradeDTO dto, HttpSession session, HttpServletRequest request)
			throws Exception {
		// 세션에 닉네임 받아서 넣기
		int tr_no = Integer.parseInt(request.getParameter("tr_no"));
		
		String tr_price = request.getParameter("tr_price");
		if (tr_price == null) {
			dto.setTr_price("무료나눔");
		}
			String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String fileName = null;
		
		if (file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes());
		} else {
			fileName = uploadPath + File.separator + "images" + File.separator + "logo.png";
		}
		dto.setTr_photo(File.separator + "imgUpload" + File.separator + fileName);
		dto.setTr_no(tr_no);
		
		if (file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			service.update_goods_photo(dto);
		}
		service.update_goods(dto);

		List<TradeDTO> list = service.tradeList(dto);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("title", "방금 올라온 물건");
		mav.setViewName("trade/used_trade");
		return mav;
	}
	
	@RequestMapping(value="/trade/registerDelete", method = RequestMethod.GET)
	public String deleteGoods(HttpServletRequest request) {
		
		int tr_no = Integer.parseInt(request.getParameter("tr_no"));
		service.delete_goods_interest(tr_no);
		service.delete_goods_chat(tr_no);
		service.delete_goods(tr_no);
		
		return "redirect:../trade/used_trade.do?category=none";
	}
}
