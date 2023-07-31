package com.test.javabasics.thread.shangguigu.listtest.safe;

import java.util.*;

public class SafeDemo {

    public static void main(String[] args) {
        List<String> list = new Vector();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, i + "").start();
        }


        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        Iterator<String> iterator = list1.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("2".equals(item)) {
                iterator.remove();
            }
        }
        System.out.println("list1 : " + list1);

    }
}
