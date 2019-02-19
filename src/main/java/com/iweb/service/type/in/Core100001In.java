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
public class Core100001In extends Request {

    private static final long serialVersionUID = 1L;

    private Head head;

    private Body body;

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

    public static class Body implements Serializable{

        private static final long serialVersionUID = 1L;

        @Check(desc="昵称",notNull=false)
        private String nickname;

        @Check(desc="密码",notNull = false,length = "6")
        private String password;

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
    }
}
