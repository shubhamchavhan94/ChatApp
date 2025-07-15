package com.chatapp.ChatApp.service;

import com.chatapp.ChatApp.entity.Channel;
import com.chatapp.ChatApp.entity.ChannelMember;
import com.chatapp.ChatApp.model.ChannelMemberResponse;
import com.chatapp.ChatApp.model.ChannelRequest;
import com.chatapp.ChatApp.model.ChannelResponse;
import com.chatapp.ChatApp.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    @Override
    public ChannelResponse crateChannel(ChannelRequest request) {

        //convert ChannelRequest to Channel entity
        Channel channel = new Channel();
        channel.setName(request.getName());
        channel.setCreatedBy(channel.getCreatedBy());
        channel.setCreatedAt(LocalDateTime.now());

        // Convert List<String> to List<ChannelMember>
        List<ChannelMember> members = request.getMembers().stream()
                .map(memberId -> {
                    ChannelMember member = new ChannelMember();
                    member.setMemberId(memberId);
                    member.setChannel(channel);  // link back to channel
                    return member;
                }).collect(Collectors.toList());

        channel.setMembers(members);

        //save channel to database
        Channel saved= channelRepository.save(channel);

        List<ChannelMemberResponse> memberResponses = saved.getMembers().stream()
                .map(member -> new ChannelMemberResponse(member.getMemberId()))
                .collect(Collectors.toList());

        //convert Channel entity to ChannelResponse
        return new ChannelResponse(
               saved.getId(),
               saved.getName(),
               saved.getCreatedBy(),
               saved.getCreatedAt(),
                memberResponses
        );
    }
}