package test.javabasics.thread;

import java.util.Arrays;
import java.util.List;

/**
 * @author by Lixq
 * @Classname Test
 * @Description TODO
 * @Date 2021/8/23 18:38
 */
public class Test {
    public static void main(String[] args) {
        String s = "xyz";
        getString(s);
    }

    private static String getString(String a) {
        String[] split = a.split("");
        List<String> strings = Arrays.asList(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i <strings.size() ; i++) {
            String oneString = strings.get(strings.size() - i -1);
            stringBuffer.append(oneString);
        }
        return stringBuffer.toString();
    }
}
