package com.jiang.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * GTR
 * 2020/12/7
 * com.jiang.springcloud.controller
 */
@RestController
public class OrderConsulController {

    private static final String INVOME_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String payment(){
        String template = restTemplate.getForObject(INVOME_URL + "/payment/consul", String.class);
        return template;
    }
}
