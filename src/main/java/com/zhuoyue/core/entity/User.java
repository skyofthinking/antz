package com.zhuoyue.core.entity;

import com.zhuoyue.core.base.BaseEntity;

import java.util.Date;

public class User extends BaseEntity {
    private String name;
    private String sex;
    private Date createDate;

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
