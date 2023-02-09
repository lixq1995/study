package test.javabasics.thread.completablefuture;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.test.javabasics.thread.config.ThreadPoolConfig;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author by Lixq
 * @Classname AcquireResultTest
 * @Description TODO https://www.cnblogs.com/fingerboy/p/9948736.html
 * @Date 2021/7/3 15:00
 */
public class AcquireResultTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        getTest();

        exceptionTest();
    }

    private static void getTest() throws ExecutionException, InterruptedException {
        // 第一个执行结果为hello h2t，因为要先睡上1分钟结果不能立即获取
        // join方法获取结果方法里不会抛异常(代码不用捕获异常)，但是执行结果会抛异常，抛出的异常为CompletionException
        // get方法获取结果方法里将抛出异常（需在代码捕获异常），执行结果抛出的异常为ExecutionException


        CompletableFuture<String> cp1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(60 * 1000 * 1 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "hello world";
        });

        // 创建自定义线程池
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("localTest-%d").build();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(50, 200, 30L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(1000),threadFactory);
        threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        //getNow方法测试
        System.out.println(cp1.getNow("hello h2t"));
        System.out.println(cp1.get());

        //join方法测试
        CompletableFuture<Integer> cp2 = CompletableFuture.supplyAsync((()-> 1 / 0),threadPool);
        System.out.println(cp2.join());

        //get方法测试
        CompletableFuture<Integer> cp3 = CompletableFuture.supplyAsync((()-> 1 / 0));
        System.out.println(cp3.get());
    }

    private static void exceptionTest() {
        CompletableFuture completableFuture = new CompletableFuture();
        new Thread(() -> {
            try {
                //doSomething，调用complete方法将其他方法的执行结果记录在completableFuture对象中
                completableFuture.complete(null);
            } catch (Exception e) {
                //异常处理
                completableFuture.completeExceptionally(e);
            }
        }).start();
    }
}
