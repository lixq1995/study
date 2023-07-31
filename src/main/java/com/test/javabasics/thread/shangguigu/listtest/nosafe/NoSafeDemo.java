package com.test.javabasics.thread.shangguigu.listtest.nosafe;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NoSafeDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        // 不加线程
        for (int i = 0; i < 3; i++) {
            list.add(UUID.randomUUID().toString().substring(0, 8));
            System.out.println(list);
        }

        // 加线程
        // ArrayList在迭代的时候如果同时对其进行修改就会抛出java.util.ConcurrentModificationException异常并发修改异常
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, i + "").start();
        }

        // 正确结果
        // [3fb16395]
        // [3fb16395, 4b2551d6]
        // [3fb16395, 4b2551d6, a6f52743]

        // 但是偶尔会这样
        // [null, f69d4ac4]
        // [null, f69d4ac4, 41e8ffc4]
        // [null, f69d4ac4]

        // Vector也不能在foreach 循环里进行元素的 remove/add 操作
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        for (String item:list1) {
            if ("2".equals(item)) {
                list1.remove(item);
            }
        }
        System.out.println("list1 : " + list1);

    }
}
