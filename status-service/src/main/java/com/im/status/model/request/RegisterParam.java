package com.im.status.model.request;

import java.io.Serializable;

/**
 * Created by zhizhuang.yang on 2017/9/12.
 */
public class RegisterParam implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userName;//用户名
    private String password;//密码
    private String smsCode;//验证码
    private String channel;//渠道

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "RegisterParam{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", smsCode='" + smsCode + '\'' +
                ", channel='" + channel + '\'' +
                '}';
    }
}
