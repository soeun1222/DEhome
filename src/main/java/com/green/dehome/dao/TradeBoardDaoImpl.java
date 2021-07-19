package com.green.dehome.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.green.dehome.dto.TradeBoardDTO;


@Repository
public class TradeBoardDaoImpl implements TradeBoardDao{
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void writeTradeBoard(TradeBoardDTO dto) throws Exception {
		sqlSession.insert("mappers.tradeBoardMapper.writeTradeBoard",dto);
	}

//	@Override
//	public List<TradeBoardDTO> tradeBoardList() throws Exception {
//		return sqlSession.selectList("mappers.tradeBoardMapper.tradeBoardList");
//	}
//	
	@Override
	public List<TradeBoardDTO> tradeBoardList(int startIndex) throws Exception {
		return sqlSession.selectList("mappers.tradeBoardMapper.selectBoard", startIndex);
	}
	
	@Override
	public int countBoard() {
		return sqlSession.selectOne("mappers.tradeBoardMapper.count");
	}
	
	@Override
	public TradeBoardDTO showTradeBoard(int board_id) throws Exception {
		return sqlSession.selectOne("mappers.tradeBoardMapper.showTradeBoard",board_id);
	}

	@Override
	public void editTradeBoard(TradeBoardDTO dto) throws Exception {
		sqlSession.update("mappers.tradeBoardMapper.editTradeBoard",dto);
	}
	
	@Override
	public void deleteTradeBoard(int board_id) throws Exception {
		sqlSession.delete("mappers.tradeBoardMapper.deleteTradeBoard", board_id);
	}
	
	@Override
	public void hitUp(int board_id) throws Exception {
		sqlSession.update("mappers.tradeBoardMapper.hitUp",board_id);
	}
	
//	@Override
//	public int pageCount(Map<String, Object> map) {
//		return sqlSession.selectOne("mappers.tradeBoardMapper.pageCount");
//	}
//
//	@Override
//	public List<TradeBoardDTO> searchBoard(Map<String, Object> map) {
//		return sqlSession.selectList("mappers.tradeBoardMapper.searchBoard");
//	}
//

	@Override
	public int getHit(int board_id) throws Exception {
		return sqlSession.selectOne("mappers.tradeBoardMapper.getHit", board_id);
	}




	
}
