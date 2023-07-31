package com.test.javabasics.thread.shangguigu.callabletest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("执行线程");
        Thread.sleep(8000);
        return 100;
    }


    /**
     * 多线程中，第3种获得多线程的方式
     */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Object> futureTask = new FutureTask(new TestCallable());

        new Thread(futureTask, "A").start();
        Thread.sleep(4000);

        System.out.println("get 前");
        // todo futureTask.get()会阻塞，直至get获取到返回值
        Object result = futureTask.get();
        System.out.println("get 后");

        System.out.println(result);
    }

}
