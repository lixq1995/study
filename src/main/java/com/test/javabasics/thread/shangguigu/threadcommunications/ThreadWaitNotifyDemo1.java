package com.test.javabasics.thread.shangguigu.threadcommunications;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程操作一个变量  一个线程让他加一 一个线程让他减一
 * 实现交替操作 10轮  让这个变量的结果还是为0
 * 1. 高内聚低耦合的前提下, 线程 操作 资源类
 * 2. 判断  干活  通知
 */
public class ThreadWaitNotifyDemo1 {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();

        // todo 2个线程，1个加1个减，程序正常运行。
        // todo 4个线程，2个加2个减，程序异常，可能会出现负数

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airConditioner.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "加一线程A").start();

//        new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                try {
//                    airConditioner.increment();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, "加一线程B").start();
//
//        new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                try {
//                    airConditioner.decrement();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, "减一线程C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airConditioner.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "减一线程D").start();
    }
}

// 改进资源类
class AirConditioner1{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    // 可以理解为生产蛋糕
    public void increment() throws InterruptedException {
        lock.lock();
        try {
            // 判断
            while (number != 0) {
                condition.await();
            }
            // 干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 通知
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    // 可以理解为消费蛋糕
    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            // todo 判断,while循环每次都会重新判断
            while (number == 0) {
                // 如果是if时，number为0，C,D多个线程进入到该行代码等待时。increment加1不为0，signalAll唤醒所有线程，此时不需要重新判断。
                // 结果可能出现负数（异常）
                condition.await();
            }
            // 干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 通知
            condition.signalAll();
        }finally {
            lock.unlock();
        }


    }

}
