package com.vote.mapper;

import com.vote.pojo.VoteResult;
import com.vote.pojo.VoteResultExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VoteResultMapper {
    int countByExample(VoteResultExample example);

    int deleteByExample(VoteResultExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VoteResult record);

    int insertSelective(VoteResult record);

    List<VoteResult> selectByExample(VoteResultExample example);

    VoteResult selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VoteResult record, @Param("example") VoteResultExample example);

    int updateByExample(@Param("record") VoteResult record, @Param("example") VoteResultExample example);

    int updateByPrimaryKeySelective(VoteResult record);

    int updateByPrimaryKey(VoteResult record);
}