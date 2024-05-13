package com.example.ddaom.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ddaom.mapper.UserMapper;
import com.example.ddaom.model.Certified;
import com.example.ddaom.model.Chat;
import com.example.ddaom.model.Chatroom;
import com.example.ddaom.model.User;
import com.example.ddaom.util.PasswordHashing;

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

		String hashedPassword = PasswordHashing.hashPassword((String) map.get("uPw"));
        map.put("uPw", hashedPassword); // 해시된 비밀번호로 대체

		userMapper.userJoin1(map);
		userMapper.userJoin2(map);
		userMapper.userJoin3(map);

		return userMapper.userJoin4(map);
	}

	@Override
	public HashMap<String, Object> userLogin(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		// 사용자가 입력한 패스워드를 암호화합니다.
		String hashedPassword = PasswordHashing.hashPassword((String) map.get("uPw"));
		map.put("uPw", hashedPassword); // 암호화된 패스워드로 대체
		
		Certified user = userMapper.selectUser(map);
		
		if(user != null) {
			if(user.getCfPCnt() >= 5) {
				resultMap.put("success", false);
				resultMap.put("message", "5회 이상 실패, 관리자에게 문의하세요.");
			}
			else {
				userMapper.resetUserCnt(map);
				resultMap.put("success", true);
				resultMap.put("message", user.getUserId() + "님 환영합니다!");
				resultMap.put("user", user);
			}
		} else {
			resultMap.put("success", false);
			Certified tempUser = userMapper.userCheckId(map) ;			
			if(tempUser != null) {
				userMapper.updateUserCnt(map);
				int cnt = tempUser.getCfPCnt() + 1;
				String message = cnt + "번 실패! \n패스워드를 확인해주세요.";
				if(cnt >= 5) {
					message = "5회 이상 실패, 관리자에게 문의하세요.";
				}
				resultMap.put("message", message);
			} else {
				resultMap.put("message", "존재하지않는 아이디입니다.");
			}
		}
		
		return resultMap;
	}
}
