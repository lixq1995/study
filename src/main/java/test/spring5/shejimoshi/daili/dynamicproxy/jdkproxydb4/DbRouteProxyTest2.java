package test.spring5.shejimoshi.daili.dynamicproxy.jdkproxydb4;


import com.test.spring5.shejimoshi.daili.staticproxy4db.IOrderService;
import com.test.spring5.shejimoshi.daili.staticproxy4db.Order;
import com.test.spring5.shejimoshi.daili.staticproxy4db.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author by Lixq
 * @Classname DbRouteProxyTest2
 * @Description 实际应用场景模拟：如分布式业务场景中，通常对数据库进行分库分表，分库分表之后使用java操作时就可能需要配置多个数据源，
 * 此时可以通过设置数据源路由来动态切换数据源。
 * 演示实例功能为：根据订单创建时间自动按年进行分库
 *
 * 对应DbRouteProxyTest1静态代理演示
 * @Date 2022/3/17 22:21
 */
public class DbRouteProxyTest2 {
    public static void main(String[] args) {
        try {
            Order order = new Order();
            // 动态代理
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2017/02/01");
            order.setCreateTime(date.getTime());

            IOrderService orderService = (IOrderService)new OrderServiceDynamicProxy().getInstance(new OrderService());
            orderService.createOrder(order);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
