package com.vote.mapper;

import com.vote.pojo.VoteAdmin;
import com.vote.pojo.VoteAdminExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VoteAdminMapper {
    int countByExample(VoteAdminExample example);

    int deleteByExample(VoteAdminExample example);

    int deleteByPrimaryKey(String id);

    int insert(VoteAdmin record);

    int insertSelective(VoteAdmin record);

    List<VoteAdmin> selectByExample(VoteAdminExample example);

    VoteAdmin selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") VoteAdmin record, @Param("example") VoteAdminExample example);

    int updateByExample(@Param("record") VoteAdmin record, @Param("example") VoteAdminExample example);

    int updateByPrimaryKeySelective(VoteAdmin record);

    int updateByPrimaryKey(VoteAdmin record);
}