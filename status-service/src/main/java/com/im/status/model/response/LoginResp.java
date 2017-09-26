package com.im.status.model.response;

import com.im.status.base.util.AddressUtils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhizhuang.yang on 2017/9/26.
 */
public class LoginResp implements Serializable {

    private static final long serialVersionUID = 1L;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private String userId;//用户ID
    private String token;//用户凭证(类似于sessionId)
    private String userName;//用户名
    private String userIcon;//用户头像
    private String mobileNumber;//用户手机号
    private String userStatus;//用户状态(是否在线等)
    private String userState;//用户状态(禁用等)
    private String userChannel;//用户类别
    private String lastLoginIp;//上次登录IP
    private String lastLoginAddr;//上次登录地址
    private Date lastLoginTime;//上次登录时间

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getUserChannel() {
        return userChannel;
    }

    public void setUserChannel(String userChannel) {
        this.userChannel = userChannel;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getLastLoginAddr() {
        return AddressUtils.getAddrByIp(this.lastLoginIp);
    }

    public void setLastLoginAddr(String lastLoginAddr) {
        this.lastLoginAddr = lastLoginAddr;
    }

    public String getLastLoginTime() {
        return format.format(lastLoginTime);
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public LoginResp() {
    }

    public LoginResp(String userId, String token, String userName, String userIcon, String mobileNumber, String userStatus, String userState, String userChannel, String lastLoginIp, String lastLoginAddr, Date lastLoginTime) {
        this.userId = userId;
        this.token = token;
        this.userName = userName;
        this.userIcon = userIcon;
        this.mobileNumber = mobileNumber;
        this.userStatus = userStatus;
        this.userState = userState;
        this.userChannel = userChannel;
        this.lastLoginIp = lastLoginIp;
        this.lastLoginAddr = lastLoginAddr;
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "LoginResp{" +
                "userId='" + userId + '\'' +
                ", token='" + token + '\'' +
                ", userName='" + userName + '\'' +
                ", userIcon='" + userIcon + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userState='" + userState + '\'' +
                ", userChannel='" + userChannel + '\'' +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", lastLoginAddr='" + lastLoginAddr + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}
