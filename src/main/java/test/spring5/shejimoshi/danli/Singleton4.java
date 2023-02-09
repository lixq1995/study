package test.spring5.shejimoshi.danli;


import lombok.extern.slf4j.Slf4j;

/**
 * 静态内部类。它有点类似饿汉式，但又能做到了延迟加载
 *
 */
@Slf4j
public class Singleton4 {

    private Singleton4() {
    }

    // static是为了使单例的空间共享，保证这个方法不会被重写，重载
    private static class SingletonHolder {
        private static final Singleton4 instance = new Singleton4();
    }

    // 默认会先初始化内部类。 如果没使用，则内部类是不加载的
    public static Singleton4 getInstance() {
        // 加载内部类
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton4 instance = getInstance();
                log.info("instance is : {}",instance);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton4 instance = getInstance();
                log.info("instance is : {}",instance);
            }
        }).start();
    }

}
