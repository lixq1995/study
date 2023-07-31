package com.test.spring5.shejimoshi.gongchang.abstractfactory3.one;

/**
 * @author by Lixq
 * @Classname PythonNote
 * @Description TODO
 * @Date 2021/12/6 23:38
 */
public class PythonNote implements INote {
    @Override
    public void edit() {
        System.out.println("编写Python笔记");
    }
}
