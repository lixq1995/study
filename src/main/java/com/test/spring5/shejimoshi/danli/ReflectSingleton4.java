package com.test.spring5.shejimoshi.danli;

import java.lang.reflect.Constructor;

/**
 * @author by Lixq
 * @Classname ReflectSingleton4
 * @Description TODO
 * @Date 2022/3/13 23:46
 */
public class ReflectSingleton4 {
    public static void main(String[] args) {
        try{
            //很无聊的情况下，进行破坏
            Class<?> clazz = Singleton4Two.class;

            //通过反射拿到私有的构造方法
            Constructor c = clazz.getDeclaredConstructor(null);
            //强制访问
            c.setAccessible(true);

            //暴力初始化
            Object o1 = c.newInstance();
            System.out.println("o1 : " + o1);

            //调用了两次构造方法，相当于new了两次
            //犯了原则性问题，
            Object o2 = c.newInstance();
            System.out.println("o2 : " + o2);
            System.out.println(o1 == o2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
