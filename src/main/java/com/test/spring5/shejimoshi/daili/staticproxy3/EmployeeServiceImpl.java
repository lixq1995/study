package com.test.spring5.shejimoshi.daili.staticproxy3;

/**
 * @author by Lixq
 * @Classname EmployeeServiceImpl
 * @Description TODO
 * @Date 2022/3/16 22:30
 */
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public void save(Employee emp) {
        System.out.println("保存员工");
    }

    @Override
    public void update(Employee emp) {
        System.out.println("修改员工信息");;
    }
}
