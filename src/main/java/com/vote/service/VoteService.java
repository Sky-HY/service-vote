package com.vote.service;

import com.vote.pojo.VoteResult;
import com.vote.utils.HyResult;

public interface VoteService {

    HyResult getVoteStatus();

    HyResult getVoteResult(Integer page,Integer rows);

    HyResult getVoteUnClose(Integer page,Integer rows,Integer status);

    HyResult insertVote(VoteResult voteResult);
}
