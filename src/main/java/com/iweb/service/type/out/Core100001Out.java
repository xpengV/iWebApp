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
public class Core100001Out extends Response {

    private static final long serialVersionUID = 1L;

    private Head head;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

}
