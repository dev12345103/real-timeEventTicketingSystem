package com.eventbooking.Config;

import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


public class EventSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new com.eventbooking.Config.EventSocketHandler(), "/event-socket")
                .setAllowedOrigins("*");
    }
}
