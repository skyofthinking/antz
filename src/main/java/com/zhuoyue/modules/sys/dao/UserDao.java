package com.zhuoyue.modules.sys.dao;

import com.zhuoyue.core.annotation.MyBatisDao;
import com.zhuoyue.core.base.CrudDao;
import com.zhuoyue.modules.sys.entity.User;
import org.springframework.stereotype.Repository;

@MyBatisDao
@Repository
public interface UserDao extends CrudDao<User> {

}
