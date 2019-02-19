package com.iweb.struts;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * -------------------------------------------------
 *
 * @ClassName RequestDistribute
 * @Auther xiaopeng
 * @Date 2019/2/14 15:27
 * @Version 1.0
 * @Description TODO
 * -------------------------------------------------
 */
public class RequestDistribute {

    public void process (HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String doPath = request.getServletPath();

        doPath = doPath.substring(doPath.lastIndexOf("/")+1, doPath.lastIndexOf("."));

        System.out.println("doPath:"+doPath);

        Attribute attribute = new Attribute("/service/mapping/service.properties");

        String className = attribute.getValue(doPath);

        System.out.println("className " + className);

        BaseAction action = ActionFactory.createAction(className);

        if(action==null){
            System.out.println(doPath+":找不到对象Action");
            return;
        }

        Map<String, String> map = new RequestGetParam().getParamsMap(request);

        String page = action.doService(map ,request, response);

        System.out.println("page--" + page);

        if(page==null||page.equals("")){
            return;
        }
        if(page.indexOf("?") > -1){
            response.sendRedirect(page);
            return;
        } else {
            request.getRequestDispatcher(page).forward(request, response);
            return;
        }

    }
}
