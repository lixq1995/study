package com.test.javabasics.thread.book.chapter1.daemonthread;

public class TestDaemonThread1 {

    public static void main(String[] args) {
        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        // 设置为守护线程
        daemonThread.setDaemon(true);
        daemonThread.start();
    }

}
