package com.vote.controller;

import com.vote.pojo.VoteResult;
import com.vote.service.VoteService;
import com.vote.utils.HyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    private VoteService voteService;

    //
    @GetMapping("/info")
    @CrossOrigin("http://localhost:63342")
    public HyResult getCurrentVoteInfo() {
        return voteService.getVoteAll();
    }

    // 获取全部比赛信息，支持分页
    @GetMapping("/pageinfo")
    @CrossOrigin("http://localhost:63342")
    public HyResult getPageVoteInfo(@RequestParam Integer page, @RequestParam(defaultValue = "3") Integer rows) {
        return voteService.getVoteResult(page, rows);
    }

    // 获取比赛信息(0表示进行中的比赛，1表比赛结束。分页)
    @GetMapping("/unclose")
    @CrossOrigin("http://localhost:63342")
    public HyResult getPageVoteUnClose(@RequestParam Integer page, @RequestParam(defaultValue = "3") Integer rows, Integer status) {
        return voteService.getVoteUnClose(page, rows, status);
    }

    // 插入比赛信息
    @PostMapping("/insert")
    @CrossOrigin("http://localhost:63342")
    public HyResult insertVoteInfo(VoteResult voteResult) {
        return voteService.insertVote(voteResult);
    }


}
