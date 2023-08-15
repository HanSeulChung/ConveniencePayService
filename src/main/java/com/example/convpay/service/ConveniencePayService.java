package com.example.convpay.service;

import com.example.convpay.dto.*;
import com.example.convpay.type.MoneyUseCancleResult;
import com.example.convpay.type.MoneyUseResult;
import com.example.convpay.type.PayCancleResult;
import com.example.convpay.type.PayResult;

public class ConveniencePayService { // 편결이
    private final MoneyAdapter moneyAdapter = new MoneyAdapter();
    public PayResponse pay(PayRequest payRequest) {
        MoneyUseResult moneyUseResult =
                moneyAdapter.use(payRequest.getPayAmount());

        if (moneyUseResult == moneyUseResult.USE_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }
        // Success Case (성공일 때는 마지막까지 내려올 수 있도록)
        return new PayResponse(PayResult.SUCCESS, payRequest.getPayAmount());

    }

    public PayCancelResponse payCancle(PayCancelRequest payCancleRequest) {
        MoneyUseCancleResult moneyUseCancleResult =
                moneyAdapter.useCancle(payCancleRequest.getPayCancleAmount());

        if (moneyUseCancleResult == MoneyUseCancleResult.MONEY_USE_CANCLE_FAIL) {
            return new PayCancelResponse(PayCancleResult.PAY_CANCEL_FAIL, 0);
        }
        return new PayCancelResponse(PayCancleResult.PAY_CANCEL_SUCCESS, payCancleRequest.getPayCancleAmount());
    }

}
