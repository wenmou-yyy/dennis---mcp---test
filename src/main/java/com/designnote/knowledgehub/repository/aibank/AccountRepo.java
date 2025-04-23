package com.designnote.knowledgehub.repository.aibank;

import com.designnote.knowledgehub.pojo.aibank.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends CrudRepository<Account,Integer> {
}
