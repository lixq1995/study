package com.test.redis;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RedisTest {

    private final static LoadingCache<String, AtomicInteger> MAP = CacheBuilder.newBuilder()
            .initialCapacity(50).
                    maximumSize(10000).
                    expireAfterAccess(30, TimeUnit.MINUTES).
                    softValues().build(new CacheLoader<String, AtomicInteger>() {
                @Override
                public AtomicInteger load(String s) throws Exception {
                    return new AtomicInteger(0);
                }
            });


    public static void main(String[] args) {
        try {
            int retryTimes = MAP.get("key").addAndGet(1);
            System.out.println(retryTimes);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
