package com.jiang.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * GTR
 * 2020/12/11
 * com.jiang.springcloud.config
 */
@Configuration
public class GatewayConfig {

    /**
     * 第二种配置网关的方式
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_jiang",r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        //http://news.baidu.com/guonei
        return routes.build();
    }
}
