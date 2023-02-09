package test.spring5.shejimoshi.gongchang.abstractfactory3;

import com.test.spring5.shejimoshi.gongchang.abstractfactory3.one.JavaCourseFactory;

/**
 * @author by Lixq
 * @Classname TestAbstractFactory 抽象工厂
 * @Description TODO
 * @Date 2021/12/6 23:24
 */
public class TestAbstractFactory {

    public static void main(String[] args) {

        JavaCourseFactory javaCourseFactory = new JavaCourseFactory();
        javaCourseFactory.createNote().edit();
        javaCourseFactory.createVideo().record();

        // 缺点：
        // 1.前期规定了所有可能被创建的产品集合，产品族扩展新产品困难（如果再增加写源码source功能，抽象工厂类需要增加对应代码），不符合开闭原则
        // 2.增加了系统的抽象性和理解难度

    }
}
