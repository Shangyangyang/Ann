package cn.ainannan.timeline.picManager.bean;

import cn.ainannan.base.bean.BaseBean;

/**
 * 快速选择Entity
 * 
 * @author syy
 * @version 2019-03-25
 */
public class TimelineLabelQuick extends BaseBean {

	private static final long serialVersionUID = 1L;

	private String name;
	private String labels;
	private String type;
	private String belong;
	private Integer selectNum;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	public Integer getSelectNum() {
		return selectNum;
	}

	public void setSelectNum(Integer selectNum) {
		this.selectNum = selectNum;
	}

}