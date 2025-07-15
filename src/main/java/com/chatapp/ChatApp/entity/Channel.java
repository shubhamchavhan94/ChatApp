package com.chatapp.ChatApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "channels", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String createdBy;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL)
    private List<ChannelMember> members = new ArrayList<>();
}
