package com.green.dehome.controller;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.green.dehome.dto.ChatDTO;
import com.green.dehome.dto.InteriorDTO;
import com.green.dehome.dto.TradeDTO;
import com.green.dehome.service.ChatService;
import com.green.dehome.service.InteriorService;
import com.green.dehome.service.TradeService;

@Controller
public class ChatController {

	@Inject
	ChatService service;
	@Inject
	TradeService service2;
	@Inject
	InteriorService service3;
	
	//중고거래 채팅방으로이동
	@RequestMapping(value = "/chat/tr_chatting", method = RequestMethod.GET)
	public ModelAndView goTradeChatting(HttpServletRequest request, TradeDTO dto, HttpSession session, ChatDTO dto3) throws Exception {
		int tr_no = Integer.parseInt(request.getParameter("tr_no"));
		String to_nick = request.getParameter("to_nick");
		TradeDTO dto2 = service2.tradeShow(dto, tr_no);
		if(dto2.getTr_price().equals("0")) {
			dto2.setTr_price("무료나눔");
		}
		String sessionNick = (String) session.getAttribute("nickname");
		dto3.setUser_nick(sessionNick);
		dto3.setTrade_no(tr_no);
		dto3.setTo_nick(to_nick);
		String nick = service.getNick(dto3);
		ModelAndView mav = new ModelAndView();
		mav.addObject("nick", nick);
		mav.addObject("to_nick", to_nick);
		mav.addObject("dto" ,dto2);
		mav.setViewName("chat/tr_chatting");
		return mav;
	}
	
	//json(k,v)로 받으려면 post사용 해야함
	@RequestMapping(value="/chatInsert.do", method = RequestMethod.POST )
	public void insertChat(HttpServletRequest request, HttpServletResponse response, ChatDTO dto) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int tr_no = Integer.parseInt(request.getParameter("tr_no"));
		String user_nick = request.getParameter("user_nick");
		String to_nick = request.getParameter("to_nick");
		String nick = request.getParameter("nick"); 
		String trade_chatcontent = request.getParameter("trade_chatcontent");
		
		if(user_nick == null || user_nick.equals("") || to_nick == null || to_nick.equals("") 
				|| trade_chatcontent == null || trade_chatcontent.equals("")) {
			response.getWriter().write("0");
		} else {
			user_nick = URLDecoder.decode(user_nick, "UTF-8");
			to_nick = URLDecoder.decode(to_nick, "UTF-8");
			trade_chatcontent = URLDecoder.decode(trade_chatcontent, "UTF-8");
			nick = URLDecoder.decode(nick, "UTF-8");
			dto.setUser_nick(user_nick);
			// 판매자가 로그인했을경우 nick을 to_nick에 대신넣어줌
			if(user_nick.equals(to_nick)) {
				dto.setTo_nick(nick);
			} else {
				dto.setTo_nick(to_nick);
			}
			dto.setTrade_chatcontent(trade_chatcontent.replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
			dto.setTrade_no(tr_no);
			
			service.chatInsert(dto);
		}
	}
	
	@RequestMapping(value="/chatList.do", method = RequestMethod.POST )
	public void listChat(HttpServletRequest request, HttpServletResponse response, ChatDTO dto) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String user_nick = request.getParameter("user_nick");
		String to_nick = request.getParameter("to_nick");
		String listType = request.getParameter("listType");
		String nick = request.getParameter("nick");
		int tr_no = Integer.parseInt(request.getParameter("tr_no"));
		
