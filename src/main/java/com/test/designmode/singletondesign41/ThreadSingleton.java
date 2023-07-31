package com.test.designmode.singletondesign41;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程唯一单例。
 * ThreadLocal 底层实现原理也是基于下面代码中所示的 HashMap
 * 即与ThreadLocal底层原理类似
 */
public class ThreadSingleton {
    private AtomicLong id = new AtomicLong(0);

    private static final ConcurrentHashMap<Long, ThreadSingleton> instances = new ConcurrentHashMap<>();

    private ThreadSingleton() {
    }

    public static ThreadSingleton getInstance() {
        Long currentThreadId = Thread.currentThread().getId();
        instances.putIfAbsent(currentThreadId, new ThreadSingleton());
        return instances.get(currentThreadId);
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
