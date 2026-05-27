package com.app.ChatApplication.controller;

import com.app.ChatApplication.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;   // ← ADD THIS

@Controller
public class ChatController {

    // Redirect localhost:8080 → localhost:8080/chat automatically
    @GetMapping("/")
    public RedirectView root() {
        return new RedirectView("/chat");
    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        return message;
    }

    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }
}