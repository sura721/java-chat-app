package com.chat.simple_chat.service;

import com.chat.simple_chat.model.ChatMessage;
import com.chat.simple_chat.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChatMessageService {

    @Autowired
    private ChatMessageRepository repository;

    public ChatMessage save(ChatMessage chatMessage) {
        return repository.save(chatMessage);
    }

    public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
        // Find history between two users (both directions)
        return repository.findBySenderIdAndRecipientIdOrSenderIdAndRecipientIdOrderByTimestampAsc(
            senderId, recipientId, recipientId, senderId
        );
    }
}