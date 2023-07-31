package com.test.javabasics.copy;

import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author by Lixq
 * @Classname BeanUtil
 * @Description TODO
 * @Date 2021/6/30 23:18
 */
public class BeanUtil {

    /**
     * @param source 源List
     * @param target 目标List
     * @param targetClassObj 目标对象类型
     */
    public static void copyList(List source, List target, Class targetClassObj) {
        source.forEach(item -> {
            try {
                Object data = targetClassObj.newInstance();
                BeanUtils.copyProperties(item, data);
                target.add(data);
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {
            }
        });
    }
}
