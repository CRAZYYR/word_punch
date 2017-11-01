package com.mylzs.cn.login.controller;

import com.mylzs.cn.common.utils.SerurityUtils;
import com.mylzs.cn.user.entity.User;
import com.mylzs.cn.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 17/10/29.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;
    @Qualifier("UserServiceImp")
    @RequestMapping("/index")
    public String login(){
    return "/login/login";
    }
    @RequestMapping("/login")
    public String checkLogin(HttpServletRequest httpServletRequest){
        String uname=httpServletRequest.getParameter("uname").trim();

        String upw=  SerurityUtils.encrpty(httpServletRequest.getParameter("upw").trim()).replace("==","");

       User user= userService.selectUser("uname",uname);

//        验证帐号、密码

        try {
            SerurityUtils.checkExistl(user);
            SerurityUtils.checkequal(upw,user.getUpw());
            HttpSession httpSession=httpServletRequest.getSession();
            httpSession.setAttribute("user",user);
        }catch (Exception e){

            httpServletRequest.setAttribute("message",e.getMessage());

            return  "/login/login";
        }


        return  "redirect:/user/index.do";
    }

    @RequestMapping("/out")
public String loginOut(HttpServletRequest request){
        request.getSession().invalidate();
    return  "/login/login";
}
}
