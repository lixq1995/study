package test.javabasics.thread.book.chapter2.locksafe;

public class ThreadSafeInteger1 {

    private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue() {
        int i = 1;
        i++;
        System.out.println("i = " + i);
    }


    private int number = 30;

    public synchronized void saleTicket(){
        if (number > 0){
            System.out.println(Thread.currentThread().getName()+"\t卖出第："+(number--)+"\t还剩下："+number);
        }
    }
}
