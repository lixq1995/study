package com.test.spring5.shejimoshi.daili.staticproxy2;

/**
 * @author by Lixq
 * @Classname Client
 * @Description 同staticproxy1内容
 * @Date 2022/3/16 22:40
 */
public class Client {

    public static void main(String[] args) {

        Proxy proxy = new Proxy(new RealSubject());
        proxy.request();

    }

}
