package com.webproject.domain;

import java.util.Date;

public class User {

    private String userId;
    private String userPass;
    private String userName;
    private Date regdate;
    private int verify; 

  public String getUserId() {
  	return this.userId;
  }
  public void setUserId(String userId) {
  	this.userId = userId;
  }


    public String getUserPass() {
    	return this.userPass;
    }
    public void setUserPass(String userPass) {
    	this.userPass = userPass;
    }


    public String getUserName() {
    	return this.userName;
    }
    public void setUserName(String userName) {
    	this.userName = userName;
    }


    public Date getRegdate() {
    	return this.regdate;
    }
    public void setRegdate(Date regdate) {
    	this.regdate = regdate;
    }


    public int getVerify() {
    	return this.verify;
    }
    public void setVerify(int verify) {
    	this.verify = verify;
    }


}