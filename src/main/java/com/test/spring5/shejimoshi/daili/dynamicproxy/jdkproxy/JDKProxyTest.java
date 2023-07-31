package com.test.spring5.shejimoshi.daili.dynamicproxy.jdkproxy;

import com.test.spring5.shejimoshi.daili.staticproxy1.Person;

/**
 * Created by Tom on 2019/3/10.
 */
public class JDKProxyTest {

    public static void main(String[] args) {
        try {

            /**
             * 调用方式一
             */
            Person obj1 = (Person)new JDKMeipo().getInstance(new Girl());
            obj1.findLove();

            /**
             * 调用方式二
             */
//            Object obj = new JDKMeipo().getInstance(new Girl());
//            Method method = obj.getClass().getMethod("findLove",null);
//            method.invoke(obj);

            //obj.findLove();

            //$Proxy0 ，运行以下代码，在E盘生成文件，通过反编译工具可以查看源代码
//            byte [] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});
//            FileOutputStream os = new FileOutputStream("E://$Proxy0.class");
//            os.write(bytes);
//            os.close();

        }catch (Exception e){
            e.printStackTrace();
        }



    }

}
