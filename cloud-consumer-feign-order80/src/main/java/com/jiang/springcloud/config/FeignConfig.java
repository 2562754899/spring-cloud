package com.jiang.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * GTR
 * 2020/12/9
 * com.jiang.springcloud.config
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level fLevel(){
        return  Logger.Level.FULL;
    }

}
