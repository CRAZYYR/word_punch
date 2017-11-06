package com.mylzs.cn.workflow.service;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.collections.FastHashMap;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 17/11/6.
 */
@Service
public class ReAttendServiceImp implements  ReAttendService {

    private static final java.lang.String RE_ATTEND_FLOW_ID ="re_attend";
    @Autowired
    ReAttendService repositoryService ;
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    TaskService taskService;
    @Autowired
    HistoryService historyService;
    @Autowired
    ManagementService managementService;
    @Override
    public void startReAttendFlow(Map varibles) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(RE_ATTEND_FLOW_ID,varibles);
        System.out.println(processInstance.getId()+"------------"+processInstance.getActivityId());
        Task task= taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        System.out.println(task.getId()+"-----"+task.getName());
        Map<String,Object> map=new HashMap<>();
  map.put("attend_moning","09:00");
        map.put("attend_evening","18:30");
        taskService.complete(task.getId(),map);
    }

    @Override
    public List<Task> listTask(Map varibles) {
        List<Task> taskList= taskService.createTaskQuery().taskDefinitionKey("re_attend_approve").active().list();
        Map<String,Object> map=taskService.getVariables(taskList.get(0).getId());
        return taskList;
    }

    @Override
    public void approveReAttendFlow(String taskId) {
        Task task=taskService.createTaskQuery().taskId(taskId).singleResult();
        taskService.complete(taskId);

    }
}
