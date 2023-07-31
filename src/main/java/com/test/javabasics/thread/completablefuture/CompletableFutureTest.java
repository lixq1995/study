package com.test.javabasics.thread.completablefuture;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author by Lixq
 * @Classname CompletableFutureTest
 * @Description TODO
 * @Date 2021/6/27 13:28
 */
@Slf4j
public class CompletableFutureTest {

    static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws Exception {
//        future();
//        supplyAsync();
//        thenApply();
//        thenAccept();
//        thenRun();
//        thenCombine();
//        thenAcceptBoth();
//        runAfterBoth();
//        thenCompose();
//        applyToEither();
//        exceptionally();
//        whenComplete1();
//        whenComplete2();
//        handle1();
//        handle2();
        allOf();
        anyOf();
    }

    /**
     * future使用
     *
     * @throws InterruptedException
     * @throws ExecutionException
     */
    private static void future() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> stringFuture = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "async thread";
            }
        });
        Thread.sleep(1000);
        System.out.println(stringFuture.get());
        System.out.println("main thread");
    }

    /**
     * supplyAsync和runAsync方法之间的区别 => 前者有返回值，后者无返回值
     * supplyAsync，有返回值
     */
    private static void supplyAsync() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            //....执行任务
            return "hello";
        }, executor);
        // get()会堵塞当前的线程,这就造成了一个问题,如果执行线程迟迟没有返回数据,get()会一直等待下去
        // get()方法会抛出异常，需要捕获
        System.out.println(future.get());
        // get()方法可以设置等待的时间
        System.out.println(future.get(1000, TimeUnit.SECONDS));
        // join()方法不会抛异常
        System.out.println(future.join());
        // getNow()方法比较有意思,表示当有了返回结果时会返回结果,如果异步线程抛了异常会返回自己设置的默认值.
        System.out.println(future.getNow("hello h2t"));
    }

    /**
     * runAsync，无返回值
     */
    private static void runAsync() {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            //....执行任务
            System.out.println("hello");
        }, executor);
    }

    /**
     * 当前任务正常完成以后执行,当前任务的执行结果可以作为下一任务的输入参数,有返回值.
     * thenApply与thenAccept都可以归类为对结果的处理，区别就是有没有返回值
     */
    private static void thenApply() {
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> "任务A");
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> "任务B");
        CompletableFuture<String> futureC = futureB.thenApply(b -> {
            System.out.println("执行任务C.");
            System.out.println("参数:" + b);//参数:任务B
            return "a";
        });
        System.out.println("futureC返回：" + futureC.join());
    }

    /**
     * 当前任务正常完成以后执行,当前任务的执行结果可以作为下一任务的输入参数,无返回值.
     */
    private static void thenAccept() {
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> "任务A");
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> "任务B");
        CompletableFuture<Void> futureC = futureB.thenAccept(b -> {
            System.out.println("执行任务C.");
            System.out.println("参数:" + b);//参数:任务B
        });
    }

    /**
     * 功能:对不关心上一步的计算结果，执行下一个操作
     * 场景:执行任务A,任务A执行完以后,执行任务B,任务B不接受任务A的返回值(不管A有没有返回值),也无返回值
     */
    private static void thenRun() {
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {

            /*try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            System.out.println("任务A");
            return "任务A";
        });
        CompletableFuture<Void> futureB = futureA.thenRun(() -> System.out.println("执行任务B"));
    }

    /**
     * thenCombine(..)是结合两个任务的返回值进行转化后再返回,又返回值
     */
    private static void thenCombine() {
        CompletableFuture<Double> futurePrice = CompletableFuture.supplyAsync(() -> 100d);
        CompletableFuture<Double> futureDiscount = CompletableFuture.supplyAsync(() -> 0.8);
        CompletableFuture<Double> futureResult = futurePrice.thenCombine(futureDiscount, (price, discount) -> price * discount);
        System.out.println("最终价格为:" + futureResult.join()); //最终价格为:80.0
    }

    /**
     * thenAcceptBoth(..)是结合两个任务的返回值进行转化，无返回值,
     */
    private static void thenAcceptBoth() {
        CompletableFuture<Double> futurePrice = CompletableFuture.supplyAsync(() -> 100d);
        CompletableFuture<Double> futureDiscount = CompletableFuture.supplyAsync(() -> 0.8);
        CompletableFuture<Void> futureResult = futurePrice.thenAcceptBoth(futureDiscount, (price, discount) -> {
            System.out.println(price * discount);
        });
        System.out.println("最终价格为:" + futureResult.join()); //最终价格为:80.0
    }

    /**
     * runAfterBoth(..)是结合两个任务，不关心2个任务的返回值，仅待2个任务执行完，再执行runAfterBoth，也无返回值,
     */
    private static void runAfterBoth() {
        CompletableFuture<Void> futurePrice = CompletableFuture.runAsync(() -> {
            int a = 0;
            if (a == 0) {
                throw new RuntimeException();
            }
            System.out.println(100d);
        });
        CompletableFuture<Void> futureDiscount = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(0.8);
        });
        CompletableFuture<Void> futureResult = futurePrice.runAfterBoth(futureDiscount, new Runnable() {
            @Override
            public void run() {
                System.out.println("price * discount");
            }
        });
        System.out.println("最终价格为:" + futureResult.join()); //最终价格为:80.0
    }

    /**
     * 这个方法接收的输入是当前的CompletableFuture的计算值，返回结果将是一个新的CompletableFuture
     * 这个方法和thenApply非常像,都是接受上一个任务的结果作为入参,执行自己的操作,然后返回
     * <p>
     * thenApply():它的功能相当于将CompletableFuture<T>转换成CompletableFuture<U>,改变的是同一个CompletableFuture中的泛型类型
     * thenCompose():用来连接两个CompletableFuture，返回值是一个新的CompletableFuture
     */
    private static void thenCompose() {
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> "hello");
        CompletableFuture<String> futureB = futureA.thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "world"));
        CompletableFuture<String> future3 = futureB.thenCompose(s -> CompletableFuture.supplyAsync(s::toUpperCase));
        System.out.println(future3.join());

        CompletableFuture<List> future = futureA.thenApply(s -> {
            ArrayList<String> list = new ArrayList<>();
            list.add(s);
            list.add("新增字段");
            return list;
        });
        System.out.println(future.join());
    }

    /**
     * 　功能:执行两个CompletionStage的结果,哪个先执行完了,就是用哪个的返回值进行下一步操作
     * 　　场景:假设查询商品a,有两种方式,A和B,但是A和B的执行速度不一样,我们希望哪个先返回就用那个的返回值.
     * <p>
     * applyToEither的兄弟方法还有acceptEither(接收2个任务之一的返回值，自身无返回值),runAfterEither(不需要接收2个任务之一的返回值，自身无返回值)
     */
    private static void applyToEither() {
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "通过方式A获取商品a";
        });
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "通过方式B获取商品a";
        });
        CompletableFuture<String> futureC = futureA.applyToEither(futureB, product -> "结果:" + product);
        System.out.println(futureC.join()); //结果:通过方式A获取商品a
    }

    /**
     * 功能:当运行出现异常时,调用该方法可进行一些补偿操作,如设置默认值.
     * 场景:异步执行任务A获取结果,如果任务A执行过程中抛出异常,则使用默认值100返回.
     */
    private static void exceptionally() {
        CompletableFuture<String> futureA = CompletableFuture.
                supplyAsync(() -> "执行结果:" + (100 / 0))
                .thenApply(s -> "futureA result:" + s)
                .exceptionally(e -> {
                    System.out.println(e.getMessage()); //java.lang.ArithmeticException: / by zero
                    return "futureA result: 100";
                });
        CompletableFuture<String> futureB = CompletableFuture.
                supplyAsync(() -> "执行结果:" + 50)
                .thenApply(s -> "futureB result:" + s)
                .exceptionally(e -> "futureB result: 100");
        System.out.println(futureA.join());//futureA result: 100
        System.out.println(futureB.join());//futureB result:执行结果:50
    }

    /**
     * 当CompletableFuture的计算结果完成，或者抛出异常的时候，都可以进入whenComplete方法执行
     * <p>
     * 先调用whenComplete再调用exceptionally,
     * 根据控制台,我们可以看出执行流程是这样,supplyAsync->whenComplete->exceptionally,
     * 可以看出并没有进入thenApply执行,原因也显而易见,在supplyAsync中出现了异常,thenApply只有当正常返回时才会去执行.
     * 而whenComplete不管是否正常执行,还要注意一点,whenComplete是没有返回值的.
     */
    private static void whenComplete1() {
        CompletableFuture<String> futureA = CompletableFuture.
                supplyAsync(() -> "执行结果:" + (100 / 0))
                .thenApply(s -> "apply result:" + s)
                .whenComplete((s, e) -> {
                    if (s != null) {
                        System.out.println("第一个s : " + s);//未执行
                    }
                    if (e == null) {
                        System.out.println("第二个s : " + s);//未执行
                    } else {
                        System.out.println("异常为 : " + e.getMessage() + "    " + "第三个s : " + s);//java.lang.ArithmeticException: / by zero
                    }
                })
                .exceptionally(e -> {
                    System.out.println("ex" + e.getMessage()); //ex:java.lang.ArithmeticException: / by zero
                    return "futureA result: 100";
                });
        System.out.println(futureA.join());//futureA result: 100
    }

    /**
     * 先调用exceptionally,再调用whenComplete
     * 可以发现,由于在exceptionally中对异常进行了处理,并返回了默认值,
     * whenComplete中接收到的结果是一个正常的结果,被exceptionally美化过的结果,这一点需要留意一下
     */
    private static void whenComplete2() {
        CompletableFuture<String> futureA = CompletableFuture.
                supplyAsync(() -> "执行结果:" + (100 / 0))
                .thenApply(s -> "apply result:" + s)
                .exceptionally(e -> {
                    System.out.println("ex:" + e.getMessage()); //ex:java.lang.ArithmeticException: / by zero
                    return "futureA result: 100";
                })
                .whenComplete((s, e) -> {
                    if (e == null) {
                        System.out.println(s);//futureA result: 100
                    } else {
                        System.out.println(e.getMessage());//未执行
                    }
                });
        System.out.println(futureA.join());//futureA result: 100
    }

    /**
     * 功能:当CompletableFuture的计算结果完成，或者抛出异常的时候，可以通过handle方法对结果进行处理
     * 通过控制台可以看出,最后打印的是handle result:futureA result: 100,执行exceptionally后对异常进行了"美化",
     * 返回了默认值,那么handle得到的就是一个正常的返回
     */
    private static void handle1() {
        CompletableFuture<String> futureA = CompletableFuture.
                supplyAsync(() -> "执行结果:" + (100 / 0))
                .thenApply(s -> "apply result:" + s)
                .exceptionally(e -> {
                    System.out.println("ex:" + e.getMessage()); //java.lang.ArithmeticException: / by zero
                    return "futureA result: 100";
                })
                .handle((s, e) -> {
                    if (e == null) {
                        System.out.println(s);//futureA result: 100
                    } else {
                        System.out.println(e.getMessage());//未执行
                    }
                    return "handle result:" + (s == null ? "500" : s);
                });
        System.out.println(futureA.join());//handle result:futureA result: 100
    }

    /**
     * 先调用handle再调用exceptionally的情况
     * <p>
     * 根据控制台输出,可以看到先执行handle,打印了异常信息,并接着设置了默认值500,exceptionally并没有执行,
     * 因为它得到的是handle返回给它的值,由此我们大概推测handle和whenComplete的区别
     * 　　1.都是对结果进行处理,handle有返回值,whenComplete没有返回值
     * 　　2.由于1的存在,使得handle多了一个特性,可在handle里实现exceptionally的功能
     */
    private static void handle2() {
        CompletableFuture<String> futureA = CompletableFuture.
                supplyAsync(() -> "执行结果:" + (100 / 0))
                .thenApply(s -> "apply result:" + s)
                .handle((s, e) -> {
                    if (e == null) {
                        System.out.println(s);//未执行
                    } else {
                        System.out.println(e.getMessage());//java.lang.ArithmeticException: / by zero
                    }
                    return "handle result:" + (s == null ? "500" : s);
                })
                .exceptionally(e -> {
                    System.out.println("ex:" + e.getMessage()); //未执行
                    return "futureA result: 100";
                });
        System.out.println(futureA.join());//handle result:500
    }

    /**
     * allOf:当所有的CompletableFuture都执行完后执行计算，allOf方法没有返回值，适合没有返回值并且需要前面所有任务执行完毕才能执行后续任务的应用场景
     * anyOf:最快的那个CompletableFuture执行完之后执行计算
     * <p>
     * 　　场景二:查询一个商品详情,需要分别去查商品信息,卖家信息,库存信息,订单信息等,这些查询相互独立,在不同的服务上,
     * 假设每个查询都需要一到两秒钟,要求总体查询时间小于2秒.
     */
    private static void allOf() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            int i = RandomUtils.nextInt(1000, 10000);
            System.out.println("future1 = " + i);
            try {
                Thread.sleep(1000 + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello");
            return "hello";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            int i = RandomUtils.nextInt(1000, 10000);
            System.out.println("future2 = " + i);
            try {
                Thread.sleep(1000 + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("world");
            return "world";
        });
        Thread.sleep(10);
        CompletableFuture<Void> result = CompletableFuture.allOf(future1, future2);
        System.out.println(result.get());
        System.out.println(future1.get() + " " + future2.get());
    }

    /**
     * 两个线程都会将结果打印出来，但是get方法只会返回最先完成任务的结果。该方法比较适合只要有一个返回值就可以继续执行其他任务的应用场景
     */
    private static void anyOf() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            int i = RandomUtils.nextInt(1000, 10000);
            System.out.println("future1 = " + i);
            try {
                Thread.sleep(1000 + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello");
            return "hello";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            int i = RandomUtils.nextInt(5000, 20000);
            System.out.println("future2 = " + i);
            try {
                Thread.sleep(1000 + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("world");
            return "world";
        });
        Thread.sleep(10);
        CompletableFuture<Object> result = CompletableFuture.anyOf(future1, future2);
        System.out.println(result.get());
        System.out.println("总耗时:" + (System.currentTimeMillis() - start));
    }
}
