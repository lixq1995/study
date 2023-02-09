package test.javabasics.copy;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author by Lixq
 * @Classname CopyTest
 * @Description TODO
 * @Date 2023/1/28 16:04
 */
public class CopyTest {

    @Data
    @AllArgsConstructor
    public class Address implements Cloneable{
        private String name;
        // 省略构造函数、Getter&Setter方法
        @Override
        public Address clone() {
            try {
                return (Address) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }

    @Data
    @AllArgsConstructor
    public class Person implements Cloneable {
        private Address address;
        // 省略构造函数、Getter&Setter方法
        @Override
        public Person clone() {
            try {
                Person person = (Person) super.clone();
                return person;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }

    @Override
    public Person clone() {
        try {
            Person person = (Person) super.clone();
            person.setAddress(person.getAddress().clone());
            return person;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }


    public static void main(String[] args) {
        CopyTest copyTest = new CopyTest();
        copyTest.testQian();

        copyTest.testShen();
    }

    private void testQian() {
        Person person1 = new Person(new Address("武汉"));
        Person person1Copy = person1.clone();
        // true
        System.out.println(person1.getAddress() == person1Copy.getAddress());
    }

    private void testShen() {
        Person person1 = new Person(new Address("武汉"));
        Person person1Copy = person1.clone();
        // false
        System.out.println(person1.getAddress() == person1Copy.getAddress());
    }
}
