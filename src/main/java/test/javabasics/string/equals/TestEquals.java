package test.javabasics.string.equals;

public class TestEquals {

    public static void main(String[] args) {
        String s1 = "DESC";
        if (!s1.equalsIgnoreCase("desc") || !s1.equalsIgnoreCase("asc")) {
            System.out.println("不相等");
        } else {
            System.out.println("相等");
        }
    }

}
