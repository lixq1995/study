package com.test.designmode.singletondesign41;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    // todo 当OrderController与UserController并发，同时执行logger与log方法时，可能存在覆盖情况
    // todo 类似在多线程环境下，如果两个线程同时给同一个共享变量加 1，因为共享变量是竞争资源，所以，共享变量最后的结果有可能并不是加了 2，而是只加了 1

    private FileWriter writer;

    public Logger() throws IOException {
        File file = new File("/Users/wangzheng/log.txt");
        writer = new FileWriter(file, true); //true表示追加写入
    }

    public void log(String message) throws IOException {
        writer.write(message);
    }
}
