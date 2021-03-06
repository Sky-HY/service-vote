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

import java.util.ArrayList;
import java.util.List;

@Service
public class VoteServiceImp implements VoteService {


    @Autowired
    private VotePlayerMapper playerMapper;

    @Autowired
    private VoteResultMapperCustom resultMapperCustom;

    @Autowired
    private VoteResultMapper resultMapper;


    @Override
    public HyResult getVoteAll() {
        List<VoteResult> currentVote = resultMapper.selectByExample(null);
        if (currentVote != null && currentVote.size() > 0) {
            List<VoteResultCustom> list = new ArrayList<>();
            for (VoteResult voteResult : currentVote) {
                VoteResultCustom resultCustom = customPlayerInfo(voteResult);
                list.add(resultCustom);
            }

            return HyResult.ok(list);

        }
        return HyResult.build(400, "没有跟多数据");
    }

    // 查询所有投票记录(分页)
    @Override
    public HyResult getVoteResult(Integer page, Integer rows) {

        // 分页
        PageHelper.startPage(page, rows);
        // 查询
        VoteResultExample example = new VoteResultExample();
        example.setOrderByClause("id desc");
        List<VoteResult> voteResults = resultMapper.selectByExample(example);
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


    /**
     * 查询的比赛
     *
     * @param status 0表示进行中的比赛，1表示结束的比赛
     */
    @Override
    public HyResult getVoteUnClose(Integer page, Integer rows, Integer status) {
        // 分页
        if (page != -1) {
            PageHelper.startPage(page, rows);
            VoteResultExample example = new VoteResultExample();
            example.setOrderByClause("id desc");
            VoteResultExample.Criteria criteria = example.createCriteria();
            criteria.andStatusEqualTo(status);
            List<VoteResult> voteResults = resultMapper.selectByExample(example);

            if (voteResults != null && voteResults.size() > 0) {
                PageInfo<VoteResult> pageInfo = new PageInfo<>(voteResults);
                PageResult pageResult = new PageResult();
                // 循环比赛记录，查询票数和选手名称
                for (VoteResult voteResult : voteResults) {
                    VoteResultCustom custom = customPlayerInfo(voteResult);
                    pageResult.getData().add(custom);

                }
                pageResult.setPage(page);
                pageResult.setCount(pageInfo.getTotal());
                return HyResult.ok(pageResult);
            }
        }

        // 不分页
        VoteResultExample example = new VoteResultExample();
        example.setOrderByClause("id desc");
        VoteResultExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(status);
        List<VoteResult> voteResults = resultMapper.selectByExample(example);

        if (voteResults != null && voteResults.size() > 0) {
            // 循环比赛记录，查询票数和选手名称
            List<VoteResultCustom> list = new ArrayList<>();
            for (VoteResult voteResult : voteResults) {
                VoteResultCustom custom = customPlayerInfo(voteResult);
                list.add(custom);
            }
            return HyResult.ok(list);
        }


        return HyResult.build(400, "没有跟多数据了");
    }

    /**
     * 添加比赛信息
     */
    @Override
    public HyResult insertVote(VoteResult voteResult) {

        try {
            voteResult.setStatus(0);
            resultMapper.insert(voteResult);

        } catch (Exception e) {
            e.printStackTrace();
            return HyResult.build(500, "服务器发生异常");
        }

        return HyResult.ok();
    }


    // 获取选手信息
    private VoteResultCustom customPlayerInfo(VoteResult voteResult) {
        // 创建包装对象
        VoteResultCustom voteResultCustom = new VoteResultCustom();
        String pkNames = voteResult.getPkNames();
        String pkTickets = voteResult.getPkTickets();
        // 分割选手
        String[] splitPkNames = pkNames.split(",");
        if (pkTickets != null) {
            // 分割分数
            String[] splitPkTickets = pkTickets.split(",");
            // 包装分数
            for (String ticket : splitPkTickets) {
                voteResultCustom.getPlayerTickets().add(Long.valueOf(ticket));
            }
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

    // 选手投票
    @Override
    public HyResult votePlayer(Integer voteId, Integer playerId) {
        // 根据id查询比赛
        VoteResult voteResult = resultMapper.selectByPrimaryKey(voteId);
        // 获取票数
        if (voteResult == null) {
            return HyResult.build(400, "没有该比赛");
        }
        String pkTickets = voteResult.getPkTickets();
        String[] split = pkTickets.split(",");
        if (playerId >= split.length) {
            return HyResult.build(400, "没有该选手");
        }
        String cur = split[playerId];
        // 指定的选手票数+1
        int ticket = Integer.valueOf(cur) + 1;
        split[playerId] = ticket + "";
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            sb.append(s).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);

        // 插入数据
        VoteResult curVote = new VoteResult();
        curVote.setId(voteResult.getId());
        curVote.setPkTickets(sb.toString());
        resultMapper.updateByPrimaryKeySelective(curVote);


        return HyResult.ok();
    }

    // 停止比赛
    @Override
    public HyResult stopVote(Integer voteId) {

        VoteResult voteResult = new VoteResult();
        voteResult.setId(voteId);
        voteResult.setStatus(1);
        resultMapper.updateByPrimaryKeySelective(voteResult);

        return HyResult.ok();
    }

    // 根据多个id获取比赛
    @Override
    public HyResult getById(String ids) {
        String[] id = ids.split(",");
        ArrayList<VoteResultCustom> list = new ArrayList<>();
        for (String i : id) {
            VoteResult result = resultMapper.selectByPrimaryKey(Integer.valueOf(i));
            VoteResultCustom voteResultCustom = customPlayerInfo(result);
            list.add(voteResultCustom);
        }
        return HyResult.ok(list);
    }
}
