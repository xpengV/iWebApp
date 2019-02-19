package com.iweb.service.type;

import com.iweb.validate.Check;

/**
 * -------------------------------------------------
 *
 * @ClassName Head
 * @Auther xiaopeng
 * @Date 2019/2/18 10:20
 * @Version 1.0
 * @Description TODO
 * -------------------------------------------------
 */
public class Head {

    @Check(desc = "流水号", notNull = false, length = "25")
    private String seqNo;

    @Check(desc = "ip地址", notNull = true)
    private String ipAddress;

    @Check(desc = "交易时间", notNull = false, dateFormat = "yyyy-MM-dd hh:mm:ss")
    private String tranDate;

    @Check(desc = "类型", notNull = true)
    private String model;

    @Check(desc = "方式", notNull = true)
    private String action;

    @Check(desc = "服务标识", notNull = false)
    private String code;

    @Check(desc = "返回码", notNull = true)
    private String retCode;

    @Check(desc = "描述信息", notNull = true)
    private String retMessage;

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }
}