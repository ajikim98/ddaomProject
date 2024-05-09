package com.example.ddaom.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data //프로필 정보
public class Profile {
    private String userId; //고객 아이디
    private String pfNickname; //고객 닉네임
    private String pfPhoto; //프사
    private String pfBgPhoto; //배사
    private String pfStateMessage; //상태메세지
    private LocalDateTime pfDate; //프로필업데이트날짜
    private LocalDateTime pfBgDate; //배사업데이트날짜   
}
