package test.designmode.proxydesign48.designmode;

public class Test {

    public static void main(String[] args) {
        // UserControllerProxy使用举例
        // 因为原始类和代理类实现相同的接口，是基于接口而非实现编程
        // 将UserController类对象替换为UserControllerProxy类对象，不需要改动太多代码
        IUserController userController = new UserControllerProxy(new UserController());
        userController.login("13549596979","123456");
        userController.register("13549596979","123456");


        // UserControllerProxy继承使用举例
        UserController userController1 = new UserControllerProxy1();


        // MetricsCollectorProxy使用举例
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        IUserController userController2 = (IUserController) proxy.createProxy(new UserController());


    }
}
