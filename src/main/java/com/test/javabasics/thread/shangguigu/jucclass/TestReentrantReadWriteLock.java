package com.test.javabasics.thread.shangguigu.jucclass;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 多个线程同时读一个资源类 没有问题. 所以为了满足并发量 读取共享资源应该可以同时进行
 * 但是
 * 如果有一个线程想去写共享资源,就不应该在有其他线程可以对资源进行度或者写
 *
 * todo 总结
 * todo 读 - 读 可以共存
 * todo 读 - 写 不能共存
 * todo 写 - 写 不能共存
 *
 * @author 卢意
 * @create 2021-01-11 13:53
 */

class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 开始写入");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t ----写入成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 开始读取");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t ----读取成功  " + o);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }

    }
}

public class TestReentrantReadWriteLock {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        // 写
        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(tempInt + "", tempInt);
            }, i + "").start();
        }



        // 读
        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.get(tempInt + "");
            }, i + "").start();
        }

        // 读
        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.get(tempInt + "");
            }, i + "").start();
        }
        // 结果
        // 1	 开始写入
        //1	 ----写入成功
        //0	 开始写入
        //0	 ----写入成功
        //2	 开始写入
        //2	 ----写入成功
        //3	 开始写入
        //3	 ----写入成功
        //4	 开始写入
        //4	 ----写入成功
        //0	 开始读取
        //1	 开始读取
        //2	 开始读取
        //3	 开始读取
        //4	 开始读取
        //0	 ----读取成功  0
        //1	 ----读取成功  1
        //2	 ----读取成功  2
        //3	 ----读取成功  3
        //4	 ----读取成功  4
        //

    }
}