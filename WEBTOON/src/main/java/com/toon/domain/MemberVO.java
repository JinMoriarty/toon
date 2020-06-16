package com.toon.domain;
	
import java.util.Date;

public class MemberVO {
/*
 	userId      varchar2(50)    not null,
    userPass    varchar2(100)   not null,
    userName    varchar2(30)    not null,
    userPhone    varchar2(30)    not null,
    userTag    number    default 0,
    userPoint    number    null,
    regiDate    date            default sysdate,
    verify      number          default 0,
    primary key(userId)
 */
	private String userId;
	private String userPass;
	private String userName;
	private String userPhone;
	private int userTag;
	private int userPoint;
	private Date regiDate;
	private int verify;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public int getUserTag() {
		return userTag;
	}
	public void setUserTag(int userTag) {
		this.userTag = userTag;
	}
	public int getUserPoint() {
		return userPoint;
	}
	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}
	public Date getRegiDate() {
		return regiDate;
	}
	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}
	public int getVerify() {
		return verify;
	}
	public void setVerify(int verify) {
		this.verify = verify;
	}
}
