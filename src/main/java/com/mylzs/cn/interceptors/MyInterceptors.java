package com.mylzs.cn.interceptors;

import com.mylzs.cn.common.utils.MyException;
import com.mylzs.cn.user.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 17/10/29.
 */
public class MyInterceptors  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {


        System.out.println("运行preHandle!");
        if ((httpServletRequest.getRequestURI().indexOf("login")>=0) || (httpServletRequest.getRequestURI().indexOf("attend")>=0 ) || ( httpServletRequest.getRequestURI().indexOf("error")>=0)){
            return  true;
        }
       User user= (User) httpServletRequest.getSession().getAttribute("user");
        if (user==null ){

            httpServletResponse.sendRedirect("/login/index.do");
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        System.out.println("运行postHandle!");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        System.out.println("运行afterCompletion!");
    }
}
