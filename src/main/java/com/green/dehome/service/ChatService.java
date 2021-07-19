package com.green.dehome.service;

import java.util.List;

import com.green.dehome.dto.ChatDTO;

public interface ChatService {
	//채팅 입력
	public void chatInsert(ChatDTO dto) throws Exception;
	//채팅내용 가져오기
	public List<ChatDTO> chatSelect(ChatDTO dto) throws Exception;
	//채팅내용 가져오기100개 제한
	public List<ChatDTO> chatSelectLimit(ChatDTO dto) throws Exception;
	//판매자일 경우 상대닉네임 가져오기
	public String getNick(ChatDTO dto) throws Exception;
	//대화리스트 가져오기 - 판매자
	public List<ChatDTO> chatList(ChatDTO dto) throws Exception;
	//대화리스트 가져오기 - 구매자
	public List<ChatDTO> chatList2(ChatDTO dto) throws Exception;
	
	//채팅 입력
	public void insertChatCoun(ChatDTO dto) throws Exception;
	//채팅내용 가져오기
	public List<ChatDTO> selectChatCoun(ChatDTO dto) throws Exception;
	//채팅내용 가져오기100개 제한
	public List<ChatDTO> selectChatLimitCoun(ChatDTO dto) throws Exception;
	//판매자일 경우 상대닉네임 가져오기
	public String getNickCoun(ChatDTO dto) throws Exception;
	//대화리스트 가져오기(유저)
	public List<ChatDTO> getChatListCounUser(ChatDTO dto) throws Exception;
	//대화리스트 가져오기(기업)
	public List<ChatDTO> getChatListCounCom(ChatDTO dto) throws Exception;
	//세션유저의 업체명 받아오기
	public String usernickComName(String user_nick) throws Exception;
}
