package com.green.dehome.dao;

import java.util.List;
import java.util.Map;

import com.green.dehome.dto.InteriorReviewDTO;
import com.green.dehome.dto.MyTradeDTO;
import com.green.dehome.dto.MypageDTO;
import com.green.dehome.dto.TradeBoardDTO;

public interface MypageDao {

	public MypageDTO getUser(String user_nick) throws Exception;
	public void editUser(MypageDTO dto) throws Exception;
	public String getPw(String user_nick) throws Exception;
	
	public void deleteUser(String user_nick) throws Exception;
	
	public List<InteriorReviewDTO> myReview(String user_nick)throws Exception;
	public List<InteriorReviewDTO> myReviewMore(Map<String, Object> map)throws Exception;
	public List<InteriorReviewDTO> myReviewMore(InteriorReviewDTO dto);
public float myReviewCompany(String com_name) throws Exception;
	
	public List<TradeBoardDTO> myTradeBoardList(Map<String, Object> map)throws Exception;
	public int myBoardCount(String user_nick) throws Exception;
	
	public List<MyTradeDTO> myTradeList(String user_nick)throws Exception;
	public List<MyTradeDTO> mySellList(String user_nick)throws Exception;
	public int sumInterest(int trade_no) throws Exception;
	public List<MyTradeDTO> myBuyList(String user_nick)throws Exception;
}
