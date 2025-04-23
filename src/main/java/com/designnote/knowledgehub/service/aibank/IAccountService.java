package com.designnote.knowledgehub.service.aibank;

import com.designnote.knowledgehub.pojo.aibank.Account;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IAccountService {

    List<Account> getAccounts(Integer userID);
    Account getAccountBalance(Integer userID, String accountID);
    Account debitDepositAccount(Integer userID, Double shareValue);
    Account creditInvestAccount(Integer userID, String accountID, Double shareValue);
}
