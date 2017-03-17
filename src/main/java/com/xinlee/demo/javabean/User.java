package com.xinlee.demo.javabean;

import java.util.Date;

/**
 * Created by xin.lee on 2017/3/16.
 * 用户JavaBean
 */
public class User {

    private String username;
    private String password;
    private int age;
    private Date birthday;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
