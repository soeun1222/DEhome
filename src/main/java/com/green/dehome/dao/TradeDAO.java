package com.green.dehome.dao;

import java.util.List;

import com.green.dehome.dto.TradeDTO;

public interface TradeDAO {
	
	//중고거래 물품등록
	public void tradeRegister(TradeDTO dto) throws Exception; 
	//중고거래 메인화면(리스트 출력)
	public List<TradeDTO> tradeList(TradeDTO dto) throws Exception;
	//중고거래 메인화면(리스트 출력) - 더보기
	public List<TradeDTO> tradeListMore(TradeDTO dto, int page) throws Exception;
	//중고거래 메인화면 카테고리별 리스트 출력
	public List<TradeDTO> tradeListCategory(TradeDTO dto, String category) throws Exception;
	//중고거래 메인화면 카테고리별 리스트 출력 - 더보기
	public List<TradeDTO> tradeListCategoryMore(TradeDTO dto, String category) throws Exception;
	//중고거래 메인화면 동네검색시 리스트(리스트 출력)
	public List<TradeDTO> tradeListSearch(TradeDTO dto, String search_area) throws Exception;
	//중고거래 리스트에서 상세페이지 이동
	public TradeDTO tradeShow(TradeDTO dto, int tr_no);
	//중고거래 상세페이지에 넣을 주소가져오기
	public String getAddr2(String user_nick);
	//조회수 올려주기
	public void setCount(int tr_no);
	//거래완료
	public void completeChange(int tr_no);
	//구매자 이름 추가
	public void completeAdd(TradeDTO dto);
	//중고거래 글 관심 +1
	public void heartIn(TradeDTO dto);
	//하트 눌렀는지 확인
	public int heartCheck(TradeDTO dto);
	// 하트 총갯수
	public int heartCount(TradeDTO dto);
	//중고거래 등록 수정 폼
	public TradeDTO tradeShowEdit(TradeDTO dto, int tr_no);
	//중고거래 수정등록
	public void update_goods(TradeDTO dto);
	//중고거래 수정등록 - 사진분류
	public void update_goods_photo(TradeDTO dto);
	//글당 관심갯수
	public List<TradeDTO> allHeart(TradeDTO dto);
	//관심도 삭제
	public void delete_goods_interest(int tr_no);
	//채팅 삭제
	public void delete_goods_chat(int tr_no);
	//관심도 삭제 후 중고거래올린 글 삭제 
	public void delete_goods(int tr_no);
}
