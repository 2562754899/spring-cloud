package com.jiang.springcloud.service;

import com.jiang.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * GTR
 * 2020/12/4
 * com.jiang.payment.service
 */
@Service
public interface PaymentService {

    public int add(Payment payment);

    public Payment getPaymentId(long id) ;

}
