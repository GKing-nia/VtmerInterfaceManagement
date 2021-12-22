package com.tzy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author : Gking
 * @date : 2021-12-19 20:56
 **/
@SpringBootApplication
@EnableFeignClients
@MapperScan("com.tzy.dao")
@EnableDiscoveryClient
public class CommentApplication {
    public static void main(String[] args) {

        SpringApplication.run(MissionApplication.class,args);


    }
}
