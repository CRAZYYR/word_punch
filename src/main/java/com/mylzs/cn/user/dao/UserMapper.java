package com.mylzs.cn.user.dao;

import com.mylzs.cn.user.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(@Param("uid") int uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(@Param("uid") int uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUser(@Param("key") String key,@Param("tag") Object tag);
}