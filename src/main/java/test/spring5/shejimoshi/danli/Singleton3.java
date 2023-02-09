package test.spring5.shejimoshi.danli;

import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉式不支持延迟加载，懒汉式有性能问题，不支持高并发
 *
 * 双重检测
 * 在这种实现方式中，只要 instance 被创建之后，即便再调用 getInstance() 函数也不会再进入到加锁逻辑中了
 */
@Slf4j
public class Singleton3 {
    private static volatile Singleton3 instance;

    // 不能解决反射暴力创建多个对象问题
    private Singleton3() {
        if (instance != null) {
            throw new RuntimeException("不允许创建多个实例");
        }
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

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton3 instance = getInstance();
                log.info("instance is : {}",instance);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton3 instance = getInstance();
                log.info("instance is : {}",instance);
            }
        }).start();
    }

}
