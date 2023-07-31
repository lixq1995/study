package com.test.designmode.lsp17;

import java.util.HashMap;

public class Demo {
    public void demoFunction1(Transporter transporter) {
        HashMap<Object, Object> request = new HashMap<>();
        //... 省略设置 request 中数据值的代码...
        HashMap response = transporter.sendRequest1(request);
        //... 省略其他逻辑...
    }

    public void demoFunction2(Transporter transporter) {
        HashMap<Object, Object> request = new HashMap<>();
        //... 省略设置 request 中数据值的代码...
        HashMap response = transporter.sendRequest2(request);
        //... 省略其他逻辑...
    }

    public void test () {
        // 里式替换原则
        Demo demo = new Demo();
        HashMap<Object, Object> request = new HashMap<>();
        demo.demoFunction1(new SecurityTransporter(request, "appId", "appToken"));
    }

    public static void main(String[] args) {
        // 里式替换原则
        Demo demo = new Demo();
        HashMap<Object, Object> request = new HashMap<>();
        demo.demoFunction1(new SecurityTransporter(request, "appId", "appToken"));
        demo.demoFunction2(new Transporter(request));


    }
}
