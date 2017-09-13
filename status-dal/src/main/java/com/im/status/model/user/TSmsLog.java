package com.im.status.model.user;

import java.io.Serializable;
import java.util.Date;

public class TSmsLog  implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;//自增Id
	private String moblieNumber;//手机号
	private String smsType;//短信类型
	private String smsCode;//验证码
	private String smsContent;//短信内容
	private String smsStatus;//短信状态
	private Date sendTime;//发送时间

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	public String getMoblieNumber() {
		return moblieNumber;
	}
	public void setMoblieNumber(String moblieNumber) {
		this.moblieNumber=moblieNumber;
	}
	public String getSmsType() {
		return smsType;
	}
	public void setSmsType(String smsType) {
		this.smsType=smsType;
	}
	public String getSmsCode() {
		return smsCode;
	}
	public void setSmsCode(String smsCode) {
		this.smsCode=smsCode;
	}
	public String getSmsContent() {
		return smsContent;
	}
	public void setSmsContent(String smsContent) {
		this.smsContent=smsContent;
	}
	public String getSmsStatus() {
		return smsStatus;
	}
	public void setSmsStatus(String smsStatus) {
		this.smsStatus=smsStatus;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime=sendTime;
	}

	public TSmsLog(Integer id, String moblieNumber, String smsType, String smsCode, String smsContent, String smsStatus, Date sendTime) {
		this.id = id;
		this.moblieNumber = moblieNumber;
		this.smsType = smsType;
		this.smsCode = smsCode;
		this.smsContent = smsContent;
		this.smsStatus = smsStatus;
		this.sendTime = sendTime;
	}

	public TSmsLog() {
	}

	@Override
	public String toString() {
		return "TSmsLog{" +
				"id=" + id +
				", moblieNumber='" + moblieNumber + '\'' +
				", smsType='" + smsType + '\'' +
				", smsCode='" + smsCode + '\'' +
				", smsContent='" + smsContent + '\'' +
				", smsStatus='" + smsStatus + '\'' +
				", sendTime=" + sendTime +
				'}';
	}
}