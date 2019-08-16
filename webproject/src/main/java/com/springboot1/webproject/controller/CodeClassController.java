package com.springboot1.webproject.controller;


import com.springboot1.webproject.domain.CodeClass;
import com.springboot1.webproject.service.CodeClassService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/codeclass")
public class CodeClassController{

    //@Autowired
    //private CodeClassService service;

    @RequestMapping(value="/register",method=RequestMethod.GET)
    public void registerForm(Model model)throws Exception{
           CodeClass codeClass=new CodeClass();

           model.addAttribute(codeClass);
    }
}