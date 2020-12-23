package com.jiang.springcloud.controller;

import com.jiang.springcloud.entities.CommonResult;
import com.jiang.springcloud.entities.Payment;
import com.jiang.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * GTR
 * 2020/12/9
 * com.jiang.springcloud.controller
 */
@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentId(@PathVariable("id") long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String getPaymentFeignTimeout(){
        return paymentFeignService.paymentFeignTimeout();
    }

}
