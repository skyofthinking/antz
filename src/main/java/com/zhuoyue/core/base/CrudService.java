package com.zhuoyue.core.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

public abstract class CrudService<D extends CrudDao<T>, T extends DataEntity<T>> extends BaseService {

    /**
     * 持久层对象
     */
    @Autowired
    protected D dao;

    /**
     * 获取单条数据
     */
    public T get(String id) {
        return dao.get(id);
    }

    /**
     * 获取单条数据
     */
    public T get(T entity) {
        return dao.get(entity);
    }

    /**
     * 查询列表数据
     */
    public List<T> query(T entity) {
        return dao.query(entity);
    }

    /**
     * 保存数据（插入或更新）
     * 根据uid判断
     */
    public void save(T entity) {
        if (StringUtils.isEmpty(entity.getUid())) {
            entity.preInsert();
            dao.insert(entity);
        } else {
            entity.preUpdate();
            dao.update(entity);
        }
    }

    public void insert(T entity) {
        entity.preInsert();
        dao.insert(entity);
    }

    public void update(T entity) {
        entity.preUpdate();
        dao.update(entity);
    }

    /**
     * 删除数据
     */
    public void delete(T entity) {
        dao.delete(entity);
    }
}