package com.green.dehome.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.green.dehome.dto.ChatDTO;

@Repository
public class ChatDAOImpl implements ChatDAO {
	@Inject
	SqlSession sql;

	@Override
	public void chatInsert(ChatDTO dto) throws Exception {
		sql.insert("mappers.chatMapper.insertChat", dto);
	}

	@Override
	public List<ChatDTO> chatSelect(ChatDTO dto) throws Exception {
		return sql.selectList("mappers.chatMapper.selectChat", dto);
	}

	@Override
	public List<ChatDTO> chatSelectLimit(ChatDTO dto) throws Exception {
		return sql.selectList("mappers.chatMapper.selectChatLimit", dto);
	}

	@Override
	public String getNick(ChatDTO dto) throws Exception {
		return sql.selectOne("mappers.chatMapper.getNick", dto);
	}

	@Override
	public List<ChatDTO> chatList(ChatDTO dto) throws Exception {
		return sql.selectList("mappers.chatMapper.getChatList", dto);
	}

	@Override
	public List<ChatDTO> chatList2(ChatDTO dto) throws Exception {
		return sql.selectList("mappers.chatMapper.getChatList2", dto);
	}
	
	/*--시공상담--*/

	@Override
	public void insertChatCoun(ChatDTO dto) throws Exception {
		sql.insert("mappers.chatMapper.insertChatCoun", dto);
		
	}

	@Override
	public List<ChatDTO> selectChatCoun(ChatDTO dto) throws Exception {
		return sql.selectList("mappers.chatMapper.selectChatCoun", dto);
	}

	@Override
	public List<ChatDTO> selectChatLimitCoun(ChatDTO dto) throws Exception {
		return sql.selectList("mappers.chatMapper.selectChatLimitCoun", dto);
	}

	@Override
	public String getNickCoun(ChatDTO dto) throws Exception {
		return sql.selectOne("mappers.chatMapper.getNickCoun", dto);
	}

	@Override
	public List<ChatDTO> getChatListCounUser(ChatDTO dto) throws Exception {
		return sql.selectList("mappers.chatMapper.getChatListCounUser", dto);
	}

	@Override
	public List<ChatDTO> getChatListCounCom(ChatDTO dto) throws Exception {
		return sql.selectList("mappers.chatMapper.getChatListCounCom", dto);
	}

	@Override
	public String usernickComName(String user_nick) throws Exception {
		return sql.selectOne("mappers.chatMapper.usernickComName", user_nick);
	}

}
