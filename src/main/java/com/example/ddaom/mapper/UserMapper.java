package com.example.ddaom.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.ddaom.model.Certified;
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

	//로그인
	Certified selectUser(HashMap<String, Object> map);

	//유저 아이디만 O
	Certified userCheckId(HashMap<String, Object> map);

	//PW 오류시 오류 횟수 추가 
	int updateUserCnt(HashMap<String, Object> map);

	//로그인 성공시 PW오류횟수 초기화
	int resetUserCnt(HashMap<String, Object> map);
}
