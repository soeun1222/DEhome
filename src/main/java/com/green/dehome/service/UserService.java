package com.green.dehome.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.green.dehome.dto.UserDTO;

public interface UserService {
	public String nickCheck(String nick) throws Exception;
	
	public String idCheck(String id) throws Exception;
	
	public String pnumCheck(int pnum) throws Exception;
	
	public String comCheck(String com_name) throws Exception;
	
	public void register(UserDTO dto) throws Exception;
	
	public UserDTO loginCheck(UserDTO dto) throws Exception;
	
	public void logout(HttpServletResponse response) throws Exception;
	
	public String kakaonickCheck(String kakaonick) throws Exception;
	
	public String navernickCheck(String navernick) throws Exception;
	
	public List<UserDTO> findID(UserDTO dto) throws Exception;
	
	public String findPW(UserDTO dto) throws Exception;
	
	public List<UserDTO> mainPageList(UserDTO dto) throws Exception;
}
