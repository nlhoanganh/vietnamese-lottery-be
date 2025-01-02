package com.flexible.lottery.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "prize")
@Getter
@Setter
public class Prize {

    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private int value;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;
}
