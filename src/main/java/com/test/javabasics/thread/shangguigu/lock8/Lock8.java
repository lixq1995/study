package com.test.javabasics.thread.shangguigu.lock8;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone {
    private static Lock lock = new ReentrantLock();
    public static void sendEmail() {
        lock.lock();
        try {
            try { TimeUnit.SECONDS.sleep(4); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("-------send Email");
        }finally {
            lock.unlock();
        }
    }

    public  void sendSMS() {
        System.out.println("准备获取锁");
        lock.lock();
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("获取到锁");
        try {
            System.out.println("-------send SMS");
        }finally {
            lock.unlock();
        }
    }

    public void hello() {
        System.out.println("-------say hello");
    }
}

/**
 * 多线程8锁
 * 1.  标准访问 Phone的邮件和短信功能  打印顺序不一定(决定权是操作系统)
 * 2.  访问 Phone的邮件和短信功能 发邮件方法需要4秒 发短信方法不需要 则执行顺序是先邮件 再短信
 * 3.  新增一个普通方法hello不加lock 先执行hello 再执行Email
 * 4.  两部手机 一部发邮件 一部发短信  先短信 后邮件
 * 5.  两个静态同步方法 同一部手机  先邮件 再短信
 * 6.  两个静态同步方法 两部手机 一部发邮件 一部发短信 先邮件 再短信
 * 7.  一个静态同步方法 一个非静态同步方法 一部手机 无论哪个方法是静态的 顺序都是先邮件 再短信(我的juc lock方法结果是这样 但是阳哥的synchronized 结果是相反的)
 * 8.  一个静态同步方法 一个非静态同步方法 两部手机 无论哪个方法是静态的 顺序都是先邮件 再短信(我的juc lock方法结果是这样 但是阳哥的synchronized 结果是相反的)
 *
 */
public class Lock8 {
    public static void main(String[] args)  {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        new Thread(() -> phone1.sendEmail(), "A").start();
        new Thread(phone2::sendSMS, "B").start();
    }

}