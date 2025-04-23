package com.designnote.knowledgehub.pojo.aibank;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Table(name="tb_transaction")
@Entity
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer transactionID;
    @Column(name="accountID")
    private String accountID;
    @Column(name="stockname")
    private String stockName;
    @Column(name="numberofshares")
    private Double numberOfShares;
    @Column(name="typeoftransaction")
    private String typeOfTransaction;
    @Column(name="share_value")
    private Double shareValue;

}
