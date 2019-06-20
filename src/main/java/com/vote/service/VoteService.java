package com.vote.service;

import com.vote.utils.HyResult;

public interface VoteService {

    HyResult getVoteStatus();

    HyResult getVoteResult(Integer page,Integer rows);

}
