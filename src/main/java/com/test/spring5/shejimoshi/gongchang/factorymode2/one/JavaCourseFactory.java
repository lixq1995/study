package com.test.spring5.shejimoshi.gongchang.factorymode2.one;

import com.test.spring5.shejimoshi.gongchang.simplefactory1.one.ICourse;
import com.test.spring5.shejimoshi.gongchang.simplefactory1.one.JavaCourse;

/**
 * @author by Lixq
 * @Classname JavaCourseFactory
 * @Description TODO
 * @Date 2021/12/6 23:10
 */
public class JavaCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
