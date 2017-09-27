package com.im.status.model.user;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhizhuang.yang
 * @version 1.0.0
 * @date 2017年9月11日
 * @description 用户登录日志实体类
 */
public class TUserLoginLog  implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;//自增ID
	private String userId;//用户ID
	private String loginIp;//用户登录IP
	private Date loginTime;//用户登录时间
	private String loginAddr;//用户登录地点
	private String userToken;//用户token令牌
	private String loginPlatform;//用户登录平台
	private Date logoutTime;//用户退出时间

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId=userId;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp=loginIp;
	}
	public String getLoginAddr() {
		return loginAddr;
	}
	public void setLoginAddr(String loginAddr) {
		this.loginAddr=loginAddr;
	}
	public String getLoginPlatform() {
		return loginPlatform;
	}
	public void setLoginPlatform(String loginPlatform) {
		this.loginPlatform=loginPlatform;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public TUserLoginLog(Integer id, String userId, String loginIp, Date loginTime, String loginAddr, String userToken, String loginPlatform, Date logoutTime) {
		this.id = id;
		this.userId = userId;
		this.loginIp = loginIp;
		this.loginTime = loginTime;
		this.loginAddr = loginAddr;
		this.userToken = userToken;
		this.loginPlatform = loginPlatform;
		this.logoutTime = logoutTime;
	}

	@Override
	public String toString() {
		return "TUserLoginLog{" +
				"id=" + id +
				", userId='" + userId + '\'' +
				", loginIp='" + loginIp + '\'' +
				", loginTime=" + loginTime +
				", loginAddr='" + loginAddr + '\'' +
				", userToken='" + userToken + '\'' +
				", loginPlatform='" + loginPlatform + '\'' +
				", logoutTime=" + logoutTime +
				'}';
	}

	public TUserLoginLog() {
	}
}