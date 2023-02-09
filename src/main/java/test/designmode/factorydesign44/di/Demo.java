package test.designmode.factorydesign44.di;

import com.test.designmode.factorydesign44.di.config.RateLimiter;

public class Demo {
    public static void main(String[] args) throws Exception {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "com/test/designmode/factorydesign44/di/config/beans.xml");
        RateLimiter rateLimiter = (RateLimiter) applicationContext.getBean("rateLimiter");
        rateLimiter.test();
        //...
    }
}
