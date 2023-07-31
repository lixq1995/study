package com.test.spring5.shejimoshi.celue.pay.payport;


/**
 * 具体的支付方式，京东
 */
public class JDPay extends Payment {

    @Override
    public String getName() {
        return "京东白条";
    }

    @Override
    protected double queryBalance(String uid) {
        return 500;
    }
}
