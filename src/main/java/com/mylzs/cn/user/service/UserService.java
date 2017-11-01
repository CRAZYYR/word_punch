package com.mylzs.cn.user.service;

import com.mylzs.cn.user.entity.User;

/**
 * Created by Administrator on 17/10/28.
 */
public interface UserService {
   public int createUser(User user);
   public User selectUser(String key,Object tag);
}
