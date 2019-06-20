package com.vote.controller;

import com.vote.service.VoteService;
import com.vote.utils.HyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    private VoteService voteService;

    // 暂时不用
    @GetMapping("/curinfo")
    @CrossOrigin("http://localhost:63342")
    public HyResult getCurrentVoteInfo() {
        return voteService.getVoteStatus();
    }

    // 获取全部比赛信息，支持分页
    @GetMapping("/pageinfo")
    @CrossOrigin("http://localhost:63342")
    public HyResult getPageVoteInfo(@RequestParam Integer page,@RequestParam(defaultValue = "3") Integer rows){
        return voteService.getVoteResult(page, rows);
    }

    // 获取进行中比赛信息

    // 获取已结束的比赛信息

    // 插入比赛
}
