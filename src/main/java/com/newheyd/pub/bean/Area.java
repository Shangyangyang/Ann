package com.newheyd.pub.bean;

import cn.ainannan.base.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public class Area extends BaseBean {

    private static final long serialVersionUID = -4367053396324424052L;

    private Area parent;

    private String code;
    private String name;
    private String areaLevel;

    private String parentCode;
    private String parentName;
    private String  leaf;
    //用于递归显示树
    private List<Area> children;

    private String areaCodeJQ;

    private String areaNames;
    private String shiAreaName;
    private String quAreaName;
    private String jieAreaName;

    private String orderNo;

    public Area() {
        super();
    }

    public Area(String id) {
        super(id);
    }

    @JsonBackReference
    public Area getParent() {
        return parent;
    }

    public void setParent(Area parent) {
        this.parent = parent;
    }

    @Length(min = 0, max = 100)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Length(min = 1, max = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(min = 1, max = 1)
    public String getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(String level) {
        this.areaLevel = level;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<Area> getChildren() {
        return children;
    }

    public void setChildren(List<Area> children) {
        this.children = children;
    }

    public String getLeaf() {
        return leaf;
    }

    public void setLeaf(String leaf) {
        this.leaf = leaf;
    }

    public String getAreaCodeJQ() {
        return areaCodeJQ;
    }

    public void setAreaCodeJQ(String areaCodeJQ) {
        this.areaCodeJQ = areaCodeJQ;
    }

    public String getAreaNames() {
        return areaNames;
    }

    public void setAreaNames(String areaNames) {
        this.areaNames = areaNames;
    }

    public String getShiAreaName() {
        return shiAreaName;
    }

    public void setShiAreaName(String shiAreaName) {
        this.shiAreaName = shiAreaName;
    }

    public String getQuAreaName() {
        return quAreaName;
    }

    public void setQuAreaName(String quAreaName) {
        this.quAreaName = quAreaName;
    }

    public String getJieAreaName() {
        return jieAreaName;
    }

    public void setJieAreaName(String jieAreaName) {
        this.jieAreaName = jieAreaName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

}