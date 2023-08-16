package com.example.convpay.dto;

import com.example.convpay.type.PayCancelResult;

public class PayCancelResponse {
    PayCancelResult payCancleResult;

    Integer payCanceledAmount;

    public PayCancelResponse(PayCancelResult payCancleResult, Integer payCanceledAmount) {
        this.payCancleResult = payCancleResult;
        this.payCanceledAmount = payCanceledAmount;
    }

    public PayCancelResult getPayCancleResult() {
        return payCancleResult;
    }

    public void setPayCancleResult(PayCancelResult payCancleResult) {
        this.payCancleResult = payCancleResult;
    }

    public Integer getPayCanceledAmount() {
        return payCanceledAmount;
    }

    public void setPayCanceledAmount(Integer payCanceledAmount) {
        this.payCanceledAmount = payCanceledAmount;
    }
}
