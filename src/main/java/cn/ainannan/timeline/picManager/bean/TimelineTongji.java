package cn.ainannan.timeline.picManager.bean;

import cn.ainannan.base.bean.BaseBean;

/**
 * 时光轴统计用
 * 
 * @author syy
 * @version 2018-09-26
 */
public class TimelineTongji extends BaseBean {

	private static final long serialVersionUID = 1L;

	// 标签主键
	private Integer weiShaixuan;
	// 标签
	private Integer yiShaixuan;

	public Integer getWeiShaixuan() {
		return weiShaixuan;
	}

	public void setWeiShaixuan(Integer weiShaixuan) {
		this.weiShaixuan = weiShaixuan;
	}

	public Integer getYiShaixuan() {
		return yiShaixuan;
	}

	public void setYiShaixuan(Integer yiShaixuan) {
		this.yiShaixuan = yiShaixuan;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}