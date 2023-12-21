package com.example.ddaom.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.ddaom.model.User;

@Mapper
public interface UserMapper {
	List<User> selectUserList(HashMap<String, Object> map);
	
}
