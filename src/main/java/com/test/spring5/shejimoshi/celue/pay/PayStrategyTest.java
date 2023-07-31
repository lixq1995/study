package com.test.spring5.shejimoshi.celue.pay;


import com.test.spring5.shejimoshi.celue.pay.payport.PayStrategy;

/**
 * Created by Tom.
 */
public class PayStrategyTest {

    public static void main(String[] args) {

        //省略把商品添加到购物车，再从购物车下单
        //模拟直接从点单开始
        Order order = new Order("1","20180311001000009",324.45);

        //开始支付，选择微信支付、支付宝、银联卡、京东白条、财付通
        //基本算法固定的
        //每个渠道它支付的具体业务代码算法支付逻辑，比如折扣等是不一样的

        //这个值是在支付的时候才决定用哪个值
        System.out.println(order.pay(PayStrategy.ALI_PAY));



//        InstantiationStrategy
//        spring初始化的时候也采用了策略模式，不同的类型采用不同的初始化策略，如上InstantiationStrategy接口，可查看其源码
//        InstantiationStrateg为顶层接口，有2个类实现该接口，即SimpleInstantiationStrategy与CglibSubclassingInstantiationStrategy。

    }

}
