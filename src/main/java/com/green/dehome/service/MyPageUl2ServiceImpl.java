package com.green.dehome.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.green.dehome.dao.MyPageUl2DAO;
import com.green.dehome.dto.MyPageUl2DTO;

@Service
public class MyPageUl2ServiceImpl implements MyPageUl2Service {
	
	@Inject
	private MyPageUl2DAO dao;
	
	@Override
	public List<MyPageUl2DTO> myTipList(MyPageUl2DTO dto) throws Exception {
		return dao.myTipList(dto);
	}

	@Override
	public List<MyPageUl2DTO> myBmTipList(MyPageUl2DTO dto) throws Exception {
		return dao.myBmTipList(dto);
	}

	@Override
	public List<MyPageUl2DTO> mySellList(MyPageUl2DTO dto) throws Exception {
		return dao.mySellList(dto);
	}
	
	@Override
	public List<MyPageUl2DTO> myBuyList(MyPageUl2DTO dto) throws Exception {
		return dao.myBuyList(dto);
	}

	@Override
	public int likeCount(int tr_no) throws Exception {
		return dao.likeCount(tr_no);
	}

	@Override
	public List<MyPageUl2DTO> myQnaList(MyPageUl2DTO dto) throws Exception {
		return dao.myQnaList(dto);
	}


}
