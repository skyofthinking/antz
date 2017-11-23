package com.zhuoyue.core.service;

import com.zhuoyue.core.base.CrudService;
import com.zhuoyue.core.dao.UserDao;
import com.zhuoyue.core.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CrudService<UserDao, User> {
}