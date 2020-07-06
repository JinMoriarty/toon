package com.toon.domain;

import java.util.Date;

public class MarkListVO {
	/*
	markNum number not null,
	userId varchar2(50) not null,
	toonNum number not null,
	addDate date DEFAULT sysdate, 
	 */
	
	private int markNum;
	private String userId;
	private int toonNum;
	private Date addDate;
	
	private int num;
	private String toonName;
	private String toonThumbImg;
	
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getToonName() {
		return toonName;
	}
	public void setToonName(String toonName) {
		this.toonName = toonName;
	}
	public String getToonThumbImg() {
		return toonThumbImg;
	}
	public void setToonThumbImg(String toonThumbImg) {
		this.toonThumbImg = toonThumbImg;
	}
	public int getMarkNum() {
		return markNum;
	}
	public void setMarkNum(int markNum) {
		this.markNum = markNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getToonNum() {
		return toonNum;
	}
	public void setToonNum(int toonNum) {
		this.toonNum = toonNum;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	
	
}
