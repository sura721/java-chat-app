package com.chat.simple_chat.service;

import com.chat.simple_chat.model.User;
import com.chat.simple_chat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List; // <--- Added this import
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String saveUser(User user) {
        // Strict Signup
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "Username already exists! Please try a different one.";
        }
        user.setStatus("OFFLINE");
        userRepository.save(user);
        return "Success";
    }

    public User loginUser(String username, String password) {
        // Strict Login
        Optional<User> dbUser = userRepository.findByUsername(username);

        if (dbUser.isPresent() && dbUser.get().getPassword().equals(password)) {
            User user = dbUser.get();
            user.setStatus("ONLINE");
            userRepository.save(user);
            return user;
        }
        return null;
    }
    
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    // --- THIS WAS MISSING ---
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}