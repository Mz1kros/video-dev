package com.zhang.controller;


import com.zhang.pojo.Users;
import com.zhang.service.UserService;
import com.zhang.utils.JSONResult;
import com.zhang.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author SUNS3T
 */
@RestController
@Api(value = "用户注册登录的接口", tags = {"注册和登录的controller"})
public class RegistLoginController  {

    @Resource
    private UserService userService;

    @ApiOperation(value = "用户注册", notes = "用户注册的接口")
    @RequestMapping("/regist")
    public JSONResult regist (@RequestBody Users user) throws Exception {
        //1、用户密码不为空
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            return JSONResult.errorMsg("用户名和密码不能为空");
        }
        //2、用户名是否存在
        boolean usernameIsExist = userService.queryUsernameIsExit(user.getUsername());
        //3、保存用户，注册信息
        if (!usernameIsExist) {
            user.setNickname(user.getUsername());
            user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
            user.setFansCounts(0);
            user.setReceiveLikeCounts(0);
            user.setFollowCounts(0);
            userService.saveUser(user);
        }else {
            return JSONResult.errorMsg("用户名已存在");
        }
        return JSONResult.ok();
    }
	
}
