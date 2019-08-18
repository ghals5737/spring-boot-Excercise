package com.web.controller;



import com.web.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class UsersController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private JoinService joinService;

    @PostMapping(value = "/joinRequest")
    public String joinRequest(@RequestParam Map<String,String> paramMap) {

        String userId = paramMap.get("user_id");
        String userPw = paramMap.get("user_pw");
        String userName = paramMap.get("user_name");

        String page = joinService.joinUser(userId , userPw , userName);

        return page;
    }

    @PostMapping("/loginRequest")
    public String loinRequest(@RequestParam Map<String,String> paramMap) {
        String userId = paramMap.get("user_id");
        String userPw = paramMap.get("user_pw");

        String page = loginService.login(userId, userPw);

        return page;

    }

}
