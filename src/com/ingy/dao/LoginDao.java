package com.ingy.dao;

import com.ingy.pojo.User;

public interface LoginDao {
    User checkLoginDao(String uname, String pwd);
    User checkLoginDao(String uid);
}
