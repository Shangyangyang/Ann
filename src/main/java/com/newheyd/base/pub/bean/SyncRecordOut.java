package com.newheyd.base.pub.bean;

import com.newheyd.base.base.BaseBean;

import java.util.Arrays;
import java.util.Date;

public class SyncRecordOut extends BaseBean {

	private static final long serialVersionUID = 1L;

	private String servicetype;
	private String [] servicetypes;
	private String servicename;
	private Date utime;
	private Integer querycount;
	private String uri;
	private String ip;
	private String params;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getServicetype() {
		return servicetype;
	}

	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}

	public String[] getServicetypes() {
		return servicetypes;
	}

	public void setServicetypes(String[] servicetypes) {
		this.servicetypes = servicetypes;
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

	public Integer getQuerycount() {
		return querycount;
	}

	public void setQuerycount(Integer querycount) {
		this.querycount = querycount;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "SyncRecordOut{" +
				"servicetype='" + servicetype + '\'' +
				", servicetypes=" + Arrays.toString(servicetypes) +
				", servicename='" + servicename + '\'' +
				", utime=" + utime +
				", querycount=" + querycount +
				", uri='" + uri + '\'' +
				", ip='" + ip + '\'' +
				", params='" + params + '\'' +
				'}';
	}
}