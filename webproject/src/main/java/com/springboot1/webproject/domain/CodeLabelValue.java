package com.springboot1.webproject.domain;

import java.io.Serializable;

public class CodeLabelValue implements Serializable{

    private static final long serialVersionUID=5660828349114511155L;

    private String label;
    private String value;

public String getLabel() {
	return this.label;
}
public void setLabel(String label) {
	this.label = label;
}


    public String getValue() {
    	return this.value;
    }
    public void setValue(String value) {
    	this.value = value;
    }


    public CodeLabelValue(){
        super();        
    }
    public CodeLabelValue(String value,String label){
        this.value=value;
        this.label=label;
    }
}