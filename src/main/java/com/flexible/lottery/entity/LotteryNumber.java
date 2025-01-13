package com.flexible.lottery.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lottery_number")
@Getter
@Setter
public class LotteryNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lottery_number_id")
    private int lotteryNumberId;

    @Column(name = "result")
    private String result;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "prize_id")
    private Prize prize;
}
