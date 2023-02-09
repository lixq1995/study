package newjdk8.lambda;

import newjdk8.dto.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListTest {
    private static List<String> items = new ArrayList<>();

    static {
        items.add("A");
        items.add("BC");
        items.add("C");
        items.add("BD");
        items.add("E");
    }

    public static void main(String[] args) {
        //Java8之前操作List
        for(String item:items){
            System.out.println(item);
        }

        System.out.println("--------");

        //Java8 lambda遍历list
        items.forEach(c-> System.out.println(c));

        System.out.println("--------");

        items.forEach(item->{
            if("C".equals(item)){
                System.out.println(item);
            }
        });

        System.out.println("--------");

        //先过滤
        items.stream().filter(s->s.contains("B")).forEach(c1-> System.out.println(c1));


        // 排序
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(7);
        System.out.println(list);
        System.out.println("--------");

        // 升序排序
        list.sort((a,b)->a.compareTo(b));
        // 或者
        list.sort((a,b)->a-b);
        System.out.println(list);

        // 降序排序
        list.sort((a,b)->b-a);
        System.out.println(list);


        // 对象集合操作
        List<Person> list1 = new ArrayList<Person>();
        Person user = new Person("10", "3zhangsan", "北京");
        Person user1 = new Person("12", "2lisi", "深圳");
        Person user2 = new Person("11", "1wangwu", "深圳");
        list1.add(user);
        list1.add(user1);
        list1.add(user2);
        System.out.println("排序前 = " + list1);
        //1、id升序
        list1.sort((a,b) -> a.getId().compareTo(b.getId()));
        System.out.println("年龄升序 = " + list1);
        //2、姓名排列
        list1.sort(Comparator.comparing(Person::getName));
        System.out.println("姓名排序升序 = " + list1);
        list1.sort(Comparator.comparing(Person::getName).reversed());
        System.out.println("姓名降序降序 = " + list1);
        //等价于 2 姓名降序排列
        list1.sort(Comparator.comparing(a->((Person)a).getId()).reversed());
        //3、先按性别排，如果年龄相同，再按年龄排序
        list1.sort(Comparator.comparing(Person::getAddress).reversed().thenComparing(Person::getId));
        System.out.println("先按地址排，地址相同再按id排 = " + list1);


    }
}
