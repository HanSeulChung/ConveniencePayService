package com.example.convpay.service;

import com.example.convpay.dto.PayCancelRequest;
import com.example.convpay.dto.PayCancelResponse;
import com.example.convpay.type.ConvenienceType;
import com.example.convpay.dto.PayRequest;
import com.example.convpay.dto.PayResponse;
import com.example.convpay.type.PayCancelResult;
import com.example.convpay.type.PayResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConveniencePayServiceTest {
    ConveniencePayService conveniencePayService = new ConveniencePayService();
    @Test
    void pay_success() {
        //given
        PayRequest payRequest = new PayRequest(ConvenienceType.G25, 50);
        //when
        PayResponse payResponse = conveniencePayService.pay(payRequest);
        //then
        assertEquals(PayResult.SUCCESS, payResponse.getPayResult());
        assertEquals(50, payResponse.getPaidAmount());
    }
    @Test
    void pay_fail() {
        //given
        PayRequest payRequest = new PayRequest(ConvenienceType.G25, 1000_001);
        //when
        PayResponse payResponse = conveniencePayService.pay(payRequest);
        //then
        assertEquals(PayResult.FAIL, payResponse.getPayResult());
        assertEquals(0, payResponse.getPaidAmount());
    }
    @Test
    void pay_cancel_success() {
        //given
        PayCancelRequest payCancelRequest = new PayCancelRequest(ConvenienceType.G25, 1010);
        //when
        PayCancelResponse payCancelResponse = conveniencePayService.payCancle(payCancelRequest);
        //then
        assertEquals(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelResponse.getPayCancleResult());
        assertEquals(1010, payCancelResponse.getPayCanceledAmount());
    }
    @Test
    void pay_cancel_fail() {
        //given
        PayCancelRequest payCancelRequest = new PayCancelRequest(ConvenienceType.G25, 99);
        //when
        PayCancelResponse payCancelResponse = conveniencePayService.payCancle(payCancelRequest);
        //then
        assertEquals(PayCancelResult.PAY_CANCEL_FAIL, payCancelResponse.getPayCancleResult());
        assertEquals(0, payCancelResponse.getPayCanceledAmount());
    }

}