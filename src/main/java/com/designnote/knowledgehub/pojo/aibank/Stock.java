package com.designnote.knowledgehub.pojo.aibank;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name="tb_stock")
@Entity
@Getter
@Setter
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer stockID;
    @Column(name="name")
    private String name;
}
