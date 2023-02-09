package test.javabasics.thread.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * @author by Lixq
 * @Classname WhenCompleteTest
 * @Description TODO
 * @Date 2021/7/3 15:30
 */
public class WhenCompleteTest {
    public static void main(String[] args) {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> "hello");
        CompletableFuture<String> cf2 = cf1.whenComplete((v, e) ->
                System.out.println(String.format("value:%s, exception:%s", v, e)));
        System.out.println(cf2.join());
    }
}
