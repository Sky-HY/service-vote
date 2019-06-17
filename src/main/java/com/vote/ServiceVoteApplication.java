package com.vote;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.vote.mapper")
public class ServiceVoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceVoteApplication.class, args);
    }


}
