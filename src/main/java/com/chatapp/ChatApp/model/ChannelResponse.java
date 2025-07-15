package com.chatapp.ChatApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ChannelResponse {

    private Long id;
    private String name;
    private String createdBy;
    private LocalDateTime createdAt;
    private List<ChannelMemberResponse> members;
}