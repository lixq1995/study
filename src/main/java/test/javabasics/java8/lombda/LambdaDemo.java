package test.javabasics.java8.lombda;


interface Foo {
    // 接口内如果只有一个声明的方法 就是函数式接口@FunctionalInterface(只有一个方法 默认加上)，即可用lambda表达式
    public void sayHello();

    // todo 以下代码放开lambda表达式报错，函数式编程只有1个方法
//    public void sayGoodbye();
}

public class LambdaDemo {

    public static void main(String[] args) {
        Foo foo = new Foo() {
            @Override
            public void sayHello() {
                System.out.println("hello");
            }
        };
        foo.sayHello();

        // lambda在函数式接口的情况下
        // 口诀
        // 拷贝小括号(复制小括号的内容) 写死右箭头 落地大箭头 () -> {}
        Foo foo1 = () -> { System.out.println("hello lamdba"); };
        foo1.sayHello();
    }



}
