package com.vote.mapper;

import com.vote.pojo.VotePlayer;
import com.vote.pojo.VotePlayerExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface VotePlayerMapper {
    int countByExample(VotePlayerExample example);

    int deleteByExample(VotePlayerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VotePlayer record);

    int insertSelective(VotePlayer record);

    List<VotePlayer> selectByExample(VotePlayerExample example);

    VotePlayer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VotePlayer record, @Param("example") VotePlayerExample example);

    int updateByExample(@Param("record") VotePlayer record, @Param("example") VotePlayerExample example);

    int updateByPrimaryKeySelective(VotePlayer record);

    int updateByPrimaryKey(VotePlayer record);
}