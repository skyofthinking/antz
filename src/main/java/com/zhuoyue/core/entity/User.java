package com.zhuoyue.core.entity;

import com.zhuoyue.core.base.DataEntity;

import java.util.Date;

public class User extends DataEntity<User> {
    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
