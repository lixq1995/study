package test.spring5.shejimoshi.daili.dynamicproxy.jdkproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Tom on 2019/3/10.
 * // todo java动态代理机制中有两个重要的类和接口InvocationHandler（接口）和Proxy（类），
 *      这一个类Proxy和接口InvocationHandler是我们实现动态代理的核心；
 * todo  InvocationHandler接口是proxy代理实例的调用处理程序实现的一个接口，每一个proxy代理实例
        都有一个关联的调用处理程序；在代理实例调用方法时，方法调用被编码分派到调用处理程序的invoke方法。
 */
public class JDKMeipo implements InvocationHandler {

    // 被代理的对象，把引用保存下来
    private Object target;

    public Object getInstance(Object person) throws Exception{
        this.target = person;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.target,args);
        after();
       return obj;
    }

    private void before(){
        System.out.println("我是媒婆，我要给你找对象，现在已经确认你的需求");
        System.out.println("开始物色");
    }

    private void after(){
        System.out.println("OK的话，准备办事");
    }
}
