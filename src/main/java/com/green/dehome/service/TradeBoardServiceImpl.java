package com.green.dehome.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.dehome.dao.TradeBoardDao;
import com.green.dehome.dto.TradeBoardDTO;

@Service
public class TradeBoardServiceImpl implements TradeBoardService {

	@Inject
	private TradeBoardDao dao;
	
	@Override
	public void writeTradeBoard(TradeBoardDTO dto) throws Exception {
		dao.writeTradeBoard(dto);
	}

//	@Override
//	public List<TradeBoardDTO> tradeBoardList() throws Exception {
//		return dao.tradeBoardList();
//	}
	
	@Override
	public List<TradeBoardDTO> tradeBoardList(int startIndex) throws Exception {
		return dao.tradeBoardList(startIndex);
	}

	@Override
	public int countBoard() {
		return dao.countBoard();
	}
	

	@Override
	public TradeBoardDTO showTradeBoard(int board_id) throws Exception {
		return dao.showTradeBoard(board_id);
	}

	@Override
	public void editTradeBoard(TradeBoardDTO dto) throws Exception {
		dao.editTradeBoard(dto);
	}

	@Override
	public void deleteTradeBoard(int board_id) throws Exception {
		dao.deleteTradeBoard(board_id);
	}

	@Override
	public void hitUp(int board_id) throws Exception {
		dao.hitUp(board_id);
		
	}

	@Override
	public int getHit(int board_id) throws Exception {
		return dao.getHit(board_id);
	}


}
