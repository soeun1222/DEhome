package com.green.dehome.dao;

import java.util.List;

import com.green.dehome.dto.UserDTO;

public interface UserDAO {
	//회원가입 - 닉네임 중복 체크
	public String nickCheck(String nick) throws Exception;
	//회원가입 - 아이디 중복 체크
	public String idCheck(String id) throws Exception;
	//회원가입 - 전화번호 중복 체크
	public String pnumCheck(int pnum) throws Exception;
	//회원가입 - 업체명 중복 체크
	public String comCheck(String com_name) throws Exception;
	//회원가입
	public void register(UserDTO dto) throws Exception;
	
	//로그인
	public UserDTO loginCheck(UserDTO dto) throws Exception;
	//카카오 닉네임이 회원정보에 등록되어있는지 체크하는 것
	public String kakaonickCheck(String kakaonick) throws Exception;
	//카카오 닉네임이 회원정보에 등록되어있는지 체크하는 것
	public String navernickCheck(String navernick) throws Exception;
	//아이디 찾기
	public List<UserDTO> findID(UserDTO dto) throws Exception;
	//비밀번호 찾기
	public String findPW(UserDTO dto) throws Exception;
	
	//메인페이지 중고거래 상품 최신 5개 들고오기
	public List<UserDTO> mainPageList(UserDTO dto) throws Exception;
}
