package com.example.convpay.dto;

import com.example.convpay.type.PayCancleResult;

public class PayCancelResponse {
    PayCancleResult payCancleResult;

    Integer payCanceledAmount;

    public PayCancelResponse(PayCancleResult payCancleResult, Integer payCanceledAmount) {
        this.payCancleResult = payCancleResult;
        this.payCanceledAmount = payCanceledAmount;
    }

    public PayCancleResult getPayCancleResult() {
        return payCancleResult;
    }

    public void setPayCancleResult(PayCancleResult payCancleResult) {
        this.payCancleResult = payCancleResult;
    }

    public Integer getPayCanceledAmount() {
        return payCanceledAmount;
    }

    public void setPayCanceledAmount(Integer payCanceledAmount) {
        this.payCanceledAmount = payCanceledAmount;
    }
}
