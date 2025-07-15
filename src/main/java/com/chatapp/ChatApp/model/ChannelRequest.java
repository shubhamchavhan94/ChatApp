package com.chatapp.ChatApp.model;

import lombok.Data;

import java.util.List;

@Data
public class ChannelRequest {

    private String name;
    private List<String> members;
}