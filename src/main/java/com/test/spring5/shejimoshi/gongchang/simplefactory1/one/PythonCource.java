package com.test.spring5.shejimoshi.gongchang.simplefactory1.one;

/**
 * @author by Lixq
 * @Classname PythonCource
 * @Description TODO
 * @Date 2021/12/6 22:22
 */
public class PythonCource implements ICourse {
    @Override
    public void record() {
        System.out.println("录制python视频");
    }
}
