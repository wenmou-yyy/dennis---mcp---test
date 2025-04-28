package com.designnote.knowledgehub.repository.aibank;

import com.designnote.knowledgehub.pojo.aibank.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends CrudRepository<Transaction,Integer> {

}


