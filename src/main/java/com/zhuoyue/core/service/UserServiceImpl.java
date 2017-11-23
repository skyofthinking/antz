package com.zhuoyue.core.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhuoyue.core.base.DataResponse;
import com.zhuoyue.core.dao.UserDao;
import com.zhuoyue.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public DataResponse query(User entity) {
        PageHelper.startPage(entity.getPageNo(), entity.getPageSize());
        List<User> users = dao.query(entity);
        PageInfo page = new PageInfo(users);
        int total = (int) page.getTotal();
        DataResponse<List<User>> data = new DataResponse();
        data.success(users);
        data.setTotal(total);
        data.setPageSize(page.getPageSize());
        return data;
    }
}