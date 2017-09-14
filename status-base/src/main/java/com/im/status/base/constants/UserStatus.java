package com.im.status.base.constants;

/**
 * Created by zhizhuang.yang on 2017/9/14.
 */
public enum UserStatus {

    ON_LINE("ON_LINE","在线"),
    OUT_LINE("ON_LINE","离线"),
    IN_LINE("IN_LINE","隐身");

    private String statusCode;
    private String statusDesc;

    private UserStatus(String statusCode,String statusDesc){
        this.statusCode = statusCode;
        this.statusDesc = statusDesc;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}
