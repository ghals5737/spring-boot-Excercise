package com.webproject.domain;

import java.util.Date;

public class Board {

    private int bno;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private int viewCnt;

 public int getViewCnt() {
 	return this.viewCnt;
 }
 public void setViewCnt(int viewCnt) {
 	this.viewCnt = viewCnt;
 }

    private int cateCode;

public int getCateCode() {
	return this.cateCode;
}
public void setCateCode(int cateCode) {
	this.cateCode = cateCode;
}




    public int getBno() {
    	return this.bno;
    }
    public void setBno(int bno) {
    	this.bno = bno;
    }


    public String getTitle() {
    	return this.title;
    }
    public void setTitle(String title) {
    	this.title = title;
    }


    public String getContent() {
    	return this.content;
    }
    public void setContent(String content) {
    	this.content = content;
    }


    public String getWriter() {
    	return this.writer;
    }
    public void setWriter(String writer) {
    	this.writer = writer;
    }


    public Date getRegDate() {
    	return this.regDate;
    }
    public void setRegDate(Date regDate) {
    	this.regDate = regDate;
    }



}