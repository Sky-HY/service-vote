package com.vote.mapper;

import com.vote.pojo.VoteResult;
import org.springframework.stereotype.Component;

@Component
public interface VoteResultMapperCustom {

    VoteResult getCurrentVote();

}
