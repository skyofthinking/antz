package com.zhuoyue.modules.sys.service;

import com.zhuoyue.core.base.CrudService;
import com.zhuoyue.modules.sys.dao.SysDictDao;
import com.zhuoyue.modules.sys.entity.SysDict;
import com.zhuoyue.modules.test.dao.UserDao;
import com.zhuoyue.modules.test.entity.User;
import org.springframework.stereotype.Service;

@Service
public class SysDictService extends CrudService<SysDictDao, SysDict> {
}