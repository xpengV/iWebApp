package com.iweb.util;

import com.iweb.dao.entity.UserBaseInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.InputStream;

/**
 * -------------------------------------------------
 *
 * @ClassName DBUtil
 * @Auther xiaopeng
 * @Date 2019/2/19 9:20
 * @Version 1.0
 * @Description TODO
 * -------------------------------------------------
 */
public class DBUtil {

    private static final String RESOURCE_FILE = "/config/mybatis.xml";

    private static Logger logger = Logger.getLogger(DBUtil.class);

    private static DBUtil instance = new DBUtil();

    private DBUtil(){}

    public static SqlSession getSession(){
        InputStream is = DBUtil.class.getResourceAsStream(RESOURCE_FILE);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        return session;
    }


}
