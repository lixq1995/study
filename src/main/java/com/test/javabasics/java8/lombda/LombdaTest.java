package com.test.javabasics.java8.lombda;

import com.test.javabasics.java8.stream.Person;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class LombdaTest {

    public static void main(String[] args) {
        lombdaThread();
        action();
        foreach();
        map();
    }

    private static void lombdaThread() {
        // 匿名函类写法1
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("欢迎关注公众号：程序新视界");
            }
        }).start();

        // 匿名函类写法
        new Thread() {
            @Override
            public void run() {
                System.out.println("欢迎关注公众号：程序新视界11111");
            }
        }.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                {
                    System.out.println("欢迎关注公众号：程序新视界 Runnable");
                }
            }
        };
        runnable.run();


        // lambda表达式写法
        new Thread(() -> System.out.println("欢迎关注公众号：程序新视界")).start();

        // todo lambda表达式 如果方法体内有多行代码需要带大括号
        new Thread(() -> {
            System.out.println("欢迎关注公众号");
            System.out.println("程序新视界");
        }).start();
    }

    /**
     * 事件处理示例
     */
    private static void action() {
        // 匿名函类写法
        JButton follow = new JButton("关注");
        follow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("已关注公众号：程序新视界");
            }
        });

        // lambda表达式写法
        follow.addActionListener((e) -> System.out.println("已关注公众号：程序新视界"));

        // lambda表达式写法，参数可舍掉（）
        follow.addActionListener(e -> {
            System.out.println("已关注公众号");
            System.out.println("程序新视界");
        });
    }

    /**
     * foreach遍历
     */
    private static void foreach() {
        System.out.println("");
        List<String> list = Arrays.asList("欢迎", "关注", "程序新视界");
        // 传统遍历
        for (String str : list) {
            System.out.println(str);
        }
        // lambda表达式写法
        list.forEach(str -> System.out.println(str));
        // lambda表达式写法
        list.forEach(System.out::println);
    }

    private static void map() {
        ConcurrentHashMap<String,Person> map = new ConcurrentHashMap();
        map.forEach(map::put);
    }
}
