package com.mylzs.cn.attend.controller;

import com.mylzs.cn.attend.entity.Attend;
import com.mylzs.cn.attend.service.AttendService;
import com.mylzs.cn.common.utils.MyException;
import org.apache.commons.logging.Log;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by Administrator on 17/11/1.
 */
@Controller
@RequestMapping("/attend")
public class AttendController {

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
    @RequestMapping("/signAttend")
    @ResponseBody
    public String signAttend(){
    Attend attend=new Attend();
    attend.setUid(1);
        Date date=new Date();
        date.getTime();
    attend.setAttendDate(date);
    attend.setAttendWeek(2);

        try {
            attendService.signAttend(attend);
        }catch (Exception e){
        throw new MyException(e.getMessage());
        }

        return "success";
}
}
