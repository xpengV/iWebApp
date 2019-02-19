package com.iweb.test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import com.iweb.dao.entity.UserBaseInfo;
import com.iweb.service.type.out.Core100002Out;
import com.iweb.util.DBUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class Test1 {

    @Test
    public void main() throws IOException {
        SqlSession session = DBUtil.getSession();

        System.out.println("session" + session);

        String statement = "com.iweb.dao.namespace.getUserBaseInfo";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        UserBaseInfo user = session.selectOne(statement, 7);
        System.out.println(user);
    }

    @Test
    public void reflect(){
        try {
            Constructor constructor = Core100002Out.class.getConstructor();
            System.out.println(constructor);

            Core100002Out o = (Core100002Out) constructor.newInstance();
            Core100002Out.Body body = new Core100002Out.Body();
            body.setUuid("312321");
            System.out.println(o);

            o.setBody(body);

            System.out.println(o.getBody().getUuid());



//            out.getBody().setUuid("UUID12313");
//
//            System.out.println(out.getBody().getUuid());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUUID(){
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号

        System.out.println(uuid.replaceAll("-", ""));
    }
}