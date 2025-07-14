package com.chatapp.ChatApp.controller;

import com.chatapp.ChatApp.config.security.JwtUtil;
import com.chatapp.ChatApp.enums.Status;
import com.chatapp.ChatApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/status")
    public ResponseEntity<?> updateUserStatus(@RequestBody Map<String, String> body,
                                              @RequestHeader("Authorization") String authHeader){

        String token = authHeader.substring(7);
        String username = jwtUtil.extractUsername(token);

        try {
            Status status= Status.valueOf(body.get("status").toUpperCase());
            userService.updateUserStatus(username, status);
            return ResponseEntity.ok(Map.of("message", "Status updated","status", status));
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body("Invalid status. Use ONLINE, OFFLINE.");
        }
    }
}
