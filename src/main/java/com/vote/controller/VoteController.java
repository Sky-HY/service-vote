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

    //获取全部比赛信息
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

    /**
     * 获取进行中的比赛，或者已结束的比赛
     *
     * @param page   页数，如果为-1则表示不分页
     * @param rows   每页条数，默认3条
     * @param status 0表进行中的比赛，1表示结束的比赛
     */
    @GetMapping("/unclose")
    @CrossOrigin("http://localhost:63342")
    public HyResult getPageVoteUnClose(@RequestParam Integer page, @RequestParam(defaultValue = "3") Integer rows,
                                       Integer status) {
        return voteService.getVoteUnClose(page, rows, status);
    }

    // 插入比赛信息
    @PostMapping("/insert")
    @CrossOrigin("http://localhost:63342")
    public HyResult insertVoteInfo(VoteResult voteResult) {
        return voteService.insertVote(voteResult);
    }


    // 移动端投票使用
    @GetMapping("/vote")
    @CrossOrigin("http://localhost:63342")
    public HyResult clientVote(Integer voteId, Integer playerId) {
        return voteService.votePlayer(voteId, playerId);
    }

    @GetMapping("/stop")
    @CrossOrigin("http://localhost:63342")
    public HyResult stopVote(Integer voteId) {
        return voteService.stopVote(voteId);
    }

    @GetMapping("/getbyids")
    @CrossOrigin("http://localhost:63342")
    public HyResult get(String ids) {
        return voteService.getById(ids);
    }

}
