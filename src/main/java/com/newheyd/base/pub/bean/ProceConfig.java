package com.newheyd.base.pub.bean;

import java.util.Date;
import java.util.List;

import com.newheyd.base.base.BaseBean;
import org.springframework.format.annotation.DateTimeFormat;

import com.google.common.collect.Lists;

public class ProceConfig extends BaseBean {

	private static final long serialVersionUID = 1L;

	private String sysCode;
	private String serviceCode;
	private String code;
	private String arealevel;
	private String areaname;
	private String areacode;
	private String name;
	private String sysCodeL;
	private String serviceCodeL;
	private String codeL;
	private String status;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date begintime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endtime;
	
	// 查询参数

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date validitytime;

	private List<ProceLink> linkList = Lists.newArrayList();
	
	public String getSysCode() {
		return sysCode;
	}

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getArealevel() {
		return arealevel;
	}

	public void setArealevel(String arealevel) {
		this.arealevel = arealevel;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getBegintime() {
		return begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<ProceLink> getLinkList() {
		return linkList;
	}

	public void setLinkList(List<ProceLink> linkList) {
		this.linkList = linkList;
	}

	public Date getValiditytime() {
		return validitytime;
	}

	public void setValiditytime(Date validitytime) {
		this.validitytime = validitytime;
	}

	/**
	 * 不传参为则当前时间
	 */
	public void setValiditytime() {
		this.validitytime = new Date();		
	}

	public String getSysCodeL() {
		return sysCodeL;
	}

	public void setSysCodeL(String sysCodeL) {
		this.sysCodeL = sysCodeL;
	}

	public String getServiceCodeL() {
		return serviceCodeL;
	}

	public void setServiceCodeL(String serviceCodeL) {
		this.serviceCodeL = serviceCodeL;
	}

	public String getCodeL() {
		return codeL;
	}

	public void setCodeL(String codeL) {
		this.codeL = codeL;
	}

}