package com.vote.mapper;

import com.vote.pojo.VotePlayer;
import org.springframework.stereotype.Component;

@Component
public interface VotePlayerMapperCustom {

    VotePlayer selectVotePlayerByNameLike(String name);

}