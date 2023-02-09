package test.designmode.singletondesign41;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 懒汉式 ,支持延迟加载
 *
 * 不过懒汉式的缺点也很明显，我们给 getInstance() 这个方法加了一把大锁（synchronzed），导致这个函数的并发度很低。
 * 量化一下的话，并发度是 1，也就相当于串行操作了。而这个函数是在单例使用期间，一直会被调用。如果这个单例类偶尔会被用到，
 * 那这种实现方式还可以接受。但是，如果频繁地用到，那频繁加锁、释放锁及并发度低等问题，会导致性能瓶颈，这种实现方式就不可取了
 *
 */
public class Singleton2 {
    private AtomicLong id = new AtomicLong(0);
    private static Singleton2 instance;

    private Singleton2() {
    }

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
