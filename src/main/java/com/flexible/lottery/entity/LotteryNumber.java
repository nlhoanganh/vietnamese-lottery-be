package com.flexible.lottery.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lottery_number")
public class LotteryNumber {

    @Id
    private int id;

    @Column(name = "result")
    private String result;

    @ManyToOne
    private Prize prize;

    @ManyToOne
    private LotteryResult lotteryResult;

}
