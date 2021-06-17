package com.newheyd.base.pub.bean;

import com.newheyd.base.base.BaseBean;

public class OperateRecord extends BaseBean {
	private String usercode;
	private String areacode;
	private String sysname;
	private String servicename;
	private String str1;
	private String str2;
	private Integer rnum;
	private String operatename;

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getSysname() {
		return sysname;
	}

	public void setSysname(String sysname) {
		this.sysname = sysname;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public String getStr1() {
		return str1;
	}

	public void setStr1(String str1) {
		this.str1 = str1;
	}

	public String getStr2() {
		return str2;
	}

	public void setStr2(String str2) {
		this.str2 = str2;
	}

	public Integer getRnum() {
		return rnum;
	}

	public void setRnum(Integer rnum) {
		this.rnum = rnum;
	}

	public String getOperatename() {
		return operatename;
	}

	public void setOperatename(String operatename) {
		this.operatename = operatename;
	}

	public OperateRecord() {
	}

	public OperateRecord(String usercode, String areacode, String sysname, String servicename, String str1, String str2, Integer rnum, String operatename) {
		this.usercode = usercode;
		this.areacode = areacode;
		this.sysname = sysname;
		this.servicename = servicename;
		this.str1 = str1;
		this.str2 = str2;
		this.rnum = rnum;
		this.operatename = operatename;
	}

	public OperateRecord(String usercode, String sysname, String servicename, String str1, String operatename) {
		this.usercode = usercode;
		this.sysname = sysname;
		this.servicename = servicename;
		this.str1 = str1;
		this.operatename = operatename;
	}


}