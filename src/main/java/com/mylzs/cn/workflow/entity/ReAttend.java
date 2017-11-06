package com.mylzs.cn.workflow.entity;

import java.io.Serializable;
import java.util.Date;

public class ReAttend implements Serializable{
    private Integer id;

    private Integer attendId;

    private String reAttendStart;

    private Date reAttendEven;

    private Date reAttendMor;

    private String currentHandler;

    private Integer status;
    private String taskId;
    private  String approveFlag;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getApproveFlag() {
        return approveFlag;
    }

    public void setApproveFlag(String approveFlag) {
        this.approveFlag = approveFlag;
    }

    private String comments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttendId() {
        return attendId;
    }

    public void setAttendId(Integer attendId) {
        this.attendId = attendId;
    }

    public String getReAttendStart() {
        return reAttendStart;
    }

    public void setReAttendStart(String reAttendStart) {
        this.reAttendStart = reAttendStart == null ? null : reAttendStart.trim();
    }

    public Date getReAttendEven() {
        return reAttendEven;
    }

    public void setReAttendEven(Date reAttendEven) {
        this.reAttendEven = reAttendEven;
    }

    public Date getReAttendMor() {
        return reAttendMor;
    }

    public void setReAttendMor(Date reAttendMor) {
        this.reAttendMor = reAttendMor;
    }

    public String getCurrentHandler() {
        return currentHandler;
    }

    public void setCurrentHandler(String currentHandler) {
        this.currentHandler = currentHandler == null ? null : currentHandler.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }
}