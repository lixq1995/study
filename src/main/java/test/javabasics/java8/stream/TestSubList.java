package test.javabasics.java8.stream;

import java.util.ArrayList;
import java.util.List;

public class TestSubList {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York1"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York2"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York3"));
        int total = 6;
        int pageSize = 2;
        int pageNum = 4;
        int totalPage = (total + pageSize - 1) / pageSize;
        List<Person> guarantorCustListPage = new ArrayList<>();
        if (total > pageSize * (pageNum - 1)) {
            guarantorCustListPage = personList.subList(pageSize * (pageNum - 1), ((pageSize * pageNum) > total ? total : (pageSize * pageNum)));
        }
        System.out.println(guarantorCustListPage);
    }
}
