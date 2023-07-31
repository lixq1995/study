package com.test.javabasics.thread.shangguigu.settest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class TestSet {

    public static void main(String[] args) {

        Set<String> set1 = new HashSet<>(); //线程不安全
        set1.add("111");


        // todo 加上synchronized锁
        Set<String> set2 = Collections.synchronizedSet(new HashSet<>()); //线程安全
        set2.add("222");

        // todo 分为读锁与写锁，相对应以上的synchronized锁效率更高
        Set<String> set3 = new CopyOnWriteArraySet<>(); //线程安全

        // hashMap
        Map<String, Object> map1 = Collections.synchronizedMap(new HashMap<>());

        Map<String, Object> map2 = new ConcurrentHashMap();
    }
}
