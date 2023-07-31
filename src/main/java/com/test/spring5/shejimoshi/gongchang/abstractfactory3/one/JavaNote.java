package com.test.spring5.shejimoshi.gongchang.abstractfactory3.one;

/**
 * @author by Lixq
 * @Classname JavaNote
 * @Description TODO
 * @Date 2021/12/6 23:36
 */
public class JavaNote implements INote {
    @Override
    public void edit() {
        System.out.println("编写java笔记");
    }
}
