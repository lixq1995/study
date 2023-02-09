package test.javabasics.thread.shangguigu.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author 卢意
 * @create 2021-01-12 10:08
 */
class MyTask extends RecursiveTask<Integer> {
    // 10以内不需要分开
    private static final Integer ADJUSTER_VALUE = 10;

    private int begin;
    private int end;
    private int result;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - begin <= ADJUSTER_VALUE) { // 不用分支
            for (int i = begin; i <= end; i++) {
                result = result + i;
            }
        } else {
            int mid = (end + begin) / 2;
            MyTask task1 = new MyTask(begin, mid);
            MyTask task2 = new MyTask(mid + 1, end);
            task1.fork();
            task2.fork();
            result = task1.join() + task2.join();
        }
        return result;
    }
}

public class TestForkJoin {
    public static void main(String[] args) {
        MyTask myTask = new MyTask(0, 100);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(myTask);
        try {
            System.out.println(forkJoinTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            forkJoinPool.shutdown();
        }
    }
}