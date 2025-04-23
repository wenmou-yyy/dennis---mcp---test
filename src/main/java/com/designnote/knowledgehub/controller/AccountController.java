package com.designnote.knowledgehub.controller;

import com.designnote.knowledgehub.pojo.ResponseMessage;
import com.designnote.knowledgehub.pojo.aibank.Account;
import com.designnote.knowledgehub.pojo.aibank.Stock;
import com.designnote.knowledgehub.pojo.dbentity.Cause;
import com.designnote.knowledgehub.service.aibank.IAccountService;
import com.designnote.knowledgehub.service.aibank.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    IAccountService service;

    @CrossOrigin
    @GetMapping("/{userID}")
    public ResponseMessage<Account> get(@PathVariable("userID") Integer userID){
        //int n = Integer.parseInt(userID);
        List<Account> accounts = service.getAccounts(userID);
        return ResponseMessage.success(accounts);
    }

    @CrossOrigin
    @GetMapping("/{userID}/{accountID}")
    public ResponseMessage<Account> getAccountBalance(@PathVariable("userID") String userID,

                                                      @PathVariable("accountID") String accountID){
        int n = Integer.parseInt(userID);
        Account account = service.getAccountBalance(n,accountID);
        List<Account> results = new ArrayList<>();
        results.add(account);
        return ResponseMessage.success(results);
    }

}
