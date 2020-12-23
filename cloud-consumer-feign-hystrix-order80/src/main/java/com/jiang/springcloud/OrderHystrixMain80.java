package com.jiang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * GTR
 * 2020/12/10
 * com.jiang.springcloud
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixMain80 {

      public static void main(String[] args) {
              SpringApplication.run(OrderHystrixMain80.class,args);}
}
