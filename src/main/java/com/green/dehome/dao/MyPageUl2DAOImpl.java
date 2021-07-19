package com.green.dehome.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.green.dehome.dto.MyPageUl2DTO;

@Repository
public class MyPageUl2DAOImpl implements MyPageUl2DAO {
	
	@Inject
	private SqlSession sql;
	
	@Override
	public List<MyPageUl2DTO> myTipList(MyPageUl2DTO dto) throws Exception {
		return sql.selectList("mappers.myPageUl2Mapper.myTipList", dto);
	}

	@Override
	public List<MyPageUl2DTO> myBmTipList(MyPageUl2DTO dto) throws Exception {
		return sql.selectList("mappers.myPageUl2Mapper.myBmTipList", dto);
	}

	@Override
	public List<MyPageUl2DTO> mySellList(MyPageUl2DTO dto) throws Exception {
		return sql.selectList("mappers.myPageUl2Mapper.mySellList", dto);
	}

	@Override
	public List<MyPageUl2DTO> myBuyList(MyPageUl2DTO dto) throws Exception {
		return sql.selectList("mappers.myPageUl2Mapper.myBuyList", dto);
	}
	
	@Override
	public int likeCount(int tr_no) throws Exception {
		return sql.selectOne("mappers.myPageUl2Mapper.likeCount", tr_no);
	}

	@Override
	public List<MyPageUl2DTO> myQnaList(MyPageUl2DTO dto) throws Exception {
		return sql.selectList("mappers.myPageUl2Mapper.myQnaList", dto);
	}


}
