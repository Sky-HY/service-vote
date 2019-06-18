package com.vote.controller;

import com.vote.service.AdminService;
import com.vote.utils.HyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    @CrossOrigin("http://localhost:63342")
    public HyResult login(String username, String password) throws Exception {
        return adminService.login(username, password);
    }

}
