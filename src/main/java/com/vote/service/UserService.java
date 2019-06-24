package com.vote.service;

public interface UserService {
    boolean checkUserIsVote(Integer voteId, String ip);
}
