package com.newheyd.pub.bean;

import cn.ainannan.base.bean.BaseBean;

import java.util.Date;

public class SyncRecord extends BaseBean {

	private static final long serialVersionUID = 1L;

	private String servicetype;
	private String [] servicetypes;
	private String servicename;
	private Date utime;
	private Integer updatenum;
	private String remark;
	
	
	public SyncRecord(int i) {
		super();
		this.updatenum = i;
	}

	public SyncRecord() {
		super();
	}

	public String[] getServicetypes() {
		return servicetypes;
	}

	public void setServicetypes(String[] servicetypes) {
		this.servicetypes = servicetypes;
	}

	public String getServicetype() {
		return servicetype;
	}

	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public Date getUtime() {
		return utime;
	}

	public void setUtime(Date utime) {
		this.utime = utime;
	}

	public Integer getUpdatenum() {
		return updatenum;
	}

	public void setUpdatenum(Integer updatenum) {
		this.updatenum = updatenum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}

}