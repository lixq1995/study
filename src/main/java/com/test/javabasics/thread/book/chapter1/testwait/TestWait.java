package com.test.javabasics.thread.book.chapter1.testwait;

import lombok.SneakyThrows;

public class TestWait {

//    // 创建资源
//    private static volatile Object resourceA = new Object();
//    private static volatile Object resourceB = new Object();
//
//    public static void main(String[] args) throws InterruptedException {
//        // 创建线程
//        Thread threadA = new Thread(new Runnable() {
//            public void run() {
//                try {
//                    // 获取resourceA 共享资源的监视器锁
//                    synchronized (resourceA) {
//                        System.out.println("threadA get resourceA lock");
//                        // 获取resourceB共享资源的监视器锁
//                        synchronized (resourceB) {
//                            System.out.println("threadA get resourceB lock");
//                            // 线程A阻塞，并择放获取到的 resourceA的锁
//                            System.out.println("threadA release resourceA lock");
//                            resourceA.wait();
//                        }
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        // 创建线程
//        Thread threadB = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    // 休眠1s
//                    Thread.sleep(1000);
//                    // 获取resourceA共享资源的监视器锁
//                    synchronized (resourceA) {
//                        System.out.println("threadB get resourceA lock");
//                        System.out.println("threadB try get resourceB lock...");
//                        // 获取resourceB共享资源的监视器锁
//                        synchronized (resourceB) {
//                            System.out.println("threadB get resourceB lock");
//                            // 线程B阻塞，并释放获取到的resourceA的锁
//                            System.out.println("threadB get resourceA lock");
//                            resourceA.wait();
//                        }
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        // 启动线程
//        threadA.start();
//        threadB.start();
//
//        // 等待两个线程结束
//        threadA.join();
//        threadB.join();
//        System.out.println("执行完成");
//    }


    //创建资源
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread threadA = new Thread(new Runnable() {
            @SneakyThrows
            public void run() {
                // todo notify与wait只能在synchronized中使用，在其外层使用会报IllegalMonitorStateException
                // wait()、notify()、notifyAll() 都是在 synchronized{}内部被调用的。如果在 synchronized{}外部调用，
                // 或者锁定的 this，而用 target.wait() 调用的话，JVM 会抛出一个运行时异常：java.lang.IllegalMonitorStateException
//                resourceA.notify();
//                resourceA.wait();
                try {
                    //获取resourceA共享资源
                    synchronized (resourceA) {
                        System.out.println("threadA get resourceA lock");
                        synchronized (resourceB) {
                            System.out.println("threadA get resourceB lock");

                            //线程A阻塞，并释放获取到的resourceA的锁
                            System.out.println("threadA release resourceA lock");
                            // todo wait只是让当前线程等待，不执行
                            resourceA.wait();
                            // todo 释放resourceB锁为啥线程B代码执行不完
                            resourceB.notify();
                            resourceB.wait();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // 同上
                    resourceA.notify();
                }
            }
        });


        //创建线程
        Thread threadB = new Thread(new Runnable() {
            public void run() {
                try {
                    //休眠ls
                    Thread.sleep(2000);
                    //获取resourceA共享资源的监视器锁
                    synchronized (resourceA) {
                        System.out.println("threadB get resourceA lock...");
                        System.out.println("threadB try get resourceB lock . . .”");
                        //获取 resourceB共 享资源的监视器锁
                        synchronized (resourceB) {
                            System.out.println("threadB get resourceB lock");
                            //线程B阻塞，并释放获取到的 resourceA的锁
                            System.out.println("threadB release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {

                }
            }
        });

        //启动线程
        threadA.start();
        threadB.start();
        //等待两个线程结束
        threadA.join();
        threadB.join();

        System.out.println("main over");

    }
}