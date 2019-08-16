package com.springboot1.webproject.mapper;

import java.util.List;

import com.springboot1.webproject.domain.CodeClass;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CodeClassMapper {
    public void create(CodeClass codeClass)throws Exception;
    public List<CodeClass> list()throws Exception;
}