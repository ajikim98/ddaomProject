package com.example.ddaom.dao;

import java.util.HashMap;
import java.util.List;

import com.example.ddaom.model.User;

public interface UserService {
	// 게시글 조회
	List<User> selectUserList(HashMap<String, Object> map);
	
}
