package com.springboot1.webproject.domain;

import java.io.Serializable;
import java.util.Date;

public class CodeClass implements Serializable {

    private static final long serialVersionUID=6621378083749101963L;

    private String classCode;
    private String className;
    private String useYn;
    private Date regDate;
    private Date updDate;

    public String getClassCode() {
        return this.classCode;
    }
    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }


    public String getClassName() {
    	return this.className;
    }
    public void setClassName(String className) {
    	this.className = className;
    }


    public String getUseYn() {
    	return this.useYn;
    }
    public void setUseYn(String useYn) {
    	this.useYn = useYn;
    }


    public Date getRegDate() {
    	return this.regDate;
    }
    public void setRegDate(Date regDate) {
    	this.regDate = regDate;
    }


    public Date getUpdDate() {
    	return this.updDate;
    }
    public void setUpdDate(Date updDate) {
    	this.updDate = updDate;
    }


}