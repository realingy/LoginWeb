package com.ingy.service;

import com.ingy.pojo.User;

public interface LoginService {
    User checkLoginService(String uname, String pwd);
    User checkLoginService(String uid);
}
