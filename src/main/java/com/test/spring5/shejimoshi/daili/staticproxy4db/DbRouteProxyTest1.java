package com.test.spring5.shejimoshi.daili.staticproxy4db;


import com.test.spring5.shejimoshi.daili.staticproxy4db.proxy.OrderServiceStaticProxy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author by Lixq
 * @Classname DbRouteProxyTest1
 * @Description 实际应用场景模拟：如分布式业务场景中，通常对数据库进行分库分表，分库分表之后使用java操作时就可能需要配置多个数据源，
 * 此时可以通过设置数据源路由来动态切换数据源。
 * 演示实例功能为：根据订单创建时间自动按年进行分库
 * @Date 2022/3/16 23:17
 */
public class DbRouteProxyTest1 {
    public static void main(String[] args) {
        try {
            Order order = new Order();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2022/02/01");
            order.setCreateTime(date.getTime());
            // 静态代理
            IOrderService orderService = new OrderServiceStaticProxy(new OrderService());
            orderService.createOrder(order);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
