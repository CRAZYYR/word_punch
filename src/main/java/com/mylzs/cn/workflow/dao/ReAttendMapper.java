package com.mylzs.cn.workflow.dao;

import com.mylzs.cn.workflow.entity.ReAttend;

public interface ReAttendMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReAttend record);

    int insertSelective(ReAttend record);

    ReAttend selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReAttend record);

    int updateByPrimaryKey(ReAttend record);
}