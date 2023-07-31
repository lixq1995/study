package com.test.designmode.singletondesign41;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 饿汉式不支持延迟加载，懒汉式有性能问题，不支持高并发
 *
 * 双重检测
 * 在这种实现方式中，只要 instance 被创建之后，即便再调用 getInstance() 函数也不会再进入到加锁逻辑中了
 */
public class Singleton3 {
    private AtomicLong id = new AtomicLong(0);
    private static volatile Singleton3 instance;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) { // 此处为类级别的锁
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
