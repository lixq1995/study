package threadstudy.saleticket;

/**
 * @Classname SaleTicket
 * @Description TODO
 * @Date 2021/1/23 16:40
 * @Created by Lixq
 */
class Ticket{// 资源类
    // 票
    private int number = 30;

    // todo 锁整个类，范围较大
    public synchronized void saleTicket(){
        if (number > 0){
            System.out.println(Thread.currentThread().getName()+"\t卖出第："+(number--)+"\t还剩下："+number);
        }
    }
}
/**
 *题目：三个售票员   卖出   30张票
 * 多线程编程的企业级套路+模板
 * 1.在高内聚低耦合的前提下，线程    操作(对外暴露的调用方法)     资源类
 */
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        // start为线程就绪状态，等待cpu等底层调度通知之后才执行该线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 30; i++) {
                    ticket.saleTicket();
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 30; i++) {
                    ticket.saleTicket();
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 30; i++) {
                    ticket.saleTicket();
                }
            }
        },"C").start();
    }
}