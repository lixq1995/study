package com.test.spring5.shejimoshi.daili.staticproxy1;

/**
 * @author by Lixq
 * @Classname Person
 * @Description TODO
 * @Date 2022/3/16 22:24
 */
public class FatherProxyTest {

    public static void main(String[] args) {
        // 客户端的调用，只能传Son
        Father father = new Father(new Son());
        father.findLove();

        //农村，媒婆
        //婚介所

        //大家每天都在用的一种静态代理的形式
        //对数据库进行分库分表
        //ThreadLocal
        //进行数据源动态切换
    }

}
