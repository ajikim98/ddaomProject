package com.example.ddaom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.lang.NonNull;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(@NonNull WebSocketHandlerRegistry registry) {
    	registry.addHandler(new YourWebSocketHandler(), "/test1")
    	.setAllowedOrigins("*");
    }
}
