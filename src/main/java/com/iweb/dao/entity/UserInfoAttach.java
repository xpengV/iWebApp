package com.iweb.dao.entity;

/**
 * -------------------------------------------------
 *
 * @ClassName UserInfoAttach
 * @Auther xiaopeng
 * @Date 2019/2/19 14:25
 * @Version 1.0
 * @Description TODO
 * -------------------------------------------------
 */
public class UserInfoAttach {

    private String uuid;
    private String registerData;
    private String password;
    private int pwdErrorTimes;
    private String image;

    public UserInfoAttach(){}

    public UserInfoAttach(String uuid, String registerData, String password, int pwdErrorTimes, String image) {
        this.uuid = uuid;
        this.registerData = registerData;
        this.password = password;
        this.pwdErrorTimes = pwdErrorTimes;
        this.image = image;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRegisterData() {
        return registerData;
    }

    public void setRegisterData(String registerData) {
        this.registerData = registerData;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPwdErrorTimes() {
        return pwdErrorTimes;
    }

    public void setPwdErrorTimes(int pwdErrorTimes) {
        this.pwdErrorTimes = pwdErrorTimes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
