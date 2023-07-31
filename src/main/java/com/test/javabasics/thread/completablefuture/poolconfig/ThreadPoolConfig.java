package com.test.javabasics.thread.completablefuture.poolconfig;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author by Lixq
 * @Classname ThreadPoolConfig
 * @Description TODO
 * @Date 2021/7/3 17:54
 */
public class ThreadPoolConfig {

    private static final Logger log = LoggerFactory.getLogger(ThreadPoolConfig.class);

    /**
     * 正则表达式校验文件名合法，不包含字符 \ / : * ? " < > |
     */
    public static final String FILENAME_REGULAR_VERIFY= "[^\\\\/:\\\\*\\\\?\\\\\\\"<>\\\\|](\\\\x20|[^\\\\/:\\\\*\\\\?\\\\\\\"<>\\\\|])*[^\\\\/:\\\\*\\\\?\\\\\\\"<>\\\\|\\\\.]{0,}$";

    private static volatile ThreadPoolConfig poolManager;

    private static final int CORE_POOL_SIZE = 50;

    private static final int MAX_POOL_SIZE = 200;

    private static final int QUEUE_CAPACITY = 1000;

    private static final int KEEP_ALIVE_SECONDS = 30;

    private final BlockingQueue<Runnable> taskPollingQueue = new LinkedBlockingQueue(1000);

    public ThreadPoolExecutor threadPool = null;

    public ThreadPoolConfig() {
        initThreadPool();
    }

    // todo 用 AccountThreadPoolConfig 作为共享的锁。ThreadPoolConfig.class 是所有 ThreadPoolConfig 对象共享的，
    // todo 而且这个对象是 Java 虚拟机在加载 ThreadPoolConfig 类的时候创建的，所以我们不用担心它的唯一性
    public static ThreadPoolConfig getInstance() {
        if (poolManager == null) {
            synchronized (com.test.javabasics.thread.config.ThreadPoolConfig.class) {
                if (poolManager == null) {
                    poolManager = new ThreadPoolConfig();
                }
            }
        }
        return poolManager;
    }

    private void initThreadPool() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("localTest-%d").build();

        /**
         * @param corePoolSize 线程池的常驻核心线程数
         * @param maximumPoolSize 线程池中能狗容纳同时执行的最大线程数,此值必须大于等于1
         * @param keepAliveTime 多于线程的存或时间 当线程池中的线程数量超过corePoolSize时,
         *                      当空闲时间到达keepAlivetime时, 多余线程会被销毁知道只剩下corePoolSize个线程位为止
         * @param unit    keepAliveTime 的单位
         * @param workQueue  任务队列, 被提交但尚未被执行的任务
         * @param threadFactory  表示生产线程池中工作线程的线程工厂 (一般默认即可)
         * @param handler   拒绝策略, 表示队列满了,并且工作线程大于等于线程池的最大数maximumPoolSize时,
         * 					如何来拒绝请求执行的Runable的策略
         */
        this.threadPool = new ThreadPoolExecutor(50, 200, 30L, TimeUnit.MILLISECONDS, this.taskPollingQueue,threadFactory);

        this.threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

    }

    public void addTaskToThreadPool(Runnable thread) {
        try {
            this.threadPool.execute(thread);
        } catch (RejectedExecutionException e) {
            log.error(e.getMessage());
        }
    }
}
