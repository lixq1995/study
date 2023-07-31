package com.test.spring5.shejimoshi.daili.dynamicproxy.gpproxy;


import com.test.spring5.shejimoshi.daili.dynamicproxy.jdkproxy.Girl;
import com.test.spring5.shejimoshi.daili.staticproxy1.Person;

/**
 * Created by Tom on 2019/3/10.
 */
public class GPProxyTest {

    public static void main(String[] args) {
        try {

            //JDK动态代理的实现原理
            Person obj = (Person) new GPMeipo().getInstance(new Girl());
            System.out.println(obj.getClass());
            obj.findLove();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
