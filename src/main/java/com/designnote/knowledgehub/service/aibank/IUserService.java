package com.designnote.knowledgehub.service.aibank;

import com.designnote.knowledgehub.pojo.aibank.User;
import com.designnote.knowledgehub.pojo.dto.CauseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IUserService {

    User login(String username, String password);

}
