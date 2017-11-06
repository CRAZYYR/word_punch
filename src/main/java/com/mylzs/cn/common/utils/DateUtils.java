package com.mylzs.cn.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 17/11/2.
 */
public class DateUtils {

    private static Calendar calendar= Calendar.getInstance();

    /**
     * 周数的处理 1、2、3、4、5、6、7（星期一、星期二、星期三、星期四、星期五、星期六、星期天）
     * @return
     */
    public static int getTodayWeek(){
        Calendar calendar= Calendar.getInstance();
        calendar.setTime(new Date());
       int week= calendar.get(calendar.DAY_OF_WEEK)-1;
       if (week<=0){return 7;}
   return  week;
    }

    /**
     * 时间差的比较
     * @param start  开始时间
     * @param end    结束时间
     * @return
     */
    public  static int getMunite(Date start,Date end){
        return (int) ((end.getTime()-start.getTime())/(1000*60));
    }

    /**
     * 设置时间戳
     * @param hour
     * @param munite
     * @return
     */
    public  static Date getDate(int hour,int munite){
     calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,munite);
      return   calendar.getTime();
    }

}
