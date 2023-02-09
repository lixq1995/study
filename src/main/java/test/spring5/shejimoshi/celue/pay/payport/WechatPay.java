package test.spring5.shejimoshi.celue.pay.payport;

/**
 * 具体的支付方式，微信
 */
public class WechatPay extends Payment {

    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 256;
    }

}
