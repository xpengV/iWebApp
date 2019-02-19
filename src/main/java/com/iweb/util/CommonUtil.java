package com.iweb.util;

import org.apache.log4j.Logger;

import java.util.UUID;

/**
 * -------------------------------------------------
 *
 * @ClassName CommonUtil
 * @Auther xiaopeng
 * @Date 2019/2/19 10:38
 * @Version 1.0
 * @Description TODO
 * -------------------------------------------------
 */
public class CommonUtil {

    public static final String SQL_NAME_SPACE = "com.iweb.dao.namespace.";

    private static Logger logger = Logger.getLogger(CommonUtil.class);

    public synchronized static String getUUID() {

        String uuid = UUID.randomUUID().toString();
//        String uid = uuid.replaceAll("-", "");
        if (logger.isDebugEnabled()) {
            logger.debug("UUID-[" + uuid + "]");
        }
        return uuid;
    }
}
