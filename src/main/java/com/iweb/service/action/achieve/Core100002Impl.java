package com.iweb.service.action.achieve;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.iweb.dao.entity.IWebLogInfo;
import com.iweb.dao.entity.UserBaseInfo;
import com.iweb.dao.entity.UserInfoAttach;
import com.iweb.service.IService;
import com.iweb.service.type.Head;
import com.iweb.service.type.Request;
import com.iweb.service.type.Response;
import com.iweb.service.type.in.Core100002In;
import com.iweb.service.type.out.Core100002Out;
import com.iweb.util.CommonUtil;
import com.iweb.util.DBUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import java.util.Date;

/**
 * -------------------------------------------------
 *
 * @ClassName Core100001Impl
 * @Auther xiaopeng
 * @Date 2019/2/18 10:30
 * @Version 1.0
 * @Description TODO
 * -------------------------------------------------
 */
public class Core100002Impl implements IService {

    private static Logger logger = Logger.getLogger(Core100002Impl.class);

    @Override
    public Class<? extends Request> getRequestModel() {
        return Core100002In.class;
    }

    @Override
    public Class<? extends Response> getResponseModel() {
        return Core100002Out.class;
    }

    @Override
    public String doService(String reqJson) {

        SqlSession session = null;
        try {
            Core100002In in = (Core100002In) JSONObject.parseObject(reqJson, getRequestModel());

            //check
            //前置已完成校验

            //生成UUID
            String uuid = CommonUtil.getUUID();
            in.getBody().setUuid(uuid);
            //dao层
            session = DBUtil.getSession();
            if (logger.isDebugEnabled()) {
                logger.debug(session);
            }

            UserBaseInfo userBaseInfo = session.selectOne(CommonUtil.SQL_NAME_SPACE+"queryByNickname",in.getBody().getNickname());

            if(userBaseInfo != null){
                logger.error("用户名已经被使用，请更换！");
                throw new RuntimeException("用户名已经被使用，请更换！");
            }

            session.insert(CommonUtil.SQL_NAME_SPACE + "insertUserBaseInfo", in.getBody());

            session.insert(CommonUtil.SQL_NAME_SPACE + "insertUserInfoAttach",
                    new UserInfoAttach(
                            uuid,
                            in.getHead().getTranDate(),
                            in.getBody().getPassword(),
                            new Integer(0),
                            "/avatar/" + uuid + ".jpg")
            );


            //--------------------输出 aop完成--------------------
            Core100002Out out = new Core100002Out();
            Head head = in.getHead();
            head.setRetCode("000000");
            head.setRetMessage("success");

            Core100002Out.Body body = new Core100002Out.Body();
            body.setUuid(uuid);
            out.setHead(head);
            out.setBody(body);

            String resJson = JSON.toJSONString(out);
            //--------------------输出--------------------

            //记录流水表 后续使用aop完成 ,记录流水的功能独立线程完成，不影响原服务

            //开启session和销毁session使用数据库连接池

            IWebLogInfo iWebLogInfo = new IWebLogInfo();
            iWebLogInfo.setAction(in.getHead().getAction());
            iWebLogInfo.setCode(in.getHead().getCode());
            iWebLogInfo.setDoClass(this.getClass().toString());
            iWebLogInfo.setReqJson(reqJson);
            iWebLogInfo.setResJson(resJson);
            iWebLogInfo.setTime(new Date() + "");
            iWebLogInfo.setIpAddress(in.getHead().getIpAddress());
            iWebLogInfo.setTranDate(in.getHead().getTranDate());
            iWebLogInfo.setErrorReason("");
            iWebLogInfo.setRetCode("000000");
            iWebLogInfo.setRetMessage("success");
            iWebLogInfo.setReference(in.getHead().getSeqNo());

            session.insert(CommonUtil.SQL_NAME_SPACE + "insertIwebLogInfo", iWebLogInfo);
            return resJson;
        } catch (Exception e) {

            logger.error("执行服务异常：" + e);
            throw new RuntimeException("执行服务异常：" + e);
        } finally {
            session.commit();
            if (session != null) {
                session.close();
            }
        }
    }
}
