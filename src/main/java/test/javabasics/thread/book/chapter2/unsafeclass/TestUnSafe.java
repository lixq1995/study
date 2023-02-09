package test.javabasics.thread.book.chapter2.unsafeclass;

import sun.misc.Unsafe;

public class TestUnSafe {

    // 2.2.1获取Unsafe的实例
    static final Unsafe unsafe = Unsafe.getUnsafe();

    // 2.2.2记录变量state在类TestUnSafe中的偏移值
    static final long stateOffset;

    // 2.2.3变量
    private volatile long state = 0;

    static {
        try {
            // 2.2.4获取state变量在类TestUnSafe中的偏移值
            stateOffset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        // 2.2.5创建实例，并设置state值为1
        TestUnSafe test = new TestUnSafe();
        // 2.2.6
        Boolean success = unsafe.compareAndSwapInt(test,stateOffset,0,1);
        System.out.println(success);
    }
}
