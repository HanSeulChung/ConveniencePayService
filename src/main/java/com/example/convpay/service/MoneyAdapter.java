package com.example.convpay.service;

import com.example.convpay.type.CancelPaymentResult;
import com.example.convpay.type.MoneyUseCancelResult;
import com.example.convpay.type.MoneyUseResult;
import com.example.convpay.type.PaymentResult;

public class MoneyAdapter implements PaymentInterface {
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

    @Override
    public PaymentResult payment(Integer payAmount) {
        MoneyUseResult moneyUseResult = use(payAmount);

        if (moneyUseResult == MoneyUseResult.USE_FAIL) {
            return PaymentResult.PAYMENT_FAIL;
        }
        return PaymentResult.PAYMENT_SUCCESS;
    }

    @Override
    public CancelPaymentResult cancelPayment(Integer cancelAmount) {
        MoneyUseCancelResult moneyUseCancelResult = useCancle(cancelAmount);

        if (moneyUseCancelResult == MoneyUseCancelResult.MONEY_USE_CANCLE_FAIL) {
            return CancelPaymentResult.CANCEL_PAYMENT_FAIL;
        }
        return CancelPaymentResult.CANCEL_PAYMENT_SUCCESS;
    }
}
