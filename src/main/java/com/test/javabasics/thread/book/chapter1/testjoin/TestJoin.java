package com.test.javabasics.thread.book.chapter1.testjoin;

// https://blog.csdn.net/weixin_33721344/article/details/88015906

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("子线程执行完毕");
    }
}

public class TestJoin {


    public static void main(String[] args) throws InterruptedException {
//        testJoin1();

//        testJoin();

        joinTest2();
        joinTest3();
    }


    // 结果分析： 子线程每次都在主线程之前执行完毕，即子线程会在主线程之前执行。
    private static void testJoin1() throws InterruptedException {
        //循环五次
        for (int i = 0; i < 5; i++) {
            MyThread thread = new MyThread();
            //启动线程
            thread.start();
            try {
                // 调用join()方法
                // Join()方法，使调用此方法的线程wait()（在例子中是main线程）,直到调用此方法的线程对象（在例子中是MyThread对象）
                // 所在的线程（在例子中是子线程）执行完毕后被唤醒。
                // todo 即主线程调用join方法，主线程wait()，
                //  然后thread线程执行完毕会调用exit()方法，然后再调用threadTerminated(Thread t)方法，
                //  notifyAll()，唤醒主线程，执行完 System.out.println("主线程执行完毕"); 代码
                //  实际join方法可理解为与CountDownLatch方法类似
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thread.sleep(2000);
            System.out.println("主线程执行完毕");
            System.out.println("~~~~~~~~~~~~~~~");
        }
        System.out.println("全部执行完");

    }


    /**
     * join位置，正确
     * @throws InterruptedException
     */
    private static void joinTest2() throws InterruptedException {
        Thread t1 = new Thread(() -> {

            for (int i = 1; i < 4; i++) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程A ： " + i);
            }
        });

        Thread t2 = new Thread(() -> {

            for (int i = 1; i < 4; i++) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程B ： " + i);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("爬取结束");
    }

    /**
     * join位置，错误，为同步方法
     * @throws InterruptedException
     */
    private static void joinTest3() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            // int a = 3/0;
            for (int i = 1; i < 4; i++) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程A ： " + i);
            }
        });

        Thread t2 = new Thread(() -> {

            for (int i = 1; i < 4; i++) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程B ： " + i);
            }
        });

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        System.out.println("爬取结束");
    }
}
