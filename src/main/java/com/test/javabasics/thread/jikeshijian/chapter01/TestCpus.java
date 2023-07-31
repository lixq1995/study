package com.test.javabasics.thread.jikeshijian.chapter01;

public class TestCpus {
    private long count = 0;
    // todo 以下add10K方法加上synchronized关键字可解决并发问题
    private void add10K() {
        int idx = 0;
        while(idx++ < 10000) {
            count += 1;
        }
        System.out.println(count);
    }

    public static long calc() throws InterruptedException {
        final TestCpus test = new TestCpus();
        // 创建两个线程，执行 add() 操作
        Thread th1 = new Thread(()->{
            test.add10K();
        });
        Thread th2 = new Thread(()->{
            test.add10K();
        });
        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        th1.join();
        th2.join();
        return 1000;
    }

    public static void main(String[] args) throws InterruptedException {
        // todo 多次运行，输出结果不为10000与20000
        for (int i = 0; i < 10; i++) {
            calc();
        }
    }
}
