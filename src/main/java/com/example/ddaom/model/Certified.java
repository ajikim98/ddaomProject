package com.example.ddaom.model;

import lombok.Data;

@Data //유저의 인증 정보를 관리
public class Certified {
    private String userId; // 고객 아이디
    private String userPw; // 고객 비밀번호
    private int cfPCnt; // 비밀번호 오류 횟수
    private char cfStatus; // 관리자여부(관리자만 A)
    private char cfState; // 밴 > B 탈퇴 > W    
}
