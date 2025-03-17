package com.eventbooking.Config;

import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.TextMessage;

public class EventSocketHandler extends TextWebSocketHandler {
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String receivedContent = message.getPayload();
        session.sendMessage(new TextMessage("Acknowledged: " + receivedContent));
    }
}
