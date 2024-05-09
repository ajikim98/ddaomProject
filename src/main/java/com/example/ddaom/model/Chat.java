package com.example.ddaom.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data //채팅
public class Chat {
	private int chatNo; //채팅번호
	private String userId; //아이디
	private int crNo; //채팅방번호
	private LocalDateTime chatDate; //보낸시간
	private String chatMessage; //채팅 메시지 내용
}
