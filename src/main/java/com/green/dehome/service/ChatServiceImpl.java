package com.green.dehome.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.green.dehome.dao.ChatDAO;
import com.green.dehome.dto.ChatDTO;

@Service
public class ChatServiceImpl implements ChatService {

	@Inject
	ChatDAO dao;
	
	@Override
	public void chatInsert(ChatDTO dto) throws Exception {
		dao.chatInsert(dto);
	}

	@Override
	public List<ChatDTO> chatSelect(ChatDTO dto) throws Exception {
		return dao.chatSelect(dto);
	}

	@Override
	public List<ChatDTO> chatSelectLimit(ChatDTO dto) throws Exception {
		return dao.chatSelectLimit(dto);
	}

	@Override
	public String getNick(ChatDTO dto) throws Exception {
		return dao.getNick(dto);
	}

	@Override
	public List<ChatDTO> chatList(ChatDTO dto) throws Exception {
		return dao.chatList(dto);
	}

	@Override
	public List<ChatDTO> chatList2(ChatDTO dto) throws Exception {
		return dao.chatList2(dto);
	}
	
	/*--시공상담--*/
	

	@Override
	public void insertChatCoun(ChatDTO dto) throws Exception {
		dao.insertChatCoun(dto);
		
	}

	@Override
	public List<ChatDTO> selectChatCoun(ChatDTO dto) throws Exception {
		return dao.selectChatCoun(dto);
	}

	@Override
	public List<ChatDTO> selectChatLimitCoun(ChatDTO dto) throws Exception {
		return dao.selectChatLimitCoun(dto);
	}

	@Override
	public String getNickCoun(ChatDTO dto) throws Exception {
		return dao.getNickCoun(dto);
	}

	@Override
	public List<ChatDTO> getChatListCounUser(ChatDTO dto) throws Exception {
		return dao.getChatListCounUser(dto);
	}

	@Override
	public List<ChatDTO> getChatListCounCom(ChatDTO dto) throws Exception {
		return dao.getChatListCounCom(dto);
	}

	@Override
	public String usernickComName(String user_nick) throws Exception {
		return dao.usernickComName(user_nick);
	}


}
