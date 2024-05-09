package com.example.ddaom.model;

import lombok.Data;

@Data //접속한 방
public class JoinRoom {
	private int crNo; //채팅방번호
	private String userId; //아이디
	private char jrAlarm; //방별 알람
	
}
