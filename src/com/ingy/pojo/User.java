package com.ingy.pojo;

import java.util.Objects;

public class User {
    private int uid;
    private String uname;
    private String pwd;

    public User() {
    }

    public User(int uid, String uname, String pwd) {
        this.uid = uid;
        this.uname = uname;
        this.pwd = pwd;
    }

    public int getUid() {
        return uid;
    }

    public String getUname() {
        return uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUid() == user.getUid() &&
                getUname().equals(user.getUname()) &&
                getPwd().equals(user.getPwd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid(), getUname(), getPwd());
    }

    @Override
    public String toString() {
//        return "AAAAAAAAAAAAAA";

        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
