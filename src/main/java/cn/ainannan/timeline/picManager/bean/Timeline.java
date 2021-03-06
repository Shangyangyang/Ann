package cn.ainannan.timeline.picManager.bean;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import cn.ainannan.base.bean.BaseBean;

/**
 * 时光轴Entity
 * 
 * @author syy
 * @version 2018-09-26
 */
public class Timeline extends BaseBean {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 图片类
	 */
	private TimelinePic pic; 
	// 1雪碧2乐乐
	private String type; 
	// 标签主键
	private String labelId; 
	// 标签
	private String label; 
	// 打分
	private String score; 
	// 简介
	private String reason; 
	
	// 时光轴查询
	private String timeType;	// 1年2月
	private String year;	// 年
	private String month;	// 月
	private Integer count;	// 总数
	private String shotDateL;	// Like查询拍摄日期

	private List<TimelinePic> picList;	// 图片集合
	

	public Timeline() {
	}

	public Timeline(String id) {
		super(id);
	}

	@Length(min = 0, max = 4, message = "1雪碧2乐乐长度必须介于 0 和 4 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Length(min = 0, max = 200, message = "标签长度必须介于 0 和 200 之间")
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Length(min = 0, max = 500, message = "简介长度必须介于 0 和 500 之间")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TimelinePic getPic() {
		return pic;
	}

	public void setPic(TimelinePic pic) {
		this.pic = pic;
	}

	public String getLabelId() {
		return labelId;
	}

	public void setLabelId(String labelId) {
		this.labelId = labelId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public List<TimelinePic> getPicList() {
		return picList;
	}

	public void setPicList(List<TimelinePic> picList) {
		this.picList = picList;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getTimeType() {
		return timeType;
	}

	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}

	public String getShotDateL() {
		return shotDateL;
	}

	public void setShotDateL(String shotDateL) {
		this.shotDateL = shotDateL;
	}

}