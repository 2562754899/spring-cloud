package com.jiang.springcloud.controller;

import com.jiang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable Integer id) {
        String info_ok = paymentService.paymentInfo_OK(id);
        log.info("*****info_ok"+info_ok);
        return  info_ok;
    }
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable Integer id) {
        String paymentInfo_Timeout = paymentService.paymentInfo_Timeout (id);
        log.info("*****info_ok"+paymentInfo_Timeout);
        return  paymentInfo_Timeout;
    }

    //===服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*******result:"+result);
        return result;
    }

}
