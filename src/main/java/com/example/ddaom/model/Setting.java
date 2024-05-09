package com.example.ddaom.model;

import lombok.Data;

@Data //유저의 셋팅 정보 관리
public class Setting {
    private String userId; //아이디
    private char setAllAlarm; //알림설정
    private char setAuto; //자동실행여부
    private char setLock; //잠금모드여부
    private char setUnusedLock; //PC미사용잠금
    private char setBirAlarm; //생일 알람 모드
    private char setPfAlarm; //프로필 변경 표시    
}
