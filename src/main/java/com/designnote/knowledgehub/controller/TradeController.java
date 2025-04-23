package com.designnote.knowledgehub.controller;

import com.designnote.knowledgehub.pojo.ResponseMessage;
import com.designnote.knowledgehub.pojo.aibank.Transaction;
import com.designnote.knowledgehub.pojo.aibank.TransactionDto;
import com.designnote.knowledgehub.service.aibank.IStockService;
import com.designnote.knowledgehub.service.aibank.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/trade")
public class TradeController {

    @Autowired
    ITransactionService transService;

    @Autowired
    IStockService stockService;

    // Get all transactions for one user
    @CrossOrigin
    @GetMapping("/{userID}")
    public ResponseMessage<Transaction> get(@PathVariable("userID") Integer userID){
        List<Transaction> transactionList = transService.getAllTransactions(userID);
        return ResponseMessage.success(transactionList);
    }

    // Get all transactions for one account
    @CrossOrigin
    @GetMapping("/{userID}/{accountID}")
    public ResponseMessage<Transaction> get(@PathVariable("userID") Integer userID,
                                            @PathVariable("accountID") String accountID){
        List<Transaction> transactionList = transService.getTransactionsForOneAccount(userID,accountID);
        return ResponseMessage.success(transactionList);
    }

    @CrossOrigin
    @PostMapping("/{userID}/{accountID}/{stockID}/{numberOfShares}")
    public ResponseMessage<Transaction> addNewTransaction(@PathVariable("userID") Integer userID,
                                  @PathVariable("accountID") String accountID,
                                  @PathVariable("stockID") Integer stockID,
                                                          @PathVariable("numberOfShares") Double numberOfShares){

        Double sharePrice = 2.0;

        TransactionDto dto = new TransactionDto();
        dto.setAccountID(accountID);
        dto.setShareValue(sharePrice*numberOfShares);
        dto.setStockName(stockService.getStock(stockID).getName());
        dto.setTypeOfTransaction("Buy");
        dto.setNumberOfShares(numberOfShares);

        Transaction result = transService.addNewTransaction(userID,dto);
        List<Transaction> results = new ArrayList<>();
        results.add(result);

        return ResponseMessage.success(results);
    }

}
