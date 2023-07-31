package com.test.spring5.shejimoshi.gongchang.simplefactory1.one;

/**
 * @author by Lixq
 * @Classname CourseFactory1
 * @Description TODO
 * @Date 2021/12/6 22:23
 */
public class CourseFactory1 {
    public ICourse create (String name) {
        if ("java".equals(name)) {
            return new JavaCourse();
        } else if ("python".equals(name)) {
            return new PythonCource();
        } else {
            return null;
        }
    }
}
