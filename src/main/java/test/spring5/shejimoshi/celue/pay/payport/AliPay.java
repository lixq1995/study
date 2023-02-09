package test.spring5.shejimoshi.celue.pay.payport;


/**
 * 具体的支付方式，阿里
 */
public class AliPay extends Payment {

    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    protected double queryBalance(String uid) {
        return 900;
    }

}
