package com.test.spring5.shejimoshi.daili.staticproxy1;

/**
 * @author by Lixq
 * @Classname Person
 * @Description TODO
 * @Date 2022/3/16 22:22
 */
public class Father implements Person {
    private Son person;

    public Father(Son person){
        this.person = person;
    }

    public void findLove(){
        // 获取目标对象的引用，父亲代理儿子的方法，并在原代码逻辑前后增加一些代码逻辑，做代码增强
        System.out.println("父亲物色对象");
        this.person.findLove();
        System.out.println("双方父母同意，确立关系");
    }

    public void findJob(){

    }


}
