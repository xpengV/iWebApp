package com.iweb.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * -------------------------------------------------
 *
 * @ClassName MessageUtil
 * @Auther xiaopeng
 * @Date 2019/2/18 11:07
 * @Version 1.0
 * @Description TODO
 * -------------------------------------------------
 */
public class MessageUtil {

    private static Logger logger = Logger.getLogger(MessageUtil.class);

    private static MessageUtil singleton = null;

    private MessageUtil(){}

    public static MessageUtil getInstance() {
        if (singleton == null) {
            synchronized (MessageUtil.class) {
                singleton = new MessageUtil();
            }
        }
        if(logger.isDebugEnabled())
            logger.debug("MessageUtil-" + singleton);
        return singleton;
    }

    /**
     * HttpServletRequest post请求的json报文
     * @param request
     * @return
     */
    public JSONObject convertRequest(HttpServletRequest request){
        BufferedReader reader = null;
        String message = "";
        String line = null;
        if(logger.isDebugEnabled()) {
            logger.debug("method--"+request.getMethod());
        }
        if(!"POST".equals(request.getMethod())){
            return null;
        }
        try {
             reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
             while((line = reader.readLine()) != null){
                 String tmp = new String(line.getBytes("GBK"),"UTF-8");
                 message += tmp;
             }
             return JSON.parseObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
