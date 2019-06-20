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

    @GetMapping("/get")
    @CrossOrigin("http://localhost:63342")
    public HyResult getPlayerName(String name,Integer page,Integer rows) {
        return playerService.selectPlayer(name);
    }

    @PostMapping("/insert")
    @CrossOrigin("http://localhost:63342")
    public HyResult insertPlayer(VotePlayer votePlayer) {
        return playerService.insertPlayer(votePlayer);
    }

    @GetMapping("/getpage")
    @CrossOrigin("http://localhost:63342")
    public HyResult getPagePlayer(@RequestParam Integer page, @RequestParam(defaultValue = "3") Integer rows) {
        return playerService.getPlayer(page, rows);
    }

}
