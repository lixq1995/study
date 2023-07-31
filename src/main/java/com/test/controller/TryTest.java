package com.test.controller;

import com.test.local.pojo.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by Lixq
 * @Classname TryTest
 * @Description TODO
 * @Date 2022/2/22 16:35
 */
public class TryTest {

    public static void main(String[] args) {

        Map map = new HashMap<>();
        map.put("1","一");
        map.put("2","二");
        map.put("3","三");
//        System.out.println(Optional.ofNullable(map.get("4")).orElse("1"));

        User user = new User();
//        user.setAge(Optional.ofNullable(map.get("4")).orElse("11").toString());
        String name = user.getName();
        if ("1".equals(name)) {
            System.out.println("111");
        }
        System.out.println(name);


//        try {
//            int a = 1/0;
//        }catch (Exception e) {
//            throw new BusinessException(HelloEnum.EXCEPTION_ONE);
//        }

    }
}
