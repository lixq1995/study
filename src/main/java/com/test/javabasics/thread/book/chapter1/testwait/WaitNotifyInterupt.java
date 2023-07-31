package com.test.javabasics.thread.book.chapter1.testwait;

public class WaitNotifyInterupt {
    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("begin---");
                    //阻塞当前进程
                    synchronized (obj) {
                        obj.wait(2000);
                    }
                    System.out.println("end----");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
//        Thread.sleep(1000);

        System.out.println("---begin interrupt threadA---");
        threadA.interrupt();
        System.out.println("--end interrupt threadA---");
    }

}