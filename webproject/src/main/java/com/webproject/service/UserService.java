package com.webproject.service;

import javax.servlet.http.HttpSession;

import com.webproject.domain.User;

public interface UserService {
    public void signup(User user)throws Exception;
    public User signin(User user)throws Exception;
    public void signout(HttpSession session);
}