package com.designnote.knowledgehub.service.aibank;

import com.designnote.knowledgehub.pojo.aibank.User;
import com.designnote.knowledgehub.repository.aibank.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public User login(String username, String password) {

        List<User> allUsers = (List<User>)userRepo.findAll();

        for(User user : allUsers){
            if (username.equals(user.getName())){
                if (Objects.equals(password, user.getPassword())){
                    return user;
                }
            }
        }
        return null;
    }
}
