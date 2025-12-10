package com.chat.simple_chat.controller;

import com.chat.simple_chat.model.ChatMessage;
import com.chat.simple_chat.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatMessageService chatMessageService;

    // 1. Send Message (WebSocket)
    @MessageMapping("/private-message")
    public ChatMessage processMessage(@Payload ChatMessage chatMessage) {
        // SAVE to Database
        ChatMessage saved = chatMessageService.save(chatMessage);

        // Send to Recipient
        messagingTemplate.convertAndSendToUser(
                chatMessage.getRecipientId(), "/private", saved);
        
        return saved;
    }

    // 2. Load History (REST API)
    @GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<List<ChatMessage>> findChatMessages(@PathVariable String senderId, @PathVariable String recipientId) {
        return ResponseEntity.ok(chatMessageService.findChatMessages(senderId, recipientId));
    }
}