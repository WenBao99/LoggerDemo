package com.wenbao.controller;

import com.wenbao.bean.User;
import com.wenbao.service.UserService;
import com.wenbao.utils.Logger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wenbao
 * @data 2022/2/22
 * @Tip
 */
@RestController
@Api("用户CURD")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/findAll")
    @ApiOperation(value = "查询用户信息")
    @Logger(loggerModel = "查询", loggerType = "POST", loggerDesc = "查询用户信息")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/addOrUpdateUser")
    @ApiOperation(value = "添加或修改用户")
    @Logger(loggerModel = "添加、修改", loggerType = "POST", loggerDesc = "添加或修改用户")
    public void addOrUpdateUser(@RequestBody User user) {
        userService.addOrUpdateUser(user);
    }

    @GetMapping("deleteById")
    @ApiOperation(value = "通过id删除用户")
    @Logger(loggerModel = "删除", loggerType = "GET", loggerDesc = "通过id删除用户")
    public void deleteById(Integer id) {
        userService.deleteById(id);
    }


}
