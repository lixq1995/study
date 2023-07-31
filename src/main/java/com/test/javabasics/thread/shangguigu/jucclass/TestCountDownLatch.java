package com.test.javabasics.thread.shangguigu.jucclass;

import java.util.concurrent.CountDownLatch;

/**
 * 需求  当同学走光了 班长再关门
 * @author 卢意
 * @create 2021-01-11 11:07
 */
public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 离开教室");
                countDownLatch.countDown();
            }, i + "").start();
        }
        countDownLatch.await(); // 阻塞住后面的线程  直到计数器为0
        System.out.println(Thread.currentThread().getName() + "\t 班长关门");
        //0	 离开教室
        //1	 离开教室
        //2	 离开教室
        //3	 离开教室
        //4	 离开教室
        //5	 离开教室
        //main	 班长关门
    }
}