package com.designnote.knowledgehub.pojo.aibank;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name="tb_account")
@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="userID")
    private Integer userID;
    @Column(name="accountID")
    private String accountID;

    @Column(name="balance")
    private Double balance;

}
