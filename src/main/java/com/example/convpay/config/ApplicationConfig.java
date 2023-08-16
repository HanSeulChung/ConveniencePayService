package com.example.convpay.config;

import com.example.convpay.service.*;

import java.util.Arrays;
import java.util.HashSet;

public class ApplicationConfig { // 꼭두각시

    public ConveniencePayService conveniencePayServiceDiscountConvenience() {
        return new ConveniencePayService(new HashSet<>(Arrays.asList(new MoneyAdapter(), new CardAdapter())),
                new DiscountByConvenience()
        );
    }

    public ConveniencePayService conveniencePayServiceDiscountPayMethod() {
        return new ConveniencePayService(new HashSet<>(Arrays.asList(new MoneyAdapter(), new CardAdapter())),
                new DiscountByPayMethod()
        );
    }
}
