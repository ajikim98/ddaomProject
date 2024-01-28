package com.example.ddaom.config;

import java.io.IOException;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class YourWebSocketHandler implements WebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) {
        // 클라이언트와의 연결이 성공했을 때의 처리 로직
    	String msg = "연결 성공시 메세지";
        
        // 원하는 내용을 가진 TextMessage 생성
        TextMessage textMessage = new TextMessage(msg);

        try {
            // 생성한 메시지를 연결된 클라이언트에게 전송
            session.sendMessage(message);
        } catch (IOException e) {
            // IOException 처리 로직 추가
            e.printStackTrace();
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
