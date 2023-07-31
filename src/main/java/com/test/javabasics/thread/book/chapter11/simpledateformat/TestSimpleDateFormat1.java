package com.test.javabasics.thread.book.chapter11.simpledateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

// todo 不安全，
public class TestSimpleDateFormat1 {

    // 1创建单利实例
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        // 2创建多个线程，并启动
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 使用单例日期实例解析文本
                        System.out.println(sdf.parse("2017-12-13 15:17:27"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }

}
