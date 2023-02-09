package test.javabasics.thread.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author by Lixq
 * @Classname ThenTest
 * @Description TODO
 * @Date 2021/7/3 15:29
 */
public class ThenTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // todo thenApply与thenAccept都可以归类为对结果的处理，区别就是有没有返回值
//        thenApplyTest();
//        ThenAcceptTest();

//        thenCompose();

        thenCompose1();

//        thenCombine();

//        allOf();

//        anyOf();
    }

    /**
     * 有返回值
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void thenApplyTest() throws ExecutionException, InterruptedException {
        // 将CompletableFuture的计算结果10作为thenApply方法的参数，返回thenApply方法处理后的结果80
        CompletableFuture<Integer> result = CompletableFuture.supplyAsync(ThenTest::randomInteger).thenApply((i) -> i * 8);
        System.out.println(result.get());
    }

    public static Integer randomInteger() {
        return 10;
    }

    /**
     * 无返回值
     */
    private static void ThenAcceptTest() {
        CompletableFuture.supplyAsync(ThenTest::getList).thenAccept(strList -> strList.stream()
                .forEach(m -> System.out.println(m)));
    }

    public static List<String> getList() {
        return Arrays.asList("a", "b", "c");
    }

    /**
     * thenCompose方法可以将两个异步操作进行流水操作
     * 这个方法和thenApply非常像,都是接受上一个任务的结果作为入参,执行自己的操作,然后返回.那具体有什么区别呢?
     　　thenApply():它的功能相当于将CompletableFuture<T>转换成CompletableFuture<U>,改变的是同一个CompletableFuture中的泛型类型
     　　thenCompose():用来连接两个CompletableFuture，返回值是一个新的CompletableFuture
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void thenCompose() throws ExecutionException, InterruptedException {
        // 将supplyAsync的返回值，放到thenCompose里组合执行
        CompletableFuture<Integer> result = CompletableFuture.supplyAsync(ThenTest::getInteger)
                .thenCompose(i -> CompletableFuture.supplyAsync(() -> i * 10));
        System.out.println(result.get());
    }


    private static void  thenCompose1() throws ExecutionException, InterruptedException {
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> "hello");
        CompletableFuture<String> futureB = futureA.thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "world"));
        CompletableFuture<String> future3 = futureB.thenCompose(s -> CompletableFuture.supplyAsync(s::toUpperCase));
        System.out.println(future3.get()); // get需要在throws ExecutionException, InterruptedException
//        System.out.println(future3.join()); // join不需要捕获异常
    }
    private static int getInteger() {
        return 666;
    }

    private static int expandValue(int num) {
        return num * 10;
    }

    /**
     * thenCombine方法将两个无关的CompletableFuture组合起来，第二个Completable并不依赖第一个Completable的结果
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void thenCombine() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> result = CompletableFuture.supplyAsync(ThenTest::randomInteger1).thenCombine(
                CompletableFuture.supplyAsync(ThenTest::randomInteger1), (i, j) ->
                {
                    System.out.println(i + "     " + j);
                    int a = i * j;
                    return a;
                }
        );

        System.out.println(result.get());
    }

    private static Random random = new Random();

    public static Integer randomInteger1() {
        int i = random.nextInt(100);
        return i;
    }

    /** allOf方法没有返回值，适合没有返回值并且需要前面所有任务执行完毕才能执行后续任务的应用场景
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void allOf() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello");
            return "hello";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("world");
            return "world";
        });
        Thread.sleep(10);
        CompletableFuture<Void> result = CompletableFuture.allOf(future1, future2);
        System.out.println(result.get());
    }

    /**
     * 两个线程都会将结果打印出来，但是get方法只会返回最先完成任务的结果。该方法比较适合只要有一个返回值就可以继续执行其他任务的应用场景
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void anyOf() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            randomSleep();
            System.out.println("hello");
            return "hello";});
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            randomSleep();
            System.out.println("world");
            return "world";
        });
        Thread.sleep(10);
        CompletableFuture<Object> result = CompletableFuture.anyOf(future1, future2);
        System.out.println(result.get());
    }

    private static void randomSleep() {
        try {
            Thread.sleep(random.nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
