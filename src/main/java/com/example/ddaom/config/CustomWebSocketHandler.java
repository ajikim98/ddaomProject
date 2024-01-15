package com.example.ddaom.config;

import java.io.IOException;

import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomWebSocketHandler extends YourWebSocketHandler {
    
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) {
        try {
            String jsonMessage = message.getPayload().toString();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonMessage);
            
            // "test" 필드의 값을 추출
            String testValue = jsonNode.get("test").asText();
            
            // 추출한 값에 대한 처리 로직 추가
            System.out.println("Received test value: " + testValue);
            
        } catch (IOException e) {
            // JSON 파싱에 실패한 경우 처리 로직
            e.printStackTrace();
        }
        
        super.handleMessage(session, message);
    }
}
