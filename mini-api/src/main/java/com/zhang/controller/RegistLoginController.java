package com.zhang.controller;


import com.zhang.pojo.Users;
import com.zhang.utils.JSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SUNS3T
 */
@RestController
public class RegistLoginController  {

    @RequestMapping("/regist")
    public JSONResult regist (@RequestBody Users user){
        //1、用户密码不为空
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            return JSONResult.errorMsg("用户名和密码不能为空");
        }
        //2、用户名是否存在
        //3、保存用户，注册信息
        return JSONResult.ok();
    }
	
}
