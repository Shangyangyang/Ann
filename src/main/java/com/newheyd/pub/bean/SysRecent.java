package com.newheyd.pub.bean;

import cn.ainannan.base.bean.BaseBean;

import java.util.Date;

public class SysRecent extends BaseBean {

    private static final long serialVersionUID = -1;

    private String userCode;

    private String appCode;

    private Date useTime;

    private String appName;

    private String appImage;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppImage() {
        return appImage;
    }

    public void setAppImage(String appImage) {
        this.appImage = appImage;
    }

}