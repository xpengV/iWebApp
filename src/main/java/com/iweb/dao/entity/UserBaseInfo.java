package com.iweb.dao.entity;

/**
 * -------------------------------------------------
 *
 * @ClassName UserBaseInfo
 * @Auther xiaopeng
 * @Date 2019/2/18 16:30
 * @Version 1.0
 * @Description TODO
 * -------------------------------------------------
 */
public class UserBaseInfo {

    private String uuid;
    private String nickname;
    private String gender;
    private String birthday;
    private String country;
    private String state;
    private String city;
    private String niversity;
    private String signature;

    public UserBaseInfo(){}

    public UserBaseInfo(String uuid, String nickname, String gender, String birthday, String country, String state, String city, String niversity, String signature) {
        this.uuid = uuid;
        this.nickname = nickname;
        this.gender = gender;
        this.birthday = birthday;
        this.country = country;
        this.state = state;
        this.city = city;
        this.niversity = niversity;
        this.signature = signature;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNiversity() {
        return niversity;
    }

    public void setNiversity(String niversity) {
        this.niversity = niversity;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "UserBaseInfo{" +
                "uuid='" + uuid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", niversity='" + niversity + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
