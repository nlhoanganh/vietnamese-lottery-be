package com.flexible.lottery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "channel")
@Getter
@Setter
public class Channel {
    @Id
    private int id;

    String name;
    String region;
}
