package test.javabasics.thread.completablefuture;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * @author by Lixq
 * @Classname ShopTest
 * @Description TODO
 * @Date 2021/7/3 14:58
 */
public class ShopTest {

    private static List<Shop> shopList = Arrays.asList(
            new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll")
    );

    private static Executor executor;

    public static void main(String[] args) {
        // 不用多线程执行时间4秒
        Date date = new Date();
        List<String> bestPrice = findPriceSync("BestPrice");
        System.out.println(bestPrice);
        Date date1 = new Date();
        System.out.println(date);
        System.out.println(date1);

        // 使用多线程CompletableFuture执行时间1秒
        Date date2 = new Date();
        List<String> bestPrice1 = findPriceAsync("BestPrice");
        System.out.println(bestPrice1);
        Date date3 = new Date();
        System.out.println(date2);
        System.out.println(date3);

        // 使用多线程Future执行时间1秒
        Date date4 = new Date();
        List<String> bestPrice2 = findPriceFutureAsync("BestPrice");
        System.out.println(bestPrice2);
        Date date5 = new Date();
        System.out.println(date4);
        System.out.println(date5);

    }


    /**
     * 不使用多线程
     *
     * @param product
     * @return
     */
    private static List<String> findPriceSync(String product) {
        return shopList.stream()
                .map(shop -> String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product)))  //格式转换
                .collect(Collectors.toList());
    }

    /**
     * 使用CompletableFuture多线程
     *
     * @param product
     * @return
     */
    private static List<String> findPriceAsync(String product) {
        List<CompletableFuture<String>> completableFutureList = shopList.stream()
                //转异步执行
                .map(shop -> CompletableFuture.supplyAsync(
                        () ->
                        {
                            return String.format("%s price is %.2f",
                                    shop.getName(), shop.getPrice(product));
                        }, executor
                ))  //格式转换
                .collect(Collectors.toList());

        return completableFutureList.stream()
                .map(CompletableFuture::join)  //获取结果不会抛出异常
                .collect(Collectors.toList());
    }

    /**
     * 使用Future多线程
     *
     * @param product
     * @return
     */
    private static List<String> findPriceFutureAsync(String product) {
        ExecutorService es = Executors.newCachedThreadPool();
        // todo lambda简写
        List<Future<String>> futureList = shopList.stream().map(shop -> es.submit(() -> String.format("%s price is %.2f",
                shop.getName(), shop.getPrice(product)))).collect(Collectors.toList());

        return futureList.stream()
                .map(f -> {
                    String result = null;
                    try {
                        result = f.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }

                    return result;
                }).collect(Collectors.toList());
    }

    /**
     * 使用Future多线程
     *
     * @param product
     * @return
     */
    private static List<String> findPriceFutureAsync1(String product) {
        ExecutorService es = Executors.newCachedThreadPool();
        // // todo 非lambda简写
        List<Future<String>> futureList = shopList.stream().map(shop -> es.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product));
            }
        })).collect(Collectors.toList());

        return futureList.stream()
                .map(f -> {
                    String result = null;
                    try {
                        result = f.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }

                    return result;
                }).collect(Collectors.toList());
    }
}