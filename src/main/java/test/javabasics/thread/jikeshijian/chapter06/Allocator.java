package test.javabasics.thread.jikeshijian.chapter06;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 等待通知机制，循环等待
 */
class Allocator {
    private List<Object> als = new ArrayList<>();

    // 一次性申请所有资源
    synchronized void apply(Object from, Object to) {
        // while经典写法
        while (als.contains(from) || als.contains(to)) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        als.add(from);
        als.add(to);
    }

    // 归还资源
    synchronized void free(Object from, Object to) {
        als.remove(from);
        als.remove(to);
        notifyAll();
    }


    public static void main(String[] args) {
        String from = "from";
        String to = "to";
        String test = "test";
        String test1 = "test1";
        String test2 = "test2";

        Allocator allocator = new Allocator();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 拿资源执行
                allocator.apply(from, to);
                try {
                    // 睡3秒，模拟业务执行
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 执行完毕，释放
                allocator.free(from,to);
                System.out.println("线程1执行完毕" + new Date());
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 拿资源执行
                allocator.apply(from, test);
                try {
                    // 睡3秒，模拟业务执行
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 执行完毕，释放
                allocator.free(from,test);
                System.out.println("线程2执行完毕" + new Date());
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 拿资源执行
                allocator.apply(test1, test2);
                try {
                    // 睡3秒，模拟业务执行
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 执行完毕，释放
                allocator.free(test1,test2);
                System.out.println("线程3执行完毕" + new Date());
            }
        });

        // todo 线程执行顺序：1 3 2。 因为1,3不冲突，同时执行完，2需要等1释放资源再执行
        thread1.start();
        thread2.start();
        thread3.start();
    }
}