package com.iweb.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * -------------------------------------------------
 *
 * @ClassName Action
 * @Auther xiaopeng
 * @Date 2019/2/14 15:08
 * @Version 1.0
 * @Description TODO
 * -------------------------------------------------
 */
public abstract class BaseAction {

    protected abstract String doService(Map<String,String> map , HttpServletRequest request, HttpServletResponse response)
            throws IOException;
}
