package test.designmode.interfaceAndabstract08.abstract1;

import java.util.logging.Level;
import java.io.IOException;

public class AbstractTest {

    public static void main(String[] args) throws Exception {


        // 抽象类可使用多态特性
        Logger logger = new FileLogger("access-log", true, Level.WARNING, "/users/wangzheng/access.log");
        logger.log(Level.WARNING, "This is a test log message.");


        // todo 正常继承类不可使用多态特性，因为Logger中没有定义log()方法
        Logger1 logger1 = new FileLogger1("access-log", true, Level.WARNING, "/users/wangzheng/access.log");
//        logger1.log(Level.WARNING, "This is a test log message.");

    }
}
