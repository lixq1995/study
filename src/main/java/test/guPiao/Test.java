package test.guPiao;

        import com.alibaba.fastjson.JSONObject;

        import java.util.ArrayList;
        import java.util.List;

/**
 * @author by Lixq
 * @Classname Test
 * @Description TODO
 * @Date 2021/6/25 23:01
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<String> objects = new ArrayList<>();
        objects.add("1");
        objects.add("2");
        objects.add("3");
        List<String> strings = objects.subList(0, 1);
        System.out.println(strings);


        String substring = "20210625161503".substring(0, 8);
        System.out.println(substring);
    }
}
