package com.springboot1.webproject.service;

import java.util.List;

import com.springboot1.webproject.domain.CodeLabelValue;

public interface CodeService {

	public List<CodeLabelValue> getCodeClassList() throws Exception;

	public List<CodeLabelValue> getCodeList(String classCode) throws Exception;

}
