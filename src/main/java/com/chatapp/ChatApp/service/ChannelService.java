package com.chatapp.ChatApp.service;

import com.chatapp.ChatApp.model.ChannelRequest;
import com.chatapp.ChatApp.model.ChannelResponse;

public interface ChannelService {

    ChannelResponse crateChannel(ChannelRequest channelRequest);
}