package com.test.spring5.shejimoshi.danli;


import lombok.extern.slf4j.Slf4j;

/**
 * 静态内部类。它有点类似饿汉式，但又能做到了延迟加载
 *
 */
@Slf4j
public class Singleton4Two {

    // 解决反射强制创建对象，破坏单例的问题
    private Singleton4Two() {
        if (SingletonHolder.instance != null) {
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    private static class SingletonHolder {
        private static final Singleton4Two instance = new Singleton4Two();
    }

    public static Singleton4Two getInstance() {
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton4Two instance = getInstance();
                log.info("instance is : {}",instance);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton4Two instance = getInstance();
                log.info("instance is : {}",instance);
            }
        }).start();
    }

}
