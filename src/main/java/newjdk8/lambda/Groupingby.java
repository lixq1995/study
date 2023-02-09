package newjdk8.lambda;

import com.google.common.collect.Lists;
import newjdk8.dto.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Groupingby {
    private static List<Person> personList = Lists.newArrayList();

    static {
        personList.add(Person.builder().id("10").address("apple").address("shanghai").build());
        personList.add(Person.builder().id("12").address("apple").address("wuhan").build());
        personList.add(Person.builder().id("16").address("apple").address("nanjing").build());
    }

    public static void main(String[] args) {
        System.out.println(personList);
        //分组
        Map<String, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(c -> c.getAddress()));
    }
}
