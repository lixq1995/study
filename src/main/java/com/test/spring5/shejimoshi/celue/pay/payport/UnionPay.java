package com.test.spring5.shejimoshi.celue.pay.payport;

/**
 * 具体的支付方式，银联
 */
public class UnionPay extends Payment {

    @Override
    public String getName() {
        return "银联支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 120;
    }

}
