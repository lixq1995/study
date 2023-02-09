package test.javabasics.thread.book.chapter1.testsleep;

public class TestSleep1 {

    // 子线程在睡眠期间 主线程中断了它，所以子线程在调用 sleep 方法处抛出了InterruptedException 异常
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("child thread is in sleep");
                    Thread.sleep(10000);
                    System.out.println("child thread is in awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 启动线程
        thread.start();

        // 主线程休眠2s
        Thread.sleep(2000);

        // 主线程中断子线程
        thread.interrupt();
    }

}
