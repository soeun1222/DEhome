package com.green.dehome.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.green.dehome.dto.TradeDTO;

@Repository
public class TradeDAOImpl implements TradeDAO {

	@Inject SqlSession sql;
	
	@Override
	public void tradeRegister(TradeDTO dto) throws Exception {
		sql.insert("mappers.tradeMapper.register_goods", dto);
	}

	@Override
	public List<TradeDTO> tradeList(TradeDTO dto) throws Exception {
		return sql.selectList("mappers.tradeMapper.tradeList");
	}


	@Override
	public List<TradeDTO> tradeListCategory(TradeDTO dto, String category) throws Exception {
		return	sql.selectList("mappers.tradeMapper.tradeListCategory", category);
	}

	@Override
	public List<TradeDTO> tradeListMore(TradeDTO dto, int page) throws Exception {
		return sql.selectList("mappers.tradeMapper.tradeListMore", page);
	}

	@Override
	public List<TradeDTO> tradeListCategoryMore(TradeDTO dto, String category) throws Exception {
		return	sql.selectList("mappers.tradeMapper.tradeListCategoryMore", category);
	}

	@Override
	public List<TradeDTO> tradeListSearch(TradeDTO dto,String search_area) throws Exception {
		return sql.selectList("mappers.tradeMapper.tradeList_search", search_area);
	}

	@Override
	public TradeDTO tradeShow(TradeDTO dto, int tr_no) {
		return sql.selectOne("mappers.tradeMapper.tradeShow", tr_no);
	}

	@Override
	public String getAddr2(String user_nick) {
		return sql.selectOne("mappers.tradeMapper.getAddr2", user_nick);
	}

	@Override
	public void setCount(int tr_no) {
		sql.update("mappers.tradeMapper.setCount", tr_no);
	}

	@Override
	public void completeChange(int tr_no) {
		sql.update("mappers.tradeMapper.completeChange", tr_no);
	}
	@Override
	public void completeAdd(TradeDTO dto) {
		sql.update("mappers.tradeMapper.completeAdd", dto);
	}	
	@Override
	public void heartIn(TradeDTO dto) {
		sql.insert("mappers.tradeMapper.heartIN", dto);
	}

	@Override
	public int heartCheck(TradeDTO dto) {
		return sql.selectOne("mappers.tradeMapper.heartCheck", dto);
	}

	@Override
	public int heartCount(TradeDTO dto) {
		return sql.selectOne("mappers.tradeMapper.heartCount", dto);
	}

	@Override
	public TradeDTO tradeShowEdit(TradeDTO dto, int tr_no) {
		return sql.selectOne("mappers.tradeMapper.tradeShowEdit", tr_no);
	}

	@Override
	public void update_goods(TradeDTO dto) {
		sql.update("mappers.tradeMapper.update_goods", dto);
	}
	
	@Override
	public void update_goods_photo(TradeDTO dto) {
		sql.update("mappers.tradeMapper.update_goods_photo", dto);
	}

	@Override
	public List<TradeDTO> allHeart(TradeDTO dto) {
		return sql.selectOne("mappers.tradeMapper.allHeart", dto);
	}

	@Override
	public void delete_goods_interest(int tr_no) {
		sql.delete("mappers.tradeMapper.delete_goods_interest", tr_no);
	}
	@Override
	public void delete_goods_chat(int tr_no) {
		sql.delete("mappers.tradeMapper.delete_chat", tr_no);
	}

	@Override
	public void delete_goods(int tr_no) {
		sql.delete("mappers.tradeMapper.delete_goods", tr_no);
	}
}
