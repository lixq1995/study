package test.javabasics.thread.shangguigu.threadorderrun;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程之前按顺序调用 实现 A -> b -> c
 * 三个线程启动 要求如下
 * AA打印5次 BB打印10次 CC打印15次
 * 接着
 * AA打印5次 BB打印10次 CC打印15次
 * ....来10轮
 *
 * @author 卢意
 * >   1. 高内聚低耦合的前提下, 线程 操作 资源类
 * >  2. 判断  干活  通知
 * >  3. 多线程交互中 需要防止多线程的虚假唤醒 即判断资源状态使用while 不能用if
 * >  4. 标志位
 * @create 2021-01-10 16:49
 */
public class ThreadOrderAccess {

    // 高内聚低耦合的前提下, 线程 操作 资源类
    // 判断 干活 通知
    // 多线程交互中 需要防止多线程的虚假唤醒 即判断资源状态使用while 不能用if
    // 标志位
    public static void main(String[] args) throws InterruptedException {
        ShareResource shareResource = new ShareResource();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    shareResource.print5();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "ThreadNameA").start();
            new Thread(() -> {
                try {
                    shareResource.print10();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "ThreadNameB").start();
            new Thread(() -> {
                try {
                    shareResource.print15();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "ThreadNameC").start();

        }


//        for (int i = 0; i < 3; i++) {
//            shareResource.print5();
//            shareResource.print10();
//            shareResource.print15();
//        }


    }
}

class ShareResource {
    private int number = 1; // 1对应A 2对应B 3对应C
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    public void print5() throws InterruptedException {
        lock.lock();
        try {
            // 判断
            while (number != 1) {
                conditionA.await();
            }
            // 干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + (i + 1));
            }
            // 标志位
            number = 2;
            // 通知
            conditionB.signal();
        } finally {
            lock.unlock();
        }
    }

    public void print10() throws InterruptedException {
        lock.lock();
        try {
            // 判断
            while (number != 2) {
                conditionB.await();
            }
            // 干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + (i + 1));
            }
            // 标志位
            number = 3;
            // 通知
            conditionC.signal();
        } finally {
            lock.unlock();
        }
    }

    public void print15() throws InterruptedException {
        lock.lock();
        try {
            // 判断
            while (number != 3) {
                conditionC.await();
            }
            // 干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + (i + 1));
            }
            // 标志位
            number = 1;
            // 通知
            conditionA.signal();
        } finally {
            lock.unlock();
        }
    }

}
