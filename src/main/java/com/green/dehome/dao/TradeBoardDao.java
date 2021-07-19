package com.green.dehome.dao;

import java.util.List;
import java.util.Map;

import com.green.dehome.dto.TradeBoardDTO;

public interface TradeBoardDao {

	public void writeTradeBoard(TradeBoardDTO dto) throws Exception;
//	public List<TradeBoardDTO> tradeBoardList() throws Exception;
	public List<TradeBoardDTO> tradeBoardList(int startIndex) throws Exception;
	
	public int countBoard();

	public TradeBoardDTO showTradeBoard(int board_id) throws Exception;
	public void editTradeBoard(TradeBoardDTO dto) throws Exception;
	// 게시물 삭제
	public void deleteTradeBoard(int board_id) throws Exception;
	
	public void hitUp(int board_id) throws Exception;
	public int getHit(int board_id) throws Exception;
}
