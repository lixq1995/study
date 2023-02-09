package test.javabasics.thread.shangguigu.threadcommunications;

/**
 * 两个线程操作一个变量  一个线程让他加一 一个线程让他减一
 * 实现交替操作 10轮  让这个变量的结果还是为0
 * 1. 高内聚低耦合的前提下, 线程 操作 资源类
 * 2. 判断  干活  通知
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();

        // todo 2个线程，1个加1个减，程序正常运行。
        // todo 4个线程，2个加2个减，程序异常，可能会出现负数
        // 原因：

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airConditioner.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "加一线程A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airConditioner.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "加一线程B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airConditioner.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "减一线程C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airConditioner.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "减一线程D").start();
    }
}

// 资源类
class AirConditioner {
    private int number = 0;

    public synchronized void increment() throws InterruptedException {
        // 判断
        if (number != 0) {
            this.wait();
        }
        // 干活
        number++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        // 通知
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        // 判断
        if (number == 0) {
            this.wait();
        }
        // 干活
        number--;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        // 通知
        this.notifyAll();
    }

}
