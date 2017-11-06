package com.mylzs.cn.workflow.service;

import com.mylzs.cn.workflow.entity.ReAttend;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 17/11/6.
 */
public interface ReAttendService {

//    void startReAttendFlow(Map varibles);
void startReAttendFlow(ReAttend reAttend);
//    List<Task> listTask(Map varibles);
    List<Task> listTask(String username);
//    void approveReAttendFlow(String taskId);
void approveReAttendFlow(ReAttend reAttendS);
}
