package test.javabasics.reflect;

import lombok.Data;

@Data
public class Person {
    private String name;  // 姓名
    private String salary; // 薪资
    protected String age; // 年龄
    public String sex; //性别
    public String area;  // 地区

    // 无参公有构造方法
    public Person(){
        System.out.println("调用了公有、无参构造方法执行了。。。");
    }

    // 有一个参数的构造方法
    public Person(String name){
        System.out.println("姓名：" + name);
    }

    // 有2个参数的私有构造方法
    public Person(String name,String age){
        System.out.println("调用了私有构造方法执行了。。。");
        System.out.println("姓名：" + name + " 年龄: " + age);
    }

    // 有3个参数的私有构造方法
    protected Person(String name,String age,String sex){
        System.out.println("姓名：" + name + " 年龄: " + age + " 性别: " + sex);
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    // 构造方法
    public Person(String name, String salary, String age, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }

    private Person(String name, String salary, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.sex = sex;
        this.area = area;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", area='" + area + '\'' +
                '}';
    }

    //**************成员方法***************//
    public void show1(String s){
        System.out.println("调用了：公有的，String参数的show1(): s = " + s);
    }
    protected void show2(){
        System.out.println("调用了：受保护的，无参的show2()");
    }
    void show3(){
        System.out.println("调用了：默认的，无参的show3()");
    }
    private String show4(int age){
        System.out.println("调用了，私有的，并且有返回值的，int参数的show4(): age = " + age);
        return "abcd";
    }

//    public static void main(String[] args) {
//        Person person = new Person("张三","15","男");
//        Person person1 = new Person("张三","5000","15","男","深圳");
//        System.out.println(person);
//        System.out.println(person.toString());
//        System.out.println(person1);
//        System.out.println(person1.toString());
//    }
}
