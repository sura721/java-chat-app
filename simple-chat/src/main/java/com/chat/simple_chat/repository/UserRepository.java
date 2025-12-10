package com.chat.simple_chat.repository;

import com.chat.simple_chat.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    // This creates a custom query to find a user by their name
    Optional<User> findByUsername(String username);
}