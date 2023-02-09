package test.javabasics.thread.shangguigu.lock8;

import java.util.concurrent.TimeUnit;

class Phone1 {
    public static synchronized void sendEmail() {

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------send Email");
    }

    public synchronized void sendSMS() {
        System.out.println("-------send SMS");
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
 *
 *
 * 两部手机指new2phone个对象
 * 4.  两部手机 一部发邮件 一部发短信  先短信 后邮件
 * 5.  两个静态同步方法 同一部手机  先邮件 再短信
 * 6.  两个静态同步方法 两部手机 一部发邮件 一部发短信 先邮件 再短信 (静态方法锁的是类)
 * 7.  一个静态同步方法 一个非静态同步方法 一部手机 无论哪个方法是静态的 顺序都是先短信 再邮件
 * 8.  一个静态同步方法 一个非静态同步方法 两部手机 无论哪个方法是静态的 顺序都是先短信 再邮件
 */
public class Lock81 {
    public static void main(String[] args) {
        Phone1 phone1 = new Phone1();
        Phone1 phone2 = new Phone1();
        new Thread(() -> phone1.sendEmail(), "A").start();
        new Thread(() -> phone2.sendSMS(), "B").start();
//        new Thread(phone2::sendSMS, "B").start();
    }

}