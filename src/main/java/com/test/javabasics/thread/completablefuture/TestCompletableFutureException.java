package com.test.javabasics.thread.completablefuture;

import java.util.concurrent.CompletableFuture;

public class TestCompletableFutureException {


    public static void main(String[] args) {

        // 线程执行错误的话，返回exceptionally中定义的数据
        CompletableFuture<String> futureA = CompletableFuture.
                supplyAsync(() -> "执行结果:" + (100 / 0))
                .thenApply(s -> "futureA result:" + s)
                .exceptionally(e -> {
                    System.out.println(e.getMessage()); //java.lang.ArithmeticException: / by zero
                    return "futureA result: 100";
                });

        // 线程执行正确，直接返回线程中的返回值
        CompletableFuture<String> futureB = CompletableFuture.
                supplyAsync(() -> {
//                        return 3/0;
                   return  "执行结果:" + 50 ;
                })
                .thenApply(s -> "futureB result:" + s)
                .exceptionally(e -> "futureB result: 100");

        System.out.println(futureA.join());//futureA result: 100
        System.out.println(futureB.join());//futureB result:执行结果:50

    }

}
