package com.web.service;

import com.web.domain.*;
import com.web.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginService {

    @Autowired
    private UserPasswordHashClass userPasswordHashClass;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    HttpSession session;

    public String login(String userId , String userPw) {
        if (userId.equals("") || userPw.equals("")) {
            return "login";
        }

        String hashedPassword = userPasswordHashClass.getSHA256(userPw);
        Users users = usersRepository.findByUserIdAndPassword(userId,hashedPassword);
        if (users == null) {
            return "login";
        }

        session.setAttribute("loginUser",users);

        return "index";
    }

}
