package cn.ainannan.sys.area.bean;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import cn.ainannan.base.bean.BaseBean;

@Component
@SuppressWarnings("deprecation")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Area extends BaseBean {

	private String areaCode;
	private String areaCodeL;	// 模糊查询
	
	private String areaName;
	private String areaLevel;
	private String parentCode;
	private String orderNo;
	
	private List<Area> childrenList;
	private String isRecursion;

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaLevel() {
		return areaLevel;
	}

	public void setAreaLevel(String areaLevel) {
		this.areaLevel = areaLevel;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public List<Area> getChildrenList() {
		return childrenList;
	}

	public void setChildrenList(List<Area> childrenList) {
		this.childrenList = childrenList;
	}

	public String getAreaCodeL() {
		return areaCodeL;
	}

	public void setAreaCodeL(String areaCodeL) {
		this.areaCodeL = areaCodeL;
	}

	public String getIsRecursion() {
		return isRecursion;
	}

	public void setIsRecursion(String isRecursion) {
		this.isRecursion = isRecursion;
	}

}
