package com.zhuoyue.core.base;

import org.springframework.beans.factory.annotation.Value;

public class DataResponse<T> {
    public static final String SUCCESS = "0"; // 0代表成功
    public static final String SUCCESS_MSG = "处理成功"; // 0代表成功
    public static final String FAILURE = "10001"; //10000开始代表失败
    public static final String FAILURE_MSG = "处理失败"; //10000开始代表失败

    public String code;
    public String message;
    public T data;
    public Integer total;
    public Integer pageSize;

    public DataResponse success(T data) {
        this.code = SUCCESS;
        this.message = SUCCESS_MSG;
        this.data = data;
        return this;
    }

    public DataResponse failure() {
        this.code = FAILURE;
        this.message = FAILURE_MSG;
        return this;
    }

    public DataResponse failure(String message) {
        this.code = FAILURE;
        this.message = message;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
