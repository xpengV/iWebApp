package com.iweb.dao.entity;

/**
 * -------------------------------------------------
 *
 * @ClassName IWebLogInfo
 * @Auther xiaopeng
 * @Date 2019/2/19 13:40
 * @Version 1.0
 * @Description TODO
 * -------------------------------------------------
 */
public class IWebLogInfo {

    private String tranDate;
    private String reference;
    private String action;
    private String code;
    private String ipAddress;
    private String time;
    private String doClass;
    private String retCode;
    private String retMessage;
    private String errorReason;
    private String reqJson;
    private String resJson;

    public IWebLogInfo(){}

    public IWebLogInfo(String tranDate, String reference, String action, String code, String ipAddress, String time, String doClass, String retCode, String retMessage, String errorReason, String reqJson, String resJson) {
        this.tranDate = tranDate;
        this.reference = reference;
        this.action = action;
        this.code = code;
        this.ipAddress = ipAddress;
        this.time = time;
        this.doClass = doClass;
        this.retCode = retCode;
        this.retMessage = retMessage;
        this.errorReason = errorReason;
        this.reqJson = reqJson;
        this.resJson = resJson;
    }

    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDoClass() {
        return doClass;
    }

    public void setDoClass(String doClass) {
        this.doClass = doClass;
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

    public String getErrorReason() {
        return errorReason;
    }

    public void setErrorReason(String errorReason) {
        this.errorReason = errorReason;
    }

    public String getReqJson() {
        return reqJson;
    }

    public void setReqJson(String reqJson) {
        this.reqJson = reqJson;
    }

    public String getResJson() {
        return resJson;
    }

    public void setResJson(String resJson) {
        this.resJson = resJson;
    }
}


