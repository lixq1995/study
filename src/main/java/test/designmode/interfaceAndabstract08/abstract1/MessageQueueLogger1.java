package test.designmode.interfaceAndabstract08.abstract1;

import java.util.logging.Level;

// 子类: 输出日志到消息中间件 (比如 kafka)
public class MessageQueueLogger1 extends Logger1 {
    private ThreadLocal threadLocal;

    public MessageQueueLogger1(String name, boolean enabled,
                              Level minPermittedLevel, ThreadLocal threadLocal) {
        //... 构造函数不变，代码省略...
        super(name, enabled, minPermittedLevel);
        this.threadLocal = threadLocal;
    }

    public void log(Level level, String mesage) {
        if (!isLoggable()) return;
        // 格式化 level 和 message, 输出到消息中间件
        threadLocal.set("test");
    }
}
