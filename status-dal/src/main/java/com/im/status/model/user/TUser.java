package com.im.status.model.user;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhizhuang.yang
 * @version 1.0.0
 * @date 2017年9月11日
 * @description 用户基础信息实体类
 */
public class TUser implements Serializable{

    private static final Long serialVersionUID = 1L;

    private Integer id;//自增Id
    private String userId;//用户ID
    private String userName;//用户名
    private String password;//用户密码
    private String userIcon;//用户头像
    private String mobileNumber;//用户手机号
    private String userStatus;//用户状态(是否在线等)
    private String userState;//用户状态(禁用等)
    private String userChannel;//用户类别
    private String lastLoginIp;//最后登录IP
    private Date lastLoginTime;//最后登录时间
    private Date registerTime;//注册时间
    private Date lastUpdateTime;//最后修改时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }


    @Override
    public String toString() {
        return "TUser{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userIcon='" + userIcon + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userState='" + userState + '\'' +
                ", userChannel='" + userChannel + '\'' +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", registerTime=" + registerTime +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }

    public TUser(Integer id, String userId, String userName, String password,
                 String userIcon, String mobileNumber, String userStatus, String userState,
                 String userChannel, String lastLoginIp, Date lastLoginTime, Date registerTime, Date lastUpdateTime) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userIcon = userIcon;
        this.mobileNumber = mobileNumber;
        this.userStatus = userStatus;
        this.userState = userState;
        this.userChannel = userChannel;
        this.lastLoginIp = lastLoginIp;
        this.lastLoginTime = lastLoginTime;
        this.registerTime = registerTime;
        this.lastUpdateTime = lastUpdateTime;
    }

    public TUser() {
    }
}
