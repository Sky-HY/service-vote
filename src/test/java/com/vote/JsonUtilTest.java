package com.vote;

import com.vote.pojo.VoteUser;
import com.vote.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonUtilTest {

    @Test
    public void pojoToJson(){
        VoteUser user = new VoteUser();
        user.setUsername("张三");
        user.setPassword("123");

        String s = JsonUtil.pojoToJson(user);
        System.out.println(s);
    }
}
