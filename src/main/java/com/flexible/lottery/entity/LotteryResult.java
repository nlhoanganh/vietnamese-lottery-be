package com.flexible.lottery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "lottery_result")
@Getter
@Setter
public class LotteryResult {

    @Id
    private int id;

    private Timestamp created_at;

    @ManyToOne
    private Channel channel;
}
