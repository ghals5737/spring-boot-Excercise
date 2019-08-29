package com.webproject.service;

import javax.servlet.http.HttpSession;

import com.webproject.domain.User;
import com.webproject.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;
    
    @Override
    public void signup(User user) throws Exception {
		mapper.signup(user);
	}

    @Override
    public User signin(User user) throws Exception {
        return mapper.signin(user);
    }

    @Override
    public void signout(HttpSession session) {
		session.invalidate();
	}
    
}