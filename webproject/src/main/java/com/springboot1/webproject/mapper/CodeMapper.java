package com.springboot1.webproject.mapper;

import java.util.List;

import com.springboot1.webproject.domain.CodeLabelValue;

public interface CodeMapper {
    public List<CodeLabelValue> getCodeClassList() throws Exception;

	public List<CodeLabelValue> getCodeList(String classCode) throws Exception;
}
