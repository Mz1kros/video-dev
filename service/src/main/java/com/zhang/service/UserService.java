package com.zhang.service;

import com.zhang.pojo.Users;

/**
 * @author by SUNS3T
 * @Classname UserService
 * @Description TODO
 */
public interface UserService {
    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    public boolean queryUsernameIsExit(String username);

    public void saveUser(Users user);
}
