package com.green.dehome.dao;

import java.util.List;

import com.green.dehome.dto.InteriorDTO;
import com.green.dehome.dto.InteriorTipDTO;

public interface InteriorTipDAO {
	//카테고리별 전체 인테리어팁 리스트 
	public List<InteriorTipDTO> tipListConstruct(InteriorTipDTO dto) throws Exception;
	public List<InteriorTipDTO> tipListStorage(InteriorTipDTO dto) throws Exception;
	public List<InteriorTipDTO> tipListDecorate(InteriorTipDTO dto) throws Exception;
	public List<InteriorTipDTO> tipListCleaning(InteriorTipDTO dto) throws Exception;
	public List<InteriorTipDTO> tipListDiy(InteriorTipDTO dto) throws Exception;
	public List<InteriorTipDTO> tipListReform(InteriorTipDTO dto) throws Exception;
	public List<InteriorTipDTO> tipListKitchen(InteriorTipDTO dto) throws Exception;
	public List<InteriorTipDTO> tipListLighting(InteriorTipDTO dto) throws Exception;
	
	//카테고리별 인테리어팁 리스트
	public List<InteriorTipDTO> tipListCategory(InteriorTipDTO dto, String category) throws Exception;
	
	//인테리어팁 상세페이지
	public InteriorTipDTO tipListPage(InteriorTipDTO dto, int tip_no);
	
	//인테리어팁 작성
	public void tipWrite(InteriorTipDTO dto) throws Exception;
	
	//조회수 증가
	public void setCount(int tip_no);
	
	//북마크 등록
	public void tipBookmark(InteriorTipDTO dto) throws Exception;
	
	//해당 유저 북마크 클릭 유무
	public InteriorTipDTO bmOnOff(InteriorTipDTO dto) throws Exception;
		
	//북마크 등록 시 북마크 테이블에 업데이트
	public void bmOn(InteriorTipDTO dto) throws Exception;
		
	//북마크가 0일때 북마크 등록 시 컬럼에 닉네임 저장
	public void bmUpdate(InteriorTipDTO dto) throws Exception;
	
	//북마크가 0이 아닐때 북마크 등록 시 컬럼에 닉네임 추가 저장
	public void bmUpdateCon(InteriorTipDTO dto) throws Exception;
	
	//북마크 등록 취소 시 북마크 테이블에서 삭제
	public void bmOff(InteriorTipDTO dto) throws Exception;
	
	//북마크가 1 일때 북마크 등록 취소 시 닉네임 제거
	public void bmReplaceOne(InteriorTipDTO dto) throws Exception;
	
	//북마크가 2 이상일때 북마크 등록 취소 시 닉네임 제거
	public void bmReplace(InteriorTipDTO dto) throws Exception;
	
	//북마크 등록 시 북마크 수 증가
	public void bmCountUp(InteriorTipDTO dto) throws Exception;
	
	//북마크 등록 취소 시 북마크 수 차감
	public void bmCountDown(InteriorTipDTO dto) throws Exception;
		
	//북마크 등록 개수 출력
	public String bmCount(InteriorTipDTO dto) throws Exception;
}
