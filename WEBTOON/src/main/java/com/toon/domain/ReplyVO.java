package com.toon.domain;

import java.util.Date;

public class ReplyVO {

/*  
    gdsNum      number          not null,
    userId    varchar2(50)    not null,
    repNum      number          not null,
    repCon      varchar2(2000)  not null,
    repGood     number null,
    repDate     date            default sysdate,
*/
	private int toonNum;
	private String userId;
	private int repNum;
	private String repCon;
	private int repGood;
	private Date repDate;
	
	public int getToonNum() {
		return toonNum;
	}
	public void setToonNum(int toonNum) {
		this.toonNum = toonNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getRepNum() {
		return repNum;
	}
	public void setRepNum(int repNum) {
		this.repNum = repNum;
	}
	public String getRepCon() {
		return repCon;
	}
	public void setRepCon(String repCon) {
		this.repCon = repCon;
	}
	public int getRepGood() {
		return repGood;
	}
	public void setRepGood(int repGood) {
		this.repGood = repGood;
	}
	public Date getRepDate() {
		return repDate;
	}
	public void setRepDate(Date repDate) {
		this.repDate = repDate;
	}
}