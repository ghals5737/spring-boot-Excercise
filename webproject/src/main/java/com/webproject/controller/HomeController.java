package com.webproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController{
   // private static final Logger logger=LoggerFactory.getLogger(UserController.class);
    @GetMapping("/")
    public String getHome()throws Exception{       
       return "index";
    }
}