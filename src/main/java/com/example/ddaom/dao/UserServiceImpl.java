package com.example.ddaom.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ddaom.mapper.UserMapper;
import com.example.ddaom.model.Chat;
import com.example.ddaom.model.Chatroom;
import com.example.ddaom.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public List<User> selectUserList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		
		return userMapper.selectUserList(map);
	}

	@Override
	public int addChatRoom(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return userMapper.addChatRoom(map);
	}

	@Override
	public List<Chatroom> selectChatRoomList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return userMapper.selectChatRoomList(map);
	}

	@Override
	public int addChat(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return userMapper.addChat(map);
	}

	@Override
	public List<Chat> chatList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return userMapper.chatList(map);
	}

	@Override
	public int userJoin(HashMap<String, Object> map) {
		// TODO Auto-generated method stub

			userMapper.userJoin1(map);
			userMapper.userJoin2(map);
			userMapper.userJoin3(map);
		return userMapper.userJoin4(map);
	}
}
