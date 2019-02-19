package com.iweb.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.iweb.service.ServiceFactory;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * -------------------------------------------------
 *
 * @ClassName Test
 * @Auther xiaopeng
 * @Date 2019/2/15 10:52
 * @Version 1.0
 * @Description TODO
 * -------------------------------------------------
 */
public class TestApp {

    @Test
    public void test_01() {
        try {
            URL url = new URL("http://localhost:8080/login.do");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 设置是否向HttpURLConnection输出
            connection.setDoOutput(true);
            // 设置是否从httpUrlConnection读入
            connection.setDoInput(true);
            // 设置请求方式
            connection.setRequestMethod("GET");
            // 设置是否使用缓存
            connection.setUseCaches(true);
            // 设置此 HttpURLConnection 实例是否应该自动执行 HTTP 重定向
            connection.setInstanceFollowRedirects(true);
            // 设置超时时间
            connection.setConnectTimeout(3000);
            // 连接
            connection.connect();
            // 4. 得到响应状态码的返回值 responseCode
            int code = connection.getResponseCode();
            // 5. 如果返回值正常，数据在网络中是以流的形式得到服务端返回的数据
            String msg = "";
            System.out.println("code=" + code);
            if (code == 200 || code != 200) { // 正常响应
                // 从流中读取响应信息
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String line = null;

                while ((line = reader.readLine()) != null) { // 循环从流中读取
                    msg += line + "\n";
                }
                reader.close(); // 关闭流
            }
            // 6. 断开连接，释放资源
            connection.disconnect();

            // 显示响应结果
            System.out.println(msg);

            connection.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void getFile() {
        File file = new File("/resources/service.properties");
    }

    private static Logger logger = Logger.getLogger(Test.class);

    @Test
    public void logTest() {
        for (int i = 1; i < 2; i++) {
            // 记录debug级别的信息
            logger.debug("This is debug message.");
            // 记录info级别的信息
            logger.info("This is info message.");
            // 记录error级别的信息
            logger.error("This is error message.");
        }
        System.out.println(logger.isInfoEnabled());
    }

    /**
     * http post 方式发送json报文
     */
    @Test
    public void postMethodSendJsonMessage() {
        try {
            URL url = new URL("http://localhost:8080/iWebApp.do");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 设置是否向HttpURLConnection输出
            connection.setDoOutput(true);
            // 设置是否从httpUrlConnection读入
            connection.setDoInput(true);
            // 设置请求方式
            connection.setRequestMethod("POST");
            // 设置是否使用缓存
            connection.setUseCaches(true);
            // 设置此 HttpURLConnection 实例是否应该自动执行 HTTP 重定向
            connection.setInstanceFollowRedirects(true);
            // 设置超时时间
            connection.setConnectTimeout(3000);
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            // 连接
            connection.connect();

            DataOutputStream out = new DataOutputStream(connection.getOutputStream());

            String str = "{\n" +
                    "  \"head\": {\n" +
                    "    \"seqNo\": \"201902180001\",\n" +
                    "    \"ipAddress\": \"192.168.0.1\",\n" +
                    "    \"tranDate\": \"20190218\",\n" +
                    "    \"model\": \"mi-5\",\n" +
                    "    \"action\": \"login\",\n" +
                    "    \"code\": \"100001\"\n" +
                    "  },\n" +
                    "  \"body\": {\n" +
                    "    \"nickname\": \"友人A\",\n" +
                    "    \"password\": \"123456\",\n" +
                    "  }\n" +
                    "}";

            JSONObject obj = JSON.parseObject(str);


            String req = JSONObject.toJSONString(obj,true);
            System.out.println(req);
//            out.writeBytes(obj.toString());//这个中文会乱码
            out.write(req.getBytes("UTF-8"));//这样可以处理中文乱码问题
            out.flush();
            out.close();


            // 4. 得到响应状态码的返回值 responseCode
            int code = connection.getResponseCode();
            // 5. 如果返回值正常，数据在网络中是以流的形式得到服务端返回的数据
            String msg = "";
            System.out.println("code=" + code);
            if (code == 200 || code != 200) { // 正常响应
                // 从流中读取响应信息
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String line = null;

                while ((line = reader.readLine()) != null) { // 循环从流中读取
                    msg += line + "\n";
                }
                reader.close(); // 关闭流
            }
            // 6. 断开连接，释放资源
            connection.disconnect();

            // 显示响应结果
            System.out.println(msg);

            connection.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        ServiceFactory.getInstance().createServiceMap();
    }
}
