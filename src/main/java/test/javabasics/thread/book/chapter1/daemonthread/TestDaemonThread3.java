package test.javabasics.thread.book.chapter1.daemonthread;

public class TestDaemonThread3 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                i++;
                System.out.println(i);
                while (i == -1) {
                }
            }
        });

        // 设置为守护线程
        thread.setDaemon(true);
        // todo 启动子线程， 主线程执行完，当子线程设为守护线程时，主线程执行完，即使还存在正在执行任务的守护子线程，也会结束jvm进程，因此子线程也会关闭
        thread.start();
        Thread.sleep(1000);
        System.out.println("main thread is over");
    }

}
