package test.javabasics.thread.book.chapter6.safelist;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestSafeList2 {

    // 线程不安全的list
    private ArrayList<String> array = new ArrayList<String>();
    // todo 解决线程安全问题使用 ReentrantLock就可以,但是 ReentrantLock是独占锁某时只个线程可以获取该锁，而实际中会有写少读多的场景，显然 ReentrantLock 满足不了这个需求
    // todo ，所以 ReentrantReadWriteLock 应运而生，ReentrantReadWriteLock采用读写分离的策略，允许多个线程可以同时获取读锁
    // 独占锁
    private volatile ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    // 添加元素
    public void add(String e) {
        writeLock.lock();
        try {
            array.add(e);
        } finally {
            writeLock.unlock();
        }
    }

    // 删除元素
    public void remove(String e) {
        writeLock.lock();
        try {
            array.remove(e);
        } finally {
            writeLock.unlock();
        }
    }

    // 获取数据
    public String get(int index) {
        readLock.lock();
        try {
            return array.get(index);
        } finally {
            readLock.unlock();
        }
    }
}
