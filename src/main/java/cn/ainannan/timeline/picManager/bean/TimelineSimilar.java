package cn.ainannan.timeline.picManager.bean;

import cn.ainannan.base.bean.BaseBean;

/**
 * 图片相似度
 * 
 * @author Administrator
 *
 */
public class TimelineSimilar extends BaseBean {

	private static final long serialVersionUID = 1L;

	private String picid;		// 图片id
	private String otherid;		// 另一个图片的id
	private Float similarity;	// 相似度
	private Integer type;		// 类别1指纹2直方图

	public String getPicid() {
		return picid;
	}

	public void setPicid(String picid) {
		this.picid = picid;
	}

	public String getOtherid() {
		return otherid;
	}

	public void setOtherid(String otherid) {
		this.otherid = otherid;
	}

	public Float getSimilarity() {
		return similarity;
	}

	public void setSimilarity(Float similarity) {
		this.similarity = similarity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}