package com.flexible.lottery.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lottery_result")
@Getter
@Setter
public class LotteryResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lottery_result_id")
    private int lotteryResultId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "lottery_result_id")
    List<LotteryNumber> lotteryNumbers = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "channel_id", nullable = false)
    private Channel channel;

    private Timestamp created_at;

}
