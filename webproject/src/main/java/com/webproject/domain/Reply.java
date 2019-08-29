package com.webproject.domain;

import java.util.Date;

public class Reply {

    private int rno;
    private int bno;
    private String userName;
    private String content;
    private Date regDate;
    private int parent;

 public int getRno() {
 	return this.rno;
 }
 public void setRno(int rno) {
 	this.rno = rno;
 }


    public int getBno() {
    	return this.bno;
    }
    public void setBno(int bno) {
    	this.bno = bno;
    }


    public String getUserName() {
    	return this.userName;
    }
    public void setUserName(String userName) {
    	this.userName = userName;
    }


    public String getContent() {
    	return this.content;
    }
    public void setContent(String content) {
    	this.content = content;
    }


    public Date getRegDate() {
    	return this.regDate;
    }
    public void setRegDate(Date regDate) {
    	this.regDate = regDate;
    }


    public int getParent() {
    	return this.parent;
    }
    public void setParent(int parent) {
    	this.parent = parent;
    }


}
    
