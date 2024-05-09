package com.example.ddaom.model;

import lombok.Data;

@Data //첨부파일
public class Attached {
    private int attId; //첨부파일번호
    private int attKind; //첨부파일 종류
    private String attAddr; //첨부파일 주소
    private int attSize; //첨부파일 크기
    private String attType; //첨부파일 형식
}
