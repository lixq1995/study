package com.test.spring5.shejimoshi.daili.staticproxy3;

/**
 * @author by Lixq
 * @Classname EmployeeServiceProxy
 * @Description TODO
 * @Date 2022/3/16 22:33
 */
public class EmployeeServiceProxy implements EmployeeService {
    private TransactionManager tx; // 事务管理器
    private EmployeeService target; // 真实对象/委托对象

    // 正常spring应为注入该对象
    public void setTarget(EmployeeService target) {
        this.target = target;
    }
    // 正常spring应为注入该对象
    public void setTx(TransactionManager tx) {
        this.tx = tx;
    }

    // 非spring容器，new出以下2个对象
    public EmployeeServiceProxy(TransactionManager tx, EmployeeService target) {
        this.tx = tx;
        this.target = target;
    }

    // 被增强的方法
    @Override
    public void save(Employee emp) {
        // 开启事务_对save方法的增强
        tx.begin();
        try {
            target.save(emp);
            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
    // 被增强的方法
    @Override
    public void update(Employee emp) {
        tx.begin();
        try {
            target.update(emp);
            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    public static void main(String[] args) {
        TransactionManager tx = new TransactionManager();
        EmployeeService target = new EmployeeServiceImpl();
        EmployeeServiceProxy employeeServiceProxy = new EmployeeServiceProxy(tx,target);
        Employee employee = new Employee();
        employeeServiceProxy.save(employee);
        System.out.println("");
        employeeServiceProxy.update(employee);
    }
}
