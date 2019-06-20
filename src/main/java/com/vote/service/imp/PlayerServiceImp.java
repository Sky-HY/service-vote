package com.vote.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vote.mapper.VotePlayerMapper;
import com.vote.mapper.VotePlayerMapperCustom;
import com.vote.pojo.PageResult;
import com.vote.pojo.VotePlayer;
import com.vote.service.PlayerService;
import com.vote.utils.HyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImp implements PlayerService {


    @Autowired
    private VotePlayerMapper playerMapper;

    @Autowired
    private VotePlayerMapperCustom playerMapperCustom;

    // 模糊查询参赛选手名称
    @Override
    public HyResult selectPlayer(String name, Integer page, Integer rows) {

        PageHelper.startPage(page, rows);
        try {
            List<VotePlayer> votePlayer = playerMapperCustom.selectVotePlayerByNameLike(name);
            if (votePlayer != null && votePlayer.size() > 0) {
                PageInfo<VotePlayer> pageInfo = new PageInfo<>(votePlayer);
                PageResult pageResult = new PageResult();
                pageResult.setPage(page);
                pageResult.setCount(pageInfo.getTotal());
                pageResult.getData().addAll(votePlayer);
                return HyResult.ok(pageResult);
            }
            return HyResult.build(400, "没有此参赛选手");

        } catch (Exception e) {
            e.printStackTrace();
            return HyResult.build(500, "服务器异常");
        }

    }


    // 插入选手
    @Override
    public HyResult insertPlayer(VotePlayer votePlayer) {

        try {
            playerMapper.insert(votePlayer);
            return HyResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return HyResult.build(500, "服务器发生异常");
        }

    }

    // 分页查询选手
    @Override
    public HyResult getPlayer(Integer page, Integer rows) {

        PageHelper.startPage(page, rows);
        try {
            PageResult pageResult = new PageResult();
            List<VotePlayer> players = playerMapper.selectByExample(null);
            if (players != null && players.size() > 0) {
                PageInfo<VotePlayer> pageInfo = new PageInfo<>(players);
                pageResult.setPage(page);
                pageResult.setCount(pageInfo.getTotal());
                pageResult.getData().addAll(players);
                // 返回结果
                return HyResult.ok(pageResult);
            }

            return HyResult.build(400, "没有更多数据");
        } catch (Exception e) {
            e.printStackTrace();
            return HyResult.build(500, "服务器发生异常");
        }

    }
}
