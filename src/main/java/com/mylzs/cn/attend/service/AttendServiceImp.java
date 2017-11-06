package com.mylzs.cn.attend.service;

import com.mylzs.cn.attend.dao.AttendMapper;
import com.mylzs.cn.attend.entity.Attend;
import com.mylzs.cn.common.utils.DateUtils;
import com.mylzs.cn.common.utils.MyException;
import com.mylzs.cn.common.utils.SerurityUtils;
import com.mylzs.cn.common.utils.page.PageQueryBean;
import com.mylzs.cn.vo.QueryCondition;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 17/11/1.
 */
@Service
public class AttendServiceImp implements  AttendService {
    private static final int NOON_HOUR = 12;
    private static final int NOON_MUNITE = 30;
    private static final Integer ABSENCE_DAY = 480;
    private static final Integer ATTEND_STATUS_ABNORMAL = 2;
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

    /**
     * 分页实现查询
     * @param queryCondition
     * @return
     */
    @Override
    public PageQueryBean listAttend(QueryCondition queryCondition) {
        //根据 条件 查询记录数
     int count= attendMapper.conuntByCondition(queryCondition);
        PageQueryBean pageQueryBean = new PageQueryBean();

     if (count>0){
         pageQueryBean.setTotalRows(count);
         pageQueryBean.setCurrentPage(queryCondition.getCurrentPage());
         pageQueryBean.setPageSize(queryCondition.getPageSize());
      List<Attend> attends =   attendMapper.selectAttendPage(queryCondition);
      pageQueryBean.setItems(attends);
     }
        //有记录才查询
        return pageQueryBean;
    }

    /**
     * 定时任务
     */
    @Override
    public void checkAttend() {
        //查询缺勤用户  ID、插入打卡记录、并且设置为异常    缺勤480分钟
        List<Integer> userIdList=attendMapper.selectTodayAbsence();
        if (CollectionUtils.isNotEmpty(userIdList)){
            List<Attend> attendList = new ArrayList<>();
            for (Integer uid:userIdList){
                Attend attend=new Attend();
                attend.setUid(uid);
                attend.setAttendDate(new Date());
                attend.setAttendWeek(DateUtils.getTodayWeek());
                attend.setAbsence(ABSENCE_DAY);
                attend.setAttendStatus(ATTEND_STATUS_ABNORMAL);
                attendList.add(attend);
            }
            attendMapper.batchInsert(attendList);
        }

        List<Attend> absenceList=attendMapper.selectTodayEveningAbsence();
        if ( CollectionUtils.isNotEmpty(absenceList)){
            for (Attend attend:absenceList){
                attend.setAbsence(ABSENCE_DAY);
                attend.setAttendStatus(ATTEND_STATUS_ABNORMAL);
                attendMapper.updateByPrimaryKeySelective(attend);
            }

        }

    }
}

