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
public class paymentMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(paymentMain8006.class,args);
    }
}
