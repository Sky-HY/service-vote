package com.vote.mapper;

import com.vote.pojo.VotePlayer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VotePlayerMapperCustom {

    List<VotePlayer> selectVotePlayerByNameLike(String name);

}