package com.springboot1.webproject.service;

import java.util.List;

import com.springboot1.webproject.domain.CodeLabelValue;
import com.springboot1.webproject.mapper.CodeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImpl implements CodeService{

    @Autowired
	private CodeMapper mapper;

	@Override
	public List<CodeLabelValue> getCodeClassList() throws Exception {
		return mapper.getCodeClassList();
	}

	@Override
	public List<CodeLabelValue> getCodeList(String classCode) throws Exception {
		return mapper.getCodeList(classCode);
	}
}
