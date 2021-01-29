package com.newheyd.pub.bean;

import cn.ainannan.base.bean.BaseBean;

public class SysApp extends BaseBean {

    private static final long serialVersionUID = -1;

    private String appCode;

    private String appName;

    private String appDesc;

    private String appImage;

    private String enterUrl;

    private String orderShow;
    
    private String grade;//等级

    private String gradeName;//等级名称

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppDesc() {
        return appDesc;
    }

    public void setAppDesc(String appDesc) {
        this.appDesc = appDesc;
    }

    public String getAppImage() {
        return appImage;
    }

    public void setAppImage(String appImage) {
        this.appImage = appImage;
    }

    public String getEnterUrl() {
        return enterUrl;
    }

    public void setEnterUrl(String enterUrl) {
        this.enterUrl = enterUrl;
    }


    public String getOrderShow() {
        return orderShow;
    }

    public void setOrderShow(String orderShow) {
        this.orderShow = orderShow;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}