package test.javabasics.thread.book.chapter1.testnotify;

import lombok.SneakyThrows;

public class TestNotify {

    //创建资源
    private static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread threadA = new Thread(new Runnable() {
            @SneakyThrows
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadA get resourceA lock");
                    try {
                        System.out.println("threadA begin wait");
                        resourceA.wait();
                        System.out.println("threadA end wait");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        //创建线程
        Thread threadB = new Thread(new Runnable() {
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadB get resourceA lock...");
                    try {
                        System.out.println("threadB begin wait");
                        resourceA.wait();
                        System.out.println("threadB end wait");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadC begin notify");
                    resourceA.notify();
                }
            }
        });

        //启动线程
        threadA.start();
        threadB.start();

        Thread.sleep(2000);
        threadC.start();

        //等待两个线程结束
//        threadA.join();
//        threadB.join();
//        threadC.join();

        System.out.println("main over");

    }

}
