package com.zhuoyue.core.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zhuoyue.core.common.IdGen;
import com.zhuoyue.core.entity.User;

import java.util.Date;

public abstract class DataEntity<T> extends BaseEntity<T> {

    private static final long serialVersionUID = 1L;

    protected User createBy;    // 创建者
    protected Date createDate;    // 创建日期
    protected User updateBy;    // 更新者
    protected Date updateDate;    // 更新日期
    protected String remark;    // 备注

    public DataEntity() {
        super();
    }

    public DataEntity(String uid) {
        super(uid);
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    @Override
    public void preInsert() {
        String uuid = IdGen.uuid();
        setUid(uuid);

        this.updateDate = new Date();
        this.createDate = this.updateDate;
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    @Override
    public void preUpdate() {
        this.updateDate = new Date();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemarks(String remark) {
        this.remark = remark;
    }

    @JsonIgnore
    public User getCreateBy() {
        return createBy;
    }

    public void setCreateBy(User createBy) {
        this.createBy = createBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @JsonIgnore
    public User getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(User updateBy) {
        this.updateBy = updateBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}