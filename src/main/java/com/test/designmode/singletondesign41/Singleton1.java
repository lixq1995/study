package com.test.designmode.singletondesign41;


import java.util.concurrent.atomic.AtomicLong;

/**
 * 饿汉式
 * 在类加载的时候，instance 静态实例就已经创建并初始化好了，所以，instance 实例的创建过程是线程安全的。
 * 不过，这样的实现方式不支持延迟加载（在真正用到 IdGenerator 的时候，再创建实例）
 */
public class Singleton1 {
    private AtomicLong id = new AtomicLong(0);
    private static final Singleton1 instance = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