		if(user_nick == null || user_nick.equals("") || to_nick == null || to_nick.equals("") 
				|| listType == null || listType.equals("")) {
			response.getWriter().write("");
		} else if(listType.equals("ten")) {
			response.getWriter().write(getTen(URLDecoder.decode(user_nick,"utf-8"), URLDecoder.decode(to_nick,"utf-8"), URLDecoder.decode(nick,"utf-8"), 100, tr_no));
		} else {
			try {
				response.getWriter().write(getID(URLDecoder.decode(user_nick,"utf-8"), URLDecoder.decode(to_nick,"utf-8"), URLDecoder.decode(nick,"utf-8"), listType, tr_no));
			} catch (Exception e) {
				response.getWriter().write("");
			}
		}
	}
	//최대 100개까지 출력하게끔함
	public String getTen(String user_nick, String to_nick,String nick, int number, int tr_no) throws Exception {
		ChatDTO dto = new ChatDTO();
		dto.setUser_nick(user_nick);
		if(user_nick.equals(to_nick)) {
			dto.setTo_nick(nick);
		} else {
			dto.setTo_nick(to_nick);
		}
		dto.setNumber(number);
		dto.setTrade_no(tr_no);
		
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		
		List<ChatDTO> chatList = service.chatSelectLimit(dto);
		if(chatList.size() == 0) return "";
		for(int i = 0; i < chatList.size(); i++) {
			result.append("[{\"value\": \"" + chatList.get(i).getUser_nick() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getTo_nick() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getTrade_chatcontent() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getTrade_chattime() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getTrade_chatread() + "\"}]");
			if(i != chatList.size() -1) result.append(",");
		}
		result.append("], \"last\":\"" + chatList.get(chatList.size() -1).getTrade_chatno() + "\"}");
		return result.toString();
	}
	
	public String getID(String user_nick, String to_nick, String nick, String list_type, int tr_no) throws Exception {
		ChatDTO dto = new ChatDTO();
		dto.setUser_nick(user_nick);
		
		if(user_nick.equals(to_nick)) {
			dto.setTo_nick(nick);
		} else {
			dto.setTo_nick(to_nick);
		}
		dto.setListType(list_type);
		dto.setTrade_no(tr_no);
		
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		List<ChatDTO> chatList = service.chatSelect(dto);
		if(chatList.size() == 0) return "";
		for(int i = 0; i < chatList.size(); i++) {
			result.append("[{\"value\": \"" + chatList.get(i).getUser_nick() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getTo_nick() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getTrade_chatcontent() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getTrade_chattime() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getTrade_chatread() + "\"}]");
			if(i != chatList.size() -1) result.append(",");
		}
		result.append("], \"last\":\"" + chatList.get(chatList.size() -1).getTrade_chatno() + "\"}");
		return result.toString();
	}
	
	//채팅목록으로 이동
	@RequestMapping(value="/chat/chattingList", method = RequestMethod.GET)
	public ModelAndView goChattingList(HttpServletRequest request, HttpSession session, ChatDTO dto) throws Exception {
		String user_nick = (String) session.getAttribute("nickname");
		dto.setUser_nick(user_nick);
		List<ChatDTO> list = service.chatList(dto);
		dto.setUser_nick(user_nick);
		List<ChatDTO> list2 = service.chatList2(dto);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("list2", list2);
		
		return mav;
	}
	
	
	
	
