package com.vote.service.imp;

import com.vote.mapper.VoteUserMapper;
import com.vote.pojo.VoteUser;
import com.vote.pojo.VoteUserExample;
import com.vote.service.UserService;
import com.vote.utils.HyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private VoteUserMapper userMapper;

    @Override
    public HyResult login(String username, String password) throws Exception {
        // 包装查询条件
        VoteUserExample example = new VoteUserExample();
        VoteUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        // 查询
        List<VoteUser> voteUsers = userMapper.selectByExample(example);
        if (voteUsers != null && voteUsers.size() > 0) {
            return HyResult.build(200, "登录成功");
        }

        return HyResult.build(400, "用户名或者密码错误");
    }
}
