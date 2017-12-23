package com.zhuoyue.core.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

public abstract class BaseEntity<T> implements Serializable {

    @JsonIgnore
    private Integer pageNo;
    @JsonIgnore
    @Value("${page.pageSize}")
    private Integer pageSize;

    private String uid;

    /**
     * 锁定标记（0：固定；1：不固定；）
     */
    public static final int FIX_FLAG_NO = 0;
    public static final int FIX_FLAG_YES = 1;

    public BaseEntity() {
    }

    public BaseEntity(String uid) {
        this();
        this.uid = uid;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 插入之前执行方法，子类实现
     */
    public abstract void preInsert();

    /**
     * 更新之前执行方法，子类实现
     */
    public abstract void preUpdate();
}
