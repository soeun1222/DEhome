package com.green.dehome.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.green.dehome.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject SqlSession sql;
	

	@Override
	public String nickCheck(String nick) throws Exception {
		return sql.selectOne("mappers.userMapper.nickCheck",  nick);
	}

	@Override
	public String idCheck(String id) throws Exception {
		return sql.selectOne("mappers.userMapper.idCheck", id);
	}
	@Override
	public String pnumCheck(int pnum) throws Exception {
		return sql.selectOne("mappers.userMapper.pnumCheck", pnum);
	}
	
	@Override
	public String comCheck(String com_name) throws Exception {
		return sql.selectOne("mappers.userMapper.comCheck", com_name);
	}
	@Override
	public void register(UserDTO dto) throws Exception {
		sql.insert("mappers.userMapper.register", dto);
	}

	@Override
	public UserDTO loginCheck(UserDTO dto) throws Exception {
		return sql.selectOne("mappers.userMapper.login", dto);
	}

	@Override
	public String kakaonickCheck(String kakaonick) throws Exception {
		return sql.selectOne("mappers.userMapper.kakaonickCheck",  kakaonick);
	}

	@Override
	public String navernickCheck(String navernick) throws Exception {
		return sql.selectOne("mappers.userMapper.navernickCheck",  navernick);
	}

	@Override
	public List<UserDTO> findID(UserDTO dto) throws Exception {
		return sql.selectList("mappers.userMapper.findID", dto);
	}

	@Override
	public String findPW(UserDTO dto) throws Exception {
		return sql.selectOne("mappers.userMapper.findPW", dto);
	}

	@Override
	public List<UserDTO> mainPageList(UserDTO dto) throws Exception {
		return sql.selectList("mappers.userMapper.mainPageList", dto);
	}
}
