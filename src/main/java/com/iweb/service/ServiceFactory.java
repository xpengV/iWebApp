package com.iweb.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.iweb.xml.bean.BeanServiceRegister;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * -------------------------------------------------
 *
 * @ClassName ServiceFactory
 * @Auther xiaopeng
 * @Date 2019/2/18 14:31
 * @Version 1.0
 * @Description TODO
 * -------------------------------------------------
 */
public class ServiceFactory {

    private static Logger logger = Logger.getLogger(ServiceFactory.class);

    private static ServiceFactory instance = new ServiceFactory();

    private static final HashMap<String, BeanServiceRegister> serviceMap = new HashMap<>();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        if (instance == null) {
            instance = new ServiceFactory();
        }
        return instance;
    }

    public HashMap<String, BeanServiceRegister> createServiceMap() {

        BufferedReader reader = null;
        String jsonString = "";
        String line = null;

        try {
            reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/service/mapping/service_register.json")));

            while ((line = reader.readLine()) != null) {
                jsonString += line;
            }
        }catch (Exception e){
            throw new RuntimeException("加载服务列表失败：" + e);
        }

        JSONObject jsonObject = JSON.parseObject(jsonString);
        JSONArray jsonArray = jsonObject.getJSONArray("services");

        if (logger.isDebugEnabled()) {
            logger.debug("service.size: " + jsonArray.size());
        }

        int size = jsonArray.size();

        for (int i = 0; i < size; i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            String key = (String) obj.get("code");
            BeanServiceRegister value = JSONArray.parseObject(JSONObject.toJSONString(obj), BeanServiceRegister.class);
            if (logger.isDebugEnabled()) {
                logger.debug("ServiceCode[" + key + "]，Clazz:[" + value + "]，加入服务列表");
            }
            serviceMap.put(key, value);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("ServiceMap:" + serviceMap);
        }
        return serviceMap;
    }


    public BeanServiceRegister getServiceBean(String code){
        return serviceMap.get(code);
    }

}
