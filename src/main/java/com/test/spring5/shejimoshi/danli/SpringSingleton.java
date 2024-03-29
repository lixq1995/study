package com.test.spring5.shejimoshi.danli;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author by Lixq
 * @Classname SpringSingleton
 * @Description TODO
 * @Date 2022/3/14 21:45
 */
//Spring中的做法，就是用这种注册式单例，非线程安全
public class SpringSingleton {

    private SpringSingleton(){}
    private static Map<String,Object> ioc = new ConcurrentHashMap<String,Object>();
    public static Object getInstance(String className){
        synchronized (ioc) {
            if (!ioc.containsKey(className)) {
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    ioc.put(className, obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            } else {
                return ioc.get(className);
            }
        }
    }
}
