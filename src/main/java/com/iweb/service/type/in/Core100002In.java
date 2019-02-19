package com.iweb.service.type.in;

import com.iweb.service.type.Head;
import com.iweb.service.type.Request;
import com.iweb.validate.Check;

import java.io.Serializable;

/**
 * -------------------------------------------------
 *
 * @ClassName Core12000001In
 * @Auther xiaopeng
 * @Date 2019/2/18 10:00
 * @Version 1.0
 * @Description login.do
 * -------------------------------------------------
 */
public class Core100002In extends Request {

    private static final long serialVersionUID = 1L;

    private Body body;

    private Head head;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public static class Body implements Serializable {

        private static final long serialVersionUID = 1L;

        @Check(desc = "UUID", notNull = true, length = "32")
        private String uuid;

        @Check(desc = "昵称", notNull = false)
        private String nickname;

        @Check(desc = "密码", notNull = false, length = "6~12")
        private String password;

        @Check(desc = "性别", notNull = true, in = "M,F")
        private String gender;

        @Check(desc = "生日", notNull = true, length = "8")
        private String birthday;

        @Check(desc = "国家", notNull = true)
        private String country;

        @Check(desc = "省", notNull = true)
        private String state;

        @Check(desc = "城市", notNull = true)
        private String city;

        @Check(desc = "大学", notNull = true, length = "0~128")
        private String niversity;

        @Check(desc = "签名", notNull = true, length = "0~256")
        private String signature;

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

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
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
    }
}
