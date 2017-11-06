package com.mylzs.cn.workflow.service;

import com.mylzs.cn.workflow.dao.ReAttendMapper;
import com.mylzs.cn.workflow.entity.ReAttend;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.FastHashMap;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 17/11/6.
 */
@Service
public class ReAttendServiceImp implements  ReAttendService {

    private static final java.lang.String RE_ATTEND_FLOW_ID ="re_attend";
    private static final Integer RE_ATTEND_STSTUS_GONING = 1;
    private static final Integer RE_ATTEND_STSTUS_PASS = 2;
    private static final Integer RE_ATTEND_STSTUS_REFUSE = 3;

    private static final String RE_ATTEND_SIGN = "re_attend";
    private static final String NEXT_HANDLER = "next_handler";
    @Autowired
    ReAttendMapper reAttendMapper;
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
//    @Override
//    public void startReAttendFlow(Map varibles) {
//        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(RE_ATTEND_FLOW_ID,varibles);
//        System.out.println(processInstance.getId()+"------------"+processInstance.getActivityId());
//        Task task= taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
//        System.out.println(task.getId()+"-----"+task.getName());
//        Map<String,Object> map=new HashMap<>();
//  map.put("attend_moning","09:00");
//        map.put("attend_evening","18:30");
//        taskService.complete(task.getId(),map);
//    }


    /**
     * 开始处理提交
     * @param reAttend
     */
    @Override
    public void startReAttendFlow(ReAttend reAttend) {
        reAttend.setCurrentHandler("老刘");
        reAttend.setStatus(RE_ATTEND_STSTUS_GONING);

        Map<String,Object> map=new HashMap<>();
        map.put(RE_ATTEND_SIGN,reAttend);
        map.put(NEXT_HANDLER,reAttend.getCurrentHandler());

                ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("re_attend",map);
        System.out.println(processInstance.getId()+"------------"+processInstance.getActivityId());
        Task task= taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        reAttendMapper.insertSelective(reAttend);

        taskService.complete(task.getId(),map);
    }

//
//    @Override
//    public List<Task> listTask(Map varibles) {
//        List<Task> taskList= taskService.createTaskQuery().taskDefinitionKey("re_attend_approve").active().list();
//        Map<String,Object> map=taskService.getVariables(taskList.get(0).getId());
//        return taskList;
//    }

    /**
     * 处理流程
     * @param username
     * @return
     */
    @Override
    public List<Task> listTask(String username) {
        List<ReAttend> reAttends=new ArrayList<>();
        List<Task> taskList= taskService.createTaskQuery().processVariableValueEquals(username).active().list();
        if (CollectionUtils.isNotEmpty(taskList)){
//            处理任务
            for (Task task :
                    taskList) {

                Map<String,Object> variables=taskService.getVariables(task.getId());
                ReAttend reAttend= (ReAttend) variables.get(RE_ATTEND_SIGN);
                reAttend.setTaskId(task.getId());
                reAttends.add(reAttend);
            }
        }




        return taskList;
    }

//
//    @Override
//    public void approveReAttendFlow(String taskId) {
//        Task task=taskService.createTaskQuery().taskId(taskId).singleResult();
//        taskService.complete(taskId);
//
//    }
    //
    @Override
    public void approveReAttendFlow(ReAttend reAttend) {
        Task task=taskService.createTaskQuery().taskId(reAttend.getTaskId()).singleResult();
        if (RE_ATTEND_STSTUS_PASS .toString().equals(reAttend.getApproveFlag())){
            reAttend.setStatus(RE_ATTEND_STSTUS_PASS);
            reAttendMapper.updateByPrimaryKeySelective(reAttend);
        }else if (RE_ATTEND_STSTUS_REFUSE .toString().equals(reAttend.getApproveFlag())){
            reAttend.setStatus(RE_ATTEND_STSTUS_REFUSE);
            reAttendMapper.updateByPrimaryKeySelective(reAttend);
        }
        taskService.complete(reAttend.getTaskId());

    }


}
