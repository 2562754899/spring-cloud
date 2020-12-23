package com.jiang.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * GTR
 * 2020/12/8
 * com.jiang.springcloud.lb
 */
public interface LoadBalancer {


    /**
     * 获取服务提供者
     * @param serviceInstances
     * @return
     */
    ServiceInstance INSTANCE(List<ServiceInstance> serviceInstances);

}
