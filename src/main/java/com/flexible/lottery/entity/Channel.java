package com.flexible.lottery.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "channel")
@Getter
@Setter
public class Channel {

    @Id
    @Column(name = "channel_id")
    private int channelId;
    private String name;
    private String region;
}
