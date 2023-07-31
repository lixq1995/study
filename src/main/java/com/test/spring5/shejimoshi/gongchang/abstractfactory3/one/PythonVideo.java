package com.test.spring5.shejimoshi.gongchang.abstractfactory3.one;

/**
 * @author by Lixq
 * @Classname PythonVideo
 * @Description TODO
 * @Date 2021/12/6 23:37
 */
public class PythonVideo implements IVideo {
    @Override
    public void record() {
        System.out.println("录制Python视频");
    }
}
