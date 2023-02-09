package test.designmode.interfaceAndabstract08.abstract1;

import java.util.logging.Level;

// 父类：非抽象类，就是普通的类. 删除了 log(),doLog()，新增了 isLoggable().
public class Logger1 {
    private String name;
    private boolean enabled;
    private Level minPermittedLevel;
    public Logger1(String name, boolean enabled, Level minPermittedLevel) {
        //... 构造函数不变，代码省略...
        this.name = name;
        this.enabled = enabled;
        this.minPermittedLevel = minPermittedLevel;
    }
    protected boolean isLoggable() {
        boolean loggable = enabled && (minPermittedLevel.intValue() <= minPermittedLevel.intValue());
        return loggable;
    }
}
