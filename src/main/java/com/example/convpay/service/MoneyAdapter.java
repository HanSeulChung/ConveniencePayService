package com.example.convpay.service;

import com.example.convpay.type.MoneyUseCancelResult;
import com.example.convpay.type.MoneyUseResult;

public class MoneyAdapter {
    public MoneyUseResult use(Integer payAmount) {
        System.out.println("MoneyAdpter.use: " + payAmount);

        if (payAmount > 1000_000) {
            return MoneyUseResult.USE_FAIL;
        }
        return MoneyUseResult.USE_SUCCESS;
    }

    public MoneyUseCancelResult useCancle(Integer payCancleAmount) {
        System.out.println("MoneyAdapter.useCancel : " + payCancleAmount);

        if (payCancleAmount < 100) {
            return MoneyUseCancelResult.MONEY_USE_CANCLE_FAIL;
        }
        return MoneyUseCancelResult.MONEY_USE_CANCLE_SUCCESS;
    }
}
