package com.vote.controller;

import com.vote.pojo.VotePlayer;
import com.vote.service.PlayerService;
import com.vote.utils.HyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    // 模糊查询参赛选手(分页)
    @GetMapping("/get")
    @CrossOrigin("http://localhost:63342")
    public HyResult getPlayerName(String name, Integer page,@RequestParam(defaultValue = "3") Integer rows) {
        return playerService.selectPlayer(name, page, rows);
    }

    // 添加参赛选手
    @PostMapping("/insert")
    @CrossOrigin("http://localhost:63342")
    public HyResult insertPlayer(VotePlayer votePlayer) {
        return playerService.insertPlayer(votePlayer);
    }

    // 获取所有参数选手(分页)
    @GetMapping("/getpage")
    @CrossOrigin("http://localhost:63342")
    public HyResult getPagePlayer(@RequestParam Integer page, @RequestParam(defaultValue = "3") Integer rows) {
        return playerService.getPlayer(page, rows);
    }

}
