package com.flexible.lottery.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "prize")
@Getter
@Setter
public class Prize {

    @Id
    @Column(name = "prize_id")
    private int prizeId;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private int value;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;
}
