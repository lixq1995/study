package com.test.javabasics.thread.shangguigu.threadpool;

import com.test.javabasics.thread.config.ThreadPoolConfig;

import java.io.Serializable;

public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadPoolTest threadTest = new ThreadPoolTest();
        threadTest.test();
    }

    public class ThreadPoolTaskTest implements Runnable, Serializable {

        private Object attachData;

        ThreadPoolTaskTest(Object tasks) {
            this.attachData = tasks;
        }

        @Override
        public void run() {
            try {
                System.out.println("start run：" + attachData + "，Thread name is：" + Thread.currentThread().getName());
                Thread.sleep(3000);
                System.out.println();

            } catch (Exception e) {
                e.printStackTrace();
            }
            attachData = null;
        }
    }

    private void test() {
        for (int i = 0; i < 100; i++) {
            ThreadPoolConfig.getInstance().addTaskToThreadPool(new ThreadPoolTaskTest(i));
        }
    }
}
