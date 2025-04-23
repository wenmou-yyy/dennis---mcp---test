package com.designnote.knowledgehub.service.aibank;

import com.designnote.knowledgehub.pojo.aibank.Transaction;
import com.designnote.knowledgehub.pojo.aibank.TransactionDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ITransactionService {

    Transaction addNewTransaction(Integer userID, TransactionDto transactionDto);
    List<Transaction> getAllTransactions(Integer userID);
    List<Transaction> getTransactionsForOneAccount(Integer userID, String accountID);

}

