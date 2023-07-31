package com.test.designmode.interfaceAndabstract08.abstract1;


import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;


// 抽象类的子类：输出日志到文件
public class FileLogger extends Logger {
    private Writer fileWriter;

    public FileLogger(String name, boolean enabled, Level minPermittedLevel, String filepath) throws IOException {
        super(name, enabled, minPermittedLevel);
        this.fileWriter = new FileWriter(filepath);
    }

    @Override
    public void doLog(Level level, String mesage) {
        // 格式化 level 和 message, 输出到日志文件
        try {
            fileWriter.write("test");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
