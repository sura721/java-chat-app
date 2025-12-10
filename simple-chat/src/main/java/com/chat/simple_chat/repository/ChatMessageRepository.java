package com.chat.simple_chat.repository;

import com.chat.simple_chat.model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
    // Find messages between two people (A->B OR B->A)
    List<ChatMessage> findBySenderIdAndRecipientIdOrSenderIdAndRecipientIdOrderByTimestampAsc(
        String senderId1, String recipientId1, 
        String senderId2, String recipientId2
    );
}