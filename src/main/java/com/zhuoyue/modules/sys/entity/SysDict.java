package com.zhuoyue.modules.sys.entity;

import com.zhuoyue.core.base.DataEntity;

public class SysDict extends DataEntity<SysDict> {

    // 数据值
    private String value;
    // 标签名
    private String label;
    // 类型
    private String type;
    // 描述
    private String description;
    // 排序
    private Integer sort;
    // 父Id
    private String parentId;
    // 是否固定, 0默认为不固定，1固定；固定就不能再去修改
    private int fixed = FIX_FLAG_NO;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getFixed() {
        return fixed;
    }

    public void setFixed(int fixed) {
        this.fixed = fixed;
    }
}
