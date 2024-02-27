package com.example.ddaom.dao;

import java.util.HashMap;
import java.util.List;

import com.example.ddaom.model.Chat;
import com.example.ddaom.model.Chatroom;
import com.example.ddaom.model.User;

public interface UserService {
	
	List<User> selectUserList(HashMap<String, Object> map);
	
	int addChatRoom (HashMap<String, Object> map);
	
	List<Chatroom> selectChatRoomList(HashMap<String, Object> map);
	
	int addChat (HashMap<String, Object> map);
	
	List<Chat> chatList(HashMap<String, Object> map);
	
}
