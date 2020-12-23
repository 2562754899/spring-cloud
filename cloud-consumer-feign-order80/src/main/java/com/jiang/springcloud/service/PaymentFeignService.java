package com.jiang.springcloud.service;

import com.jiang.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * GTR
 * 2020/12/8
 * com.jiang.springcloud.service
 */
@Service
@FeignClient("CLOUT-PAYMENT-SERVICE")//调用客户端
public interface  PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();
}
