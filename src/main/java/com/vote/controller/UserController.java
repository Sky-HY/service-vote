package com.vote.controller;

import com.vote.service.UserService;
import com.vote.utils.HyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    @CrossOrigin("http://localhost:63342")
    public HyResult login(String username, String password) throws Exception {
        return userService.login(username, password);
    }

}
