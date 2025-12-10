package com.chat.simple_chat.controller;

import com.chat.simple_chat.model.User;
import com.chat.simple_chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*") // Allows the frontend to talk to the backend
public class UserController {

    @Autowired
    private UserService userService;

    // 1. REGISTER (Fixes the 405 Error)
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // 2. LOGIN
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.loginUser(user.getUsername(), user.getPassword());
    }

    // 3. GET ALL USERS (Fixes the previous "cannot find symbol" error)
    @GetMapping("/all")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }
}