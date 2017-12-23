package com.zhuoyue.modules.sys.dao;

import com.zhuoyue.core.annotation.MyBatisDao;
import com.zhuoyue.core.base.CrudDao;
import com.zhuoyue.modules.sys.entity.SysDict;
import com.zhuoyue.modules.test.entity.User;
import org.springframework.stereotype.Repository;

@MyBatisDao
@Repository
public interface SysDictDao extends CrudDao<SysDict> {

}
