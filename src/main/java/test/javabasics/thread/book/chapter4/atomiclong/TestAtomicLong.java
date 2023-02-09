package test.javabasics.thread.book.chapter4.atomiclong;

import java.util.concurrent.atomic.AtomicLong;

public class TestAtomicLong {

    public static void main(String[] args) throws InterruptedException {
        AtomicLong atomicLong = new AtomicLong(1);

        Long aLong = new Long(1);
        for (int i = 0; i < 10; i++) {
            atomicLong.incrementAndGet();
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    atomicLong.incrementAndGet();
                }
                System.out.println(atomicLong);
            }
        });
        thread.start();
        thread.join();
        System.out.println(atomicLong);
    }
}
