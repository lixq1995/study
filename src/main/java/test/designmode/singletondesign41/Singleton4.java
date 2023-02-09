package test.designmode.singletondesign41;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 静态内部类。它有点类似饿汉式，但又能做到了延迟加载
 *
 */
public class Singleton4 {
    private AtomicLong id = new AtomicLong(0);

    private Singleton4() {
    }

    private static class SingletonHolder {
        private static final Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
