package com.springboot1.webproject.domain;

import java.io.Serializable;
import java.util.Date;

public class CodeDetail implements Serializable{

    public static final long serialVersionUID=855442078128455643L;

    private String classCode;
    private String codeValue;
    private String codeName;
    private int sortSeq;
    private String useYn;
    private Date regDate;
    private Date updDate;

    public String getClassCode() {
        return this.classCode;
    }
    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }


    public String getCodeValue() {
    	return this.codeValue;
    }
    public void setCodeValue(String codeValue) {
    	this.codeValue = codeValue;
    }


    public String getCodeName() {
    	return this.codeName;
    }
    public void setCodeName(String codeName) {
    	this.codeName = codeName;
    }


    public int getSortSeq() {
    	return this.sortSeq;
    }
    public void setSortSeq(int sortSeq) {
    	this.sortSeq = sortSeq;
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
 

