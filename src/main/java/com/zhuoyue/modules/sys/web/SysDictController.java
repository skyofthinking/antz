package com.zhuoyue.modules.sys.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhuoyue.core.base.BaseController;
import com.zhuoyue.core.base.DataResponse;
import com.zhuoyue.modules.sys.entity.SysDict;
import com.zhuoyue.modules.sys.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/sysDict")
public class SysDictController extends BaseController {

    @Autowired
    private SysDictService sysDictService;

    @GetMapping(value = "/all")
    public DataResponse all(SysDict entity) {
        PageHelper.startPage(entity.getPageNo(), entity.getPageSize());
        List<SysDict> SysDicts = sysDictService.query(entity);
        PageInfo page = new PageInfo(SysDicts);
        int total = (int) page.getTotal();
        DataResponse<List<SysDict>> dataResponse = new DataResponse();
        dataResponse.success(SysDicts);
        dataResponse.setTotal(total);
        dataResponse.setPageSize(page.getPageSize());
        return dataResponse;
    }

    @GetMapping(value = "/query")
    public DataResponse query(SysDict entity) {
        PageHelper.startPage(entity.getPageNo(), entity.getPageSize());
        List<SysDict> SysDicts = sysDictService.query(entity);
        PageInfo page = new PageInfo(SysDicts);
        int total = (int) page.getTotal();
        DataResponse<List<SysDict>> dataResponse = new DataResponse();
        dataResponse.success(SysDicts);
        dataResponse.setTotal(total);
        dataResponse.setPageSize(page.getPageSize());
        return dataResponse;
    }

    // 获取指定Id的用户
    @GetMapping(value = "/get/{uid}", produces = "application/json")
    public DataResponse get(@PathVariable("uid") String uid) {
        SysDict SysDict = sysDictService.get(uid);
        List<SysDict> SysDicts = new ArrayList();
        SysDicts.add(SysDict);
        DataResponse<List<SysDict>> dataResponse = new DataResponse();
        return dataResponse.success(SysDicts);
    }

    @PutMapping(value = "/insert", consumes = "application/json")
    public DataResponse insert(@RequestBody @Valid SysDict entity) {
        sysDictService.save(entity);
        DataResponse<List<SysDict>> dataResponse = new DataResponse();
        return dataResponse.success();
    }

    @PutMapping(value = "/update", consumes = "application/json")
    public DataResponse update(@RequestBody @Valid SysDict entity) {
        sysDictService.save(entity);
        DataResponse<List<SysDict>> dataResponse = new DataResponse();
        return dataResponse.success();
    }

    @DeleteMapping(value = "/delete/{uid}", produces = "application/json")
    public DataResponse delete(@PathVariable("uid") String uid) {
        sysDictService.delete(uid);
        DataResponse<List<SysDict>> dataResponse = new DataResponse();
        return dataResponse.success();
    }

    @DeleteMapping(value = "/batchdelete/{uids}", produces = "application/json")
    public DataResponse batchdelete(@PathVariable("uids") String uids) {
        sysDictService.batchdelete(uids);
        DataResponse<List<SysDict>> dataResponse = new DataResponse();
        return dataResponse.success();
    }
}
