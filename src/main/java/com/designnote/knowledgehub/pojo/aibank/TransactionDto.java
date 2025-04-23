package com.designnote.knowledgehub.pojo.aibank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionDto {

    private Integer transactionID;
    private String accountID;
    private String stockName;
    private Double numberOfShares;
    private String typeOfTransaction;
    private Double shareValue;

}





