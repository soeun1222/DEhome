package com.green.dehome.dao;

import java.util.List;

import com.green.dehome.dto.InteriorDTO;


public interface InteriorDAO {
	//해당 유저 위치 정보
	public String userAddr(String user_nick) throws Exception;
	
	//시공업체 기본 리스트
	public List<InteriorDTO> locList(String addr) throws Exception;
	
	//시공업체 더보기 리스트
	public List<InteriorDTO> moreLocList(InteriorDTO dto) throws Exception;
	
	//해당 유저 업체명
	public String userComName(String user_nick) throws Exception;
	
	//해당 업체 정보
	public InteriorDTO companyInfo(InteriorDTO dto) throws Exception;
	
	//해당 업체 리뷰 기본 리스트
	public List<InteriorDTO> comReivew(String com_name) throws Exception;
	
	//해당 업체 리뷰 더보기 리스트
	public List<InteriorDTO> moreReList(InteriorDTO dto) throws Exception;
	
	//해당 업체 사례 기본 리스트
	public List<InteriorDTO> comExample(String com_name) throws Exception;
		
	//해당 업체 사례 더보기 리스트
	public List<InteriorDTO> moreExList(InteriorDTO dto) throws Exception;
	
	//등록전인 업체명 받아오기
	public List<String> notInCompany() throws Exception;
	
	//업체 등록하기
	public void companyRegist(InteriorDTO dto) throws Exception;
	
	//리뷰 등록하기
	public void reviewRegist(InteriorDTO dto) throws Exception;
	
	//리뷰 총점 더하기
	public void reSum(InteriorDTO dto) throws Exception;
	
	//리뷰 카운트 더하기
	public void reCount(InteriorDTO dto) throws Exception;
	
	//리뷰 등록시 업체 평점 업데이트
	public void reRating(InteriorDTO dto) throws Exception;
	
	//해당 리뷰 정보
	public InteriorDTO reviewShow(InteriorDTO dto) throws Exception;
	
	
	//해당 유저 리뷰 좋아요 클릭 유무
	public InteriorDTO likeOnOff(InteriorDTO dto) throws Exception;
	
	//리뷰 좋아요 클릭시 좋아요 테이블에 더하기
	public void reviewLikeOn(InteriorDTO dto) throws Exception;
	
	//리뷰 좋아요 클릭시 좋아요 수 증가
	public void reInterestCountUp(InteriorDTO dto) throws Exception;
	
	//리뷰 좋아요 취소 클릭시 좋아요 테이블에서 삭제
	public void reviewLikeOff(InteriorDTO dto) throws Exception;
	
	//리뷰 좋아요 취소 클릭시 좋아요 수 차감
	public void reInterestCountDown(InteriorDTO dto) throws Exception;
	
	//좋아요 갯수 카운트
	public String likeCount(InteriorDTO dto) throws Exception;
	
	
	//시공사례 등록하기
	public void exRegist(InteriorDTO dto) throws Exception;
	
	//시공사례 카운트 더하기
	public void exCount(InteriorDTO dto) throws Exception;
	
	//해당 시공사례 정보
	public InteriorDTO exShow(InteriorDTO dto) throws Exception;
	
	//업체 수정하기
	public void comEdit(InteriorDTO dto) throws Exception;
	
	//업체 사진 수정하기
	public void comEditFile(InteriorDTO dto) throws Exception;
	
	//리뷰 수정하기
	public void reEdit(InteriorDTO dto) throws Exception;
	
	//리뷰 사진 수정하기
	public void reEditFile(InteriorDTO dto) throws Exception;
	
	//리뷰 삭제하기
	public void reDelete(InteriorDTO dto) throws Exception;
	
	//시공사례 수정하기
	public void exEdit(InteriorDTO dto) throws Exception;
	
	//시공사례 사진 수정하기
	public void exEditFile(InteriorDTO dto) throws Exception;

	//시공사례 삭제하기
	public void exDelete(InteriorDTO dto) throws Exception;
	
	//실제 리뷰 카운트 들고오기
	public int realReCount(InteriorDTO dto) throws Exception;
	
	//실제 시공사례 카운트 들고오기
	public int realExCount(InteriorDTO dto) throws Exception;
	
	//리뷰 삭제시 해당 리뷰 좋아요 삭제
	public void reLikeDelete(InteriorDTO dto) throws Exception;
	
	//시공 사례 등록시 리뷰 테이블에 해당 업체명 있는지 확인
	public String checkComNameforCons(InteriorDTO dto) throws Exception;
}
