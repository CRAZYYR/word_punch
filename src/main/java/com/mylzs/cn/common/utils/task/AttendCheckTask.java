package com.mylzs.cn.common.utils.task;

import com.mylzs.cn.attend.service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 17/11/5.
 */
public class AttendCheckTask {
    @Autowired
    AttendService attendService;
    public  void checkAttend(){
//      插入打卡记录  设置为缺席
        attendService.checkAttend();

    }
}
