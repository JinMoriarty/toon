package com.toon.domain;

import java.util.Date;

public class ToonVO {
	/*
 	create table tbl_toon (
    toonNum       number          not null,
    toonName      varchar2(50)    not null,
    toonGenre     varchar2(30)   not null,
    cateCode     varchar2(30)    not null,
    toonFin     number           null,
    toonCash number 	   null,
    toonView     number         null,
    toonGood number 	   null,
    toonDes       varchar(500)   null,
    toonImg       varchar(200)   null,
    toonDate      date            default sysdate,
    primary key(toonNum)  
	*/
	private int toonNum;
	private String toonName;
	private String toonGenre;
	private int cateCode;
	private int toonFin;
	private int toonCash;
	private int toonView;
	private int toonGood;
	private String toonDes;
	private String toonImg;
	private Date toonDate;
	
	public int getToonNum() {
		return toonNum;
	}
	public void setToonNum(int toonNum) {
		this.toonNum = toonNum;
	}
	public String getToonName() {
		return toonName;
	}
	public void setToonName(String toonName) {
		this.toonName = toonName;
	}
	public String getToonGenre() {
		return toonGenre;
	}
	public void setToonGenre(String toonGenre) {
		this.toonGenre = toonGenre;
	}
	public int getCateCode() {
		return cateCode;
	}
	public void setCateCode(int cateCode) {
		this.cateCode = cateCode;
	}
	public int getToonFin() {
		return toonFin;
	}
	public void setToonFin(int toonFin) {
		this.toonFin = toonFin;
	}
	public int getToonCash() {
		return toonCash;
	}
	public void setToonCash(int toonCash) {
		this.toonCash = toonCash;
	}
	public int getToonView() {
		return toonView;
	}
	public void setToonView(int toonView) {
		this.toonView = toonView;
	}
	public int getToonGood() {
		return toonGood;
	}
	public void setToonGood(int toonGood) {
		this.toonGood = toonGood;
	}
	public String getToonDes() {
		return toonDes;
	}
	public void setToonDes(String toonDes) {
		this.toonDes = toonDes;
	}
	public String getToonImg() {
		return toonImg;
	}
	public void setToonImg(String toonImg) {
		this.toonImg = toonImg;
	}
	public Date getToonDate() {
		return toonDate;
	}
	public void setToonDate(Date toonDate) {
		this.toonDate = toonDate;
	}
	
	
}