package com.test.javabasics.thread.shangguigu.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 卢意
 * @create 2021-01-11 15:36
 */
public class TestThreadPool1 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5); // 一池5个受理线程

        try {
            // 模拟10个顾客办理业务 但是只有5个员工办理业务
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
        // pool-1-thread-1	 办理业务
        // pool-1-thread-3	 办理业务
        // pool-1-thread-2	 办理业务
        // pool-1-thread-3	 办理业务
        // pool-1-thread-2	 办理业务
        // pool-1-thread-3	 办理业务
        // pool-1-thread-3	 办理业务
        // pool-1-thread-2	 办理业务
        // pool-1-thread-4	 办理业务
        // pool-1-thread-5	 办理业务
    }
}