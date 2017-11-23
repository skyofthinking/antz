package com.zhuoyue.core.dao;

import com.zhuoyue.core.annotation.MyBatisDao;
import com.zhuoyue.core.base.CrudDao;
import com.zhuoyue.core.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@MyBatisDao
@Repository
public interface UserDao extends CrudDao<User> {

}
