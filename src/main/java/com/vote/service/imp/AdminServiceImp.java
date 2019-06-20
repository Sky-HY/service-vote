package com.vote.service.imp;

import com.vote.mapper.VoteAdminMapper;
import com.vote.pojo.VoteAdmin;
import com.vote.pojo.VoteAdminExample;
import com.vote.service.AdminService;
import com.vote.utils.HyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    private VoteAdminMapper adminMapper;

    @Override
    public HyResult login(String username, String password) throws Exception {
        // 包装查询条件
        VoteAdminExample example = new VoteAdminExample();
        VoteAdminExample.Criteria criteria = example.createCriteria();
        criteria.andAdminNameEqualTo(username);
        criteria.andAdminPwdEqualTo(password);
        // 查询
        List<VoteAdmin> voteUsers = adminMapper.selectByExample(example);
        if (voteUsers != null && voteUsers.size() > 0) {
            return HyResult.build(200, "登录成功",username);
        }

        return HyResult.build(400, "用户名或者密码错误");
    }
}
