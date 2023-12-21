package com.example.ddaom.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ddaom.mapper.UserMapper;
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
}
