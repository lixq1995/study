package com.test.javabasics.thread.book.chapter1.daemonthread;

public class TestDaemonThread2 {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ;) {
                }
            }
        });

        // todo 启动子线程， 主线程执行完，子线程还在继续执行，循环
        thread.start();
        System.out.println("main thread is over");
    }

}
