package com.green.dehome.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.green.dehome.dto.MyPageUl2DTO;
import com.green.dehome.service.MyPageUl2Service;

@Controller
public class MyPageUl2Controller {

	@Inject
	MyPageUl2Service service;
	
	// 내가 작성한 인테리어 팁 리스트
	@RequestMapping(value = "/mypage/my_interior_tip", method = RequestMethod.GET)
	public ModelAndView getMyInteriorTip(HttpSession session, MyPageUl2DTO dto) throws Exception {
		// 세션에 닉네임 받아서 넣기
		String user_nick = (String) session.getAttribute("nickname");
		dto.setTip_user_nick(user_nick);
		
		ModelAndView mav = new ModelAndView();
		
		List<MyPageUl2DTO> myTipList = null;
		myTipList = service.myTipList(dto);
		mav.addObject("myTipList", myTipList);
		mav.addObject("bmuser", dto.getTip_bmuser());
		mav.addObject("nick", user_nick);
		
		return mav;
	}
	
	// 내가 북마크한 인테리어 팁 리스트
	@RequestMapping(value = "/mypage/my_bookmark", method = RequestMethod.GET)
	public ModelAndView getMyBmTip(HttpSession session, MyPageUl2DTO dto) throws Exception {
		// 세션에 닉네임 받아서 넣기
		String user_nick = (String) session.getAttribute("nickname");
		dto.setTip_user_nick(user_nick);
		
		ModelAndView mav = new ModelAndView();
		
		List<MyPageUl2DTO> myBmTipList = null;
		myBmTipList = service.myBmTipList(dto);
		mav.addObject("myBmTipList", myBmTipList);
		mav.addObject("bmuser", dto.getTip_bmuser());
		mav.addObject("nick", user_nick);
		
		return mav;
	}
	
	// 내가 작성한 중고거래 상품 ( 판매 )
	@RequestMapping(value = "/mypage/my_sell_list", method = RequestMethod.GET)
	public ModelAndView getMySellList(HttpSession session, MyPageUl2DTO dto) throws Exception {
		// 세션에 닉네임 받아서 넣기
		String user_nick = (String) session.getAttribute("nickname");
		dto.setTr_user_nick(user_nick);
		
		List<MyPageUl2DTO> mySellList = service.mySellList(dto);
		//좋아요 수 
		for (int i = 0; i < mySellList.size(); i++) {
			dto = mySellList.get(i);
			
			int tr_no = dto.getTr_no();
			
			int likeCount = service.likeCount(tr_no);
			
			if (likeCount != 0) {
				mySellList.get(i).setLike(likeCount);
			}else {
				mySellList.get(i).setLike(0);
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("mySellList", mySellList);
		mav.addObject("nick", user_nick);
		
		return mav;
	}
	
	// 내가 구매한 중고거래 상품
	@RequestMapping(value = "/mypage/my_buy_list", method = RequestMethod.GET)
	public ModelAndView getMyBuyList(HttpSession session, MyPageUl2DTO dto) throws Exception {
		// 세션에 닉네임 받아서 넣기
		String user_nick = (String) session.getAttribute("nickname");
		dto.setTr_user_nick(user_nick);
		
		List<MyPageUl2DTO> myBuyList = service.myBuyList(dto);
		//좋아요 수 
		for (int i = 0; i < myBuyList.size(); i++) {
			dto = myBuyList.get(i);
			
			int tr_no = dto.getTr_no();
			
			int likeCount = service.likeCount(tr_no);
			
			if (likeCount != 0) {
				myBuyList.get(i).setLike(likeCount);
			}else {
				myBuyList.get(i).setLike(0);
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("myBuyList", myBuyList);
		mav.addObject("nick", user_nick);
		
		return mav;
	}
	
	// 내가 작성한 QNA
	@RequestMapping(value = "/mypage/my_qna", method = RequestMethod.GET)
	public ModelAndView getMyQnaList(HttpSession session, MyPageUl2DTO dto) throws Exception {
		// 세션에 닉네임 받아서 넣기
		String user_nick = (String) session.getAttribute("nickname");
		dto.setQna_user_nick(user_nick);
		
		List<MyPageUl2DTO> myQnaList = service.myQnaList(dto);
		
		for(int i = 0; i < myQnaList.size(); i++) {
			if(myQnaList.get(i).getQna_type().equals("usedtrade")) {
				myQnaList.get(i).setQna_type("중고거래");
			}else if(myQnaList.get(i).getQna_type().equals("membership")){
				myQnaList.get(i).setQna_type("회원관련");
			}else if(myQnaList.get(i).getQna_type().equals("interrior")){
				myQnaList.get(i).setQna_type("인테리어");
			}
		}
		
		for(int i = 0; i < myQnaList.size(); i++) {
			if(myQnaList.get(i).getQna_process().equals("processing")) {
				myQnaList.get(i).setQna_process("처리중");
			}else if(myQnaList.get(i).getQna_process().equals("compelete")){
				myQnaList.get(i).setQna_process("답변완료");
			}
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("myQnaList", myQnaList);
		mav.addObject("nick", user_nick);
		
		return mav;
	}
}
