package com.mylzs.cn.attend.service;

import com.mylzs.cn.attend.dao.AttendMapper;
import com.mylzs.cn.attend.entity.Attend;
import com.mylzs.cn.common.utils.DateUtils;
import com.mylzs.cn.common.utils.MyException;
import com.mylzs.cn.common.utils.SerurityUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 17/11/1.
 */
@Service
public class AttendServiceImp implements  AttendService {
    private static final int NOON_HOUR = 12;
    private static final int NOON_MUNITE = 30;
    private   SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
  private   Log log= LogFactory.getLog(AttendServiceImp.class);
    @Autowired
    AttendMapper attendMapper;
    @Override
    public void signAttend(Attend attend) {
        Log log= LogFactory.getLog(AttendServiceImp.class);
        Date date = new Date();
        Date noon=  DateUtils.getDate(NOON_HOUR,NOON_MUNITE);
        try {
            attend.setAttendDate(date);
            attend.setAttendWeek(DateUtils.getTodayWeek());
            //查看当天
          Attend  todayRecord  =attendMapper.selectTodaySingnRecord(attend.getUid());
          if (todayRecord==null){
//                无打卡记录
              if (date.compareTo(noon)<=0){
                  attend.setAttendMoning(date);
              }else{
                  attend.setAttendEvening(date);
              }
              attendMapper.insertSelective(attend);

          }else {
              //已经打卡了

              if (date.compareTo(noon)<=0){

                  throw  new MyException("已经打过卡了!");
              }else{
                  todayRecord.setAttendEvening(date);
                  attendMapper.updateByPrimaryKeySelective(todayRecord);
              }

          }



        }catch (Exception e){
            log.error("用户签到异常!",e);
            throw e;
        }

    }



}

