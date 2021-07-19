package com.green.dehome.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.green.dehome.dto.InteriorDTO;


@Repository
public class InteriorDAOImpl implements InteriorDAO {
	
	@Inject SqlSession sql;

	@Override
	public String userAddr(String user_nick) throws Exception {
		return sql.selectOne("mappers.interiorMapper.userAddr", user_nick);
	}

	@Override
	public List<InteriorDTO> locList(String addr) throws Exception {
		return sql.selectList("mappers.interiorMapper.locList", addr);
	}

	@Override
	public List<InteriorDTO> moreLocList(InteriorDTO dto) throws Exception {
		return sql.selectList("mappers.interiorMapper.moreLocList", dto);
	}

	@Override
	public String userComName(String user_nick) throws Exception {
		return sql.selectOne("mappers.interiorMapper.userComName", user_nick);
	}

	@Override
	public InteriorDTO companyInfo(InteriorDTO dto) throws Exception {
		return sql.selectOne("mappers.interiorMapper.companyInfo", dto);
	}

	@Override
	public List<InteriorDTO> comReivew(String com_name) throws Exception {
		return sql.selectList("mappers.interiorMapper.comReivew", com_name);
	}

	@Override
	public List<InteriorDTO> moreReList(InteriorDTO dto) throws Exception {
		return sql.selectList("mappers.interiorMapper.moreReList", dto);
	}

	@Override
	public List<InteriorDTO> comExample(String com_name) throws Exception {
		return sql.selectList("mappers.interiorMapper.comExample", com_name);
	}

	@Override
	public List<InteriorDTO> moreExList(InteriorDTO dto) throws Exception {
		return sql.selectList("mappers.interiorMapper.moreExList", dto);
	}

	@Override
	public List<String> notInCompany() throws Exception {
		return sql.selectList("mappers.interiorMapper.notInCompany");
	}

	@Override
	public void companyRegist(InteriorDTO dto) throws Exception {
		sql.insert("mappers.interiorMapper.companyRegist", dto);
		
	}

	@Override
	public void reviewRegist(InteriorDTO dto) throws Exception {
		sql.insert("mappers.interiorMapper.reviewRegist", dto);
		
	}

	@Override
	public void reSum(InteriorDTO dto) throws Exception {
		sql.update("mappers.interiorMapper.reSum", dto);
		
	}

	@Override
	public void reCount(InteriorDTO dto) throws Exception {
		sql.update("mappers.interiorMapper.reCount", dto);
		
	}

	@Override
	public void reRating(InteriorDTO dto) throws Exception {
		sql.update("mappers.interiorMapper.reRating", dto);
		
	}

	@Override
	public InteriorDTO reviewShow(InteriorDTO dto) throws Exception {
		return sql.selectOne("mappers.interiorMapper.reviewShow", dto);
	}
	
	@Override
	public InteriorDTO likeOnOff(InteriorDTO dto) throws Exception {
		return sql.selectOne("mappers.interiorMapper.likeOnOff", dto);
	}

	@Override
	public void reviewLikeOn(InteriorDTO dto) throws Exception {
		sql.insert("mappers.interiorMapper.reviewLikeOn", dto);
		
	}

	@Override
	public void reInterestCountUp(InteriorDTO dto) throws Exception {
		sql.update("mappers.interiorMapper.reInterestCountUp", dto);
		
	}

	@Override
	public void reviewLikeOff(InteriorDTO dto) throws Exception {
		sql.delete("mappers.interiorMapper.reviewLikeOff", dto);
		
	}

	@Override
	public void reInterestCountDown(InteriorDTO dto) throws Exception {
		sql.update("mappers.interiorMapper.reInterestCountDown", dto);
		
	}

	@Override
	public String likeCount(InteriorDTO dto) throws Exception {
		return sql.selectOne("mappers.interiorMapper.likeCount", dto);
		
	}

	@Override
	public void exRegist(InteriorDTO dto) throws Exception {
		sql.insert("mappers.interiorMapper.exRegist", dto);
		
	}

	@Override
	public void exCount(InteriorDTO dto) throws Exception {
		sql.update("mappers.interiorMapper.exCount", dto);
		
	}

	@Override
	public InteriorDTO exShow(InteriorDTO dto) throws Exception {
		return sql.selectOne("mappers.interiorMapper.exShow", dto);
	}

	@Override
	public void comEdit(InteriorDTO dto) throws Exception {
		sql.update("mappers.interiorMapper.comEdit", dto);
		
	}

	@Override
	public void comEditFile(InteriorDTO dto) throws Exception {
		sql.update("mappers.interiorMapper.comEditFile", dto);
		
	}

	@Override
	public void reEdit(InteriorDTO dto) throws Exception {
		sql.update("mappers.interiorMapper.reEdit", dto);
		
	}

	@Override
	public void reEditFile(InteriorDTO dto) throws Exception {
		sql.update("mappers.interiorMapper.reEditFile", dto);
		
	}
	
	@Override
	public void reDelete(InteriorDTO dto) throws Exception {
		sql.delete("mappers.interiorMapper.reDelete", dto);
		
	}

	@Override
	public void exEdit(InteriorDTO dto) throws Exception {
		sql.update("mappers.interiorMapper.exEdit", dto);
		
	}

	@Override
	public void exEditFile(InteriorDTO dto) throws Exception {
		sql.update("mappers.interiorMapper.exEditFile", dto);
		
	}

	@Override
	public void exDelete(InteriorDTO dto) throws Exception {
		sql.delete("mappers.interiorMapper.exDelete", dto);
		
	}

	@Override
	public int realReCount(InteriorDTO dto) throws Exception {
		return sql.selectOne("mappers.interiorMapper.realReCount", dto);
	}

	@Override
	public int realExCount(InteriorDTO dto) throws Exception {
		return sql.selectOne("mappers.interiorMapper.realExCount", dto);
	}

	@Override
	public void reLikeDelete(InteriorDTO dto) throws Exception {
		sql.delete("mappers.interiorMapper.reLikeDelete", dto);
		
	}

	@Override
	public String checkComNameforCons(InteriorDTO dto) throws Exception {
		return sql.selectOne("mappers.interiorMapper.checkComNameforCons", dto);
	}

	

}
