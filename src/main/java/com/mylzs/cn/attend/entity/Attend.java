package com.mylzs.cn.attend.entity;

import java.util.Date;

public class Attend {
    private Integer attendId;

    private Integer uid;

    private Date attendDate;

    private Integer attendWeek;

    private Date attendMoning;

    private Date attendEvening;

    private Integer absence;

    private Integer attendStatus;

    public Integer getAttendId() {
        return attendId;
    }

    public void setAttendId(Integer attendId) {
        this.attendId = attendId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getAttendDate() {
        return attendDate;
    }

    public void setAttendDate(Date attendDate) {
        this.attendDate = attendDate;
    }

    public Integer getAttendWeek() {
        return attendWeek;
    }

    public void setAttendWeek(Integer attendWeek) {
        this.attendWeek = attendWeek;
    }

    public Date getAttendMoning() {
        return attendMoning;
    }

    public void setAttendMoning(Date attendMoning) {
        this.attendMoning = attendMoning;
    }

    public Date getAttendEvening() {
        return attendEvening;
    }

    public void setAttendEvening(Date attendEvening) {
        this.attendEvening = attendEvening;
    }

    public Integer getAbsence() {
        return absence;
    }

    public void setAbsence(Integer absence) {
        this.absence = absence;
    }

    public Integer getAttendStatus() {
        return attendStatus;
    }

    public void setAttendStatus(Integer attendStatus) {
        this.attendStatus = attendStatus;
    }
}