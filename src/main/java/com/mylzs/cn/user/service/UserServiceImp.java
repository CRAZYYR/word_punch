package com.mylzs.cn.user.service;

import com.mylzs.cn.user.dao.UserMapper;
import com.mylzs.cn.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 17/10/28.
 */
@Service("UserServiceImp")
public class UserServiceImp implements UserService {

    @Autowired
    private  UserMapper userMapper;
    @Override
    public int createUser(User user) {


        return
                userMapper.insert(user);
    }

    @Override
    public User selectUser(String key,Object tag) {
       User user= userMapper.selectUser(key,tag);
        return user;
    }
}
