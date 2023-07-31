package com.test.spring5.shejimoshi.daili.staticproxy4db;

/**
 * @author by Lixq
 * @Classname OrderDao
 * @Description TODO
 * @Date 2022/3/16 22:53
 */
public class OrderDao {
    public int insert(Order order){
        System.out.println("OrderDao创建Order成功!");
        return 1;
    }
}
