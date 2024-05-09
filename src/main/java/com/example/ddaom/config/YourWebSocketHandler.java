package com.example.ddaom.config;

import java.io.IOException;
import java.util.*;

import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class YourWebSocketHandler implements WebSocketHandler {

	Set<WebSocketSession> sessions = new HashSet<WebSocketSession>();
	
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
    	sessions.add(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) {
        // 세션이 열려있는지 확인
        if (session.isOpen()) {
            if (message instanceof PongMessage) {
                System.out.println("PongMessage를 받았습니다");
                // PongMessage를 처리하는 추가 로직을 여기에 작성하세요
            } else if (message instanceof TextMessage) {
                System.out.println(message);
                String msg = "연결 성공시 메세지";
                // 원하는 내용을 가진 TextMessage 생성
                TextMessage textMessage = new TextMessage(msg);
                try {
                    // 생성한 메시지를 연결된 클라이언트에게 전송
                    session.sendMessage(textMessage);
                } catch (IOException e) {
                    // IOException 처리 로직 추가
                    e.printStackTrace();
                }
                // TextMessage를 처리하는 추가 로직을 여기에 작성하세요
            } else {
                System.out.println("알 수 없는 형식의 메시지를 받았습니다");
            }
        } else {
            System.out.println("세션이 이미 닫혔습니다");
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        // 에러 발생 시 처리 로직
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) {
        // 클라이언트와의 연결이 종료되었을 때의 처리 로직
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
