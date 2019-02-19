package com.iweb.xml.bean;

/**
 * -------------------------------------------------
 *
 * @ClassName BeanServiceRegister
 * @Auther xiaopeng
 * @Date 2019/2/18 14:24
 * @Version 1.0
 * @Description TODO
 * -------------------------------------------------
 */
public class BeanServiceRegister {

    private String code;

    private String action;

    private String main;

    private String in;

    private String out;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    @Override
    public String toString() {
        return "BeanServiceRegister{" +
                "code='" + code + '\'' +
                ", action='" + action + '\'' +
                ", main='" + main + '\'' +
                ", in='" + in + '\'' +
                ", out='" + out + '\'' +
                '}';
    }
}
