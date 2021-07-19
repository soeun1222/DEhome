package com.green.dehome.controller;

import java.net.URLEncoder;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.scribejava.core.model.Response;
import com.green.dehome.dto.TradeBoardDTO;
import com.green.dehome.dto.TradeBoardPaging;
import com.green.dehome.dto.TradeBoardPagingDTO;
import com.green.dehome.service.TradeBoardService;
import com.green.dehome.service.TradeBoardServiceImpl;



@Controller
public class TradeBoardController {
	@Inject TradeBoardService service;
	private static final Logger logger = LoggerFactory.getLogger(TradeBoardController.class);
	
	@RequestMapping(value = "/trade/tr_board_write", method = RequestMethod.GET)
	public void writeView() throws Exception{
		logger.info("writeView");
	}
	
	
	@RequestMapping(value = "/trade/tr_board_write", method = RequestMethod.POST)
	public String writeTradeBoard(TradeBoardDTO dto) throws Exception {
//		if (Integer.toString(dto.getTr_board_id()) == null) {
//			dto.setTr_board_id(1);
//		}
		logger.info("write");
		service.writeTradeBoard(dto);
		return "redirect:/trade/tr_board_list";
	}
	

	@RequestMapping(value = "/trade/tr_board_list", method = RequestMethod.GET)
	public String tradeBoardList(@ModelAttribute("TradeBoardDTO") TradeBoardDTO dto,
            					@RequestParam(defaultValue="1") int curPage,
            					HttpServletRequest request,Model model) throws Exception{
		//페이지 시작 인덱스 
		int startIndex = (curPage-1 )*10;
		List<TradeBoardDTO> list  = service.tradeBoardList(startIndex);
		
		int listCnt = service.countBoard();
		TradeBoardPaging pagingDto = new TradeBoardPaging(listCnt, curPage);
		
		model.addAttribute("list", list);
		model.addAttribute("listCnt", listCnt);
        
        model.addAttribute("paging", pagingDto);
        return "trade/tr_board_list";
	}
	

	
	
	
	// 게시판 글 가져오기(조회)
	@RequestMapping(value = "/trade/tr_board_show", method = RequestMethod.GET)
	public String showTradeBoard(HttpServletRequest request
							, @RequestParam("board_id") int board_id
							, Model model
							, HttpSession session
							, HttpServletResponse response) throws Exception{
		
		String nickname = (String) session.getAttribute("nickname");
		
		TradeBoardDTO dto = service.showTradeBoard(board_id);
	     // 조회수 중복 쿠키
	      Cookie[] cookies = request.getCookies();
	      // 비교하기 위해 새로운 쿠키
	      Cookie viewCookie = null;
	      
	      if (cookies != null && cookies.length > 0) {
	          for (int i = 0; i < cookies.length; i++){
	              if (cookies[i].getName().equals("|" + board_id + "|") ){ 
	                  viewCookie = cookies[i];
	                  
	              }
	          }
	      }
	      
	      if (viewCookie == null) {
	          Cookie newCookie = new Cookie("|" + board_id + "|", URLEncoder.encode(nickname, "UTF-8"));
	          if(!dto.getUser_nick().equals(nickname)) {
	             newCookie.setMaxAge(1*24*60*60);
	             response.addCookie(newCookie);
	             service.hitUp(board_id);
	          }
	          
	       } else {
	          String value = viewCookie.getValue();
	       }
	      
		
		int count = service.getHit(board_id);
		dto.setBoard_count(count);
		model.addAttribute("show",dto);
		return "trade/tr_board_show";
	}
		
	// 게시판 글 수정
	@RequestMapping(value = "/trade/tr_board_edit", method = RequestMethod.GET)
	public void editView(@RequestParam("board_id") int board_id, Model model) throws Exception{
		TradeBoardDTO dto = service.showTradeBoard(board_id);
		
		model.addAttribute("show",dto);
	}
	
	@RequestMapping(value = "/trade/tr_board_edit", method = RequestMethod.POST)
	public String editTradeBoard(TradeBoardDTO dto, HttpServletRequest request) throws Exception{
		
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		dto.setBoard_id(board_id);
		service.editTradeBoard(dto);
		
		return "redirect:/trade/tr_board_list";
	}
	

	// 게시물 삭제
	@RequestMapping(value = "/trade/tr_board_delete", method = RequestMethod.GET)
	public String deleteTradeBoard(@RequestParam("board_id") int board_id) throws Exception {
	  
	 service.deleteTradeBoard(board_id);  

	 return "redirect:/trade/tr_board_list";
	}
	
}
