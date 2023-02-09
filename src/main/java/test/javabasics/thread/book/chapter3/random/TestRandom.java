package test.javabasics.thread.book.chapter3.random;

import java.util.Random;

public class TestRandom {

    public static void main(String[] args) {
        // 1创建一个默认种子的随机数生成器
        Random random = new Random();
        // 2输出10个在0-5（包含0，不包含5）之间的随机数
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(5));
        }
    }
}
