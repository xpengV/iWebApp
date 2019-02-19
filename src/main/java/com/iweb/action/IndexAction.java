package com.iweb.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.iweb.service.IService;
import com.iweb.service.ServiceFactory;
import com.iweb.service.type.Request;
import com.iweb.struts.BaseAction;
import com.iweb.util.MessageUtil;
import com.iweb.xml.bean.BeanServiceRegister;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * -------------------------------------------------
 *
 * @ClassName IndexAction
 * @Auther xiaopeng
 * @Date 2019/2/14 15:31
 * @Version 1.0
 * @Description TODO
 * -------------------------------------------------
 */
public class IndexAction extends BaseAction {

    private Logger logger = Logger.getLogger(IndexAction.class);

    @Override
    protected String doService(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //1. 编码过滤器
        //2. 获取code编号，根据service_register.xml调用对应的服务
        //3. Check注解校验-每个字段都输出到日志
        //3.1 反射过程中in/out-type是否兼容
        //3.2 dao层
        //3.3 异常处理

        JSONObject reqObj = MessageUtil.getInstance().convertRequest(request);

        String reqStr = JSONObject.toJSONString(reqObj, true);

        if (logger.isDebugEnabled()) {
            logger.debug("" +
                    "\r\n----------------------------------------------------" +
                    "\r\nRequest:" + reqStr + "" +
                    "\r\n----------------------------------------------------" +
                    "\r\n");
        }

        String code = reqObj.getJSONObject("head").getString("code");

        if (logger.isDebugEnabled()) {
            logger.debug("code" + code);
        }

        if ("".equals(code) || code == null) {
            throw new RuntimeException("上送报文服务未注册");
        }


        BeanServiceRegister serviceRegister = ServiceFactory.getInstance().getServiceBean(code);

        if (logger.isDebugEnabled()) {
            logger.debug("服务[" + code + "]对应的接口信息为" + serviceRegister.toString());
        }

        try {
            IService main = (IService) JSON.parseObject(reqStr, Class.forName(serviceRegister.getMain()));
            String resStr = main.doService(reqStr);

            if(resStr != null){
                logger.debug("" +
                        "\r\n----------------------------------------------------" +
                        "\r\nResponse:" + JSONObject.toJSONString(JSONObject.parseObject(resStr),true) + "" +
                        "\r\n----------------------------------------------------" +
                        "\r\n");
                PrintWriter pw = response.getWriter();
                pw.write(resStr);
            }
        } catch (Exception e) {
            throw new RuntimeException("类初始化失败" + e);
        }
        return null; //跳转连接
    }
}
