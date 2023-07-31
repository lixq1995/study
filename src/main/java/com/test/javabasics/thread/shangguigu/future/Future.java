package com.test.javabasics.thread.shangguigu.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author by Lixq
 * @Classname Future
 * @Description TODO
 * @Date 2021/6/27 19:09
 */
public interface Future<V> {

    // 取消任务执行
    boolean cancel(boolean mayInterruptIfRunning);

    // 任务是否取消
    boolean isCancelled();

    // 任务是否完成
    boolean isDone();

    // 阻塞等待结果返回
    V get() throws InterruptedException, ExecutionException;

    // 超时阻塞等待结果返回
    V get(long timeout, TimeUnit unit)
            throws InterruptedException, ExecutionException, TimeoutException;
}