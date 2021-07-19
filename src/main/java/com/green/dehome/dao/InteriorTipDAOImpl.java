package com.green.dehome.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.green.dehome.dto.InteriorDTO;
import com.green.dehome.dto.InteriorTipDTO;

@Repository
public class InteriorTipDAOImpl implements InteriorTipDAO {
	
	@Inject
	private SqlSession sql;
	
	@Override
	public List<InteriorTipDTO> tipListConstruct(InteriorTipDTO dto) {
		return sql.selectList("mappers.interiorTipMapper.tipListConstruct", dto);
	}

	@Override
	public List<InteriorTipDTO> tipListStorage(InteriorTipDTO dto) {
		return sql.selectList("mappers.interiorTipMapper.tipListStorage", dto);
	}

	@Override
	public List<InteriorTipDTO> tipListDecorate(InteriorTipDTO dto) {
		return sql.selectList("mappers.interiorTipMapper.tipListDecorate", dto);
	}

	@Override
	public List<InteriorTipDTO> tipListCleaning(InteriorTipDTO dto) {
		return sql.selectList("mappers.interiorTipMapper.tipListCleaning", dto);
	}

	@Override
	public List<InteriorTipDTO> tipListDiy(InteriorTipDTO dto) {
		return sql.selectList("mappers.interiorTipMapper.tipListDiy", dto);
	}

	@Override
	public List<InteriorTipDTO> tipListReform(InteriorTipDTO dto) {
		return sql.selectList("mappers.interiorTipMapper.tipListReform", dto);
	}

	@Override
	public List<InteriorTipDTO> tipListKitchen(InteriorTipDTO dto) {
		return sql.selectList("mappers.interiorTipMapper.tipListKitchen", dto);
	}

	@Override
	public List<InteriorTipDTO> tipListLighting(InteriorTipDTO dto) {
		return sql.selectList("mappers.interiorTipMapper.tipListLighting", dto);
	}
	
	@Override
	public List<InteriorTipDTO> tipListCategory(InteriorTipDTO dto, String category) {
		return sql.selectList("mappers.interiorTipMapper.tipListCategory", category);
	}
	
	@Override
	public void tipWrite(InteriorTipDTO dto) throws Exception {
		sql.insert("mappers.interiorTipMapper.tipWrite", dto);
	}

	@Override
	public InteriorTipDTO tipListPage(InteriorTipDTO dto, int tip_no) {
		return sql.selectOne("mappers.interiorTipMapper.tipListPage", tip_no);
	}

	@Override
	public void setCount(int tip_no) {
		sql.update("mappers.interiorTipMapper.setCount", tip_no);
	}

	@Override
	public void tipBookmark(InteriorTipDTO dto) throws Exception {
		sql.insert("mappers.interiorTipMapper.tipBookmark", dto);
	}

	@Override
	public InteriorTipDTO bmOnOff(InteriorTipDTO dto) throws Exception {
		return sql.selectOne("mappers.interiorTipMapper.bmOnOff", dto);
	}

	@Override
	public void bmOn(InteriorTipDTO dto) throws Exception {
		sql.insert("mappers.interiorTipMapper.bmOn", dto);
	}

	@Override
	public void bmOff(InteriorTipDTO dto) throws Exception {
		sql.delete("mappers.interiorTipMapper.bmOff", dto);
	}

	@Override
	public void bmCountUp(InteriorTipDTO dto) throws Exception {
		sql.update("mappers.interiorTipMapper.bmCountUp", dto);
	}

	@Override
	public void bmCountDown(InteriorTipDTO dto) throws Exception {
		sql.update("mappers.interiorTipMapper.bmCountDown", dto);
	}

	@Override
	public String bmCount(InteriorTipDTO dto) throws Exception {
		return sql.selectOne("mappers.interiorTipMapper.bmCount", dto);
	}

	@Override
	public void bmUpdate(InteriorTipDTO dto) throws Exception {
		sql.update("mappers.interiorTipMapper.bmUpdate", dto);
	}

	@Override
	public void bmUpdateCon(InteriorTipDTO dto) throws Exception {
		sql.update("mappers.interiorTipMapper.bmUpdateCon", dto);
	}

	@Override
	public void bmReplaceOne(InteriorTipDTO dto) throws Exception {
		sql.update("mappers.interiorTipMapper.bmReplaceOne", dto);
	}

	@Override
	public void bmReplace(InteriorTipDTO dto) throws Exception {
		sql.update("mappers.interiorTipMapper.bmReplace", dto);
	}

}