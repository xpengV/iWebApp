package com.iweb.struts;

import com.iweb.service.ServiceFactory;
import com.iweb.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ActionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.process(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.process(request,response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        ServiceFactory.getInstance().createServiceMap();
    }

    protected void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        System.out.println("re"+request.getServletPath());
        new RequestDistribute().process(request, response);

    }
}
