package com.iweb.struts;

import java.io.IOException;
import java.util.Properties;

/**
 * -------------------------------------------------
 *
 * @ClassName Attribute
 * @Auther xiaopeng
 * @Date 2019/2/14 15:28
 * @Version 1.0
 * @Description TODO
 * -------------------------------------------------
 */
public class Attribute {

    private String filePath = null;
    private Properties cache = new Properties();

    public Attribute(String filePath) {
        // TODO Auto-generated constructor stub
        this.filePath = filePath;
        try {

            System.out.println("filePath:"+this.filePath);
            this.cache.load(getClass().getResourceAsStream(this.filePath));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public String getValue(String key){
        if(this.cache.containsKey(key)){
            return this.cache.getProperty(key);
        }
        return null;
    }
}
