package com.newheyd.pub.bean;

import cn.ainannan.base.bean.BaseBean;

/**
 * 用于前端传送显示Bean，比如根据ID显示用户名，根据areaCode显示行政区划
 * 对应表：多个
 */
public class ShowName extends BaseBean {

    private static final long serialVersionUID = -4367053396324424052L;

    private String name;//姓名
    private String relationID;//关联数据ID
    private String returnValue;//返回数据
    private String areaCode;

    public static String getData(int i, int i1, Integer auditStatus) {
        return null;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationID() {
        return relationID;
    }

    public void setRelationID(String relationID) {
        this.relationID = relationID;
    }
}