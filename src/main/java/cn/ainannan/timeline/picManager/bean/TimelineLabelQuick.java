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

}