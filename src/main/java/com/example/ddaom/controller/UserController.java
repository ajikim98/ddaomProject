package com.example.ddaom.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ddaom.dao.UserService;
import com.example.ddaom.model.Chat;
import com.example.ddaom.model.Chatroom;
import com.example.ddaom.model.User;
import com.google.gson.Gson;

@RequestMapping("/user")

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/login.do") 
    public String login(Model model) throws Exception{

        return "/login";
    }

	@RequestMapping("/join.do") 
    public String join(Model model) throws Exception{

        return "/popup/join";
    }

	@RequestMapping("/user.do") 
    public String main(Model model) throws Exception{

        return "/user-list";
    }
	
	@RequestMapping("/addRoomPage.do") 
	public String addRoomPage(Model model) throws Exception{
		
		return "/popup/addRoomPage";
	}
	
	@RequestMapping("/viewChatRoom.do") 
	public String viewChatRoom(Model model) throws Exception{
		
		return "/viewChatRoom";
	}
	
	@RequestMapping("/chatRoomList.do") 
	public String chatRoomList(Model model) throws Exception{
		
		return "/chatRoomList";
	}
	
	
	@RequestMapping(value = "/list.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String searchUserList(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<User> list = userService.selectUserList(map);
		resultMap.put("list", list);
		resultMap.put("result", "success");
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping(value = "/addRoom.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String addChatRoom(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		userService.addChatRoom(map);
		resultMap.put("message", "success");
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping(value = "/chatRoomList.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String chatRoomList(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<Chatroom> list = userService.selectChatRoomList(map);
		resultMap.put("chatRooms", list);
		resultMap.put("result", "success");
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping(value = "/addchat.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String addchat(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		userService.addChat(map);
		resultMap.put("message", "success");
		return new Gson().toJson(resultMap);
	}

	@RequestMapping(value = "/chatList.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String chatList(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<Chat> list = userService.chatList(map);
		resultMap.put("list", list);
		resultMap.put("result", "success");
		return new Gson().toJson(resultMap);
	}

	@RequestMapping(value = "/userJoin.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String userJoin(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		userService.userJoin(map);
		return new Gson().toJson(resultMap);
	}
	
}


