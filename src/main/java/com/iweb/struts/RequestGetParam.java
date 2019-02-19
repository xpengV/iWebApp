package com.iweb.struts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class RequestGetParam {

    private  ArrayList<String>  list = new ArrayList<String>();

    public  HashMap<String, String> getParamsMap(HttpServletRequest request)
            throws IOException{
        HashMap<String, String>  map = new HashMap<String, String>();
        Enumeration<?> paramNames = request.getParameterNames();
        while(paramNames.hasMoreElements()){
            String paramName = paramNames.nextElement().toString();
            list.add(paramName);
            String[] values = request.getParameterValues(paramName);
            map.put(paramName, values[0]);
        }

        return map;
    }

    public  String getXMLString(String header, HttpServletRequest request)
            throws IOException{
        HashMap<String, String> map = getParamsMap(request);
        Document document = DocumentHelper.createDocument();
        Element rootEl = document.addElement(header);
        for(int i = 0; i < list.size(); i++){
            String key = list.get(i);
            Element el = rootEl.addElement(key);
            el.setText(map.get(key));
        }
        //System.out.println(document.asXML());
        return rootEl.asXML();
    }

    public Document getXMLDoc(String header, HttpServletRequest request)
            throws IOException{
        HashMap<String, String> map = getParamsMap(request);
        Document document = DocumentHelper.createDocument();
        Element rootEl = document.addElement(header);
        for(int i = 0; i < list.size(); i++){
            String key = list.get(i);
            Element el = rootEl.addElement(key);
            el.setText(map.get(key));
        }
        //System.out.println(document.asXML());
        return document;
    }

//    public static void main(String[] args) {
//        Document document = DocumentHelper.createDocument();
//        Element rootEl = document.addElement("header");
//        Element el = rootEl.addElement("body");
//        el.setText("nihao");
//        System.out.println(document.asXML());
//    }
}
