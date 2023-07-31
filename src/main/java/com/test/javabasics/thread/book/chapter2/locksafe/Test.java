package com.test.javabasics.thread.book.chapter2.locksafe;

public class Test {

    public static void main(String[] args) {

        // todo 可能出现重复的票，即线程A1与线程A2同时都进入方法，卖出同一张票30
        /*ThreadNotSafeInteger threadNotSafeInteger = new ThreadNotSafeInteger();
        Thread threadA1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    threadNotSafeInteger.saleTicket();
                }
            }
        });
        threadA1.start();


        Thread threadA2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    threadNotSafeInteger.saleTicket();
                }
            }
        });
        threadA2.start();

        Thread threadA3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    threadNotSafeInteger.saleTicket();
                }
            }
        });
        threadA3.start();*/

        // todo synchronized有锁锁住，每次只允许一个线程进去，依次售票
        /*ThreadSafeInteger1 threadSafeInteger1 = new ThreadSafeInteger1();
        Thread threadB1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    threadSafeInteger1.saleTicket();
                }
            }
        });
        threadB1.start();


        Thread threadB2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    threadSafeInteger1.saleTicket();
                }
            }
        });
        threadB2.start();

        Thread threadB3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    threadSafeInteger1.saleTicket();
                }
            }
        });
        threadB3.start();*/

        // todo volatile对其他线程可见。
        ThreadSafeInteger2 threadSafeInteger2 = new ThreadSafeInteger2();
        Thread threadC1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    threadSafeInteger2.saleTicket();
                }
            }
        });
        threadC1.start();


        Thread threadC2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    threadSafeInteger2.saleTicket();
                }
            }
        });
        threadC2.start();

        Thread threadC3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    threadSafeInteger2.saleTicket();
                }
            }
        });
        threadC3.start();
    }
}
