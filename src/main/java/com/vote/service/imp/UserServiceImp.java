package com.vote.service.imp;

import com.vote.mapper.VoteUserMapper;
import com.vote.pojo.VoteUser;
import com.vote.pojo.VoteUserExample;
import com.vote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private VoteUserMapper userMapper;

    /**
     * 检查用户是否在该次比赛投票
     *
     * @param voteId 比赛的id
     * @param ip     用户的ip
     * @return true表示用户已经投票，false表示用户没有投票
     */
    @Override
    public boolean checkUserIsVote(Integer voteId, String ip) {
        VoteUserExample example = new VoteUserExample();
        VoteUserExample.Criteria criteria = example.createCriteria();
        criteria.andVoteIdEqualTo(voteId);
        criteria.andUserIpEqualTo(ip);
        List<VoteUser> users = userMapper.selectByExample(example);
        // 投过票了
        if (users != null && users.size() > 0) {
            return true;
        }
        // 记录用户的投票
        VoteUser user = new VoteUser();
        user.setUserIp(ip);
        user.setVoteId(voteId);
        userMapper.insert(user);
        return false;
    }


}
