package com.im.status.model.user;

import java.io.Serializable;

/**
 * @author zhizhuang.yang
 * @version 1.0.0
 * @date 2017年9月11日
 * @description 用户密码修改日志实体类
 */
public class TUserPwdLog  implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;//自增ID
	private String userId;//用户ID(密码被修改者)
	private String password;//旧密码
	private String updateIp;//修改时用户IP
	private String updateAddr;//修改时地点
	private String updateChannel;//修改方式
	private String updateUser;//修改人用户ID
	private String updateTime;//修改时间

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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getUpdateIp() {
		return updateIp;
	}
	public void setUpdateIp(String updateIp) {
		this.updateIp=updateIp;
	}
	public String getUpdateAddr() {
		return updateAddr;
	}
	public void setUpdateAddr(String updateAddr) {
		this.updateAddr=updateAddr;
	}
	public String getUpdateChannel() {
		return updateChannel;
	}
	public void setUpdateChannel(String updateChannel) {
		this.updateChannel=updateChannel;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser=updateUser;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime=updateTime;
	}

	@Override
	public String toString() {
		return "TUserPwdLog{" +
				"id=" + id +
				", userId='" + userId + '\'' +
				", password='" + password + '\'' +
				", updateIp='" + updateIp + '\'' +
				", updateAddr='" + updateAddr + '\'' +
				", updateChannel='" + updateChannel + '\'' +
				", updateUser='" + updateUser + '\'' +
				", updateTime='" + updateTime + '\'' +
				'}';
	}

	public TUserPwdLog(Integer id, String userId, String password, String updateIp, String updateAddr, String updateChannel, String updateUser, String updateTime) {
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.updateIp = updateIp;
		this.updateAddr = updateAddr;
		this.updateChannel = updateChannel;
		this.updateUser = updateUser;
		this.updateTime = updateTime;
	}
}