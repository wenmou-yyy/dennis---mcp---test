package com.designnote.knowledgehub.service.aibank;

import com.designnote.knowledgehub.pojo.aibank.Account;
import com.designnote.knowledgehub.repository.aibank.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AccountService implements IAccountService {

    private static final String NONEXISTENTERROR = "Account does not exist !";

    @Autowired
    AccountRepo accountRepo;

    @Override
    public List<Account> getAccounts(Integer userID) {

        //List<Account> allAccounts = (List<Account>) accountRepo.findById(userID).orElseThrow(() -> new DbEntityException(NONEXISTENTERROR));
        List<Account> testallAccounts = getUserAllAccounts(userID);
        return testallAccounts;
    }

    @Override
    public Account getAccountBalance(Integer userID, String accountID) {
        Account result = null;
        List<Account> allAccounts = getUserAllAccounts(userID);
        for(Account account : allAccounts){
            if(Objects.equals(account.getAccountID(), accountID)){
                result = account;
                break;
            }
        }
        return result;
    }

    @Override
    public Account debitDepositAccount(Integer userID, Double shareValue) {

        Account account = findTargetAccount(userID, "Deposit");
        account.setBalance(account.getBalance() - shareValue);
        accountRepo.save(account);
        return account;
    }
    @Override
    public Account creditInvestAccount(Integer userID, String accountID, Double shareValue){

        Account account = findTargetAccount(userID, accountID);
        account.setBalance(account.getBalance() + shareValue);
        accountRepo.save(account);
        return account;
    }

    private Account findTargetAccount(Integer userID, String accountID){
        Account targetAccount = null;
        List<Account> allAccounts = getUserAllAccounts(userID);
        for(Account account : allAccounts){

            if(Objects.equals(account.getAccountID(), accountID)){
                return account; // can use this as example of bug for AI analysis
                // it was written as return targetAccount
            }
        }
        return targetAccount;
    }

    // Find all accounts for this user
    private List<Account> getUserAllAccounts(Integer userID){

        List<Account> allAccounts =   (List<Account>) accountRepo.findAll();
        List<Account> userAllAccounts = new ArrayList<>();
        for(Account account : allAccounts){
            if(Objects.equals(account.getUserID(), userID)){
                userAllAccounts.add(account);
            }
        }
        return userAllAccounts;
    }
}
