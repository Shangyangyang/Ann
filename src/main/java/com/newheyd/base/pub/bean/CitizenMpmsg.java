package com.newheyd.base.pub.bean;

import com.newheyd.base.base.BaseBean;

public class CitizenMpmsg extends BaseBean {

    private String openId;
    private String templateId;
    private String mpPage;
    private String smType;
    private String idCard;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getMpPage() {
        return mpPage;
    }

    public void setMpPage(String mpPage) {
        this.mpPage = mpPage;
    }

    public String getSmType() {
        return smType;
    }

    public void setSmType(String smType) {
        this.smType = smType;
    }
}