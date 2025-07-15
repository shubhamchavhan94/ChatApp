package com.chatapp.ChatApp.controller;

import com.chatapp.ChatApp.model.ChannelRequest;
import com.chatapp.ChatApp.model.ChannelResponse;
import com.chatapp.ChatApp.service.ChannelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/channels")
@AllArgsConstructor
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @PostMapping("/create")
    public ResponseEntity<ChannelResponse> crateChannel(@RequestBody ChannelRequest channelRequest){

         ChannelResponse response= channelService.crateChannel(channelRequest);

         return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
