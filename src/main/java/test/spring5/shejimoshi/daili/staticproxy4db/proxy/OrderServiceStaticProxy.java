package test.spring5.shejimoshi.daili.staticproxy4db.proxy;


import com.test.spring5.shejimoshi.daili.staticproxy4db.IOrderService;
import com.test.spring5.shejimoshi.daili.staticproxy4db.Order;
import com.test.spring5.shejimoshi.daili.staticproxy4db.db.DynamicDataSourceEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author by Lixq
 * @Classname OrderServiceStaticProxy
 * @Description TODO
 * @Date 2022/3/16 23:07
 */
public class OrderServiceStaticProxy implements IOrderService {
    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    private IOrderService orderService;
    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        before();
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
        System.out.println("静态代理类自动分配到【DB_" +  dbRouter + "】数据源处理数据" );
        DynamicDataSourceEntity.set(dbRouter);

        this.orderService.createOrder(order);
        DynamicDataSourceEntity.restore();

        after();
        return 0;
    }

    private void before() {
        System.out.println("proxy before method.");
    }

    private void after() {
        System.out.println("proxy after method.");
    }
}
