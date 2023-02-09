package test.designmode.interfaceAndabstract08.abstract1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;

// 子类：输出日志到文件
public class FileLogger1 extends Logger1 {
    private Writer fileWriter;
    public FileLogger1(String name, boolean enabled,
                      Level minPermittedLevel, String filepath) throws IOException {
        //... 构造函数不变，代码省略...
        super(name, enabled, minPermittedLevel);
        this.fileWriter = new FileWriter(filepath);
    }

    public void log(Level level, String mesage) throws IOException {
        if (!isLoggable()) return;
        // 格式化 level 和 message, 输出到日志文件
        fileWriter.write("test");
    }
}
