package com.green.dehome.service;

import java.util.List;

import com.green.dehome.dto.MyPageUl2DTO;

public interface MyPageUl2Service {
	// 내가 작성한 인테리어 팁 리스트 출력
	public List<MyPageUl2DTO> myTipList(MyPageUl2DTO dto) throws Exception;
	
	// 내가 북마크한 인테리어 팁 리스트 출력
	public List<MyPageUl2DTO> myBmTipList(MyPageUl2DTO dto) throws Exception;
	
	// 내가 등록한 중고거래 물품 (판매)
	public List<MyPageUl2DTO> mySellList(MyPageUl2DTO dto) throws Exception;

	// 내가 구매한 중고거래 물품
	public List<MyPageUl2DTO> myBuyList(MyPageUl2DTO dto) throws Exception;
	
	// 내가 등록한 중고거래 물품 좋아요 갯수
	public int likeCount(int tr_no) throws Exception;
	
	// 내가 작성한 QNA
	public List<MyPageUl2DTO> myQnaList(MyPageUl2DTO dto) throws Exception;
}
