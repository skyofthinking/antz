package com.zhuoyue.core.base;

public class DataResponse<T> {

    public String count;
    public T data;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
