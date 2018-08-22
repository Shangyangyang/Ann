package cn.ainannan.timeline.picManager.bean;

import java.util.Date;

import cn.ainannan.base.bean.BaseBean;

public class TimelinePic extends BaseBean<TimelinePic> {
	private String shortId;
	private String filename;
	private String path;
	private String src;
	private String suffix;
	private Long size;
	private String MD5;
	private String fingerPrint;
	private Date shotDate;
	private String similarId;
	private String state;

	public String getShortId() {
		return shortId;
	}

	public void setShortId(String shortId) {
		this.shortId = shortId;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getMD5() {
		return MD5;
	}

	public void setMD5(String mD5) {
		MD5 = mD5;
	}

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public String getSimilarId() {
		return similarId;
	}

	public void setSimilarId(String similarId) {
		this.similarId = similarId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getShotDate() {
		return shotDate;
	}

	public void setShotDate(Date shotDate) {
		this.shotDate = shotDate;
	}

}
