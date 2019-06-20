package com.vote.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vote.mapper.VotePlayerMapper;
import com.vote.mapper.VoteResultMapper;
import com.vote.mapper.VoteResultMapperCustom;
import com.vote.pojo.*;
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

    @Autowired
    private VoteResultMapper resultMapper;

    @Override
    public HyResult getVoteStatus() {
        VoteResult currentVote = resultMapperCustom.getCurrentVote();
        if (currentVote != null) {
            // 创建包装对象
            VoteResultCustom voteResultCustom = customPlayerInfo(currentVote);

            return HyResult.ok(voteResultCustom);

        }
        return HyResult.build(500, "未知错误");
    }

    // 查询所有投票记录(分页)
    @Override
    public HyResult getVoteResult(Integer page, Integer rows) {

        // 分页
        PageHelper.startPage(page, rows);
        // 查询
        List<VoteResult> voteResults = resultMapper.selectByExample(null);
        // 有数据
        if (voteResults != null && voteResults.size() > 0) {
            // 结果包装对象
            PageResult pageResult = new PageResult();
            // 获取分页信息
            PageInfo<VoteResult> pageInfo = new PageInfo<>(voteResults);
            // 数据库总条数
            pageResult.setCount(pageInfo.getTotal());
            pageResult.setPage(page);

            for (VoteResult voteResult : voteResults) {
                // 查询选手
                pageResult.getData().add(customPlayerInfo(voteResult));
            }

            return HyResult.ok(pageResult);
        }

        // 没有数据
        return HyResult.build(400, "没有数据了");
    }

    // 获取选手信息
    private VoteResultCustom customPlayerInfo(VoteResult voteResult){
        // 创建包装对象
        VoteResultCustom voteResultCustom = new VoteResultCustom();
        String pkNames = voteResult.getPkNames();
        String pkTickets = voteResult.getPkTickets();
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
        voteResultCustom.setId(voteResult.getId());
        voteResultCustom.setStartTime(voteResult.getStartTime());
        voteResultCustom.setVoteName(voteResult.getVoteName());
        voteResultCustom.setEndTime(voteResult.getEndTime());
        voteResultCustom.setStatus(voteResult.getStatus());
        return voteResultCustom;
    }
}
