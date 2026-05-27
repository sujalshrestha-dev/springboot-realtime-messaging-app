package com.app.ChatApplication.controller;

import com.app.ChatApplication.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        return message;
    }

    @GetMapping("/chat")   // Fix #2: added leading slash
    public String chat() {
        return "chat";
    }
}