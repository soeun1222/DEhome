package com.green.dehome.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.green.dehome.dao.TradeDAO;
import com.green.dehome.dto.TradeDTO;

@Service
public class TradeServiceImpl implements TradeService {
	
	@Inject
	TradeDAO dao;

	@Override
	public void tradeRegister(TradeDTO dto) throws Exception {
		dao.tradeRegister(dto);
	}

	@Override
	public List<TradeDTO> tradeList(TradeDTO dto) throws Exception {
		return dao.tradeList(dto);
	}

	@Override
	public List<TradeDTO> tradeListSearch(TradeDTO dto,String search_area) throws Exception {
		return dao.tradeListSearch(dto,search_area);
	}

	@Override
	public List<TradeDTO> tradeListCategory(TradeDTO dto, String category) throws Exception {
		return dao.tradeListCategory(dto,category);
	}

	@Override
	public List<TradeDTO> tradeListMore(TradeDTO dto, int page) throws Exception {
		return dao.tradeListMore(dto, page);
	}

	@Override
	public List<TradeDTO> tradeListCategoryMore(TradeDTO dto, String category) throws Exception {
		return dao.tradeListCategoryMore(dto, category);
	}

	@Override
	public TradeDTO tradeShow(TradeDTO dto, int tr_no) {
		return dao.tradeShow(dto, tr_no);
	}

	@Override
	public String getAddr2(String user_nick) {
		return dao.getAddr2(user_nick);
	}

	@Override
	public void setCount(int tr_no) {
		dao.setCount(tr_no);
	}

	@Override
	public void completeChange(int tr_no) {
		dao.completeChange(tr_no);
	}

	@Override
	public void completeAdd(TradeDTO dto) {
		dao.completeAdd(dto);
	}
	
	
	@Override
	public void heartIn(TradeDTO dto) {
		dao.heartIn(dto);
	}

	@Override
	public int heartCheck(TradeDTO dto) {
		return dao.heartCheck(dto);
	}

	@Override
	public int heartCount(TradeDTO dto) {
		return dao.heartCount(dto);
	}

	@Override
	public TradeDTO tradeShowEdit(TradeDTO dto, int tr_no) {
		return dao.tradeShowEdit(dto, tr_no);
	}

	@Override
	public void update_goods(TradeDTO dto) {
		dao.update_goods(dto);
	}
	
	@Override
	public void update_goods_photo(TradeDTO dto) {
		dao.update_goods_photo(dto);
	}

	@Override
	public List<TradeDTO> allHeart(TradeDTO dto) {
		return dao.allHeart(dto);
	}

	@Override
	public void delete_goods_interest(int tr_no) {
		dao.delete_goods_interest(tr_no);
	}
	@Override
	public void delete_goods_chat(int tr_no) {
		dao.delete_goods_chat(tr_no);
	}

	@Override
	public void delete_goods(int tr_no) {
		dao.delete_goods(tr_no);
	}
}
