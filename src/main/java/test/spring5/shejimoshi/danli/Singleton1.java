package test.spring5.shejimoshi.danli;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicLong;

// todo 单例模式可以保证内存里只有一个实例，减少了内存的开销，还可以避免对资源的多重占用

/**
 * 饿汉式
 * 在类加载的时候，instance 静态实例就已经创建并初始化好了，所以，instance 实例的创建过程是线程安全的。
 * 不过，这样的实现方式不支持延迟加载（在真正用到 IdGenerator 的时候，再创建实例）
 */
@Slf4j
public class Singleton1 {
    private static final Singleton1 instance = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton1 instance = getInstance();
                log.info("instance is : {}",instance);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton1 instance = getInstance();
                log.info("instance is : {}",instance);
            }
        }).start();
    }

}
