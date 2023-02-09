package test.local;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class TestJson {

    public static void main(String[] args) {
        jsonToList();
    }


    private static void jsonToList() {
//        mqJsonTest();
        boolean flag = true;
        if (flag == true) {
            System.out.println("true");
        }
        int anInt = getInt();
        if (anInt <= 3) {
            System.out.println("i小于等于3");
        }
    }

    private static int getInt() {
        int i = 3;
        return i;
    }

    private static void mqJsonTest() {
        String msg = "[\n" +
                "  {\n" +
                "    \"id\": \"案例编号1111\",\n" +
                "    \"casesName\": \"测试2222222\",\n" +
                "    \"managerUM\": \"um账号\",\n" +
                "    \"casesDescription\": \"仅test用\"\n" +
                "  }\n" +
                "]";
        Object s1 = JSON.parse(msg);
        String s2 = JSON.toJSONString(s1);
        List<CasePushMsg> casePushMsgList = JSON.parseArray(s2, CasePushMsg.class);
        System.out.println(casePushMsgList);


        String s3 = "{\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"systemId\": \"IIRP-CORE\",\n" +
                "      \"requestType\": \"liquidate\",\n" +
                "      \"managerUM\": \"xuzhenghao973\",\n" +
                "      \"customerId\": \"20120531000262\",\n" +
                "      \"industry\": \"其他金属工具制造\",\n" +
                "      \"name\": null,\n" +
                "      \"productList\": [\n" +
                "        {\n" +
                "          \"guaranteeType\": \"保证\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        Object object = (Object) s3;
        Class<? extends String> aClass = s3.getClass();

        JSONObject jsonObject = JSON.parseObject(s3);
//        System.out.println(JSON.toJSONString(jsonObject,SerializerFeature.WriteMapNullValue));
//        System.out.println(JSON.toJSONString(jsonObject));
        JSONArray data = jsonObject.getJSONArray("data");
//        Object o1 = (JSONObject)data.get(0);
        String o = JSON.toJSONString(data.get(0), SerializerFeature.WriteMapNullValue);
        System.out.println(o);

    }
}
