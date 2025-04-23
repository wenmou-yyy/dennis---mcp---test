package com.designnote.knowledgehub.service.aibank;

import com.designnote.knowledgehub.pojo.aibank.Account;
import com.designnote.knowledgehub.pojo.aibank.Transaction;
import com.designnote.knowledgehub.pojo.aibank.TransactionDto;
import com.designnote.knowledgehub.repository.aibank.AccountRepo;
import com.designnote.knowledgehub.repository.aibank.TransactionRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TransactoinService implements ITransactionService{

    private static final String NONEXISTENTERROR = "Transaction does not exist !";
    private static final String ENTITYID = "transactionID";

    @Autowired
    TransactionRepo transRepo;

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    IAccountService accountService;

    @Override
    public Transaction addNewTransaction(Integer userID, TransactionDto transDto) {

        Transaction newTransaction = new Transaction();
        BeanUtils.copyProperties(transDto, newTransaction,ENTITYID);
        transRepo.save(newTransaction);

        // at same time, debit same account from Deposit account
        accountService.debitDepositAccount(userID,transDto.getShareValue());
        // at same time, credit same account into target Account
        accountService.creditInvestAccount(userID,transDto.getAccountID(),transDto.getShareValue());

        return newTransaction;
    }

    @Override
    public List<Transaction> getAllTransactions (Integer userID){

        List<Transaction> allTransactionsinDB =   (List<Transaction>) transRepo.findAll();

        // Find all accounts for this user
        List<Account> userAllAccounts = getUserAllAccounts(userID);

        // Find all transactions for this user's all accounts
        List<Transaction> userAllTransactionsForAllAccounts = new ArrayList<>();

        String accountID = null;
        for(Account balance : userAllAccounts){
            accountID = balance.getAccountID();
            for(Transaction trans : allTransactionsinDB){
                if(Objects.equals(trans.getAccountID(), accountID)){
                    userAllTransactionsForAllAccounts.add(trans);
                }
            }
        }
        return userAllTransactionsForAllAccounts;

    }

    @Override
    public List<Transaction> getTransactionsForOneAccount(Integer userID, String accountID) {

        List<Transaction> allTransactionsinDB =   (List<Transaction>) transRepo.findAll();
        List<Transaction> userAllTransactionsForOneAccount = new ArrayList<>();

        for(Transaction trans : allTransactionsinDB){
            if(Objects.equals(trans.getAccountID(), accountID)){
                userAllTransactionsForOneAccount.add(trans);
            }
        }
        return userAllTransactionsForOneAccount;

    }

    private List<Account> getUserAllAccounts(Integer userID){

        List<Account> allAccounts =   (List<Account>) accountRepo.findAll();

        List<Account> userAllAccounts = new ArrayList<>();

        // Find all accounts for this user
        for(Account balance : allAccounts){
            if(Objects.equals(balance.getUserID(), userID)){
                userAllAccounts.add(balance);
            }
        }
        return userAllAccounts;
    }


}









