package com.zhang.service;

import com.zhang.pojo.Users;

import com.zhang.mapper.UsersMapper;
import org.n3r.idworker.Sid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author by SUNS3T
 * @Classname UserServiceImpl
 * @Description TODO
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UsersMapper userMapper;

    @Resource
    private Sid sid;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExit(String username) {
        Users users = new Users();
        users.setUsername(username);
        Users result = userMapper.selectOne(users);
        return result == null ? false : true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveUser(Users user) {
        //生成全局唯一ID
        String userId = sid.nextShort();
        user.setId(userId);
        userMapper.insert(user);
    }
}
