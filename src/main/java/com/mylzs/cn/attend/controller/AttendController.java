package com.mylzs.cn.attend.controller;

import com.github.pagehelper.PageHelper;
import com.mylzs.cn.attend.entity.Attend;
import com.mylzs.cn.attend.service.AttendService;
import com.mylzs.cn.common.utils.MyException;
import com.mylzs.cn.common.utils.page.PageQueryBean;
import com.mylzs.cn.user.entity.User;
import com.mylzs.cn.vo.QueryCondition;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Administrator on 17/11/1.
 */
@Controller
@RequestMapping("/attend")
public class AttendController {
Log  log= LogFactory.getLog(AttendController.class);
    @Autowired
    private AttendService attendService;
    /***
     * 打卡记录页面
     */
    @RequestMapping("/index")
    public  String  ToAttend(){
        return "/attend/historicalRecord";
    }

    /**
     * 打卡接口地址
     *
     * @return
     */
    @RequestMapping(value = "/signAttend")
    @ResponseBody
    public String signAttend(HttpServletRequest httpServletRequest){
        Attend attend=new Attend();
       String suid= httpServletRequest.getParameter("uid");
       int uid=Integer.parseInt(suid);
        attend.setUid(uid);
        try {
            attendService.signAttend(attend);
        }catch (Exception e){
            log.debug(e);
        throw new MyException(e.getMessage());
        }

        return "success";
}

    /**
     * 分页查询
     * @param queryCondition
     * @return
     */
    @RequestMapping("/signList")
    @ResponseBody
    public PageQueryBean pageQueryBeanList( QueryCondition queryCondition ,HttpServletRequest httpServletRequest){
        User user= (User) httpServletRequest.getSession().getAttribute("user");
        queryCondition.setUid(user.getUid());
              PageQueryBean pageQueryBean = attendService.listAttend(queryCondition);

              return  pageQueryBean;
        }

}
