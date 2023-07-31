package com.test.javabasics.thread.book.chapter1.testyield;

// 调用yield 方法时，线程只是让出自己剩余的时间片，并没有被阻塞挂起，而是处于就绪状态，
// 线程调度器下一次调度时就有可能调度到当前线程执行。
public class TestYield implements Runnable{

    TestYield() {
        // 创建并启动线程
        Thread thread = new Thread(this::run);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            // 当i = 0时让出cpu执行权，放弃时间片，进行下一轮调度
            if ((i % 5) == 0) {
                System.out.println(Thread.currentThread() + "yield cpu ...");
                // 当前线程让出cpu执行权，放弃时间片，进行下一轮调度
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread() + "is over");
    }

    public static void main(String[] args) {
        new TestYield();
        new TestYield();
        new TestYield();
    }
}
