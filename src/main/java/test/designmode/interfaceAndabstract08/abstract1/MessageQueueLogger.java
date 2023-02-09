package test.designmode.interfaceAndabstract08.abstract1;

import java.util.logging.Level;

// 抽象类的子类: 输出日志到消息中间件 (比如 kafka)
public class MessageQueueLogger extends Logger {
    private ThreadLocal threadLocal;

    public MessageQueueLogger(String name, boolean enabled, Level minPermittedLevel, ThreadLocal threadLocal) {
        super(name, enabled, minPermittedLevel);
        this.threadLocal = threadLocal;
    }

    @Override
    protected void doLog(Level level, String mesage) {
        // 格式化 level 和 message, 输出到消息中间件
        threadLocal.set("test");
    }
}