package com.mylzs.cn.vo;

import com.mylzs.cn.common.utils.page.PageQueryBean;

/**
 * Created by Administrator on 17/11/3.
 */
public class QueryCondition extends PageQueryBean {
        private int uid;
    private  String startDate;
    private  String endDate;

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

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
