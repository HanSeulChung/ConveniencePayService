package com.example.convpay.service;

import com.example.convpay.type.CancelPaymentResult;
import com.example.convpay.type.PayMethodType;
import com.example.convpay.type.PaymentResult;

public interface PaymentInterface {
    PayMethodType getpayMehtodType();
    PaymentResult payment(Integer payAmount);
    CancelPaymentResult cancelPayment(Integer cancelAmount);
}
