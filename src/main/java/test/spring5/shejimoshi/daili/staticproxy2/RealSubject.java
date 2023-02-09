package test.spring5.shejimoshi.daili.staticproxy2;

/**
 * @author by Lixq
 * @Classname RealSubject
 * @Description TODO
 * @Date 2022/3/16 22:36
 */
public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("real service is called.");
    }
}
