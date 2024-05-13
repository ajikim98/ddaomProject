package com.example.ddaom.model;

import lombok.Data;

@Data //채팅방
public class Chatroom {
	private int crNo; //채팅방번호
	private String crName; //채팅방 이름
	private String crDate; //채팅방 생성일
}
