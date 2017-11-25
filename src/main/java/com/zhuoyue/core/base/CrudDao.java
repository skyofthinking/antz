package com.zhuoyue.core.base;

import java.util.List;

public interface CrudDao<T> extends BaseDao {

    /**
     * 获取单条数据
     */
    public T get(String id);

    /**
     * 获取单条数据
     */
    public T get(T entity);

    /**
     * 查询数据列表
     */
    public List<T> query(T entity);

    /**
     * 查询所有数据列表
     */
    public List<T> all(T entity);

    /**
     * 插入数据
     */
    public int insert(T entity);

    /**
     * 更新数据
     */
    public int update(T entity);

    /**
     * 删除数据
     */
    public int delete(T entity);

    /**
     * 删除数据
     */
    public int delete(String uid);

    /**
     * 获取数据量
     */
    public int count(T entity);
}
