package com.jiang.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * GTR
 * 2020/12/23
 * com.jiang.springcloud
 */

@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain9001 {
      public static void main(String[] args) {
              SpringApplication.run(PaymentMain9001.class,args);}
    
}
