package com.test.designmode.singletondesign41;

import com.test.javabasics.reflect.Person;

public class Test {

    public static void main(String[] args) {
        Singleton4 instance = Singleton4.getInstance();

        Singleton4 instance1 = Singleton4.getInstance();

        System.out.println("instance" + instance + "     " + "instance1" + instance1);
        System.out.println(instance == instance1);
        System.out.println(instance.equals(instance1));


        Person person = new Person();
        Person person1 = new Person();
        System.out.println(person == person1);
        System.out.println(person.equals(person1));
    }
}
