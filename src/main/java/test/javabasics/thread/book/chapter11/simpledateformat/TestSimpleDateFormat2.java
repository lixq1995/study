package test.javabasics.thread.book.chapter11.simpledateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

// todo 方案1 每次使用时new一个simpleDateFormat实例，这样可以保证每个实例使用自己的Calendar实例，但是每次使用都需要new一个对象，并且使用后由于没有其他引用，有需要回收，开销会很大
public class TestSimpleDateFormat2 {

    // 1创建单利实例
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // todo 方案2使用synchronized进行同步
    public static void main(String[] args) {
        // 2创建多个线程，并启动
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        synchronized (sdf) {
                            // 使用单例日期实例解析文本
                            System.out.println(sdf.parse("2017-12-13 15:17:27"));
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }

}
