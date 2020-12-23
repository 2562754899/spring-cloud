package com.jiang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * GTR
 * 2020/12/7
 * com.jiang.springcloud
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain80 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain80.class,args);
    }
}
