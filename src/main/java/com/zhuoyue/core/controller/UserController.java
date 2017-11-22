package com.zhuoyue.core.controller;

import com.zhuoyue.core.base.DataResponse;
import com.zhuoyue.core.entity.User;
import com.zhuoyue.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/query")
    public DataResponse query(User user) {
        return userService.query(user);
    }

}
