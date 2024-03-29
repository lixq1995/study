package com.test.javabasics.thread;

import org.springframework.util.StopWatch;

/**
 * @author by Lixq
 * @Classname StopWatchTest
 * @Description TODO 计时器的使用  https://www.cnblogs.com/kingsonfu/p/11175524.html
 * @Date 2021/7/10 0:42
 */
public class StopWatchTest {
    public static void main(String[] args) throws Exception {
        StopWatch stopWatch = new StopWatch("任务耗时秒表工具");

        stopWatch.start("task1");
        Thread.sleep(1000);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
        stopWatch.start("task2");
        Thread.sleep(3000);
        stopWatch.stop();
        //所有任务耗时时间
        System.out.println(stopWatch.getTotalTimeMillis());
        System.out.println(stopWatch.prettyPrint());

        StopWatch stopWatch2 = new StopWatch("任务耗时秒表工具2");
        stopWatch2.start("task3");
        Thread.sleep(3000);
        stopWatch2.stop();
        //所有任务耗时时间
        System.out.println(stopWatch2.getTotalTimeMillis());
        System.out.println(stopWatch2.prettyPrint());
    }
}
