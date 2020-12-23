package com.jiang.springcloud.dao;

import com.jiang.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
//@repository
public interface PaymentMapper {


    public int add(Payment payment);

    public Payment getPaymentId(@Param("id") long id) ;

}
