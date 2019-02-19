package com.iweb.service.type.out;

import com.iweb.service.type.Head;
import com.iweb.service.type.Response;
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
public class Core100002Out extends Response {

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

    public static class Body implements Serializable {

        private static final long serialVersionUID = 1L;

        @Check(desc = "uuid", notNull = false,length = "16")
        private String uuid;

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }
    }
}
