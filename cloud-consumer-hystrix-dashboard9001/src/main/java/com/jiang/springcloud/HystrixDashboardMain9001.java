package com.jiang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * GTR
 * 2020/12/11
 * com.jiang.springcloud
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {
      public static void main(String[] args) {
              SpringApplication.run(HystrixDashboardMain9001.class,args);}
}
