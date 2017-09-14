package com.im.status.base.constants;

/**
 * Created by zhizhuang.yang on 2017/9/14.
 */
public enum UserState {

    ENABLE("ENABLE","正常"),
    LOGOFF("LOGOFF","注销"),
    DISABLE("DISABLE","禁用");


    private String stateCode;
    private String stateDesc;

    private UserState(String stateCode,String stateDesc){
        this.stateCode = stateCode;
        this.stateDesc = stateDesc;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateDesc() {
        return stateDesc;
    }

    public void setStateDesc(String stateDesc) {
        this.stateDesc = stateDesc;
    }
}
