package com.test.spring5.shejimoshi.daili.staticproxy2;

/**
 * @author by Lixq
 * @Classname Proxy
 * @Description TODO
 * @Date 2022/3/16 22:38
 */
public class Proxy implements Subject {

    private Subject subject;

    public Proxy(Subject subject){
        this.subject = subject;
    }


    public void request() {
        before();
        subject.request();
        after();
    }

    public void before(){
        System.out.println("called before request().");
    }

    public void after(){
        System.out.println("called after request().");
    }
}
