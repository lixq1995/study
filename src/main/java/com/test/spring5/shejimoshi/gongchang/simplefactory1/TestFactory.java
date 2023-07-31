package com.test.spring5.shejimoshi.gongchang.simplefactory1;

import com.test.spring5.shejimoshi.gongchang.simplefactory1.one.CourseFactory1;
import com.test.spring5.shejimoshi.gongchang.simplefactory1.one.ICourse;
import com.test.spring5.shejimoshi.gongchang.simplefactory1.one.JavaCourse;
import com.test.spring5.shejimoshi.gongchang.simplefactory1.three.CourseFactory3;
import com.test.spring5.shejimoshi.gongchang.simplefactory1.two.CourseFactory2;

/**
 * @author by Lixq
 * @Classname TestFactory 简单工厂模式
 * @Description TODO
 * @Date 2021/12/6 22:16
 */
public class TestFactory {

    public static void main(String[] args) {
        // one.存在问题：如果需要再增加新的课程，比如c++，那需要增加一个c++对象，并修改CourseFactory代码，再新增一个if else。  违反开闭原则
        // 优化：采用反射技术，见CourseFactory2
        CourseFactory1 factory1 = new CourseFactory1();
        ICourse java1 = factory1.create("java");
        java1.record();

        // two.存在问题：方法参数是字符串，入参不可控，并且返回值需要强转类型
        // 优化：见CourseFactory3
        CourseFactory2 factory2 = new CourseFactory2();
        ICourse java2 = factory2.create("com.test.spring5.shejimoshi.gongchang.simplefactory1.one.JavaCourse");
        java2.record();

        // three
        CourseFactory3 factory3 = new CourseFactory3();
        ICourse java3 = factory3.create(JavaCourse.class);
        java3.record();

        // 简单工厂缺点：工厂类的职责相对较重，不易于扩展过于复杂的产品结构。
    }
}
