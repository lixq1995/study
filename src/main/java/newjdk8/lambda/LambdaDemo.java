package newjdk8.lambda;

/**
 * @Classname Foo1
 * @Description TODO
 * @Date 2021/1/23 18:12
 * @Created by Lixq
 */
//
interface Foo1 {
    public void sayHello();

    // todo 放开以下代码报错  因为接口内如果只有一个声明的方法 就是函数式接口@FunctionalInterface(只有一个方法 默认加上)
//    public void sayGoodbye();
}


public class LambdaDemo {
    public static void main(String[] args) {

        Foo1 newFoo = new Foo1() {
            @Override
            public void sayHello() {
                System.out.println("hello");
            }
        };
        newFoo.sayHello();

        // 在函数式接口的情况下
        // 口诀:拷贝小括号(复制小括号的内容) 写死右箭头 落地大箭头 () -> {}
        Foo1 newFoo1 = () -> System.out.println("Hello lambda");
        newFoo1.sayHello();
    }
}