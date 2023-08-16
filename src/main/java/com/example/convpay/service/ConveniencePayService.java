package com.example.convpay.service;

import com.example.convpay.dto.*;
import com.example.convpay.type.*;

public class ConveniencePayService { // 편결이
    private final MoneyAdapter moneyAdapter = new MoneyAdapter();
    private final CardAdapter cardAdapter = new CardAdapter();
    public PayResponse pay(PayRequest payRequest) {
        CardUseResult cardUseResult;
        MoneyUseResult moneyUseResult;
        if (payRequest.getPayMethodType() == PayMethodType.CARD) {
            cardAdapter.authorization();
            cardAdapter.approval();
            cardUseResult = cardAdapter.capture(payRequest.getPayAmount());
        } else {
            moneyUseResult =
                    moneyAdapter.use(payRequest.getPayAmount());
        }

        if (cardUseResult == CardUseResult.USE_FAIL || moneyUseResult == MoneyUseResult.USE_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }
        // Success Case (성공일 때는 마지막까지 내려올 수 있도록)
        return new PayResponse(PayResult.SUCCESS, payRequest.getPayAmount());

    }

    public PayCancelResponse payCancle(PayCancelRequest payCancleRequest) {
        MoneyUseCancelResult moneyUseCancleResult =
                moneyAdapter.useCancle(payCancleRequest.getPayCancleAmount());

        if (moneyUseCancleResult == MoneyUseCancelResult.MONEY_USE_CANCLE_FAIL) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS, payCancleRequest.getPayCancleAmount());
    }

}
