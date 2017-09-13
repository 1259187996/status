package com.im.status.model.user;

import java.io.Serializable;

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
	private String loginTime;//用户登录时间
	private String loginAddr;//用户登录地点
	private String loginPlatform;//用户登录平台
	private String logoutTime;//用户退出时间

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
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime=loginTime;
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
	public String getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(String logoutTime) {
		this.logoutTime=logoutTime;
	}

	@Override
	public String toString() {
		return "TUserLoginLog{" +
				"id=" + id +
				", userId='" + userId + '\'' +
				", loginIp='" + loginIp + '\'' +
				", loginTime='" + loginTime + '\'' +
				", loginAddr='" + loginAddr + '\'' +
				", loginPlatform='" + loginPlatform + '\'' +
				", logoutTime='" + logoutTime + '\'' +
				'}';
	}

	public TUserLoginLog(Integer id, String userId, String loginIp, String loginTime, String loginAddr, String loginPlatform, String logoutTime) {
		this.id = id;
		this.userId = userId;
		this.loginIp = loginIp;
		this.loginTime = loginTime;
		this.loginAddr = loginAddr;
		this.loginPlatform = loginPlatform;
		this.logoutTime = logoutTime;
	}

	public TUserLoginLog() {
	}
}