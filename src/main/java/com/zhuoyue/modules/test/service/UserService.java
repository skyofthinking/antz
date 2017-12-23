package com.zhuoyue.modules.test.service;

import com.zhuoyue.core.base.CrudService;
import com.zhuoyue.modules.test.dao.UserDao;
import com.zhuoyue.modules.test.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CrudService<UserDao, User> {
}