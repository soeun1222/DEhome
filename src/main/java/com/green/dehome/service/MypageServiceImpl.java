package com.green.dehome.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.green.dehome.dao.MypageDao;
import com.green.dehome.dto.InteriorReviewDTO;
import com.green.dehome.dto.MyTradeDTO;
import com.green.dehome.dto.MypageDTO;
import com.green.dehome.dto.TradeBoardDTO;


@Service
public class MypageServiceImpl implements MypageService {
	@Inject
	private MypageDao dao;
	
	@Override
	public MypageDTO getUser(String user_nick) throws Exception {
		return dao.getUser(user_nick);
	}

	@Override
	public void editUser(MypageDTO dto) throws Exception {
		dao.editUser(dto);
	}

	@Override
	public String getPw(String user_nick) throws Exception {
		return dao.getPw(user_nick);
	}

	@Override
	public void deleteUser(String user_nick) throws Exception {
		dao.deleteUser(user_nick);
	}

	@Override
	public List<InteriorReviewDTO> myReview(String user_nick) throws Exception {
		return dao.myReview(user_nick);
	}

//	@Override
//	public List<InteriorReviewDTO> myReviewMore(Map<String, Object> map) throws Exception {
//		return dao.myReviewMore(map);
//	}
	@Override
	public float myReviewCompany(String com_name) throws Exception {
		return dao.myReviewCompany(com_name);
	}

	@Override
	public List<TradeBoardDTO> myTradeBoardList(Map<String, Object> map) throws Exception {
		return dao.myTradeBoardList(map);
	}

	@Override
	public int myBoardCount(String user_nick) throws Exception {
		return dao.myBoardCount(user_nick);
	}
	
	@Override
	public List<MyTradeDTO> myTradeList(String user_nick) throws Exception {
		return dao.myTradeList(user_nick);
	}

	@Override
	public List<MyTradeDTO> mySellList(String user_nick) throws Exception {
		return dao.mySellList(user_nick);
	}

	@Override
	public int sumInterest(int trade_no) throws Exception {
		return dao.sumInterest(trade_no);
	}

	@Override
	public List<MyTradeDTO> myBuyList(String user_nick) throws Exception {
		return dao.myBuyList(user_nick);
	}

	@Override
	public List<InteriorReviewDTO> myReviewMore(InteriorReviewDTO dto) {
		return dao.myReviewMore(dto);
	}


}
