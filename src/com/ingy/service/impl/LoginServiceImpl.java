package com.ingy.service.impl;

import com.ingy.dao.LoginDao;
import com.ingy.dao.impl.LoginDaoImpl;
import com.ingy.pojo.User;
import com.ingy.service.LoginService;

public class LoginServiceImpl implements LoginService {

    //创建Dao层过度向
    LoginDao ld=new LoginDaoImpl();

    @Override
    public User checkLoginService(String uname, String pwd) {
        return ld.checkLoginDao(uname, pwd);
    }

    @Override
    public User checkLoginService(String uid) {
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@"+uid);
        return ld.checkLoginDao(uid);
    }
}
