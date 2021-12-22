package com.tzy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author
 * @date
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@MapperScan("com.tzy.dao")
public class MissionApplication {
    public static void main(String[] args) {

            SpringApplication.run(MissionApplication.class,args);


    }
}
