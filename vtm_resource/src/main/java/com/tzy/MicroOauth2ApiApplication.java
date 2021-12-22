package com.tzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author Hung
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
public class MicroOauth2ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroOauth2ApiApplication.class, args);
    }

}
