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
import com.iweb.service.type.in.Core100001In;
import com.iweb.service.type.out.Core100001Out;
import com.iweb.service.type.out.Core100002Out;
import com.iweb.util.CommonUtil;
import com.iweb.util.DBUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
public class Core100001Impl implements IService {

    private Logger logger = Logger.getLogger(Core100001Impl.class);

    @Override
    public Class<? extends Request> getRequestModel() {
        return Core100001In.class;
    }

    @Override
    public Class<? extends Response> getResponseModel() {
        return Core100001Out.class;
    }

    @Override
    public String doService(String reqJson) {
        SqlSession session = null;
        String nickname,password;
        try{
            Core100001In in = (Core100001In) JSONObject.parseObject(reqJson,getRequestModel());
            //check
            //前置已完成校验

            //默认userName不允许重复
            nickname = in.getBody().getNickname();
            password = in.getBody().getPassword();
            Map<String,String> para = new HashMap<>();
            para.put("nickname",nickname);
            session = DBUtil.getSession();
            UserBaseInfo info1 = session.selectOne(CommonUtil.SQL_NAME_SPACE+"queryByNickname",para);

            if(info1 == null){
                logger.debug("该用户不存在");
                throw new RuntimeException("该用户不存在");
            }

            para.put("password",password);
            UserBaseInfo info2 = session.selectOne(CommonUtil.SQL_NAME_SPACE+"queryByNickname",para);

            if(info2 == null) {
//                throw new RuntimeException("密码错误");
                para.remove("password");
                UserInfoAttach attach = session.selectOne(CommonUtil.SQL_NAME_SPACE+"queryErrorTimes",para);
                logger.debug("密码错误次数：["+attach.getPwdErrorTimes()+"]");

                if(attach.getPwdErrorTimes()>=5){
                    throw new RuntimeException("错误次数超限");
                }else{
                    throw new RuntimeException("密码错误！");
                }
            }else{
                //累计错误次数
                Map<String,Object> map = new HashMap<>();
                map.put("nickname",nickname);
                map.put("pwdErrorTimes",new Integer(0));
                session.update(CommonUtil.SQL_NAME_SPACE+"addErrorTimes",map);
                logger.debug("登陆成功");
            }
            //输出
            Core100001Out out = new Core100001Out();
            Head head = in.getHead();
            head.setRetCode("000000");
            head.setRetMessage("success");
            out.setHead(head);

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

        }catch (Exception e){
            logger.error(e);
            throw new RuntimeException(e);
        }finally {
            session.commit();
            if(session != null){
                session.close();
            }
        }
    }
}
