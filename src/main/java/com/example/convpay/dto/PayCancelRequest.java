package com.example.convpay.dto;

import com.example.convpay.type.ConvenienceType;

public class PayCancelRequest {
    // 편의점 종류
    ConvenienceType convenienceType;
    // 결제 취소 금액
    Integer payCancleAmount;

    public PayCancelRequest(ConvenienceType convenienceType, Integer payCancleAmount) {
        this.convenienceType = convenienceType;
        this.payCancleAmount = payCancleAmount;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    public Integer getPayCancleAmount() {
        return payCancleAmount;
    }

    public void setPayCancleAmount(Integer payCancleAmount) {
        this.payCancleAmount = payCancleAmount;
    }
}
