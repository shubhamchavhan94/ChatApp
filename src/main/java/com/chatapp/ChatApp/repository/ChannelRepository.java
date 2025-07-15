package com.chatapp.ChatApp.repository;

import com.chatapp.ChatApp.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel,Long> {
}
