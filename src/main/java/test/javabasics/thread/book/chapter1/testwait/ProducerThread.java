package test.javabasics.thread.book.chapter1.testwait;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerThread {

    private final BlockingQueue queue = new LinkedBlockingQueue(1000);

    // 生产线程
    public void producer() {
        synchronized (queue) {
            // 消费队列满，则等待队列空闲
            while (queue.size() == 1000) {
                try {
                    // 挂起当前线程，并释放通过同步块获取的queue上的锁，让消费者线程可以获取该锁。
                    // 然后获取队列里面的元素
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 空闲则生成元素，并通知消费者线程
            queue.add(1000);
            queue.notifyAll();
        }
    }


    // 消费线程
    public void consumer() throws InterruptedException {
        synchronized (queue) {
            // 消费队列为空
            while (queue.size() == 0) {
                try {
                    // 挂起当前线程，并释放通过同步块获取的queue上的锁，让生产者线程可以获取该锁。
                    // 并将元素放入队列
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 消费元素，并通知唤醒生产者线程
            queue.take();
            queue.notifyAll();
        }
    }
}