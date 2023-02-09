package test.spring5.shejimoshi.daili.dynamicproxy.jdkproxy;


import com.test.spring5.shejimoshi.daili.staticproxy1.Person;

/**
 * Created by Tom on 2019/3/10.
 */
public class Girl implements Person {
    @Override
    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高180cm");
        System.out.println("有6块腹肌");
    }
}
