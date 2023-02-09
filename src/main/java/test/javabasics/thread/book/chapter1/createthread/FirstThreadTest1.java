package test.javabasics.thread.book.chapter1.createthread;

public class FirstThreadTest1 extends Thread {

    int i = 0;

    //重写run方法，run方法的方法体就是现场执行体
    public void run() {
        for (; i < 100; i++) {
            System.out.println(getName() + "  " + i);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "  : " + i);
            if (i == 50) {
                new FirstThreadTest1().start();
                new FirstThreadTest1().start();
            }
        }
    }


}