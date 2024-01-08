package com.example.ddaom.config;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class YourWebSocketHandler implements WebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        // 클라이언트와의 연결이 성공했을 때의 처리 로직
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) {
        // 클라이언트로부터 메시지를 받았을 때의 처리 로직
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
