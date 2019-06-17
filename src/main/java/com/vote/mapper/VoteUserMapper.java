package com.vote.mapper;

import com.vote.pojo.VoteUser;
import com.vote.pojo.VoteUserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VoteUserMapper {
    int countByExample(VoteUserExample example);

    int deleteByExample(VoteUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(VoteUser record);

    int insertSelective(VoteUser record);

    List<VoteUser> selectByExample(VoteUserExample example);

    VoteUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") VoteUser record, @Param("example") VoteUserExample example);

    int updateByExample(@Param("record") VoteUser record, @Param("example") VoteUserExample example);

    int updateByPrimaryKeySelective(VoteUser record);

    int updateByPrimaryKey(VoteUser record);
}