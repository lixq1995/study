package com.test.javabasics.reflect;

public class DocumentFactory {
// 通过一个工厂方法来创建 person
    private Person person;

    public DocumentFactory(Person person) {
        this.person = person;
    }

    public Person createDocument(String url) {
        String age = person.age;
        return new Person(url, age);
    }
}
