package com.mylzs.cn.workflow.controller;

import com.mylzs.cn.workflow.service.ReAttendService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 17/11/6.
 */
@Controller
@RequestMapping("/reAttend")
public class ReAttendController {
    @Autowired
    private ReAttendService reAttendService;

    /**
     * 开启工作流
     * @param varibles
     */
    @RequestMapping("/start")
     public  void  startReAttendFlow(Map varibles)
     {

         reAttendService.startReAttendFlow(varibles);
     }

    /**
     *
     * @param varibles
     * @return
     */
    @RequestMapping("/list")
    public List<Task> listReAttendFlow(Map varibles)
    {
        List<Task> tasks=reAttendService.listTask(varibles);
        return  tasks;
    }

    /**
     *
     * @param taskId
     */
    @RequestMapping("/approve/{taskId}")
    public  void  approveReAttendFlow(@PathVariable String taskId)
    {
        reAttendService.approveReAttendFlow(taskId);
    }
}
