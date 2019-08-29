package com.webproject.mapper;

import com.webproject.domain.User;

public interface UserMapper {
    public void signup(User user)throws Exception;
    public User signin(User user)throws Exception;
}