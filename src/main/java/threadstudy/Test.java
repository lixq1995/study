package threadstudy;

import lombok.Data;

public class Test {
    public static void main(String[] args) {
//        boolean a = true;
//        Integer b = 1;
//        System.out.println(a);
//        System.out.println(b);
        test();

        Integer integer = 40;
        Integer intege1 = 40;
        String dd = "1";
        Integer integer2 = new Integer(40);
        System.out.println(integer == intege1);
        System.out.println(integer == integer2);

        int num1 = 1;
        int num2 = 1;
    }

    private static void test() {
        testClasss a = new testClasss();
        System.out.println(a.getA());
        System.out.println(a.getB());
        System.out.println(a.isC());
        System.out.println(a.getD());
    }

    @Data
    static class testClasss {
        private int a;
        private Integer b;
        private boolean c;
        private Boolean d;

    }


}


