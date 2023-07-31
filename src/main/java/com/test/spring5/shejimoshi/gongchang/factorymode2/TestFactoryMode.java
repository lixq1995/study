package com.test.spring5.shejimoshi.gongchang.factorymode2;

import com.test.spring5.shejimoshi.gongchang.factorymode2.one.JavaCourseFactory;
import com.test.spring5.shejimoshi.gongchang.factorymode2.one.PythonCourseFactory;
import com.test.spring5.shejimoshi.gongchang.simplefactory1.one.ICourse;

/**
 * @author by Lixq
 * @Classname TestFactoryMode 工厂模式
 * @Description TODO
 * @Date 2021/12/6 23:09
 */
public class TestFactoryMode {

    public static void main(String[] args) {
        // 工厂方法主要解决的问题为，在简单工厂中，当产品链越来越多（如c++等等），如果每个课程创建逻辑有所不同，则工厂的职责会越来越多，
        // 有点像万能工厂，不利于维护。（职责相对过重，不易于扩展过于复杂的产品结构）
        // 根据单一职责原则继续优化拆分，专人干专事，如java课程由java工厂创建，对工厂本身也做一个抽象，编写工厂接口

        JavaCourseFactory javaCourseFactory = new JavaCourseFactory();
        ICourse javaCourse = javaCourseFactory.create();
        javaCourse.record();

        PythonCourseFactory pythonCourseFactory = new PythonCourseFactory();
        ICourse pythonCourse = pythonCourseFactory.create();
        pythonCourse.record();

        // 适用场景：
        // 1.创建对象需要大量重复代码
        // 2.客户端（应用层）不依赖于产品实例如何被创建、如何被实现等细节
        // 3.一个雷通过其子类来指定创建哪个对象

        // 缺点：
        // 1.类的个数容易过多，增加复杂度
        // 2.增加了系统的抽象性和理解难度

        /**
         * 工厂模式与抽象工厂模式的区别：
         * 工厂模式针对同一个产品等级结构（产品单一），如单单就课程分类，java,python
         * 抽象工厂模式针对的是多个产品等级结构，如java，Python课程都包含录视频，做笔记等等，并且java与python又有不同的地方
         *
         * 即区别：
         * 工厂方法模式：产品族
         * 一个抽象产品类，可以派生出多个具体产品类。
         * 一个抽象工厂类，可以派生出多个具体工厂类。
         * 每个具体工厂类只能创建一个具体产品类的实例。
         *
         * 抽象工厂模式：产品族与产品等级
         * 多个抽象产品类，每个抽象产品类可以派生出多个具体产品类。
         * 一个抽象工厂类，可以派生出多个具体工厂类。
         * 每个具体工厂类可以创建多个具体产品类的实例。
         */
    }
}
