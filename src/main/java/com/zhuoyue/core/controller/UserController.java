package com.zhuoyue.core.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhuoyue.core.base.BaseController;
import com.zhuoyue.core.base.DataResponse;
import com.zhuoyue.core.entity.User;
import com.zhuoyue.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/query")
    public DataResponse query(User entity) {
        PageHelper.startPage(entity.getPageNo(), entity.getPageSize());
        List<User> users = userService.query(entity);
        PageInfo page = new PageInfo(users);
        int total = (int) page.getTotal();
        DataResponse<List<User>> dataResponse = new DataResponse();
        dataResponse.success(users);
        dataResponse.setTotal(total);
        dataResponse.setPageSize(page.getPageSize());
        return dataResponse;
    }

    @PostMapping("/insert")
    public DataResponse insert(User entity) {
        userService.insert(entity);
        DataResponse<List<User>> dataResponse = new DataResponse();
        return dataResponse.success();
    }

    @PostMapping("/update")
    public DataResponse update(User entity) {
        userService.update(entity);
        DataResponse<List<User>> dataResponse = new DataResponse();
        return dataResponse.success();
    }
}
