package com.test.javabasics.thread.book.chapter6.safelist;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class TestSafeList1 {

    // 线程不安全的list
    private ArrayList<String> array = new ArrayList<String>();
    // todo 解决线程安全问题使用 ReentrantLock就可以,但是 ReentrantLock是独占锁某时只个线程可以获取该锁，而实际中会有写少读多的场景，显然 ReentrantLock 满足不了这个需求
    // todo ，所以 ReentrantReadWriteLock 应运而生，ReentrantReadWriteLock采用读写分离的策略，允许多个线程可以同时获取读锁
    // 独占锁
    private volatile ReentrantLock lock = new ReentrantLock();

    // 添加元素
    public void add(String e) {
        lock.lock();
        try {
            array.add(e);
        } finally {
            lock.unlock();
        }
    }

    // 删除元素
    public void remove(String e) {
        lock.lock();
        try {
            array.remove(e);
        } finally {
            lock.unlock();
        }
    }

    // 获取数据
    public String get(int index) {
        lock.lock();
        try {
            return array.get(index);
        } finally {
            lock.unlock();
        }
    }
}
