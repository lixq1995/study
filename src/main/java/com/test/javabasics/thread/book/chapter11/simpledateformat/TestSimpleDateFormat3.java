package com.test.javabasics.thread.book.chapter11.simpledateformat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestSimpleDateFormat3 {

    // 1创建threadLocal实例
    static ThreadLocal<DateFormat> safeSdf = new ThreadLocal<DateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };


    // todo 方案3使用threadLocal，每个线程只需要使用一个simpleDateFormat实例，节省对象的创建销毁开销，并且不需要使用多个线程同步
    public static void main(String[] args) {
        // 2创建多个线程，并启动
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 使用单例日期实例解析文本
                        System.out.println(safeSdf.get().parse("2017-12-13 15:17:27") + Thread.currentThread().getName());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    } finally {
                        // 使用完毕记得清除，避免内存泄漏
                        safeSdf.remove();
                    }
                }
            },"  时间转换线程");
            thread.start();

        }
    }

}
