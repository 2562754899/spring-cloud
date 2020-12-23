package com.jiang.springcloud.controller;

import com.jiang.springcloud.entities.CommonResult;
import com.jiang.springcloud.entities.Payment;
import com.jiang.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * GTR
 * 2020/12/4
 * com.jiang.springcloud.controller
 */
@RestController
@Slf4j
public class OrderController {
    //单机版
//    public  static final  String PAYMENT_URL="http://localhost:8001";
    //负载均衡
    public static final String PAYMENT_URL = "http://CLOUT-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/add")
    public CommonResult<Payment> getPayment(Payment payment) {

        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    /**
     * 使用getForEntity方法
     * getForEntity比getForObject返回跟加详细
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/get2/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") long id) {
        //可以返回更加详细的信息比如响应头，响应体，响应状态码
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            //可以通过日志查看，获取其他信息继续在日志里加
            log.info(entity.getStatusCode() + "");
            return entity.getBody();
        } else {
            return new CommonResult<>(400, "操作失败");
        }
    }

    @GetMapping("/consumer/payment/post")
    public CommonResult<Payment> postPayment2(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
//      return restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class).getBody();
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLb() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUT-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.INSTANCE(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

    // ====================> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        String result = restTemplate.getForObject("http://localhost:8001" + "/payment/zipkin/", String.class);
        return result;
    }


}
