package com.example.convpay.config;

import com.example.convpay.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;
@Configuration

public class ApplicationConfig { // 꼭두각시

    @Bean
    public ConveniencePayService conveniencePayService() {
        return new ConveniencePayService(new HashSet<>(Arrays.asList(mondeyAdapter(), cardAdapter())),
                discountByConvenience()
        );
    }
    @Bean
    public CardAdapter cardAdapter() {
        return new CardAdapter();
    }
    @Bean
    public MoneyAdapter mondeyAdapter() {
        return new MoneyAdapter();
    }
    @Bean
    public DiscountByConvenience discountByConvenience() {
        return new DiscountByConvenience();
    }

//    public ConveniencePayService conveniencePayServiceDiscountPayMethod() {
//        return new ConveniencePayService(new HashSet<>(Arrays.asList(new MoneyAdapter(), new CardAdapter())),
//                new DiscountByPayMethod()
//        );
//    }
}
