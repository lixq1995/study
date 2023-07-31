package com.test.spring5.shejimoshi.gongchang.factorymode2.one;

import com.test.spring5.shejimoshi.gongchang.simplefactory1.one.ICourse;
import com.test.spring5.shejimoshi.gongchang.simplefactory1.one.PythonCource;

/**
 * @author by Lixq
 * @Classname PythonCourseFactory
 * @Description TODO
 * @Date 2021/12/6 23:11
 */
public class PythonCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new PythonCource();
    }
}
