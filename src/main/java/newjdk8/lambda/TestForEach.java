package newjdk8.lambda;

import newjdk8.dto.Person;

import java.util.ArrayList;
import java.util.List;

public class TestForEach {
    public static void main(String[] args) {

        TestForEach testForEach = new TestForEach();
        testForEach.testList();
    }

    public void setTest(Person person) {
        person.setAddress("上海");
    }

    public void testList () {
        List<Person> list1 = new ArrayList<Person>();
        Person user = new Person("10", "zhangsan", "北京");
        Person user1 = new Person("12", "lisi", "深圳");
        list1.add(user);
        list1.add(user1);
        System.out.println(list1);
        list1.forEach(this::setTest);
        System.out.println(list1);
    }
}
