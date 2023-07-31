package com.test.spring5.shejimoshi.gongchang.abstractfactory3.one;

/**
 * @author by Lixq
 * @Classname JavaVideo
 * @Description TODO
 * @Date 2021/12/6 23:35
 */
public class JavaVideo implements IVideo {
    @Override
    public void record() {
        System.out.println("录制java视频");
    }
}
