package test.spring5.shejimoshi.daili.staticproxy3;

/**
 * @author by Lixq
 * @Classname TransactionManager
 * @Description tx包,模拟事务管理器
 * @Date 2022/3/16 22:32
 */
public class TransactionManager {
    public void begin(){
        System.out.println("开启事务");
    }

    public void commit(){
        System.out.println("提交事务");
    }

    public void rollback(){
        System.out.println("回滚事务");
    }
}