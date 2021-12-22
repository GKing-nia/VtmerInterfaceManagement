package com.tzy;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
/**
 * @author
 * @date
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
public class VtmCommonApplication {
}
