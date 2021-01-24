package threadstudy.saleticket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname SaleTicket1
 * @Description 资源类 = 实例变量 + 实例方法
 * @Date 2021/1/23 17:00
 * @Created by Lixq
 */
class Ticket1 {
    // 票
    private int number = 30;

    // todo 可重入锁
    Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t卖出第：" + (number--) + "\t还剩下：" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 题目：三个售票员   卖出   30张票
 * 笔记：如何编写企业级的多线程
 * 固定的编程套路+模板
 * 1.在高内聚低耦合的前提下，线程    操作(对外暴露的调用方法)     资源类
 * 1.1先创建一个资源类
 */
public class SaleTicket1 {

    public static void main(String[] args) {
        Ticket1 ticket1 = new Ticket1();

        new Thread(() -> {
            for (int i = 1; i <= 40; i++) ticket1.sale();
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i <= 40; i++) ticket1.sale();
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i <= 40; i++) ticket1.sale();
        }, "C").start();
    }
}