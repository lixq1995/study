package test.javabasics.thread.book.chapter1.testinterrupt;

public class TestInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 如果当前线程被中断则退出循环
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread() + "hello");
                }
            }
        });

        // 启动子线程
        thread.start();

        // 主线程休眠1毫秒,以便中断前让子线程输出
        Thread.sleep(1);

        // 中断子线程
        System.out.println("main thread interrupt thread");
        thread.interrupt();

        // todo 可理解为主线程wait,等待子线程执行完毕
        thread.join();
        System.out.println("main is over");
    }

}
