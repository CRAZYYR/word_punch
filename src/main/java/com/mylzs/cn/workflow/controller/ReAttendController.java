package com.mylzs.cn.workflow.controller;

import com.mylzs.cn.workflow.entity.ReAttend;
import com.mylzs.cn.workflow.service.ReAttendService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
     * @param reAttend
     * @param httpSession
     */
    @RequestMapping("/start")
     public  void  startReAttendFlow(@RequestBody ReAttend  reAttend, HttpSession httpSession)
     {

         reAttend.setReAttendStart("shuaizi");
         reAttendService.startReAttendFlow(reAttend);
     }

    /**
     *
     * @param varibles
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<Task> listReAttendFlow(Map varibles)
    {
        List<Task> tasks=reAttendService.listTask("老刘");
        return  tasks;
    }

    /**
     * 审批
     * @param reAttend
     */
    @RequestMapping("/approve")
    public  void  approveReAttendFlow(@RequestBody ReAttend reAttend)
    {
        reAttendService.approveReAttendFlow(reAttend);
    }
}
