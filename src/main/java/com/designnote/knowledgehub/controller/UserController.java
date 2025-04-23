package com.designnote.knowledgehub.controller;

import com.designnote.knowledgehub.pojo.ResponseMessage;
import com.designnote.knowledgehub.pojo.aibank.User;
import com.designnote.knowledgehub.pojo.dto.UserDto;
import com.designnote.knowledgehub.service.aibank.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService service;

    @CrossOrigin
    @PostMapping
    public ResponseMessage<User> login(@Validated @RequestBody UserDto userDto){

        User loggedinUser = service.login(userDto.getUsername(), userDto.getPassword());

        List<User> results = new ArrayList<>();
        results.add(loggedinUser);
        return ResponseMessage.success(results);
    }

}
