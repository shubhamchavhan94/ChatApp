package com.chatapp.ChatApp.service;

import com.chatapp.ChatApp.enums.Status;

public interface UserService {

    void updateUserStatus(String username, Status status);
}
