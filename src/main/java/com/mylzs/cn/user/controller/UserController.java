package com.mylzs.cn.user.controller;

import com.mylzs.cn.user.dao.UserMapper;
import com.mylzs.cn.user.entity.User;
import com.mylzs.cn.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 17/10/28.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private  UserService userService;
    @Qualifier("UserServiceImp")
    @RequestMapping("/index")
    public String user(){


        return "/user/index";
    }

}
