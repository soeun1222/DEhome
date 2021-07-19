package com.green.dehome.service;

import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import com.green.dehome.dao.UserDAO;
import com.green.dehome.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService{

	@Inject UserDAO dao;

	@Override
	public String nickCheck(String nick) throws Exception {
		return dao.nickCheck(nick);
	}

	@Override
	public String idCheck(String id) throws Exception {
		return dao.idCheck(id);
	}
	@Override
	public String pnumCheck(int pnum) throws Exception {
		return dao.pnumCheck(pnum);
	}
	
	@Override
	public String comCheck(String com_name) throws Exception {
		return dao.comCheck(com_name);
	}

	@Override
	public void register(UserDTO dto) throws Exception {
		dao.register(dto);
	}
	@Override
	public UserDTO loginCheck(UserDTO dto) throws Exception {
		return dao.loginCheck(dto);
	}
	//계정 로그아웃
	@Override
	public void logout(HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("location.href='user/login'");
		out.println("</script>");
		out.close();
	}

	@Override
	public String kakaonickCheck(String kakaonick) throws Exception {
		return dao.kakaonickCheck(kakaonick);
	}

	@Override
	public String navernickCheck(String navernick) throws Exception {
		return dao.navernickCheck(navernick);
	}

	@Override
	public List<UserDTO> findID(UserDTO dto) throws Exception {
		return dao.findID(dto);
	}

	@Override
	public String findPW(UserDTO dto) throws Exception {
		return dao.findPW(dto);
	}
	
	@Override
	public List<UserDTO> mainPageList(UserDTO dto) throws Exception {
		return dao.mainPageList(dto);
	}

}
