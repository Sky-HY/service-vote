package com.vote.service;

import com.vote.pojo.VotePlayer;
import com.vote.utils.HyResult;

public interface PlayerService {

    HyResult selectPlayer(String name);

    HyResult insertPlayer(VotePlayer votePlayer);

    HyResult getPlayer(Integer page,Integer rows);
}
