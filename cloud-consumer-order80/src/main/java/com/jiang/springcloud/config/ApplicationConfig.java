package com.jiang.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * GTR
 * 2020/12/4
 * com.jiang.springcloud.config
 */
@Configuration
public class ApplicationConfig {

//    @LoadBalanced //添加注解开启负载均衡能力
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
