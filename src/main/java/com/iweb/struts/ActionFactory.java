package com.iweb.struts;

import java.util.HashMap;
import java.util.Map;

/**
 * -------------------------------------------------
 *
 * @ClassName ActionFactory
 * @Auther xiaopeng
 * @Date 2019/2/14 15:26
 * @Version 1.0
 * @Description TODO
 * -------------------------------------------------
 */
public class ActionFactory {

    protected static HashMap<String, BaseAction> actions = new HashMap<String, BaseAction>();

    private ActionFactory(){};

    public static synchronized BaseAction createAction(String className){
        if(actions.containsKey(className)){
            return actions.get(className);
        }
        BaseAction action = null;
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            action = (BaseAction)loader.loadClass(className).newInstance();
            actions.put(className, action);

            //遍历map
            for(Map.Entry<String,BaseAction> entry : actions.entrySet()){
                String k = entry.getKey();
                String v = entry.getValue().toString();
                System.out.println(k + "-->" + v);
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
            return action;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return action;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return action;
        }
        return action;
    }
}
