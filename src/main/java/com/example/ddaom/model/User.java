package com.example.ddaom.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data //유저 정보
public class User {
	private String userId; //고객 아이디
	private double userUId; //유저 식별넘버(사용자가 id 를 변경할 경우 임시로 사용하게 될 유저 식별 번호)
	private String userName; //고객 이름
	private LocalDateTime userJoinDate; //고객 가입일
	private String userPhone; //고객 폰번호
	private String userEmail; //유저 이메일
	private LocalDate userBirth; //고객 가입일
}
