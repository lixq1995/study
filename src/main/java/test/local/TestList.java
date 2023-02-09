package test.local;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.test.local.pojo.Content;
import com.test.local.pojo.ImageAndText;
import com.test.local.pojo.Msg;

import java.util.ArrayList;
import java.util.List;

public class TestList {

    public static void main(String[] args) {
//        testJsonList();
        testJsonList1();
    }

    private static void testJsonList() {
        String s1 = "{\n" +
                "  \"qust\": {\n" +
                "    \"faqId\": \"202012010028\",\n" +
                "    \"faqName\": \"test1112\",\n" +
                "    \"role\": \"客户经理\",\n" +
                "    \"faqSort\": \"3\",\n" +
                "    \"createUserId\": \"jiasd\",\n" +
                "    \"createUserName\": \"贾似道\",\n" +
                "    \"createTime\": null,\n" +
                "    \"updateUserId\": null,\n" +
                "    \"updateUserName\": null,\n" +
                "    \"updateTime\": 1606979368000,\n" +
                "    \"startTime\": 1608393600000,\n" +
                "    \"endTime\": 1608480000000,\n" +
                "    \"faqType\": \"1\",\n" +
                "    \"isValid\": \"Y\",\n" +
                "    \"detailImageName\": \"图图图\",\n" +
                "    \"detailUserId\": \"jiasd\",\n" +
                "    \"detailUserName\": \"贾似道\",\n" +
                "    \"detailUploadTime\": 1608393600000,\n" +
                "    \"isdelete\": \"N\"\n" +
                "  },\n" +
                "  \"msg\": [\n" +
                "    [\n" +
                "      {\n" +
                "        \"msgId\": \"968790e57622adbb017622b33a0b001c\",\n" +
                "        \"msgName\": \"突突突111\",\n" +
                "        \"msg\": \"test111\",\n" +
                "        \"msgType\": \"1\",\n" +
                "        \"fileName\": null,\n" +
                "        \"msgBy\": \"1\",\n" +
                "        \"faqId\": \"202012010028\",\n" +
                "        \"isdelete\": \"N\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"msgId\": \"968790e57622adbb017622b33a0b0021\",\n" +
                "        \"msgName\": null,\n" +
                "        \"msg\": \"../../udmp\",\n" +
                "        \"msgType\": \"2\",\n" +
                "        \"fileName\": \"filename\",\n" +
                "        \"msgBy\": \"1\",\n" +
                "        \"faqId\": \"202012010028\",\n" +
                "        \"isdelete\": \"N\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"msgId\": \"968790e57622adbb017622b33a0b001f\",\n" +
                "        \"msgName\": null,\n" +
                "        \"msg\": \"../../udmp\",\n" +
                "        \"msgType\": \"2\",\n" +
                "        \"fileName\": \"filename\",\n" +
                "        \"msgBy\": \"1\",\n" +
                "        \"faqId\": \"202012010028\",\n" +
                "        \"isdelete\": \"N\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"msgId\": \"968790e57622adbb017622b33a0b0020\",\n" +
                "        \"msgName\": null,\n" +
                "        \"msg\": \"../../udmp\",\n" +
                "        \"msgType\": \"2\",\n" +
                "        \"fileName\": \"filename\",\n" +
                "        \"msgBy\": \"1\",\n" +
                "        \"faqId\": \"202012010028\",\n" +
                "        \"isdelete\": \"N\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"msgId\": \"968790e57622adbb017622b33a0b001d\",\n" +
                "        \"msgName\": null,\n" +
                "        \"msg\": \"../../udmp\",\n" +
                "        \"msgType\": \"2\",\n" +
                "        \"fileName\": \"filename\",\n" +
                "        \"msgBy\": \"1\",\n" +
                "        \"faqId\": \"202012010028\",\n" +
                "        \"isdelete\": \"N\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"msgId\": \"968790e57622adbb017622b33a0b001e\",\n" +
                "        \"msgName\": null,\n" +
                "        \"msg\": \"../../udmp\",\n" +
                "        \"msgType\": \"2\",\n" +
                "        \"fileName\": \"filename\",\n" +
                "        \"msgBy\": \"1\",\n" +
                "        \"faqId\": \"202012010028\",\n" +
                "        \"isdelete\": \"N\"\n" +
                "      }\n" +
                "    ],\n" +
                "    [\n" +
                "      {\n" +
                "        \"msgId\": \"968790e57622adbb017622b33a0c0022\",\n" +
                "        \"msgName\": \"突突突2\",\n" +
                "        \"msg\": \"test2222\",\n" +
                "        \"msgType\": \"1\",\n" +
                "        \"fileName\": null,\n" +
                "        \"msgBy\": \"2\",\n" +
                "        \"faqId\": \"202012010028\",\n" +
                "        \"isdelete\": \"N\"\n" +
                "      }\n" +
                "    ],\n" +
                "    [\n" +
                "      {\n" +
                "        \"msgId\": \"968790e57622adbb017622b33a0c0023\",\n" +
                "        \"msgName\": \"突33333\",\n" +
                "        \"msg\": \"test3333333\",\n" +
                "        \"msgType\": \"1\",\n" +
                "        \"fileName\": null,\n" +
                "        \"msgBy\": \"3\",\n" +
                "        \"faqId\": \"202012010028\",\n" +
                "        \"isdelete\": \"N\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"msgId\": \"968790e57622adbb017622b33a0c0024\",\n" +
                "        \"msgName\": null,\n" +
                "        \"msg\": \"../../udmp333\",\n" +
                "        \"msgType\": \"2\",\n" +
                "        \"fileName\": \"filename33333333\",\n" +
                "        \"msgBy\": \"3\",\n" +
                "        \"faqId\": \"202012010028\",\n" +
                "        \"isdelete\": \"N\"\n" +
                "      }\n" +
                "    ]\n" +
                "  ]\n" +
                "}";
        JSONObject parse = JSON.parseObject(s1);
        Content content = JSONObject.parseObject(parse.toJSONString(), Content.class);
//        List<ArrayList<ImageAndText>> msg1 = content.getMsg();
//        ArrayList<ImageAndText> imageAndTexts = msg1.get(0);

        JSONArray msg = parse.getJSONArray("msg");
        for (Object o:msg) {
            JSONArray jsonArray = JSON.parseArray(JSON.toJSONString(o));
            for (Object o1:jsonArray) {
                JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(o1));
                String msgId = jsonObject.getString("msgId");
                System.out.println(msgId);
            }
        }
    }

    private static void testJsonList1() {
        String s1 = "{\n" +
                "  \"qust\": {\n" +
                "    \"faqId\": \"202012010028\",\n" +
                "    \"faqName\": \"test1112\",\n" +
                "    \"role\": \"客户经理\",\n" +
                "    \"faqSort\": \"3\",\n" +
                "    \"createUserId\": \"jiasd\",\n" +
                "    \"createUserName\": \"贾似道\",\n" +
                "    \"createTime\": null,\n" +
                "    \"updateUserId\": null,\n" +
                "    \"updateUserName\": null,\n" +
                "    \"updateTime\": 1606979368000,\n" +
                "    \"startTime\": 1608393600000,\n" +
                "    \"endTime\": 1608480000000,\n" +
                "    \"faqType\": \"1\",\n" +
                "    \"isValid\": \"Y\",\n" +
                "    \"detailImageName\": \"图图图\",\n" +
                "    \"detailUserId\": \"jiasd\",\n" +
                "    \"detailUserName\": \"贾似道\",\n" +
                "    \"detailUploadTime\": 1608393600000,\n" +
                "    \"isdelete\": \"N\"\n" +
                "  },\n" +
                "  \"msg\": [\n" +
                "    {\n" +
                "      \"img\": [\n" +
                "        {\n" +
                "          \"msgId\": \"968790e57622adbb017622b33a0b001c\",\n" +
                "          \"msgName\": \"突突突111\",\n" +
                "          \"msg\": \"test111\",\n" +
                "          \"msgType\": \"1\",\n" +
                "          \"fileName\": null,\n" +
                "          \"msgBy\": \"1\",\n" +
                "          \"faqId\": \"202012010028\",\n" +
                "          \"isdelete\": \"N\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"msgId\": \"968790e57622adbb017622b33a0b0021\",\n" +
                "          \"msgName\": null,\n" +
                "          \"msg\": \"../../udmp\",\n" +
                "          \"msgType\": \"2\",\n" +
                "          \"fileName\": \"filename\",\n" +
                "          \"msgBy\": \"1\",\n" +
                "          \"faqId\": \"202012010028\",\n" +
                "          \"isdelete\": \"N\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"msgId\": \"968790e57622adbb017622b33a0b001f\",\n" +
                "          \"msgName\": null,\n" +
                "          \"msg\": \"../../udmp\",\n" +
                "          \"msgType\": \"2\",\n" +
                "          \"fileName\": \"filename\",\n" +
                "          \"msgBy\": \"1\",\n" +
                "          \"faqId\": \"202012010028\",\n" +
                "          \"isdelete\": \"N\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"msgId\": \"968790e57622adbb017622b33a0b0020\",\n" +
                "          \"msgName\": null,\n" +
                "          \"msg\": \"../../udmp\",\n" +
                "          \"msgType\": \"2\",\n" +
                "          \"fileName\": \"filename\",\n" +
                "          \"msgBy\": \"1\",\n" +
                "          \"faqId\": \"202012010028\",\n" +
                "          \"isdelete\": \"N\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"msgId\": \"968790e57622adbb017622b33a0b001d\",\n" +
                "          \"msgName\": null,\n" +
                "          \"msg\": \"../../udmp\",\n" +
                "          \"msgType\": \"2\",\n" +
                "          \"fileName\": \"filename\",\n" +
                "          \"msgBy\": \"1\",\n" +
                "          \"faqId\": \"202012010028\",\n" +
                "          \"isdelete\": \"N\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"msgId\": \"968790e57622adbb017622b33a0b001e\",\n" +
                "          \"msgName\": null,\n" +
                "          \"msg\": \"../../udmp\",\n" +
                "          \"msgType\": \"2\",\n" +
                "          \"fileName\": \"filename\",\n" +
                "          \"msgBy\": \"1\",\n" +
                "          \"faqId\": \"202012010028\",\n" +
                "          \"isdelete\": \"N\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"img\": [\n" +
                "        {\n" +
                "          \"msgId\": \"968790e57622adbb017622b33a0c0022\",\n" +
                "          \"msgName\": \"突突突2\",\n" +
                "          \"msg\": \"test2222\",\n" +
                "          \"msgType\": \"1\",\n" +
                "          \"fileName\": null,\n" +
                "          \"msgBy\": \"2\",\n" +
                "          \"faqId\": \"202012010028\",\n" +
                "          \"isdelete\": \"N\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"img\": [\n" +
                "        {\n" +
                "          \"msgId\": \"968790e57622adbb017622b33a0c0023\",\n" +
                "          \"msgName\": \"突33333\",\n" +
                "          \"msg\": \"test3333333\",\n" +
                "          \"msgType\": \"1\",\n" +
                "          \"fileName\": null,\n" +
                "          \"msgBy\": \"3\",\n" +
                "          \"faqId\": \"202012010028\",\n" +
                "          \"isdelete\": \"N\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"msgId\": \"968790e57622adbb017622b33a0c0024\",\n" +
                "          \"msgName\": null,\n" +
                "          \"msg\": \"../../udmp333\",\n" +
                "          \"msgType\": \"2\",\n" +
                "          \"fileName\": \"filename33333333\",\n" +
                "          \"msgBy\": \"3\",\n" +
                "          \"faqId\": \"202012010028\",\n" +
                "          \"isdelete\": \"N\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        JSONObject parse = JSON.parseObject(s1);
        Content content = JSONObject.parseObject(parse.toJSONString(), Content.class);
        List<Msg> msg1 = content.getMsg();
//        List<Msg> msg1 = content.getMsg();
//        List<ImageAndText> imgAndText = msg1.get(0).getImgAndText();

        System.out.println("msg : " + msg1);
        JSONArray msg = parse.getJSONArray("msg");
    }
}
