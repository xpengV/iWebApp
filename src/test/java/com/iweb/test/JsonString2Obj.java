package com.iweb.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.iweb.service.type.Request;
import com.iweb.service.type.in.Core100001In;
import org.junit.Test;

/**
 * -------------------------------------------------
 *
 * @ClassName JsonString2Obj
 * @Auther xiaopeng
 * @Date 2019/2/18 14:03
 * @Version 1.0
 * @Description TODO
 * -------------------------------------------------
 */
public class JsonString2Obj {

    @Test
    public void test1(){
        String jsonString = "{\n" +
                "  \"head\": {\n" +
                "    \"seqNo\": \"201902180001\",\n" +
                "    \"ipAddress\": \"192.168.0.1\",\n" +
                "    \"tranDate\": \"20190218\",\n" +
                "    \"model\": \"mi-5\",\n" +
                "    \"action\": \"login\",\n" +
                "    \"code\": \"100002\"\n" +
                "  },\n" +
                "  \"body\": {\n" +
                "    \"nickname\": \"一只友人A\",\n" +
                "    \"password\": \"123456\",\n" +
                "    \"gender\": \"M\",\n" +
                "    \"birthday\": \"1990927\",\n" +
                "    \"country\": \"CHN\",\n" +
                "    \"state\": \"61\",\n" +
                "    \"city\": \"612321\",\n" +
                "    \"niversity\": \"西安电子科技大学\",\n" +
                "    \"signature\": \"行车不规范，亲人两行泪！\",\n" +
                "    \"image\":\"\"\n" +
                "  }\n" +
                "}";
        Request in;
        try {

            in = JSON.parseObject(jsonString, Core100001In.class);
        }catch (Exception e){
            throw new RuntimeException("json转换失败" + e);
        }
        System.out.println(in);

        System.out.println(((Core100001In) in).getHead().getIpAddress());

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
