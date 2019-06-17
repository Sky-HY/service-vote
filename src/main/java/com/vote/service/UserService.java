package com.vote.service;

import com.vote.utils.HyResult;

public interface UserService {
    HyResult login(String username,String password)throws Exception;
}
