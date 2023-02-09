package test.spring5.shejimoshi.danli;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程唯一单例。
 * ThreadLocal 底层实现原理也是基于下面代码中所示的 HashMap
 * 即与ThreadLocal底层原理类似
 */
@Slf4j
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


    public static void main(String[] args) {
        ThreadSingleton instance = getInstance();
        ThreadSingleton instance1 = getInstance();
        System.out.println("instance" + instance + "     " + "instance1" + instance1);
        System.out.println(instance == instance1);
        System.out.println(instance.equals(instance1));


        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadSingleton instance = getInstance();
                log.info("instance is : {}",instance);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadSingleton instance = getInstance();
                log.info("instance is : {}",instance);
            }
        }).start();
    }
}
