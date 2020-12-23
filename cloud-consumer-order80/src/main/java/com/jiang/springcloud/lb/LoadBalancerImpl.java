package com.jiang.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * GTR
 * 2020/12/8
 * com.jiang.springcloud.lb
 */
//这个注解跟service注解类似，加入spring容器管理
@Component
public class LoadBalancerImpl implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        //当前值
        int current;
        //更想值
        int next;
        //自旋锁
        do {
            //当前值0
            current = this.atomicInteger.get();
            //更想值为1，判断current大于等于2147483647判断为false 当前值归零
            next = current >= 2147483647 ? 0 : current + 1;
            //current当前值  next更想值
            // this.atomicInteger.compareAndSet(current, next)更行访问次数成功后=true 取反返回false跳出循环
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("****第几次访问数字next:" + next);
        //返回更新值1
        return next;

    }


    @Override
    public ServiceInstance INSTANCE(List<ServiceInstance> serviceInstances) {

        //getAndIncrement是访问次数 serviceInstances.size()是获取提供者的数量 取余
        int index=getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
