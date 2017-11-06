package com.mylzs.cn.attend.dao;

import com.mylzs.cn.attend.entity.Attend;
import com.mylzs.cn.vo.QueryCondition;

import java.util.List;

public interface AttendMapper {
    int deleteByPrimaryKey(Integer attendId);

    int insert(Attend record);

    int insertSelective(Attend record);

    Attend selectByPrimaryKey(Integer attendId);

    int updateByPrimaryKeySelective(Attend record);

    int updateByPrimaryKey(Attend record);
    Attend   selectTodaySingnRecord(Integer uid);

    int conuntByCondition(QueryCondition queryCondition);

    List<Attend> selectAttendPage(QueryCondition queryCondition);

    List<Integer> selectTodayAbsence();

    void batchInsert(List<Attend> attendList);

    List<Attend> selectTodayEveningAbsence();
}