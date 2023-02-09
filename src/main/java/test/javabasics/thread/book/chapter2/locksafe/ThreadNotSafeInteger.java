package test.javabasics.thread.book.chapter2.locksafe;

public class ThreadNotSafeInteger {

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue() {
        int i = 1;
        i++;
        System.out.println("i = " + i);
    }


    private int number = 30;

    public void saleTicket(){
        if (number > 0){
            System.out.println(Thread.currentThread().getName()+"\t卖出第："+(number--)+"\t还剩下："+number);
        }
    }
}