/*--시공상담 채팅--*/
	
	
	
	//시공상담 채팅방으로이동
	@RequestMapping(value = "/chat/coun_chatting", method = RequestMethod.GET)
	public ModelAndView goCounChatting(HttpServletRequest request, InteriorDTO dto, HttpSession session, ChatDTO dto3) throws Exception {
		String com_name = request.getParameter("com_name");
		dto.setCom_name(com_name);
		InteriorDTO dto2 = service3.companyInfo(dto);

		String sessionNick = (String) session.getAttribute("nickname");

		//세션유저가 업체일때 닉네임으로 업체명 받아오기
		String user_nick_com = service.usernickComName(sessionNick);
		
		if (user_nick_com == null || user_nick_com == "" || user_nick_com.isEmpty()) {
			user_nick_com = "notCom"; // 업체가 아니라 유저(가져온 업체명이 없음)면 notCom 넣어주기
		}
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("user_nick_com", user_nick_com); // 세션 유저의 업체명 던지기
		mav.addObject("dto" , dto2);
		mav.setViewName("chat/coun_chatting");
		
		return mav;
	}
	
	//json(k,v)로 받으려면 post사용 해야함
	@RequestMapping(value="/chatInsertCoun.do", method = RequestMethod.POST )
	public void insertChatCoun(HttpServletRequest request, HttpServletResponse response, ChatDTO dto) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String com_name = URLDecoder.decode(request.getParameter("com_name"), "UTF-8");
		
		String user_nick = request.getParameter("user_nick");
		String to_nick = request.getParameter("to_nick");
		String coun_chatcontent = request.getParameter("coun_chatcontent");

		if(user_nick == null || user_nick.equals("") || to_nick == null || to_nick.equals("") 
				|| coun_chatcontent == null || coun_chatcontent.equals("")) {
			response.getWriter().write("0");
		} else {
			
			user_nick = URLDecoder.decode(user_nick, "UTF-8");
			to_nick = URLDecoder.decode(to_nick, "UTF-8");
			coun_chatcontent = URLDecoder.decode(coun_chatcontent, "UTF-8");
			
			//세션유저가 업체일때 닉네임으로 업체명 받아오기
			String user_nick_com = service.usernickComName(user_nick);
			
			if (user_nick_com == null || user_nick_com == "" || user_nick_com.isEmpty()) { 
				// 일반 유저일 경우
			} else {
				user_nick = user_nick_com; // 기업이면 user_nick(보내는 사람)에 기업명 넣기
			}
			
			dto.setUser_nick(user_nick);
			dto.setTo_nick(to_nick);
			dto.setCoun_chatcontent(coun_chatcontent.replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
			dto.setCom_name(com_name);
			
			service.insertChatCoun(dto);
		}
	}
	
	@RequestMapping(value="/chatListCoun.do", method = RequestMethod.POST )
	public void listChatCoun(HttpServletRequest request, HttpServletResponse response, ChatDTO dto) throws Exception {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String user_nick = request.getParameter("user_nick");
		String to_nick = request.getParameter("to_nick");
		String listType = request.getParameter("listType");
		String com_name = request.getParameter("com_name");
		
		if(user_nick == null || user_nick.equals("") || to_nick == null || to_nick.equals("") 
				|| listType == null || listType.equals("")) {
			response.getWriter().write("");
		} else if(listType.equals("ten")) {
			response.getWriter().write(getTenCoun(URLDecoder.decode(user_nick,"utf-8"), URLDecoder.decode(to_nick,"utf-8"), 100, com_name));
		} else {
			try {
				response.getWriter().write(getIDCoun(URLDecoder.decode(user_nick,"utf-8"), URLDecoder.decode(to_nick,"utf-8"), listType, com_name));
			} catch (Exception e) {
				response.getWriter().write("");
			}
		}
	}
	
	
	//최대 100개까지 출력하게끔함
	public String getTenCoun(String user_nick, String to_nick, int number, String com_name) throws Exception {
		ChatDTO dto = new ChatDTO();
		
		//세션유저가 업체일때 닉네임으로 업체명 받아오기
		String user_nick_com = service.usernickComName(user_nick);
		
		if (user_nick_com == null || user_nick_com == "" || user_nick_com.isEmpty()) { 
			//일반 유저일때
		} else {
			user_nick = user_nick_com; // 기업이면 user_nick(보내는 사람)에 기업명 넣기
		}
		
		dto.setUser_nick(user_nick);
		dto.setTo_nick(to_nick);
		
		dto.setNumber(number);
		dto.setCom_name(com_name);
		
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		
		List<ChatDTO> chatList = service.selectChatLimitCoun(dto);
		
		if(chatList.size() == 0) return "";
		
		for(int i = 0; i < chatList.size(); i++) {
			result.append("[{\"value\": \"" + chatList.get(i).getUser_nick() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getTo_nick() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getCoun_chatcontent() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getCoun_chattime() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getCoun_chatread() + "\"}]");
			if(i != chatList.size() -1) result.append(",");
		}
		result.append("], \"last\":\"" + chatList.get(chatList.size() -1).getCoun_chatno() + "\"}");
		return result.toString();
	}
	
	public String getIDCoun(String user_nick, String to_nick, String list_type, String com_name) throws Exception {
		ChatDTO dto = new ChatDTO();
		
		//세션유저가 업체일때 닉네임으로 업체명 받아오기
		String user_nick_com = service.usernickComName(user_nick);
		
		if (user_nick_com == null || user_nick_com == "" || user_nick_com.isEmpty()) { // 해당기업이면 user_nick(보내는 사람)에 기업명 넣기
			//일반 유저일때
		} else {
			user_nick = user_nick_com; // 기업이면 user_nick(보내는 사람)에 기업명 넣기
		}
		
		dto.setUser_nick(user_nick);
		dto.setTo_nick(to_nick);
		
		dto.setListType(list_type);
		dto.setCom_name(com_name);
		
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		List<ChatDTO> chatList = service.selectChatCoun(dto);
		if(chatList.size() == 0) return "";
		for(int i = 0; i < chatList.size(); i++) {
			result.append("[{\"value\": \"" + chatList.get(i).getUser_nick() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getTo_nick() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getCoun_chatcontent() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getCoun_chattime() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getCoun_chatread() + "\"}]");
			if(i != chatList.size() -1) result.append(",");
		}
		result.append("], \"last\":\"" + chatList.get(chatList.size() -1).getCoun_chatno() + "\"}");
		return result.toString();
	}
	
	
	//시공상담 채팅목록으로 이동
	@RequestMapping(value="/chat/coun_chattingList", method = RequestMethod.GET)
	public ModelAndView goCounChattingList(HttpServletRequest request, HttpSession session, ChatDTO dto) throws Exception {
		
		String user_nick = (String) session.getAttribute("nickname");
		
		//세션유저가 업체일때 닉네임으로 업체명 받아오기
		String user_nick_com = service.usernickComName(user_nick);
		
		if (user_nick_com == null || user_nick_com == "" || user_nick_com.isEmpty()) { 
			//일반 유저일때
		} else {
			user_nick = user_nick_com; // 기업이면 user_nick(보내는 사람)에 기업명 넣기
		}
		dto.setUser_nick(user_nick);
		
		List<ChatDTO> list = null;
		
		if (user_nick_com == null || user_nick_com == "" || user_nick_com.isEmpty()) { 
			list = service.getChatListCounUser(dto); //일반 유저일때
		} else {
			list = service.getChatListCounCom(dto); // 기업이면 user_nick(보내는 사람)에 기업명 넣기
		}
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		
		return mav;
	}
}
