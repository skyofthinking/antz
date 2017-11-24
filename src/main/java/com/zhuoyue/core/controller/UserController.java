package com.zhuoyue.core.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhuoyue.core.base.BaseController;
import com.zhuoyue.core.base.DataResponse;
import com.zhuoyue.core.entity.User;
import com.zhuoyue.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/query", consumes = "application/json")
    public DataResponse query(@RequestBody User entity) {
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

    // 获取指定Id的用户
    @GetMapping(value = "/get/{uid}", produces = "application/json")
    public DataResponse get(@PathVariable("uid") String uid) {
        User user = (User) userService.get(uid);
        List<User> users = new ArrayList();
        users.add(user);
        DataResponse<List<User>> dataResponse = new DataResponse();
        return dataResponse.success(users);
    }

    @PutMapping(value = "/insert", consumes = "application/json")
    public DataResponse insert(@RequestBody @Valid User entity) {
        userService.insert(entity);
        DataResponse<List<User>> dataResponse = new DataResponse();
        return dataResponse.success();
    }

    @PutMapping(value = "/update", consumes = "application/json")
    public DataResponse update(@RequestBody @Valid User entity) {
        userService.update(entity);
        DataResponse<List<User>> dataResponse = new DataResponse();
        return dataResponse.success();
    }

    @DeleteMapping(value = "/delete", consumes = "application/json")
    public DataResponse delete(@RequestBody @Valid User entity) {
        userService.update(entity);
        DataResponse<List<User>> dataResponse = new DataResponse();
        return dataResponse.success();
    }
}
