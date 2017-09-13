package com.im.status.model.resp;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhizhuang.yang
 * @version 1.0.0
 * @date 2017年9月11日
 * @description 用户基础信息返参类
 */
public class UserResp implements Serializable{

    private static final Long serialVersionUID = 1L;

    private Integer ids;//自增Id
    private String userIds;//用户ID
    private String userName;//用户名
    private String password;//用户密码
    private String userIcon;//用户头像
    private String mobileNumber;//用户手机号
    private String userStatuss;//用户状态(是否在线等)
    private String userStates;//用户状态(禁用等)
    private String userChannel;//用户类别
    private String lastLoginIp;//最后登录IP
    private Date lastLoginTime;//最后登录时间
    private Date registerTime;//注册时间
    private Date lastUpdateTime;//最后修改时间

    public Integer getIds() {
        return ids;
    }

    public void setIds(Integer ids) {
        this.ids = ids;
    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
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

    public String getUserStatuss() {
        return userStatuss;
    }

    public void setUserStatuss(String userStatuss) {
        this.userStatuss = userStatuss;
    }

    public String getUserStates() {
        return userStates;
    }

    public void setUserStates(String userStates) {
        this.userStates = userStates;
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
        return "UserResp{" +
                "ids=" + ids +
                ", userIds='" + userIds + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userIcon='" + userIcon + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", userStatuss='" + userStatuss + '\'' +
                ", userStates='" + userStates + '\'' +
                ", userChannel='" + userChannel + '\'' +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", registerTime=" + registerTime +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }
}
