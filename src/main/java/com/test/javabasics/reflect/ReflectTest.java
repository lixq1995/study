package com.test.javabasics.reflect;


import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Slf4j
public class ReflectTest {

    public static void main(String[] args) throws Exception {
        getClassMethod();
        getConstructor();
        getFields();
        methodTest();
        test();
    }

    /**
     * 获取Class对象的三种方式
     */
    private static void getClassMethod() {
        log.info("         getClassMethod  开始        ");
        Object object = new Person("Tom", "8900", "23", "male", "New York");
        // 1 Object ——> getClass();
        Class personClass1 = object.getClass();
        // 2 任何数据类型（包括基本数据类型）都有一个“静态”的class属性
        Class personClass2 = Person.class;
        log.info("判断class是否相等 : {}", personClass1 == personClass2);
        // 3 通过Class类的静态方法：forName（String  className）(常用)
        try {
            // 注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
            Class personClass3 = Class.forName("com.test.javabasics.reflect.Person");
            log.info("判断class是否相等 : {}", personClass1 == personClass3);
            System.out.println("1 : " + personClass1 + "   2 : " + personClass2 + "   3 :" + personClass3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("");
    }

    /**
     * 通过反射获取构造方法并使用
     *
     * @throws Exception
     */
    private static void getConstructor() throws Exception {
        log.info("         getConstructor  开始        ");
        Class personClass = Class.forName("com.test.javabasics.reflect.Person");

        System.out.println("**********************所有公有构造方法*********************************");
        Constructor[] conArray = personClass.getConstructors();
        for (Constructor c : conArray) {
            System.out.println("Constructor构造方法1 : " + c);
        }

        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        conArray = personClass.getDeclaredConstructors();
        for (Constructor c : conArray) {
            System.out.println("Constructor构造方法2 : " + c);
        }
        System.out.println("*****************获取公有、无参的构造方法*******************************");
        Constructor con = personClass.getConstructor(null);
        //1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
        //2>、返回的是描述这个无参构造函数的类对象。
        System.out.println("Constructor构造方法3 : " + con);

        //调用构造方法
        Object obj = con.newInstance();
        System.out.println("调用无参构造方法 : " + obj);
        Person stu = (Person) obj;

        System.out.println("******************获取私有构造方法，并调用*******************************");
        Constructor con1 = personClass.getDeclaredConstructor(String.class, String.class);
        System.out.println("调用私有构造方法 : " + con1);
        //调用构造方法
        con1.setAccessible(true);//暴力访问(忽略掉访问修饰符)
        // todo newInstance即调用构造方法，  类似 new Person(String name,String age)
        obj = con1.newInstance("男", "12");
        System.out.println("");
    }

    /**
     * 通过反射获取操作字段
     */
    /**
     * 获取成员变量并调用：
     * <p>
     * 1.批量的
     * 1).Field[] getFields():获取所有的"公有字段"
     * 2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
     * 2.获取单个的：
     * 1).public Field getField(String fieldName):获取某个"公有的"字段；
     * 2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
     * <p>
     * 设置字段的值：
     * Field --> public void set(Object obj,Object value):
     * 参数说明：
     * 1.obj:要设置的字段所在的对象；
     * 2.value:要为字段设置的值；
     */
    private static void getFields() throws Exception {
        log.info("         getFields  开始        ");
        // 1.获取Class对象
        Class personClass = Class.forName("com.test.javabasics.reflect.Person");
        // 2.获取字段
        System.out.println("************获取所有公有的字段********************");
        Field[] fieldArray1 = personClass.getFields();
        for (Field f : fieldArray1) {
            System.out.println("person对象的字段public属性为 : " + f);
        }

        System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
        Field[] fieldArray2 = personClass.getDeclaredFields();
        for (Field f : fieldArray2) {
            System.out.println("person对象的所有字段属性为 : " + f);
        }

        System.out.println("*************获取公有字段**并调用***********************************");
        Field f1 = personClass.getField("area");
        System.out.println("f1 : " + f1);
        //获取一个对象
        Object obj = personClass.getConstructor().newInstance();//产生Student对象--》Student stu = new Student();
        // todo 为字段设置值
        f1.set(obj, "深圳");//为Student对象中的age属性赋值--》stu.area = "深圳"
        //验证
        Person stu = (Person) obj;
        System.out.println("验证地区：" + stu.area);

        System.out.println("**************获取私有字段****并调用********************************");
        Field f2 = personClass.getDeclaredField("name");
        System.out.println(f2);
        f2.setAccessible(true);//暴力反射，解除私有限定
        f2.set(obj, "张三");
        System.out.println("验证名字：" + stu);
        System.out.println("");
    }


    /**
     * 获取成员方法并调用：
     *
     * 1.批量的：
     * 		public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
     * 		public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
     * 2.获取单个的：
     * 		public Method getMethod(String name,Class<?>... parameterTypes):
     * 					参数：
     * 						name : 方法名；
     * 						Class ... : 形参的Class类型对象
     * 		public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
     *
     * 	 调用方法：
     * 		Method --> public Object invoke(Object obj,Object... args):
     * 					参数说明：
     * 					obj : 要调用方法的对象；
     * 					args:调用方式时所传递的实参；
     ):
     */
    /**
     * 获取成员方法并调用
     */
    private static void methodTest() throws Exception {
        log.info("         methodTest  开始        ");
        //1.获取Class对象
        Class stuClass = Class.forName("com.test.javabasics.reflect.Person");
        //2.获取所有公有方法
        System.out.println("***************获取所有的”公有“方法*******************");
        stuClass.getMethods();
        Method[] methodArray = stuClass.getMethods();
        for (Method m : methodArray) {
            System.out.println(m);
        }
        System.out.println("***************获取所有的方法，包括私有的*******************");
        methodArray = stuClass.getDeclaredMethods();
        for (Method m : methodArray) {
            System.out.println(m);
        }
        System.out.println("***************获取公有的show1()方法*******************");
        Method m = stuClass.getMethod("show1", String.class);
        System.out.println(m);
        // 实例化一个Student对象
        Object obj = stuClass.getConstructor().newInstance();
        m.invoke(obj, "刘德华");

        System.out.println("***************获取私有的show4()方法******************");
        m = stuClass.getDeclaredMethod("show4", int.class);
        System.out.println(m);
        m.setAccessible(true);//解除私有限定
        Object result = m.invoke(obj, 20);//需要两个参数，一个是要调用的对象（获取有反射），一个是实参
        System.out.println("返回值：" + result);
        System.out.println("");
    }


    private static void test() {
        Object object = new Person("Tom", "8900", "23", "male", "New York");
        Class<?> aClass = object.getClass();
        String personName = object.getClass().getName();
        String simpleName = object.getClass().getSimpleName();
        String typeName = object.getClass().getTypeName();
        System.out.println("        " + "personName : " + personName + "         " + "typeName : " + typeName + "            " + "simpleName : " + simpleName);
        Field[] declaredFields = object.getClass().getDeclaredFields();
        System.out.println("declaredFields : " + declaredFields);
        for (Field field : declaredFields) {
            String attributeName = field.getName();
            String methodName = attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1);
            System.out.println("field字段值 : " + field);
            try {
                Method setMethod = object.getClass().getMethod("set" + methodName, String.class);
                Method getMethod = aClass.getMethod("get" + methodName);
                System.out.println("setMethod方法名 : " + setMethod + "  getMethod方法名 : " + getMethod);
                // todo 反射set方法使用
                Object setUse = setMethod.invoke(object, "test");
                // todo 反射get方法使用
                Object getUse = getMethod.invoke(object);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(object);
        }
    }
}
