package com.vote.service.imp;

import com.vote.mapper.VotePlayerMapper;
import com.vote.mapper.VoteResultMapperCustom;
import com.vote.pojo.VotePlayer;
import com.vote.pojo.VotePlayerExample;
import com.vote.pojo.VoteResult;
import com.vote.pojo.VoteResultCustom;
import com.vote.service.VoteService;
import com.vote.utils.HyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImp implements VoteService {

    // @Autowired
    // private VoteResultMapper resultMapper;

    @Autowired
    private VotePlayerMapper playerMapper;

    @Autowired
    private VoteResultMapperCustom resultMapperCustom;

    @Override
    public HyResult getVoteStatus() {
        VoteResult currentVote = resultMapperCustom.getCurrentVote();
        if (currentVote != null) {
            // 创建包装对象
            VoteResultCustom voteResultCustom = new VoteResultCustom();
            String pkNames = currentVote.getPkNames();
            String pkTickets = currentVote.getPkTickets();
            // 分割选手
            String[] splitPkNames = pkNames.split(",");
            // 分割分数
            String[] splitPkTickets = pkTickets.split(",");
            // 包装分数
            for (String ticket : splitPkTickets) {
                voteResultCustom.getPlayerTickets().add(Long.valueOf(ticket));
            }

            for (String name : splitPkNames) {
                // 创建查询条件，根据id查询选手名称
                VotePlayerExample example = new VotePlayerExample();
                VotePlayerExample.Criteria criteria = example.createCriteria();
                criteria.andIdEqualTo(Integer.valueOf(name));
                List<VotePlayer> votePlayers = playerMapper.selectByExample(example);
                String playerName = votePlayers.get(0).getPlayerName();
                // 包装选手
                voteResultCustom.getPlayerNames().add(playerName);
            }

            // 包装其他的数据
            voteResultCustom.setId(currentVote.getId());
            voteResultCustom.setStartTime(currentVote.getStartTime());
            voteResultCustom.setVoteName(currentVote.getVoteName());

            return HyResult.ok(voteResultCustom);

        }
        return HyResult.build(500, "未知错误");
    }
}
