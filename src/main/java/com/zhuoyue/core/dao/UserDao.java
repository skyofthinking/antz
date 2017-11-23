package com.zhuoyue.core.dao;

import com.zhuoyue.core.annotation.MyBatisDao;
import com.zhuoyue.core.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@MyBatisDao
@Repository
public interface UserDao {

    List<User> query(User entity);

    int count(User entity);

    int insert(User user);

    int update(User user);

    int delete(User entity);
}
