package com.jiang.springcloud.service;

import com.jiang.springcloud.dao.PaymentMapper;
import com.jiang.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * GTR
 * 2020/12/4
 * com.jiang.payment.service
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int add(Payment payment) {
        return paymentMapper.add(payment);
    }

    @Override
    public Payment getPaymentId(long id) {
        return paymentMapper.getPaymentId(id);
    }
}
