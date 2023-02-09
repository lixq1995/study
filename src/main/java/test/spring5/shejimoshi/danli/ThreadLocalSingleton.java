package test.spring5.shejimoshi.danli;

import lombok.extern.slf4j.Slf4j;

/**
 * @author by Lixq
 * @Classname ThreadLocalSingleton
 * @Description TODO
 * @Date 2022/3/14 21:52
 */
@Slf4j
public class ThreadLocalSingleton {

    // ThreadLocal将所有的对象全部放在ThreadLocalMap中，为每个线程都提供一个对象，实际上是以空间换时间来实现线程隔离
    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance =
            new ThreadLocal<ThreadLocalSingleton>(){
                @Override
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };

    private ThreadLocalSingleton(){}

    public static ThreadLocalSingleton getInstance(){
        return threadLocalInstance.get();
    }

    public static void main(String[] args) {

        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocalSingleton instance = getInstance();
                log.info("instance is : {}",instance);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocalSingleton instance = getInstance();
                log.info("instance is : {}",instance);
            }
        }).start();

    }
}
