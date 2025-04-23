package com.designnote.knowledgehub.repository.aibank;

import com.designnote.knowledgehub.pojo.aibank.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User,Integer> {
}
