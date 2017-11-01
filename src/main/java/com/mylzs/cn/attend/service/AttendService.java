package com.mylzs.cn.attend.service;

import com.mylzs.cn.attend.entity.Attend;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 17/11/1.
 */
public interface AttendService {
    /**
     * 打卡
     * @param attend
     */
    public void   signAttend(Attend attend) throws  RuntimeException;
}
