package com.mylzs.cn.attend.dao;

import com.mylzs.cn.attend.entity.Attend;

public interface AttendMapper {
    int deleteByPrimaryKey(Integer attendId);

    int insert(Attend record);

    int insertSelective(Attend record);

    Attend selectByPrimaryKey(Integer attendId);

    int updateByPrimaryKeySelective(Attend record);

    int updateByPrimaryKey(Attend record);
    Attend   selectTodaySingnRecord(Integer uid);
}