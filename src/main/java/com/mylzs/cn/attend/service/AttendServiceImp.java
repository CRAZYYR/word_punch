package com.mylzs.cn.attend.service;

import com.mylzs.cn.attend.dao.AttendMapper;
import com.mylzs.cn.attend.entity.Attend;
import com.mylzs.cn.common.utils.SerurityUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 17/11/1.
 */
@Service
public class AttendServiceImp implements  AttendService {
    @Autowired
    AttendMapper attendMapper;
    @Override
    public void signAttend(Attend attend) {
        Log log= LogFactory.getLog(AttendServiceImp.class);
        try {
            attendMapper.insertSelective(attend);
        }catch (Exception e){
            log.error("用户签到异常!",e);
            throw e;
        }

    }
}

