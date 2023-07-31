package com.test.javabasics.thread.book.chapter1.threadlocal;

public class TestThreadLocal2 {

    //1创建线程变量,
    // todo ThreadLocal改为InheritableThreadLocal，子线程即可拿到主线程中设置在ThreadLocal中的属性
    public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        //2设置线程变量
        threadLocal.set("hello world");
        //3启动子线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //4子线程输出线程变量的值
                System.out.println("thread : " + threadLocal.get());
            }
        });

        thread.start();

        //5主线程输出线程变量的值
        System.out.println("main : " + threadLocal.get());
    }
}
