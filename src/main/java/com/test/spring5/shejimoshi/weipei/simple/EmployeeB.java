package com.test.spring5.shejimoshi.weipei.simple;

/**
 * Created by Tom.
 */
public class EmployeeB implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("我是员工B，我现在开始干" + command + "工作");
    }
}
