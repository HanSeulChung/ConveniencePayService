package com.example.convpay.service;

import com.example.convpay.type.MoneyUseCancleResult;
import com.example.convpay.type.MoneyUseResult;

public class MoneyAdapter {
    public MoneyUseResult use(Integer payAmount) {
        System.out.println("MoneyAdpter.use: " + payAmount);

        if (payAmount > 1000_000) {
            return MoneyUseResult.USE_FAIL;
        }
        return MoneyUseResult.USE_SUCCESS;
    }

    public MoneyUseCancleResult useCancle(Integer payCancleAmount) {
        System.out.println("MoneyAdapter.useCancel : " + payCancleAmount);

        if (payCancleAmount < 100) {
            return MoneyUseCancleResult.MONEY_USE_CANCLE_FAIL;
        }
        return MoneyUseCancleResult.MONEY_USE_CANCLE_SUCCESS;
    }
}
