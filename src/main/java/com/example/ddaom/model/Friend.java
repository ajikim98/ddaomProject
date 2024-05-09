package com.example.ddaom.model;

import lombok.Data;

@Data //유저 정보
public class Friend {
	private String userId; //고객 아이디
	private double friBlockYn; //차단여부
	private String friUid; //상대 아이디	
}
