package com.test.javabasics.thread.shangguigu.future;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author by Lixq
 * @Classname FutureTest
 * @Description TODO
 * @Date 2021/6/27 19:11
 */
@Slf4j
public class FutureTest {
    public static void main(String[] args) throws Exception {
//        futureTask();
        futurePool();
    }



    private static void futureTask() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        // 等凉菜
        Callable ca1 = new Callable() {
            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "凉菜准备完毕";
            }
        };
        FutureTask<String> ft1 = new FutureTask<String>(ca1);
        new Thread(ft1).start();

        // 等包子 -- 必须要等待返回的结果，所以要调用join方法
        Callable ca2 = new Callable() {

            @Override
            public Object call() throws Exception {
                try {
                    Thread.sleep(1000 * 3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "包子准备完毕";
            }
        };
        FutureTask<String> ft2 = new FutureTask<String>(ca2);
        new Thread(ft2).start();

        System.out.println(ft1.get());
        System.out.println(ft2.get());

        long end = System.currentTimeMillis();
        System.out.println("准备完毕时间：" + (end - start));
    }


    private static void futureTest() throws Exception{
        Callable<String> stringCallable = new Callable<String>() {

            @Override
            public String call() throws Exception {
                System.out.println("开始执行任务");
                Thread.sleep(3000);
                System.out.println("结束任务");
                return "[1,2,3,4]";
            }
        };

        FutureTask<String> stringFutureTask = new FutureTask<>(stringCallable);


        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        // 泛型指定返回的结果类型
        Future<String> future = threadPool.submit(stringCallable);

        System.out.println("我先去上班,下班回来再获取任务结果");
        Thread.sleep(5000);

        System.out.println("下班了开始获取任务结果: " + Thread.currentThread().getName());
        String result = future.get(); // 阻塞等待任务完成
        System.out.println("下班了获取任务结果为: "+result + "  "+Thread.currentThread().getName());
    }






    @Data
    @AllArgsConstructor
    static class Book {
        private String name;
        private Double price;

        @Override
        public String toString() {
            return "书籍 <" + name + "> 价钱是:" + price;
        }
    }

    /**
     * 购买书籍任务-需要耗费一定时间：假定买书需要等7天(一秒模拟一天)
     *
     * @author niewj
     */
    static class BuyBookTask implements Callable<Book> {
        @Override
        public Book call() throws Exception {
            int time = new Random().nextInt(10); // 等进货时间
            log.info("===> 买书ing........");
            TimeUnit.SECONDS.sleep(time);
            log.info("===> 买书耗时{}秒 <====", time);

            return new Book("<Java核心技术第七版卷一>", 120.5);
        }
    }


    /**
     * 购买书籍任务-需要耗费一定时间：假定买书需要等7天(一秒模拟一天)
     *
     * @author niewj
     */
    static class BuyBookrunableTask implements Runnable {

        @SneakyThrows
        @Override
        public void run() {
            int time = new Random().nextInt(10); // 等进货时间
            log.info("===> 买书ing........");
            TimeUnit.SECONDS.sleep(time);
            log.info("===> 买书耗时{}秒 <====", time);
        }
    }


    private static void futurePool() throws Exception {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        long start = System.currentTimeMillis();

        // 1. 第一件事：买书 [需要一定的时间]
        Future<Book> future = exec.submit(new BuyBookTask());
//        Future<?> submit = exec.submit(new BuyBookrunableTask());
        exec.shutdown();

        // 2. 第一件事：报名考试 报名考试花费10秒
        int timeReg = new Random().nextInt(10); // 等进货时间
        log.info("====> 报名考试排队ing.... ");
        TimeUnit.SECONDS.sleep(timeReg);
        log.info("====> 报名考试排队{}秒 <==== ", timeReg);

        Book book = future.get();
        log.info("考试报上名了; 书也买到了： " + book);
        log.info("总耗时 {} 秒!", (System.currentTimeMillis() - start) / 1000);
    }
}