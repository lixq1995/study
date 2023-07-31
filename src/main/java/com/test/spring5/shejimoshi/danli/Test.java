package com.test.spring5.shejimoshi.danli;

import com.test.designmode.singletondesign41.Singleton4;

public class Test {

    public static void main(String[] args) {
        Singleton4 instance = Singleton4.getInstance();

        Singleton4 instance1 = Singleton4.getInstance();

        System.out.println("instance" + instance + "     " + "instance1" + instance1);
        System.out.println(instance == instance1);
        System.out.println(instance.equals(instance1));


    }
}
