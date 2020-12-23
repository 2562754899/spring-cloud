package com.jiang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * GTR
 * 2020/12/6
 * com.jiang.springcloud
 */
@SpringBootApplication
@EnableDiscoveryClient //该注解用于consul或者zookeeper作为注册中心注册该服务
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class,args);
    }


}
