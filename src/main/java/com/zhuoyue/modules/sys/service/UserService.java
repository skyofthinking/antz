package com.zhuoyue.modules.sys.service;

import com.zhuoyue.core.base.CrudService;
import com.zhuoyue.modules.sys.dao.UserDao;
import com.zhuoyue.modules.sys.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CrudService<UserDao, User> {
}