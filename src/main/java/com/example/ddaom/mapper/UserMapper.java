package com.example.ddaom.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.ddaom.model.Chat;
import com.example.ddaom.model.Chatroom;
import com.example.ddaom.model.User;

@Mapper
public interface UserMapper {
	List<User> selectUserList(HashMap<String, Object> map);
	
	int addChatRoom (HashMap<String, Object> map);
	
	List<Chatroom> selectChatRoomList(HashMap<String, Object> map);
	
	int addChat (HashMap<String, Object> map);
	
	List<Chat> chatList(HashMap<String, Object> map);

	int userJoin1 (HashMap<String, Object> map);
	int userJoin2 (HashMap<String, Object> map);
	int userJoin3 (HashMap<String, Object> map);
	int userJoin4 (HashMap<String, Object> map);
}
