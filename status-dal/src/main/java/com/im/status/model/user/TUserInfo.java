package com.im.status.model.user;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhizhuang.yang
 * @version 1.0.0
 * @date 2017年9月11日
 * @description 用户资料信息实体类
 */
public class TUserInfo  implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;//自增ID
	private String userId;//用户名
	private String nickName;//用户昵称
	private String realName;//用户真实姓名
	private String userSign;//用户签名
	private String userQq;//用户QQ
	private String userSex;//用户性别
	private Date userBirthday;//用户生日
	private String userEmail;//用户邮箱
	private String userAddr;//用户地址
	private String userIdcard;//用户身份证号
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Date updateUser;//修改人


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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUserSign() {
		return userSign;
	}

	public void setUserSign(String userSign) {
		this.userSign = userSign;
	}

	public String getUserQq() {
		return userQq;
	}

	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getUserIdcard() {
		return userIdcard;
	}

	public void setUserIdcard(String userIdcard) {
		this.userIdcard = userIdcard;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Date updateUser) {
		this.updateUser = updateUser;
	}

	@Override
	public String toString() {
		return "TUserInfo{" +
				"id=" + id +
				", userId='" + userId + '\'' +
				", nickName='" + nickName + '\'' +
				", realName='" + realName + '\'' +
				", userSign='" + userSign + '\'' +
				", userQq='" + userQq + '\'' +
				", userSex='" + userSex + '\'' +
				", userBirthday=" + userBirthday +
				", userEmail='" + userEmail + '\'' +
				", userAddr='" + userAddr + '\'' +
				", userIdcard='" + userIdcard + '\'' +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				", updateUser=" + updateUser +
				'}';
	}

	public TUserInfo(Integer id, String userId, String nickName, String realName, String userSign,
					 String userQq, String userSex, Date userBirthday, String userEmail, String userAddr,
					 String userIdcard, Date createTime, Date updateTime, Date updateUser) {
		this.id = id;
		this.userId = userId;
		this.nickName = nickName;
		this.realName = realName;
		this.userSign = userSign;
		this.userQq = userQq;
		this.userSex = userSex;
		this.userBirthday = userBirthday;
		this.userEmail = userEmail;
		this.userAddr = userAddr;
		this.userIdcard = userIdcard;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
	}
}