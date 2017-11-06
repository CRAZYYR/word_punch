package com.mylzs.cn.vo;

import com.mylzs.cn.common.utils.page.PageQueryBean;

import java.util.Date;

/**
 * Created by Administrator on 17/11/3.
 */
public class QueryCondition extends PageQueryBean {
    private  int attendStatus;



    private int uid;
    private  String startDate;
    private  String endDate;
    public int getAttendStatus() {
        return attendStatus;
    }

    public void setAttendStatus(int attendStatus) {
        this.attendStatus = attendStatus;
    }
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate)
    {
        Date date = new Date();
        this.endDate  = (endDate == "")? date.toString():endDate;
    }
}
