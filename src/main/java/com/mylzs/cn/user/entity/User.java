package com.mylzs.cn.user.entity;

public class User {
    private int uid;

    private String uname;

    private String upw;

    private String uphone;

    private String urealName;

    private String uhandImage;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUpw() {
        return upw;
    }

    public void setUpw(String upw) {
        this.upw = upw == null ? null : upw.trim();
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone == null ? null : uphone.trim();
    }

    public String getUrealName() {
        return urealName;
    }

    public void setUrealName(String urealName) {
        this.urealName = urealName == null ? null : urealName.trim();
    }

    public String getUhandImage() {
        return uhandImage;
    }

    public void setUhandImage(String uhandImage) {
        this.uhandImage = uhandImage == null ? null : uhandImage.trim();
    }
}